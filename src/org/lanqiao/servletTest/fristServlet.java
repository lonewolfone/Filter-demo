package org.lanqiao.servletTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/fristServlet")
public class fristServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //转发：一次请求
        //request.getRequestDispatcher("/secondServlet").forward(request,response);
        //重定向
        //response.sendRedirect("/secondServlet");
        //请求包含
        //request.getRequestDispatcher("/secondServlet").include(request,response);
        //包含
        //request.getRequestDispatcher("/secondServlet").include(request,response);
        System.out.println("fristServlet........................................");
        out.write("firstServlet.................................");


    }
}
