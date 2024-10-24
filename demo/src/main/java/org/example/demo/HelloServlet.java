package org.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
// @WebServlet 어노테이션
// : 해당 서블릿을 문자열의 URL 패턴과 매핑
// : "/hello" 요청의 경우 해당 서블릿이 처리
public class HelloServlet extends HttpServlet {

    // HTTP GET 요청을 처리하는 doGet 메서드 - 재정의
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HelloController controller = new HelloController();
        controller.handleRequest();

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>Servlet Processed MVC</h1>");
    }
}