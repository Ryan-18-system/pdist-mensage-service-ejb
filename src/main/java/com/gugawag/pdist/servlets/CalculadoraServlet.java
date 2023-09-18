package com.gugawag.pdist.servlets;

import br.edu.ipfb.service.CalculadoraService;
import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/calculadora.do"})
public class CalculadoraServlet  extends HttpServlet {
    @EJB(lookup = "java:global/calculadoraEjb-1.0-SNAPSHOT/calculadoraServiceImpl!br.edu.ipfb.service.CalculadoraService")
    private CalculadoraService calculadoraService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operacao = req.getParameter("oper");
        PrintWriter resposta = resp.getWriter();
        switch (operacao) {
            case "1": { // inserir
                int num1 = Integer.parseInt( req.getParameter("num1"));
                int num2 = Integer.parseInt(req.getParameter("num2"));
                resposta.println(calculadoraService.somar(num1,num2));
            }

        }
    }
}
