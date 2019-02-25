package com.map.dao;

public interface ChangeInformation {

    /**
     * 根据所给点来修改详细信息
     * @param origin 待修改的点
     * @param information 修改为的信息
     * @return 是否修改成功
     * @throws Exception SQL异常
     */
    boolean changeInformation(String origin, String information) throws Exception;
}
