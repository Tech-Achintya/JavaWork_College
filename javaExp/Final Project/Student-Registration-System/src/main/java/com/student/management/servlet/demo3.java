package com.student.management.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validate")
public class demo3 extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("uname");
        String pass = req.getParameter("upass");
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        if ("Hello".equals(name) && "Hello@123".equals(pass)) {
            out.print("{\"message\":\"Hello\"}");
        } else {
            out.print("{\"error\":\"Invalid credentials\"}");
        }
        out.flush();
    }
}
