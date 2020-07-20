package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:08 on 2020/4/9
 * @version V0.1
 * @classNmae AnnotationServlet
 */
@WebServlet("/myAnnotationServlet")
public class AnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("AnnotationServlet 在处理get请求...");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");
        out.println("<strong>Annotation Servlet!</strong><br>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("AnnotationServlet 在处理post请求...");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");
        out.println("<strong>Annotation Servlet!</strong><br>");

    }

}