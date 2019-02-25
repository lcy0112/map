package com.map.servlet;

import com.map.algorithm.AllPath;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "AdvanceSearch")
public class AdvanceSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        origin = URLDecoder.decode(origin, "UTF-8");
        destination = URLDecoder.decode(destination, "UTF-8");
        QueryLocation ql = new QueryLocationImp();
        Map<String, Location> map = ql.getAdjacencyList();
        Set<List<String>> allPath = AllPath.getAllPath(origin, destination, map);
        List<String> tmp = new LinkedList<>();
        for(List<String> list : allPath){
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < list.size() - 1; i++){
                sb.append(list.get(i));
                sb.append("-->");
            }
            sb.append(list.get(list.size() - 1));
            sb.append("<br />");
            tmp.add(sb.toString());
        }
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < tmp.size(); i++){
            res.append(tmp.get(i));
        }
        response.getWriter().print(res.toString());
    }
}
