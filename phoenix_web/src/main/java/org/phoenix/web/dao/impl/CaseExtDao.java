package org.phoenix.web.dao.impl;

import org.phoenix.basic.impl.BaseDao;
import org.phoenix.model.CaseExtBean;
import org.phoenix.web.dao.ICaseExtDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Kemi on 2017/12/3.
 * Description:
 */
@Repository
public class CaseExtDao extends BaseDao<CaseExtBean> implements ICaseExtDao{

    @Override
    public CaseExtBean getCaseExtBeanByCaseId(int caseId) {
        return (CaseExtBean) super.queryObject("from CaseExtBean where webCaseId ='"+caseId+"'");
    }
}
