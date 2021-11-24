package com.liming.unionfindset;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2020-10-22 20:22
 */
public class BabyName {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String,Integer> map=new HashMap<>();
        Map<String,String> unionmap=new HashMap<>();

        for (String name : names) {
            int index = name.indexOf("(");
            String n=name.substring(0, index);
            Integer f=Integer.valueOf(name.substring(index+1,name.length()-1));
            map.put(n,f);
        }
        for (String synonym : synonyms) {
            int index=synonym.indexOf(",");
            String name1=synonym.substring(1, index);
            String name2=synonym.substring(index+1, synonym.length()-1);
            while(unionmap.containsKey(name1)){
                name1=unionmap.get(name1);
            }
            while(unionmap.containsKey(name2)){
                name2=unionmap.get(name2);
            }

            if(!name1.equals(name2)){
                int f=map.getOrDefault(name1, 0)+map.getOrDefault(name2, 0);
                String truename=name1.compareTo(name2)<0?name1:name2;
                String nickname=name1.compareTo(name2)<0?name2:name1;
                unionmap.put(nickname, truename);
                map.remove(nickname);
                map.put(truename, f);
            }
        }
        String [] res=new String[map.size()];
        int index=0;
        for (String s : map.keySet()) {
            StringBuffer sb=new StringBuffer(s);
            sb.append("(");
            sb.append(map.get(s));
            sb.append(")");
            res[index++]=sb.toString();
        }
        return res;
     }


}
