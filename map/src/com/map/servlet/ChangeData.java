package com.map.servlet;

import com.map.service.ChangePath;
import com.map.service.imp.ChangePathImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "ChangeData")
public class ChangeData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        int length = Integer.parseInt(request.getParameter("length"));
        origin = URLDecoder.decode(origin, "UTF-8");
        destination = URLDecoder.decode(destination, "UTF-8");
        ChangePath cp = new ChangePathImp();
        boolean ret = cp.changeLength(origin, destination, length);
        response.getWriter().print(ret);
    }
}
