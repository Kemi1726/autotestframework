package org.phoenix.web.engine;

/**
 * Created by Kemi on 2017/12/9.
 * Description:
 */
public class GenTask implements Runnable{
    @Override
    public void run() {
        //--首先加载interfaceMetadata 根据metadataId
        //--修改Metadata状态
        //--加载Metadata_field 字段， 根据字段类型放到List
        //--生成笛卡尔积
        //--插入batchdata_autogen, 和data_auto_gen
    }
}
