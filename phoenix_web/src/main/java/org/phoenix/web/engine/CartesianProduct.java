package org.phoenix.web.engine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kemi on 2017/10/31.
 * Description:
 */
public class CartesianProduct<T> {
    public List<List<T>> generate(List<List<T>> lists){
        List<List<T>> result = new LinkedList<List<T>>();
        if(lists == null){
            return result;
        }
        //初始化first
        int length = lists.size();
        if(length > 0){
            List<T> firstElem = lists.get(0);
            for (T s : firstElem){
                List<T> line = new ArrayList<T>();
                line.add(s);
                result.add(line);
            }
        }

        for(int step = 1; step < length; step ++){
            List<T> stepElem = lists.get(step);
            List<List<T>> tempResult = new LinkedList<List<T>>();

            for (List<T> xx: result){
                for(T ye: stepElem){
                    List<T> newXx = new LinkedList<T>(xx);
                    newXx.add(ye);
                    tempResult.add(newXx);
                }
            }
            return tempResult;
        }
        return result;
    }
//    public static void main(String[] args){
//        List<String> a = new ArrayList<>();
//        a.add("a");
//        a.add("b");
//        a.add("c");
//
//        List<String> b = new ArrayList<>();
//        b.add("x");
//        b.add("y");
//        b.add("z");
//
//        List<String> c = new ArrayList<>();
//        c.add("1");
//
//        List<String> d = new ArrayList<>();
//        d.add("45");
//        d.add("46");
//        d.add("47");
//
//        List<String> e = new ArrayList<>();
//        e.add("111");
//        e.add("0000");
//
//        List<List<String>> abc = new LinkedList<>();
//        abc.add(a);
//        abc.add(b);
//        abc.add(c);
//        abc.add(d);
//        abc.add(e);
//
//        CartesianProduct<String> cp = new CartesianProduct<String>();
//
//        List<List<String>> result = cp.generate(abc);
//
//        int product = 1;
//        for (List<String> xxx : abc){
//            product *= xxx.size();
//        }
//
//        System.out.println(product + "*******" + result.size());
//
//        for (List<String> elem : result){
//            for(String yy: elem){
//                System.out.println(yy + ";");
//            }
//            System.out.println();
//        }
//    }
}
