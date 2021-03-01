package com.araz.controller;

import com.araz.util.GeneratePDF;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


@WebServlet("/pdfGenerate")
public class GeneratePDFController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf;charset=UTF-8");

        resp.addHeader("Content-Disposition", "inline; filename=" + "cities.pdf");
        ServletOutputStream out = resp.getOutputStream();
        HttpSession session = req.getSession();
        List<String> info = (List<String>) session.getAttribute("list");

        ByteArrayOutputStream baos = GeneratePDF.getPdfFile(info);
        baos.writeTo(out);
    }
}
