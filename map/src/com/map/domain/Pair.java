package com.map.domain;

public class Pair <K, V>{
    public K first;
    public V second;

    @Override
    public boolean equals(Object o) {
        Pair p = (Pair)o;
        if(first.equals(p.first) && second.equals(p.second)){
            return true;
        }
        if(first.equals(p.second) && second.equals(p.first)){
            return true;
        }
        return false;
    }
}
