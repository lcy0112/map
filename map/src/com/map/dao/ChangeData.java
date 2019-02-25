package com.map.dao;

public interface ChangeData {
    /**
     * 根据指定数据添加一条路径
     * @param origin 起始位置
     * @param destination 终点位置
     * @param length 路径长度
     * @return 添加是否成功
     * @throws Exception SQL异常
     */
    boolean addPath(String origin, String destination, int length) throws Exception;

    /**
     * 根据指定数据修改一条路径
     * @param origin 起始点
     * @param destination 终点
     * @param length 待修改的长度
     * @return 是否修改成功
     * @throws Exception SQL异常
     */
    boolean changeLength(String origin, String destination, int length) throws Exception;

    /**
     * 根据所给数据删除一条路径
     * @param origin 起始点
     * @param destination 终点
     * @return 是否删除成功
     * @throws Exception SQL异常
     */
    boolean delPath(String origin, String destination) throws Exception;
}
