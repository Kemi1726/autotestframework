package org.phoenix.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.phoenix.basic.paging.Pager;
import org.phoenix.model.CaseBean;
import org.phoenix.model.CaseExtBean;
import org.phoenix.web.dao.ICaseDao;
import org.phoenix.web.dao.ICaseExtDao;
import org.phoenix.web.service.ICaseService;
import org.phoenix.web.util.ShiroKit;
import org.springframework.stereotype.Service;

@Service
public class CaseService implements ICaseService{
    private ICaseDao caseDao;
    private ICaseExtDao caseExtDao;

	public ICaseDao getCaseDao() {
		return caseDao;
	}
    
	@Resource
	public void setCaseDao(ICaseDao caseDao) {
		this.caseDao = caseDao;
	}
	
	public CaseService() {
	}

	public ICaseExtDao getCaseExtDao() {
		return caseExtDao;
	}

	@Resource
	public void setCaseExtDao(ICaseExtDao caseExtDao) {
		this.caseExtDao = caseExtDao;
	}

	public void addCase(CaseBean caseBean, CaseExtBean caseExtBean){
		caseDao.add(caseBean);
		if (!ShiroKit.isEmpty(caseExtBean.getUrl())){
			caseExtBean.setWebCaseId(caseBean.getId());
			caseExtDao.add(caseExtBean);
		}
	}

	@Override
	public void delCase(int id) {
		caseDao.delete(id);
	}

	@Override
	public void updateCaseAndExt(CaseBean caseBean, CaseExtBean caseExtBean) {
		caseDao.update(caseBean);
		caseExtBean.setWebCaseId(caseBean.getId());
		caseExtDao.update(caseExtBean);
	}

	@Override
	public List<CaseBean> getCaseBeanListByUser(int uid) {
		return caseDao.getCaseBeanListByUser(uid);
	}
	
	@Override
	public List<CaseBean> getCaseBeanListByUT(int uid, String taskType) {
		return caseDao.getCaseBeanListByUT(uid, taskType);
	} 
	
	@Override
	public List<CaseBean> getCaseBeanListByScenario(int scenarioId) {
		return caseDao.getCaseBeanListByScenario(scenarioId);
	}

	@Override
	public Pager<CaseBean> getCaseBeanPagerByUser(int uid) {
		return caseDao.getCaseBeanPagerByUser(uid);
	}

	@Override
	public Pager<CaseBean> getCaseBeanPagerByScenario(int scenarioId) {
		return caseDao.getCaseBeanPagerByScenario(scenarioId);
	}

	@Override
	public CaseBean getCaseBean(int id) {
		return caseDao.load(id);
	}

	@Override
	public Pager<CaseBean> getCaseBeanPagerByKeyWord(int uid, String keyword,String keyword2) {
		return caseDao.getCaseBeanPagerByKeyWord(uid, keyword, keyword2);
	}

	@Override
	public CaseExtBean getCaseExtBean(int id) {
		return caseExtDao.getCaseExtBeanByCaseId(id);
	}

	@Override
	public CaseBean getCaseBeanByName(String name) {
		return caseDao.getCaseBeanByName(name);
	}
  
}
