package com.map.algorithm;

import com.map.domain.Location;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Dijkstra {

    public static Map<String, LinkedList<String>> Dijkstra(Map<String, Location> map, String key){
        Map<String, LinkedList<String>> ret = new HashMap<>();
        Map<String, LinkedList<String>> tmp = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        list.add(key);
        ret.put(key, new LinkedList<String>(list));
        for(String str : map.get(key).getPath().keySet()){
            list.add(str);
            tmp.put(str, new LinkedList<String>(list));
            list.removeLast();
        }
        while(!tmp.isEmpty()){
            String minKey = getMinPath(map, tmp);
            ret.put(minKey, new LinkedList<String>(tmp.get(minKey)));
            tmp.remove(minKey);
            addPath(minKey, map, ret, tmp);
        }
        return ret;
    }

    public static String getMinPath(Map<String, Location> map, Map<String, LinkedList<String>> res){
        LinkedList<String> list = new LinkedList<>(res.keySet());
        String str = list.get(0);
        LinkedList<String> pathS = res.get(str);
        int minPath = getPath(map, pathS);
        for(int i = 1; i < list.size(); i++){
            int num = getPath(map, res.get(list.get(i)));
            if(minPath > num){
                minPath = num;
                str = list.get(i);
            }
        }
        return str;
    }

    public static int getPath(Map<String, Location> map, LinkedList<String> list){
        int ret = 0;
        for(int i = 0; i < list.size() - 1; i++){
            ret += map.get(list.get(i)).getPath().get(list.get(i + 1));
        }
        return ret;
    }

    public static void addPath(String key, Map<String, Location> map, Map<String, LinkedList<String>> ass, Map<String, LinkedList<String>> res){
        LinkedList<String> path = new LinkedList<String>(ass.get(key));
        LinkedList<String> allDst = new LinkedList<String>(map.get(key).getPath().keySet());
        for(String str : allDst){
            if(!ass.containsKey(str)){
                if(!res.containsKey(str)){
                    path.addLast(str);
                    res.put(str, new LinkedList<String>(path));
                    path.removeLast();
                } else {
                    path.addLast(str);
                    int len1 = getPath(map, path);
                    int len2 = getPath(map, res.get(str));
                    if(len1 < len2){
                        res.put(str, new LinkedList<String>(path));
                    }
                    path.removeLast();
                }
            }
        }
    }
}
