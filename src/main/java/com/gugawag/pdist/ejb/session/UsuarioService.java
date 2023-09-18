package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


import java.util.List;

@Stateless(name = "usuarioService")
public class UsuarioService {
    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private MensagemService mensagemService;
    public void inserir(long id, String nome) {
        Usuario novoUsuario = new Usuario(id, nome);
        if(id == 4L){
            mensagemService.inserir("mensagem 4u");
        }
        this.usuarioDAO.inserir(novoUsuario);
    }

    public List<Usuario> listar() {
        return this.usuarioDAO.listar();
    }
}
