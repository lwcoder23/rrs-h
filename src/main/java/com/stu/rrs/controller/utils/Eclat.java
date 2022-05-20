package com.stu.rrs.controller.utils;

import java.util.*;

public class Eclat {

    // 获取垂直数据
    // c=1 的 uid


    // Eclat获取频繁项集以及置信度和支持度

    // demo
    public static String SPLIT = ";";
    public static int F = 2;
    public static double C = 0.6;
    int num;

    public static List<String> transList = new ArrayList<>();

    static {
        transList.add("1;c1;c3;c5;c6;c7");
        transList.add("2;c1;c2;c3;c6");
        transList.add("3;c2;c3;c5;c7");
        transList.add("4;c3;c6;");
        transList.add("5;c1;c4;;c6;c8");
        transList.add("6;c1;c2;c3;c5;c6");
        transList.add("7;c1;c2;c3;c4;c5;c6;c7;c8");
        transList.add("8;c3;c4;c5;c7;c8");
        transList.add("10;c2;c3;c4;c5;c7;c8");
        transList.add("11;c2;c4;c5;c7;c8");
        transList.add("12;c1;c3;c4;c5;c6;c8");
        transList.add("13;c1;c2;c3;c5;c7;c8");
    }

    private Map<String, Set<String>> datas;

    // 垂直数据
    private void etl(){
        datas = new HashMap<>();
        for (String string : transList) {
            String[] records = string.split(SPLIT);
            num = datas.size();
            for(int i = 1;i<records.length;i++){
                if(!datas.containsKey(records[i])){
                    datas.put(records[i],new HashSet<>());
                }
                datas.get(records[i]).add(records[0]);
            }
        }
    }

    public List<String> getFItems(){
        etl();
        Double sup;
        Double cof;
        Double mount = 0.0;
        Set<String> keys = datas.keySet();
        Set<String> items = new HashSet<>();
        items.addAll(keys);
        ArrayList<Set<String>> subsets = SetUtils.getSubset(items);
        Set<String> tmp = new HashSet<>();
        List<String> fItems = new ArrayList<>();
        for (Set<String> set : subsets) {
            tmp.clear();
            Iterator<String> it = set.iterator();
            if(it.hasNext()){
                tmp.addAll(datas.get(it.next()));
                mount = (double)tmp.size();
                System.out.println("before" + mount);
                System.out.println("count" + num);
                while(it.hasNext() && tmp.size()>=F){
                    tmp.retainAll(datas.get(it.next()));
                    System.out.println("after" + tmp.size());
                }
            }
            if(tmp.size()>=F){
                sup = (double)tmp.size()/num;
                cof = ((double)tmp.size())/mount;
                fItems.add(set.toString()+":"+tmp.size() + "    sup = " + sup.toString()
                                                            + " cof = " + cof.toString());
            }
        }
        return fItems;
    }

    public static void main(String[] args) {
        Eclat eclat = new  Eclat();

        List<String> fItems = eclat.getFItems();
        for (String string : fItems) {
            System.out.println(string);
        }
    }


}
