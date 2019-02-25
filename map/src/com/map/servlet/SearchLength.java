package com.map.servlet;

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
import java.util.Map;

@WebServlet(name = "SearchLength")
public class SearchLength extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        origin = URLDecoder.decode(origin, "UTF-8");
        destination = URLDecoder.decode(destination, "UTF-8");
        QueryLocation ql = new QueryLocationImp();
        Map<String, Location> map = ql.getAdjacencyList();
        int len = map.get(origin).getPath().get(destination);
        response.getWriter().print(len);
    }
}
