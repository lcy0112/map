package com.map.dao.imp;

import com.map.dao.QueryData;
import com.map.domain.Location;
import com.map.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryDataImp implements QueryData {
    @Override
    public List<Location> getLocations() throws Exception {
        List<Location> ret = new ArrayList<>();
        Connection conn = DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from mappath");
        while(rs.next()){
            ret.add(new Location(rs.getString("origin"), rs.getNString("information")));
        }
        DBUtils.clossAll(conn, stmt, rs);
        return ret;
    }

    @Override
    public Map<String, Location> getLocationMap() throws Exception {
        Map<String, Location> ret = new HashMap<>();
        Connection conn = DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from mappath");
        while(rs.next()){
            String origin = rs.getString("origin");
            String destination = rs.getString("destination");
            int length = rs.getInt("length");
            String information = rs.getString("information");
            if(ret.containsKey(origin)){
                ret.get(origin).addPath(destination, length);
            }else{
                Location tmp = new Location(origin, information);
                tmp.addPath(destination, length);
                ret.put(origin, tmp);
            }
        }
        return ret;
    }
}
