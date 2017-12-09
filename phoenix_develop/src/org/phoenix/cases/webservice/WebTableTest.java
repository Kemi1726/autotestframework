package org.phoenix.cases.webservice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.phoenix.api.utils.RandomUtils;
import org.phoenix.enums.LocatorType;
import org.phoenix.model.CaseLogBean;
import org.phoenix.model.UnitLogBean;
import org.phoenix.proxy.ActionProxy;

/**
 * 获取webtable的内容
 * @author mengfeiyang
 *
 */
public class WebTableTest extends ActionProxy{
	@Override
	public LinkedList<UnitLogBean> run(CaseLogBean caseLogBean) {
		init(caseLogBean);
		List<String[]> dataList = new ArrayList<String[]>();
		phoenix.webAPI().setFirefoxExePath("D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		phoenix.webAPI().openNewWindowByFirefox("http://dianjing.eapidoc.360.cn/#api-Account-account_getcertlist", "10.138.65.218",80);
		
		//phoenix.webAPI().openNewWindowByPhantomJs("http://dianjing.eapidoc.360.cn/#api-Account-account_getcertlist", "10.138.65.218",80);
		//phoenix.webAPI().openNewWindowByHtmlUnit("http://dianjing.eapidoc.360.cn/#api-Account-account_getcertlist",true,BrowserVersion.CHROME);
		//phoenix.webAPI().openNewWindowByHtmlUnit("http://dianjing.eapidoc.360.cn/#api-Account-account_getcertlist",true,BrowserVersion.CHROME,"10.138.65.218",80);
		for(int tr=1;tr<13;tr++){
			String[] dataUnit = new String[2];
			String txt1 = phoenix.webAPI().webElement("//*[@id=\"api-Account-account_getcertlist-1.0.0\"]/table[1]/tbody/tr["+tr+"]/td[1]", LocatorType.XPATH).getText();
			String txt2 = phoenix.webAPI().webElement("//*[@id=\"api-Account-account_getcertlist-1.0.0\"]/table[1]/tbody/tr["+tr+"]/td[2]/p", LocatorType.XPATH).getText();
			dataUnit[0]=txt1;
			dataUnit[1]=txt2;
			dataList.add(dataUnit);
		}
		phoenix.webAPI().closeWindow();;
		for(String[] arr:dataList){
			//根据参数类型自动生成对应的数据类型
			System.out.println("数据名称："+arr[0]+" 数据类型："+arr[1]+" 生成的数据："+createData(arr[1]));
		}
		
		return getUnitLog();
	}
	
	public String createData(String type){
		switch(type){
		case "Number":return Integer.toString(RandomUtils.getRanInt(30));
		case "String":return RandomUtils.getRanCHS(5);
		default:return null;
		}
	}
	
	public static void main(String[] args) {
		WebTableTest t = new WebTableTest();
		
		LinkedList<UnitLogBean> ll = t.run(new CaseLogBean());
		for(UnitLogBean l : ll){
			System.out.println(l.getContent());
		}
	}

}
