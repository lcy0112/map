package com.map.algorithm;

import com.map.domain.Location;
import com.map.domain.Pair;

import java.util.*;

public class Kruskal {
    public static Map<String, Location> getSubMap(String[] points, Map<String, Location> map){
        Map<String, Location> subMap = new HashMap<>();
        Set<String> pointsS = new HashSet<>();
        for(int i = 0; i < points.length; i++){
            pointsS.add(points[i]);
        }
        for(String key : pointsS){
            Location tmp =  map.get(key);
            subMap.put(key, new Location(key, tmp.getInformation()));
            Map<String, Integer> path = subMap.get(key).getPath();
            Map<String, Integer> pathT = tmp.getPath();
            for(Map.Entry<String, Integer> iteam : pathT.entrySet()){
                if(pointsS.contains(iteam.getKey())){
                    path.put(iteam.getKey(), iteam.getValue());
                }
            }
        }
        return subMap;
    }

    public static Map<String, Location> Kruskal(Map<String, Location> map){
        Map<String, Location> ret = new HashMap<>();
        Map<Integer, Set<Pair<String, String>>> path = new TreeMap<>();
        for(Map.Entry<String, Location> item : map.entrySet()){
            for(Map.Entry<String, Integer> p : item.getValue().getPath().entrySet()){
                Pair<String, String> tmp = new Pair<>();
                tmp.first = item.getKey();
                tmp.second = p.getKey();
                if(path.containsKey(p.getValue())){
                    path.get(p.getValue()).add(tmp);
                }else{
                    Set<Pair<String, String>> tmpS = new HashSet<>();
                    tmpS.add(tmp);
                    path.put(p.getValue(), tmpS);
                }
            }
        }
        for(Map.Entry<Integer, Set<Pair<String, String>>> item : path.entrySet()){
            Set<Pair<String, String>> values = item.getValue();
            for(Pair<String, String> p : values){
                if(!ret.containsKey(p.first)){
                    Location tmp = new Location(p.first, map.get(p.first).getInformation());
                    ret.put(p.first, tmp);
                }
                if(!ret.containsKey(p.second)){
                    Location tmp = new Location(p.second, map.get(p.second).getInformation());
                    ret.put(p.second, tmp);
                }
                if(!toLink(p.first, p.second, ret)) {
                    ret.get(p.first).addPath(p.second, item.getKey());
                    ret.get(p.second).addPath(p.first, item.getKey());
                }
            }
        }
        return ret;
    }

    private static boolean toLink(String first, String second, Map<String, Location> map){
        Stack<Pair<String, Boolean>> s = new Stack<>();
        Pair<String, Boolean> p = new Pair<>();
        p.first = first;
        p.second = false;
        s.push(p);
        Set<String> visit = new HashSet<>();
        visit.add(first);
        while(!s.empty()){
            Pair<String, Boolean> tmp = s.pop();
            if(tmp.second){
                if(tmp.first.equals(second)){
                    return true;
                }
            }else{
                tmp.second = true;
                s.push(tmp);
                if(map.containsKey(tmp.first)){
                    Location location = map.get(tmp.first);
                    for(String str : location.getPath().keySet()){
                        if(!visit.contains(str)){
                            visit.add(str);
                            Pair<String, Boolean> ps = new Pair<>();
                            ps.first = str;
                            ps.second = false;
                            s.push(ps);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static Set<List<String>> getBFSResult(String key, Map<String, Location> map){
        Set<List<String>> ret = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(key);
        Set<String> visit = new HashSet<>();
        visit.add(key);
        while(!q.isEmpty()) {
            int count = q.size();
            List<String> list = new LinkedList<>();
            for(int i = 0; i < count; i++){
                String head = q.poll();
                list.add(head);
                Location location = map.get(head);
                for(String item : location.getPath().keySet()){
                    if(!visit.contains(item)) {
                        visit.add(item);
                        q.add(item);
                    }
                }
            }
            ret.add(list);
        }
        return ret;
    }
}
