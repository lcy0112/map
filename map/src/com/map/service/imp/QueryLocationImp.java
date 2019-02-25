package com.map.service.imp;

import com.map.dao.QueryData;
import com.map.dao.imp.QueryDataImp;
import com.map.domain.Location;
import com.map.service.QueryLocation;

import java.util.List;
import java.util.Map;

public class QueryLocationImp implements QueryLocation {
    @Override
    public List<Location> getLocations() {
        try {
            return qd.getLocations();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Location> getAdjacencyList() {
        try {
            return qd.getLocationMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private QueryData qd = new QueryDataImp();
}
