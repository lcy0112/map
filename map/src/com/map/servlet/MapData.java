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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "MapData")
public class MapData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QueryLocation ql = new QueryLocationImp();
        List<Location> locations = ql.getLocations();
        Set<String> points = new HashSet<>();
        for (Location l: locations) {
            points.add(l.getOrigin());
        }
        request.setAttribute("points", points);
        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }
}
