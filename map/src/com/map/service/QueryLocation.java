package com.map.service;

import com.map.domain.Location;

import java.util.List;
import java.util.Map;

public interface QueryLocation {
    /**
     *
     *
     * @return 查询所有点的数据
     */
    List<Location> getLocations();

    /**
     *
     * @return 查询地图的所有数据, 以邻接表的形式返回
     */
    Map<String, Location> getAdjacencyList();
}
