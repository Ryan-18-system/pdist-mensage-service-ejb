package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless(name = "mensagemService")
public class MensagemService {
    @EJB
    private MensagemDAO mensagemDAO;

    public void inserir(String texto) {
        Mensagem novaMensagem = new Mensagem(texto);
        this.mensagemDAO.inserir(novaMensagem);
    }

    public Mensagem pesquisarPorId(long id) {
        return this.mensagemDAO.pesquisarPorId(id);
    }

    public List<Mensagem> listar() {
        return this.mensagemDAO.listar();
    }
}
