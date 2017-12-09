package org.phoenix.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.phoenix.aop.PhoenixLogger;
import org.phoenix.model.CaseLogBean;
import org.phoenix.model.UnitLogBean;
import org.phoenix.utils.ScreenShot;
import org.phoenix.utils.SystemInfo;

import com.beust.jcommander.internal.Lists;

/**
 * @author mengfeiyang
 * 使用动态代理需要实现InvocationHandler接口
 * 
 */
public class CheckPointProxy implements InvocationHandler {
	private Object target = null;
	private LinkedList<UnitLogBean> unitLog;
	private CaseLogBean caseLogBean;
	private long picName;

	public CheckPointProxy(Object target,LinkedList<UnitLogBean> unitLog,CaseLogBean caseLogBean) {
		this.target = target;
		this.unitLog = unitLog;
		this.caseLogBean = caseLogBean;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		Object result = null;
		String picPath = null;
		String picWebPath = null;
		List<String> list = Lists.newArrayList("equals","toString");
		
			try{
				result = method.invoke(this.target, args);
				if(result == null){
					if(!list.contains(method.getName())){
						unitLog.add(new UnitLogBean("检查点 ["+method.getName()+"] 执行通过，相关参数："+Arrays.toString(args),method.getName(),"CHECKPOINT","SUCCESS","",caseLogBean));
						PhoenixLogger.info("检查点 ["+method.getName()+"] 执行通过，相关参数："+Arrays.toString(args));
					}
				} else {
					if(SystemInfo.isWindows()){
						picName = new Date().getTime();
						picPath = ScreenShot.TakeScreenshot(caseLogBean.getAttachPath()+"/screenshot/"+picName+".jpg");
						picWebPath = "<a href='http://"+caseLogBean.getClientIP()+"/phoenix_node/screenshot/"+picName+".jpg' target='_blank'>点击查看</a>";
					}else{
						picWebPath = picPath = "linux不支持截图";
					}
					if(!list.contains(method.getName())){
						unitLog.add(new UnitLogBean("检查点 ["+method.getName()+"] 校验失败，相关参数："+Arrays.toString(args)+",校验结果："+result,method.getName(),"CHECKPOINT","FAIL",picWebPath,caseLogBean));
						PhoenixLogger.warn("检查点 ["+method.getName()+"] 校验失败，相关参数："+Arrays.toString(args)+",校验结果："+result);
					}
				}
			}catch(Exception e){
				if(SystemInfo.isWindows()){
					picName = new Date().getTime();
					picPath = ScreenShot.TakeScreenshot(caseLogBean.getAttachPath()+"/screenshot/"+picName+".jpg");
					picWebPath = "<a href='http://"+caseLogBean.getClientIP()+"/phoenix_node/screenshot/"+picName+".jpg' target='_blank'>点击查看</a>";
				}else{
					picWebPath = picPath = "linux不支持截图";
				}
				if(!list.contains(method.getName())){
					PhoenixLogger.error("检查点 ["+method.getName()+"] 方法执行失败，相关参数："+Arrays.toString(args)+",异常信息："+e.getClass().getSimpleName()+",msg:"+e.getMessage()+",caused by:"+e.getCause().toString()+",截图路径："+picPath);
					unitLog.add(new UnitLogBean("检查点 ["+method.getName()+"] 方法执行失败，相关参数："+Arrays.toString(args)+",异常信息："+e.getClass().getSimpleName()+",msg:"+e.getMessage()+",caused by:"+e.getCause().toString(),method.getName(),"CHECKPOINT","FAIL",picWebPath,caseLogBean));
				}
			}
		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),this.target.getClass().getInterfaces(), this);
	}
}