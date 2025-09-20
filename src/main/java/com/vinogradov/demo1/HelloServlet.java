package com.vinogradov.demo1;

import java.io.*;
import java.util.stream.Collectors;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "hello", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "HI, please send me your name in Post method!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String boder = request.getReader().lines().collect(Collectors.joining(System.lineSeparator())).split(",")[1].split(":")[1];
        out.println("Your name " + boder);
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String boder = request.getReader().lines().collect(Collectors.joining(System.lineSeparator())).split(",")[1].split(":")[1];
        out.println("PUT name " + boder);
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String boder = request.getReader().lines().collect(Collectors.joining(System.lineSeparator())).split(",")[1].split(":")[1];
        out.println("Delete name " + boder);
    }
}