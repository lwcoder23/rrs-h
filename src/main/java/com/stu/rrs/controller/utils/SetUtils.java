package com.stu.rrs.controller.utils;

import org.springframework.util.CollectionUtils;
import com.google.common.collect.Lists;

import java.util.*;

public class SetUtils {

    public static ArrayList<Set<String>> getSubset(Set<String> items){
        if (CollectionUtils.isEmpty(items)) {
            return new ArrayList<>();
        }
        List<String> list = Lists.newArrayList(items);
        /*Set<String> set = Sets.newLinkedHashSet(list.subList(0, items.size()));
        Iterator<String> it = set.iterator();
        ArrayList<Set<String>> arrayList = new ArrayList<>();
        Set<String> s = new HashSet<>();
        while (it.hasNext()) {
            s.add(it.next());
            arrayList.add(s);
        }*/
        List<String> stringList;
        Set<String> set;
        ArrayList<Set<String>> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                stringList = list.subList(i, j);
                set = new HashSet<>();
                set.addAll(stringList);
                arrayList.add(set);
            }
        }
        return arrayList;
    }

    /**
     * 输入一个集合，输出这个集合的所有子集
     * @author liangyongxing
     * @createTime 2017-02-06

    public class SubListExport {
        public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            System.out.println("请输入一串整数并在输入时用英文逗号隔开：");
            String inputString = new Scanner(System.in).next().toString();
            if (inputString != null && !inputString.isEmpty()) {
                String[] strArray = inputString.split(",");
                for (String str : strArray) {
                    list.add(Integer.parseInt(str));
                }
                HashSet<ArrayList<Integer>> allsubsets = getSubsets(list);
                for(ArrayList<Integer> subList : allsubsets) {
                    System.out.println(subList);
                }
            }
        }

        public static HashSet<ArrayList<Integer>> getSubsets(ArrayList<Integer> subList) {
            HashSet<ArrayList<Integer>> allsubsets = new HashSet<ArrayList<Integer>>();
            int max = 1 << subList.size();
            for(int loop = 0; loop < max; loop++) {
                int index = 0;
                int temp = loop;
                ArrayList<Integer> currentCharList = new ArrayList<Integer>();
                while(temp > 0) {
                    if((temp & 1) > 0) {
                        currentCharList.add(subList.get(index));
                    }
                    temp>>=1;
                    index++;
                }
                allsubsets.add(currentCharList);
            }
            return allsubsets;
        }
    }

     */

}
