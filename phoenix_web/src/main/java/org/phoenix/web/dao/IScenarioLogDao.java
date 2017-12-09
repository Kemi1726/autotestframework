package org.phoenix.web.dao;

import org.phoenix.basic.dao.IBaseDao;
import org.phoenix.basic.paging.Pager;
import org.phoenix.model.ScenarioLogBean;
/**
 * 场景日志操作
 * @author mengfeiyang
 *
 */
public interface IScenarioLogDao extends IBaseDao<ScenarioLogBean>{
	void deleteLog(int id);
	
	ScenarioLogBean getLog(int id);
	Pager<ScenarioLogBean> getLogPager(int batchId);
}
