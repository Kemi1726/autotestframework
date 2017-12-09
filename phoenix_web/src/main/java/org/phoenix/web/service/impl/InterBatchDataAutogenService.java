package org.phoenix.web.service.impl;

import org.phoenix.basic.paging.Pager;
import org.phoenix.model.InterfaceBatchDataAutogenBean;
import org.phoenix.web.dao.IInterBatchDataAutogenDao;
import org.phoenix.web.service.IInterBatchDataAutogenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Kemi on 2017/10/26.
 * Description:操作笛卡尔乘积数据表业务层实现类
 */
@Service
public class InterBatchDataAutogenService implements IInterBatchDataAutogenService{
    @Resource
    private IInterBatchDataAutogenDao interBatchDataAutogenDao;
    /**
     * 添加一条笛卡尔乘积测试数据
     * @param interfaceBatchDataAutogenBean 笛卡尔乘积数据对象
     * @return 添加成功的条数
     */
    public InterfaceBatchDataAutogenBean add(InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean) {
        return interBatchDataAutogenDao.add(interfaceBatchDataAutogenBean);
    }

    /**
     * 批量笛卡尔乘积测试数据列表
     * @param interfaceBatchDataAutogenBeanList 笛卡尔乘积数据对象列表
     * @return 添加成功的条数
     */
    public void addInBatch(List<InterfaceBatchDataAutogenBean> interfaceBatchDataAutogenBeanList) {
        interBatchDataAutogenDao.addBatchData(interfaceBatchDataAutogenBeanList);
    }

    /**
     * 更新一条笛卡尔乘积测试数据
     * @param interfaceBatchDataAutogenBean 笛卡尔乘积数据对象
     * @return 更新成功的条数
     */
    public void update(InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean) {
        interBatchDataAutogenDao.update(interfaceBatchDataAutogenBean);
    }

    /*
    * 删除一条笛卡尔乘积测试数据
    * @param id 主键
    * @return 成功删除的条数
    * */
    public void deleteById(int id) {
        interBatchDataAutogenDao.delete(id);
    }

    /*
    * 根据条件分页查询笛卡尔乘积测试数据列表
    *@param interfaceBatchDataAutogenBean 笛卡尔乘积数据对象
    * @param pageNo 页号
    * @param pageSize 每页条数
    * @return 笛卡尔乘积测试数据列表
    * */
    public Pager<InterfaceBatchDataAutogenBean> queryByCondition(InterfaceBatchDataAutogenBean interfaceBatchDataAutogenBean) {
        return interBatchDataAutogenDao.queryListByCondition(interfaceBatchDataAutogenBean);
    }

    /*
    * 根据id查询笛卡尔乘积测试数据
    * @param id 主键
    * @return 笛卡尔乘积测试数据实体
    * */
    public InterfaceBatchDataAutogenBean queryById(int id) {
        return interBatchDataAutogenDao.load(id);
    }


}
