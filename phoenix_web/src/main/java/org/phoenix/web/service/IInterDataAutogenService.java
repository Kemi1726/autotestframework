package org.phoenix.web.service;

import org.phoenix.model.InterfaceDataAutogenBean;

import java.util.List;

/**
 * Created by Kemi on 2017/10/26.
 * Description:操作笛卡尔乘积数据参数表业务层接口
 */
public interface IInterDataAutogenService {
    /*
    * 添加一条笛卡尔乘积数据参数
    * @param interfaceDataAutogenBean 笛卡尔乘积数据参数对象
    * @return 添加成功的条数
    * */
    InterfaceDataAutogenBean add(InterfaceDataAutogenBean interfaceDataAutogenBean);

    /*
    * 批量添加笛卡尔乘积数据参数列表
    * @param interfaceDataAutogenBeanList 笛卡尔乘积数据参数对象
    * @return 添加成功的条数
    * */
    void addInBatch(List<InterfaceDataAutogenBean> interfaceDataAutogenBeanList);

    /*
    * 修改一条笛卡尔乘积数据参数
    * @param interfaceDataAutogenBean 笛卡尔乘积数据参数对象
    * @return 修改成功的条数
    * */
    void update(InterfaceDataAutogenBean interfaceDataAutogenBean);

    /*
    * 根据主键删除一条笛卡尔乘积数据参数
    * @param id 主键
    * @return 删除成功的条数
    * */
    void deleteById(int id);

}
