package org.phoenix.web.service;

import org.phoenix.basic.paging.Pager;
import org.phoenix.model.InterfaceBatchDataAutogenBean;

import java.util.List;

/**
 * Created by Kemi on 2017/10/26.
 * Description:操作笛卡尔乘积数据表业务层接口
 */
public interface IInterBatchDataAutogenService {
    /**
     * 添加一条笛卡尔乘积测试数据
     * @param interfaceBatchDataAutogenBean 笛卡尔乘积数据对象
     * @return 添加成功的条数
     */
    InterfaceBatchDataAutogenBean add(InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean);

    /**
     * 批量笛卡尔乘积测试数据列表
     * @param interfaceBatchDataAutogenBeanList 笛卡尔乘积数据对象列表
     * @return 添加成功的条数
     */
    void addInBatch(List<InterfaceBatchDataAutogenBean> interfaceBatchDataAutogenBeanList);

    /**
     * 更新一条笛卡尔乘积测试数据
     * @param interfaceBatchDataAutogenBean 笛卡尔乘积数据对象
     * @return 更新成功的条数
     */
    void update(InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean);

    /*
    * 删除一条笛卡尔乘积测试数据
    * @param id 主键
    * @return 成功删除的条数
    * */
    void deleteById(int id);

    /*
    * 根据条件分页查询笛卡尔乘积测试数据列表
    *@param interfaceBatchDataAutogenBean 笛卡尔乘积数据对象
    * @param pageNo 页号
    * @param pageSize 每页条数
    * @return 笛卡尔乘积测试数据列表
    * */
    Pager <InterfaceBatchDataAutogenBean> queryByCondition(InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean);

    /*
    * 根据id查询笛卡尔乘积测试数据
    * @param id 主键
    * @return 笛卡尔乘积测试数据实体
    * */
    InterfaceBatchDataAutogenBean queryById(int id);


}
