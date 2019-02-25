package com.map.servlet;

import com.map.algorithm.Kruskal;
import com.map.domain.Location;
import com.map.service.QueryLocation;
import com.map.service.imp.QueryLocationImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

@WebServlet(name = "MultiPoints")
public class MultiPoints extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] points = request.getParameterValues("point");
        if(points.length == 0){
            response.getWriter().print("无数据");
            return;
        }
        for(int i = 0; i < points.length; i++){
            points[i] = URLDecoder.decode(points[i], "UTF-8");
        }
        QueryLocation ql = new QueryLocationImp();
        Map<String, Location> map = ql.getAdjacencyList();
        Map<String, Location> subMap = Kruskal.getSubMap(points, map);
        Map<String, Location> litteTree = Kruskal.Kruskal(subMap);
        Set<List<String>> res = Kruskal.getBFSResult(points[0], litteTree);
        StringBuffer sb = new StringBuffer();
        for(List<String> list : res){
            StringBuffer tmp = new StringBuffer();
            tmp.append("[");
            for(int i = 0; i < list.size(); i++){
                tmp.append(list.get(i));
                if(i != list.size() - 1){
                    tmp.append(", ");
                }
            }
            tmp.append("]<br />");
            sb.append(tmp.toString());
        }
        response.getWriter().print(sb.toString());
    }
}
