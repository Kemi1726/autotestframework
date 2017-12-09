package org.phoenix.web.service.impl;

import org.phoenix.model.InterfaceDataAutogenBean;
import org.phoenix.web.dao.IInterDataAutogenDao;
import org.phoenix.web.service.IInterDataAutogenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Kemi on 2017/10/26.
 * Description:操作笛卡尔乘积数据参数表业务层实现类
 */
@Service
public class InterDataAutogenService implements IInterDataAutogenService{
    @Resource
    private IInterDataAutogenDao interDataAutogenDao;
    /*
    * 添加一条笛卡尔乘积数据参数
    * @param interfaceDataAutogenBean 笛卡尔乘积数据参数对象
    * @return 添加成功的条数
    * */
    public InterfaceDataAutogenBean add(InterfaceDataAutogenBean interfaceDataAutogenBean) {
        return interDataAutogenDao.add(interfaceDataAutogenBean);
    }

    /*
    * 批量添加笛卡尔乘积数据参数列表
    * @param interfaceDataAutogenBeanList 笛卡尔乘积数据参数对象
    * @return 添加成功的条数
    * */
    public void addInBatch(List<InterfaceDataAutogenBean> interfaceDataAutogenBeanList) {
        interDataAutogenDao.addBatchData(interfaceDataAutogenBeanList);
    }

    /*
    * 修改一条笛卡尔乘积数据参数
    * @param interfaceDataAutogenBean 笛卡尔乘积数据参数对象
    * @return 修改成功的条数
    * */
    public void update(InterfaceDataAutogenBean interfaceDataAutogenBean) {
        interDataAutogenDao.update(interfaceDataAutogenBean);
    }

    /*
    * 根据主键删除一条笛卡尔乘积数据参数
    * @param id 主键
    * @return 删除成功的条数
    * */
    public void deleteById(int id) {
        interDataAutogenDao.delete(id);
    }
}
