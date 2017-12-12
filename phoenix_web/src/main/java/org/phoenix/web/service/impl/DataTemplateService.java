package org.phoenix.web.service.impl;

import org.phoenix.basic.paging.Pager;
import org.phoenix.basic.utils.PerThreadSessionUtil;
import org.phoenix.model.DataTemplateBean;
import org.phoenix.model.DataTemplateFieldBean;
import org.phoenix.web.dao.impl.DataTemplateDao;
import org.phoenix.web.dao.impl.DataTemplateFieldDao;
import org.phoenix.web.engine.CartesianProduct;
import org.phoenix.web.service.IDataTemplateService;
import org.phoenix.web.util.thread.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;


/**
 * Created by Kemi on 2017/9/23.
 * Description:
 */
public class DataTemplateService implements IDataTemplateService {
    private Logger logger = LoggerFactory.getLogger(DataTemplateService.class);
    @Autowired
    DataTemplateDao dataTemplateDao;
    @Autowired
    DataTemplateFieldDao dataTemplateFieldDao;

    @Override
    public Pager<DataTemplateBean> getDataTemplateBeanPager(Integer uid) {
        return dataTemplateDao.getDataTemplateBeanPager(uid);
    }

    @Override
    public Pager<DataTemplateBean> getDataTemplateBeanPagerByKeyWord(Integer uid,String keyWord) {
        return dataTemplateDao.getDataTemplateBeanPagerByKeyWord(uid,keyWord);
    }

    @Override
    public DataTemplateBean add(DataTemplateBean dataTemplateBean) {
        return dataTemplateDao.add(dataTemplateBean);
    }

    @Override
    public DataTemplateBean getDataTemplateById(Integer id) {
        return dataTemplateDao.load(id);
    }

    @Override
    public void deleteDataTemplate(Integer id) {
        dataTemplateDao.delete(id);
    }

    @Override
    public void updataDataTemplate(DataTemplateBean dataTemplateBean) {
        dataTemplateDao.update(dataTemplateBean);
    }

    @Override
    public DataTemplateFieldBean add(DataTemplateFieldBean dataTemplateFieldBean) {
        return dataTemplateFieldDao.add(dataTemplateFieldBean);
    }

    @Override
    public void deleteDataTemplateFieldId(Integer id) {
        dataTemplateFieldDao.delete(id);
    }

    @Override
    public void updateDataTemplateField(DataTemplateFieldBean dataTemplateFieldBean) {
        dataTemplateFieldDao.update(dataTemplateFieldBean);
    }

    @Override
    public DataTemplateFieldBean getDataTemplateFieldBean(Integer fid) {
        return dataTemplateFieldDao.load(fid);
    }

    @Override
    public void updateDataTemplateFieldBean(DataTemplateFieldBean dataTemplateFieldBean) {
        dataTemplateFieldDao.update(dataTemplateFieldBean);
    }
}
