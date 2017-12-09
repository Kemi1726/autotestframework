package org.phoenix.web.dao.impl;

import org.phoenix.basic.impl.BaseDao;
import org.phoenix.basic.paging.Pager;
import org.phoenix.model.InterfaceBatchDataAutogenBean;
import org.phoenix.web.dao.IInterBatchDataAutogenDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kemi on 2017/10/26.
 * Description:操作笛卡尔乘积数据表数据访问层实现类
 */
@Repository
public class InterBatchDataAutogenDao extends BaseDao<InterfaceBatchDataAutogenBean> implements IInterBatchDataAutogenDao{
    /*根据条件查询笛卡尔乘积数据列表
    * @param interfaceBatchDataAutogenBean 笛卡尔乘积数据实体
    * @return 笛卡尔乘积数据f页列表
    */
    public Pager<InterfaceBatchDataAutogenBean> queryListByCondition(InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean){
        return super.find("from InterfaceBatchDataAutogenBean where caseBean.id=?", interfaceBatchDataAutogenBean.getCaseBean().getId());
    }
}
