package org.phoenix.cases.kafka;

import java.util.LinkedList;

import org.phoenix.model.CaseLogBean;
import org.phoenix.model.UnitLogBean;
import org.phoenix.plugins.ITelnetClient;
import org.phoenix.proxy.ActionProxy;

public class RemoteMonitor extends ActionProxy{

	@Override
	public LinkedList<UnitLogBean> run(CaseLogBean caseLogBean) {
		ITelnetClient tl = phoenix.telnetClient().configTelnetClient("10.16.57.106", 7777);
		for(int i=0;i<10;i++){
			String r = tl.sendCommand("!runsh vmstat", "success!");
			System.out.println(r);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		tl.disconnect();
		return getUnitLog();
	}
	
	public static void main(String[] args) {
		RemoteMonitor rm = new RemoteMonitor();
		rm.run(new CaseLogBean());
	}

}
