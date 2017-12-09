package org.phoenix.web.dao;

import org.phoenix.basic.dao.IBaseDao;
import org.phoenix.model.CaseExtBean;

/**
 * Created by Kemi on 2017/12/3.
 * Description:用例表操作接口
 */
public interface ICaseExtDao extends IBaseDao<CaseExtBean>{
    CaseExtBean getCaseExtBeanByCaseId(int caseId);

}
