package org.phoenix.cases.extendbpool;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.phoenix.extend.druid.DruidUtil;
import org.phoenix.model.CaseLogBean;
import org.phoenix.model.UnitLogBean;
import org.phoenix.proxy.ActionProxy;

/**
 * 使用phoenix做接口测试的案例<br>
 * @author mengfeiyang
 *
 */
public class DruidDemo extends ActionProxy{
	public DruidDemo() {
	}
	@Override
	public LinkedList<UnitLogBean> run(CaseLogBean caseLogBean) {
		init(caseLogBean);
       try{
    	   DruidUtil druid = new DruidUtil();
    	   druid.config("jdbc:mysql://localhost:3306/ykstimer?useUnicode=true&characterEncoding=utf-8", "root", "root");
		ResultSet rs = druid.getQueryResultSet("select * from t_user where id = '8'");
		while(rs.next()){
			int level = rs.getInt(2);//根据列编号
			String name = rs.getString("name");//根据列名
			String password = rs.getString("password");//根据列名
                        phoenix.checkPoint().checkIsEqual(password, "mfy");
                        phoenix.checkPoint().checkIsEqual(name, "mfy");
			System.out.println(level +"  "+name+"  "+password);
		         }

			} catch (Exception e) {
				e.printStackTrace();
			}
     		return getUnitLog();
		}
}
