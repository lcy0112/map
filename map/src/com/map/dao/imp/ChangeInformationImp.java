package com.map.dao.imp;

import com.map.dao.ChangeInformation;
import com.map.utils.DBUtils;

import java.sql.Connection;
import java.sql.Statement;

public class ChangeInformationImp implements ChangeInformation {
    @Override
    public boolean changeInformation(String origin, String information) throws Exception {
        String sql = String.format("update mappath set information = '%s' where origin = '%s'", information, origin);
        Connection conn = DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        if(count != 0){
            return true;
        }else {
            return false;
        }
    }
}
