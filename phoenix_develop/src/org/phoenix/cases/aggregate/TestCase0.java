package org.phoenix.cases.aggregate;

import java.util.LinkedList;

import org.phoenix.enums.LocatorType;
import org.phoenix.model.CaseLogBean;
import org.phoenix.model.UnitLogBean;
import org.phoenix.proxy.ActionProxy;

/**
 * 模拟登陆，但登陆后不关闭浏览器，目的是为了给其他用例引用<br>
 * 这个是被引用的类，及公共用例，可在其他用例中引用该用例。<br>
 * 
 * 这个类也可以独立的运行，该类将在  {@link TestCase1} 中被引用.
 * @author mengfeiyang
 *
 */
public class TestCase0 extends ActionProxy{
	private static String caseName = "公共登陆用例";//该类在数据库中的标识为“公共用例”，
	//private static int caseName = 7;//该类在数据库中的id标识为7
	@Override
	public LinkedList<UnitLogBean> run(CaseLogBean caseLogBean) {
		init(caseLogBean);
		//webProxy.setChromeDriverExePath("C:\\Users\\mengfeiyang\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		//webProxy.openNewWindowByChrome("http://lianmeng.360.cn/account");
		//webProxy.setFirefoxExePath("D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		//webProxy.openNewWindowByFirefox("http://lianmeng.360.cn/account");
		
		phoenix.webAPI().openNewWindowByPhantomJs("http://lianmeng.360.cn/");
		phoenix.webAPI().webElement("#uname",null).setText("test");
		phoenix.webAPI().webElement("passwd", LocatorType.NAME).setText("123456");
		phoenix.webAPI().webElement("verifyCode", LocatorType.NAME).setText("6g6m");
		if(phoenix.webAPI().webElement("verifyCode", LocatorType.NAME).getText()!=null){
			System.out.println("设置值成功....");
		}
		phoenix.webAPI().webElement("//*[@id=\"login_form\"]/dl[4]/dd/button",LocatorType.XPATH).click();
		
		return getUnitLog(); //若该用例被其他用例引用了，则getUnitLog则为分割用的关键字。
	}

}
