package org.phoenix.web.service.impl;

import org.phoenix.model.CaseExtBean;
import org.phoenix.web.dao.ICaseExtDao;
import org.phoenix.web.service.ICaseExtService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Kemi on 2017/12/3.
 * Description:
 */
@Service
public class CaseExtService implements ICaseExtService{
    private ICaseExtDao caseExtDao;

    public ICaseExtDao getCaseExtDao() {
        return caseExtDao;
    }

    @Resource
    public void setCaseExtDao(ICaseExtDao caseExtDao) {
        this.caseExtDao = caseExtDao;
    }

    @Override
    public void addCaseExt(CaseExtBean caseExtBean) {
        caseExtDao.add(caseExtBean);
    }
}
