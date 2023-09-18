package com.gugawag.pdist.servlets;

import com.gugawag.pdist.ejb.session.MensagemService;
import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"mensagem.do"})
public class MensagemServlet extends HttpServlet {

    @EJB(lookup = "java:module/mensagemService")
    private MensagemService mensagemService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operacao = req.getParameter("oper");
        PrintWriter resposta = resp.getWriter();
        switch (operacao) {
            case "1": { // inserir
                Long id = Long.parseLong( req.getParameter("id"));
                String mensagem = req.getParameter("mensagem");
                mensagemService.inserir(mensagem);
            }
            case "2": { // listar
                for(Mensagem mensagem: mensagemService.listar()){
                    resposta.println(mensagem.getTexto());
                }
                break;
            }
            case "3":{
                Long id = Long.parseLong( req.getParameter("id"));
                resposta.println( mensagemService.pesquisarPorId(id));
            }
        }
    }
}
