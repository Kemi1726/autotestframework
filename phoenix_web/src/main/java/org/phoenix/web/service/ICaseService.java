package org.phoenix.web.service;

import java.util.List;

import org.phoenix.basic.paging.Pager;
import org.phoenix.model.CaseBean;
import org.phoenix.model.CaseExtBean;

public interface ICaseService {
	
	void addCase(CaseBean caseBean, CaseExtBean caseExtBean);
	void delCase(int id);
	void updateCaseAndExt(CaseBean caseBean, CaseExtBean caseExtBean);
	List<CaseBean> getCaseBeanListByUser(int uid);
	List<CaseBean> getCaseBeanListByUT(int uid,String taskType);
	List<CaseBean> getCaseBeanListByScenario(int scenarioId);
	Pager<CaseBean> getCaseBeanPagerByUser(int uid);
	Pager<CaseBean> getCaseBeanPagerByScenario(int scenarioId);
	Pager<CaseBean> getCaseBeanPagerByKeyWord(int uid,String keyword,String keyword2);
	CaseBean getCaseBean(int id);
	CaseExtBean getCaseExtBean(int id);
	CaseBean getCaseBeanByName(String name);

}
