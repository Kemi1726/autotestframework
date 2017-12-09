package org.phoenix.web.dao;

import org.phoenix.basic.dao.IBaseDao;
import org.phoenix.basic.paging.Pager;
import org.phoenix.model.InterfaceBatchDataAutogenBean;

import java.util.List;

/**
 * Created by Kemi on 2017/10/26.
 * Description:操作笛卡尔乘积数据表数据访问层接口
 */
public interface IInterBatchDataAutogenDao extends IBaseDao<InterfaceBatchDataAutogenBean>{
    /*根据条件查询笛卡尔乘积数据列表
    * @param interfaceBatchDataAutogenBean 笛卡尔乘积数据实体
    * @return 笛卡尔乘积数据f页列表
    */
    Pager <InterfaceBatchDataAutogenBean> queryListByCondition(InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean);

}
