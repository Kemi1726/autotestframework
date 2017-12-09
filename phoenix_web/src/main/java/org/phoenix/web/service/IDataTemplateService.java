package org.phoenix.web.service;

import org.phoenix.basic.paging.Pager;
import org.phoenix.model.DataTemplateBean;
import org.phoenix.model.DataTemplateFieldBean;

/**
 * Created by Kemi on 2017/9/23.
 * Description:
 */
public interface IDataTemplateService {
/*
*加载多个DataTemplateBean，并且获取分页信息，根据用户的uid
*/
    Pager<DataTemplateBean> getDataTemplateBeanPager(Integer uid);

    /*
    *加载多个DataTemplateBean，并且获取分页信息 ,根据名称模糊查询
    */
    Pager<DataTemplateBean> getDataTemplateBeanPagerByKeyWord(Integer uid, String keyWord);
    /*
    * 添加数据模板操作
    * */
    DataTemplateBean add(DataTemplateBean dataTemplateBean);

    /*
    * @param id
    * @return
    */
    DataTemplateBean getDataTemplateById(Integer id);

    /*
    * DataTemplate id
    * @param id
    */
    void deleteDataTemplate(Integer id);

    /*
    * 更新
    * @param dataTemplateBean
    */
    void updataDataTemplate(DataTemplateBean dataTemplateBean);

    DataTemplateFieldBean add(DataTemplateFieldBean dataTemplateFieldBean);

    /*
    * DataTemplateField id
    * @param id
    */
    void deleteDataTemplateFieldId(Integer id);

    /*
    * 更新
    * @param dataTemplateFieldBean
    */
    void updateDataTemplateField(DataTemplateFieldBean dataTemplateFieldBean);

    DataTemplateFieldBean getDataTemplateFieldBean(Integer fid);

    void  updateDataTemplateFieldBean(DataTemplateFieldBean dataTemplateFieldBean);

    int updateTask(Integer taskId);

    public void updateWork(Integer taskId);

}
