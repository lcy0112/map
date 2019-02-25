package com.map.servlet;

import com.map.algorithm.Dijkstra;
import com.map.domain.Location;
import com.map.service.QueryLocation;
import com.map.service.imp.QueryLocationImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.Map;

@WebServlet(name = "ShortestRoute")
public class ShortestRoute extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        origin = URLDecoder.decode(origin, "UTF-8");
        destination = URLDecoder.decode(destination, "UTF-8");
        QueryLocation ql = new QueryLocationImp();
        Map<String, Location> path = ql.getAdjacencyList();
        Map<String, LinkedList<String>> map = Dijkstra.Dijkstra(path, origin);
        LinkedList<String> route = map.get(destination);
        String str = route.get(0);
        for(int i = 1; i < route.size(); i++){
            str += (" --" + path.get(route.get(i - 1)).getPath().get(route.get(i)) + "--> " + route.get(i));
        }
        PrintWriter writer = response.getWriter();
        writer.println("最短路径为: <br />" + str + "<br />");
    }
}
