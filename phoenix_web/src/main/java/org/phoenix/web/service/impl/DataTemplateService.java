package org.phoenix.web.service.impl;

import org.phoenix.basic.paging.Pager;
import org.phoenix.basic.utils.PerThreadSessionUtil;
import org.phoenix.model.DataTemplateBean;
import org.phoenix.model.DataTemplateFieldBean;
import org.phoenix.web.dao.impl.DataTemplateDao;
import org.phoenix.web.dao.impl.DataTemplateFieldDao;
import org.phoenix.web.engine.CartesianProduct;
import org.phoenix.web.service.IDataTemplateService;
import org.phoenix.web.util.thread.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kemi on 2017/9/23.
 * Description:
 */
public class DataTemplateService implements IDataTemplateService {
    private Logger logger = LoggerFactory.getLogger(DataTemplateService.class);
    @Autowired
    DataTemplateDao dataTemplateDao;
    @Autowired
    DataTemplateFieldDao dataTemplateFieldDao;

    @Override
    public Pager<DataTemplateBean> getDataTemplateBeanPager(Integer uid) {
        return dataTemplateDao.getDataTemplateBeanPager(uid);
    }

    @Override
    public Pager<DataTemplateBean> getDataTemplateBeanPagerByKeyWord(Integer uid,String keyWord) {
        return dataTemplateDao.getDataTemplateBeanPagerByKeyWord(uid,keyWord);
    }

    @Override
    public DataTemplateBean add(DataTemplateBean dataTemplateBean) {
        return dataTemplateDao.add(dataTemplateBean);
    }

    @Override
    public DataTemplateBean getDataTemplateById(Integer id) {
        return dataTemplateDao.load(id);
    }

    @Override
    public void deleteDataTemplate(Integer id) {
        dataTemplateDao.delete(id);
    }

    @Override
    public void updataDataTemplate(DataTemplateBean dataTemplateBean) {
        dataTemplateDao.update(dataTemplateBean);
    }

    @Override
    public DataTemplateFieldBean add(DataTemplateFieldBean dataTemplateFieldBean) {
        return dataTemplateFieldDao.add(dataTemplateFieldBean);
    }

    @Override
    public void deleteDataTemplateFieldId(Integer id) {
        dataTemplateFieldDao.delete(id);
    }

    @Override
    public void updateDataTemplateField(DataTemplateFieldBean dataTemplateFieldBean) {
        dataTemplateFieldDao.update(dataTemplateFieldBean);
    }

    @Override
    public DataTemplateFieldBean getDataTemplateFieldBean(Integer fid) {
        return dataTemplateFieldDao.load(fid);
    }

    @Override
    public void updateDataTemplateFieldBean(DataTemplateFieldBean dataTemplateFieldBean) {
        dataTemplateFieldDao.update(dataTemplateFieldBean);
    }

    public void updateWork(Integer id){
        logger.info(dataTemplateDao.load(id).getName());
        System.out.println(dataTemplateDao.load(id).getName());
    }

    private void generateWork(Integer id){
        updateWork(id);

        //-- 根据metadataId 首先加载interfaceMetadata
        //判读interfaceMetadata 生成状态，如果生成中，返回失败，已经生成，删除老的数据，重新生成
        //--修改Metadata状态
        //--加载Metadata_field 字段， 根据字段类型放到List
        //--生成笛卡尔积
        //-- 分批次插入interface_batchdata_autogen, 和interface_data_autogen
        //生成笛卡尔积例子
        List< String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");

        List< String > b = new ArrayList<>();
        b.add("x");
        b.add("y");
        b.add("z");

        List< String > c = new ArrayList<>();
        c.add("1");


        List< String > d = new ArrayList<>();
        d.add("45");
        d.add("46");
        d.add("47");

        List< String > e = new ArrayList<>();
        e.add("1111");
        e.add("0000");

        List<List< String > > abc = new LinkedList<>();
        abc.add(a);
        abc.add(c);
        abc.add(b);
        abc.add(d);
        abc.add(e);



        CartesianProduct<String> cp = new CartesianProduct<String>();
        //生成笛卡尔积
        List<List< String> > result =  cp.generate(abc);

        int product =1;
        for(List< String > xxx : abc){
            product *= xxx.size();
        }
        System.out.println(product +"**********" +result.size());
        for(List< String > elem : result){
            for( String  yy : elem){
                System.out.print(yy+";");
            }
            System.out.println();
        }
    }

    @Override
    public int updateTask(Integer taskId) {
        Gen2Task genTask = new Gen2Task(taskId);

        boolean isSuccess = ThreadPool.commitTask(genTask);
        if(isSuccess){
            return 1;
        }
        return 0;
    }

    private class Gen2Task implements Runnable{
        public Gen2Task(Integer id){
            this.id = id;
        }

        private  Integer id;

        @Override
        public void run() {
            try {
                generateWork(id);
                Thread.sleep(10*1000);
            }catch (Exception e){
                e.printStackTrace();;
            }finally {
                PerThreadSessionUtil.closeSession();
            }
        }
    }
}
