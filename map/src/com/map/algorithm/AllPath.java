package com.map.algorithm;

import com.map.domain.Location;

import java.util.*;

public class AllPath {
    public static Set<List<String>> getAllPath(String origin, String destination, Map<String, Location> map){
        Set<List<String>> ret = new HashSet<>();
        List<String> list = new LinkedList<>();
        list.add(origin);
        assist(origin, destination, ret, list, map);
        return ret;
    }

    private static void assist(String origin, String destination, Set<List<String>> ret, List<String> list, Map<String, Location> map){
        if(origin.equals(destination)){
            ret.add(new LinkedList<>(list));
            return;
        }
        Set<String> keys = map.get(origin).getPath().keySet();
        for(String key : keys){
            if(!list.contains(key)){
                list.add(key);
                assist(key, destination, ret, list, map);
                list.remove(list.size() - 1);
            }
        }
    }
}
