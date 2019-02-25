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
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Map;

@WebServlet(name = "SearchInformation")
public class SearchInformation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String origin = request.getParameter("origin");
        origin = URLDecoder.decode(origin, "UTF-8");
        QueryLocation ql = new QueryLocationImp();
        Map<String, Location> map = ql.getAdjacencyList();
        PrintWriter out = response.getWriter();
        String information = map.get(origin).getInformation();
        out.print(information);
    }
}
