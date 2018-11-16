package org.lanqiao.servletTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        //用户在登陆后，将用户的信息保存在Session中
        HttpSession session = request.getSession();
        if( !username.equals("") && username != null){
             session.setAttribute("username",username);
             request.getRequestDispatcher("/success.jsp").forward(request,response);
        }
    }
}
