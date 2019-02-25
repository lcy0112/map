package com.map.service.imp;

import com.map.dao.ChangeData;
import com.map.dao.imp.ChangeDataImp;
import com.map.service.ChangePath;

public class ChangePathImp implements ChangePath {
    @Override
    public boolean addPath(String origin, String destination, int length) {
        boolean b1 = false, b2 = false;
        try {
            b1 = cd.addPath(origin, destination, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            b2 = cd.addPath(destination, origin, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b1 && b2;
    }

    @Override
    public boolean changeLength(String origin, String destination, int length) {
        boolean b1 = false, b2 = false;
        try {
            b1 = cd.changeLength(origin, destination, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            b2 = cd.changeLength(destination, origin, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b1 && b2;
    }

    @Override
    public boolean delPath(String origin, String destination) {
        boolean b1 = false, b2 = false;
        try {
            b1 = cd.delPath(origin, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            b2 = cd.delPath(destination, origin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b1 && b2;
    }

    private ChangeData cd = new ChangeDataImp();
}
