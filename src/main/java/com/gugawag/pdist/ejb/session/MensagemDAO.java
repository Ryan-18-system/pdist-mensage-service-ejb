package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName = "bd2")
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(MensagemDAO.class.getName());

    public void inserir(Mensagem mensagem) {

        logger.log(Level.INFO, mensagem.toString());
        em.merge(mensagem);
    }

    public List<Mensagem> listar() {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT * FROM tb_mensagem");
        return em.createNativeQuery(consulta.toString(), Mensagem.class).getResultList();
    }

    public Mensagem pesquisarPorId(long id) {
        String sql = "SELECT * FROM tb_mensagem WHERE id = :id";
        Query query = em.createNativeQuery(sql, Mensagem.class);
        query.setParameter("id", id);

        try {
            return (Mensagem) query.getSingleResult();
        } catch (NoResultException e) {

            return null;
        }
    }

}
