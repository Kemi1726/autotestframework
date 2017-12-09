package org.phoenix.web.dao;

import org.phoenix.basic.paging.Pager;
import org.phoenix.model.DataTemplateBean;

/**
 * Created by Kemi on 2017/9/23.
 * Description:
 */
public interface IDataTemplateDao {
    /*
    * 获取多批及分页信息
    */
    Pager<DataTemplateBean> getDataTemplateBeanPager(int uid);

    /*
    * 根据名字搜索数据模板，注意uid没有使用
    * @param uid
    * @param keyword
    * @return
    */
    Pager<DataTemplateBean> getDataTemplateBeanPagerByKeyWord(int uid, String keyWord);


}
