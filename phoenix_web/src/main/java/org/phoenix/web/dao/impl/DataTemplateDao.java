package org.phoenix.web.dao.impl;

import org.phoenix.basic.impl.BaseDao;
import org.phoenix.basic.paging.Pager;
import org.phoenix.model.DataTemplateBean;
import org.phoenix.web.dao.IDataTemplateDao;

/**
 * Created by Kemi on 2017/9/23.
 * Description:
 */
public class DataTemplateDao extends BaseDao<DataTemplateBean> implements IDataTemplateDao{
    @Override public Pager<DataTemplateBean> getDataTemplateBeanPager(int uid){
        return super.find("from DataTemplateBean");
    }

    @Override public Pager<DataTemplateBean> getDataTemplateBeanPagerByKeyWord(int uid,String keyWord){
        return super.find("from DataTemplateBean where name like '%\"+keyWord+\"%'\"");
    }
}
