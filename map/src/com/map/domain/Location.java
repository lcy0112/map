package com.map.domain;

import java.util.HashMap;
import java.util.Map;

public class Location {

    public Location(String origin, String information) {
        this.origin = origin;
        this.information = information;
        this.path = new HashMap<>();
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void addPath(String destination, int length){
        path.put(destination, length);
    }

    public Map<String, Integer> getPath(){
        return path;
    }

    private String origin;
    private Map<String, Integer> path;
    private String information;

}
