package com.map.service;

public interface ChangeDetail {

    /**
     * 根据所给点修改详细信息
     * @param origin 指定点
     * @param information 要修改成的信息
     * @return 是否修改成功
     */
    boolean changeDetail(String origin, String information);
}
