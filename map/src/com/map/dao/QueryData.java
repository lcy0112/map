package com.map.dao;

import com.map.domain.Location;

import java.util.List;
import java.util.Map;

public interface QueryData {
    /**
     *
     * @return 查询所有点的集合
     * @throws Exception
     */
    List<Location> getLocations() throws Exception;

    /**
     *
     * @return 查询地图数据
     */
    Map<String, Location> getLocationMap() throws Exception;
}
