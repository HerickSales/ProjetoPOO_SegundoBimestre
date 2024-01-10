/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Emprestimo;


/**
 *
 * @author lefoly
 */
public class EmprestimoDaoJpa implements InterfaceDao<Emprestimo> {

    @Override
    public void incluir(Emprestimo entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Emprestimo entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Emprestimo entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            Emprestimo e1 = em.find(Emprestimo.class, entidade.getId());
            em.remove(e1);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }   

    @Override
    public Emprestimo pesquisarPorId(int id) throws Exception {
        Emprestimo e = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            e = em.find(Emprestimo.class, id);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return e;
    }

    @Override
    public List<Emprestimo> listar() throws Exception {
        List<Emprestimo> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("FROM Emprestimo e").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }


    
    @Override
    public List<Emprestimo> filtrarPorNome(String nome) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Emprestimo> filtrarPorTitulo(String titulo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Emprestimo> filtrarPorNomeOuTitulo(int id) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        Query query = em.createNamedQuery("Emprestimo.filtrarPorNomeOuTitulo");
        query.setParameter("id", id);
        List<Emprestimo> resultado = query.getResultList();
        return resultado;    }
}


