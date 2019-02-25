package com.map.service.imp;

import com.map.dao.ChangeInformation;
import com.map.dao.imp.ChangeInformationImp;
import com.map.service.ChangeDetail;

public class ChangeDetailImp implements ChangeDetail {
    @Override
    public boolean changeDetail(String origin, String information) {
        boolean ret = false;
        try {
            ret = ci.changeInformation(origin, information);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    private ChangeInformation ci = new ChangeInformationImp();
}
