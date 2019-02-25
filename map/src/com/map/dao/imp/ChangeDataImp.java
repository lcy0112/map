package com.map.dao.imp;

import com.map.dao.ChangeData;
import com.map.utils.DBUtils;

import java.sql.Connection;
import java.sql.Statement;

public class ChangeDataImp implements ChangeData {
    @Override
    public boolean addPath(String origin, String destination, int length) throws Exception {
        String sql = String.format("insert into mappath values('%s', '%s', %d, null)", origin, destination, length);
        Connection conn = DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        DBUtils.clossAll(conn, stmt, null);
        if(count != 1) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean changeLength(String origin, String destination, int length) throws Exception {
        String sql = String.format("update mappath set length=%d where origin='%s' and destination='%s'", length, origin, destination);
        Connection conn = DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        DBUtils.clossAll(conn, stmt, null);
        if(count == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delPath(String origin, String destination) throws Exception{
        String sql = String.format("delete from mappath where origin='%s' and destination='%s'", origin, destination);
        Connection conn = DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        DBUtils.clossAll(conn, stmt, null);
        if(count == 1){
            return true;
        }else {
            return false;
        }
    }
}
