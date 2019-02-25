package com.map.servlet;

import com.map.service.ChangeDetail;
import com.map.service.imp.ChangeDetailImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "ChangeInformation")
public class ChangeInformation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String origin = request.getParameter("origin");
        String information = request.getParameter("information");
        origin = URLDecoder.decode(origin, "UTF-8");
        information = URLDecoder.decode(information, "UTF-8");
        ChangeDetail cd = new ChangeDetailImp();
        boolean res = cd.changeDetail(origin, information);
        response.getWriter().print(res);
    }
}
