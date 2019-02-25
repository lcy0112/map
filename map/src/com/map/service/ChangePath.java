package com.map.service;

public interface ChangePath {
    /**
     * 根据指定数据添加一对路径
     * @param origin 起始点
     * @param destination 终点
     * @param length 距离
     * @return 添加是否成功
     */
    boolean addPath(String origin, String destination, int length);

    /**
     * 根据指定数据修改一对路径
     * @param origin 起始点
     * @param destination 终点
     * @param length 要修改的距离
     * @return 修改是否成功
     */
    boolean changeLength(String origin, String destination, int length);

    /**
     * 根据所给数据删除一对路径
     * @param origin 起始点
     * @param destination 终点
     * @return 删除是否成功
     */
    boolean delPath(String origin, String destination);
}
