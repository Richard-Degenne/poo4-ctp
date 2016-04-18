/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import model.Paragraph;

/**
 *
 * @author richou
 */
public class ParagraphJpaDao extends JpaDao<Paragraph> implements ParagraphDao {
    
    private static ParagraphJpaDao instance;
    
    private ParagraphJpaDao() {
        
    }
    
    protected static ParagraphJpaDao getInstance() {
        if(instance == null)
            instance = new ParagraphJpaDao();
        return instance;
    }

    @Override
    public Paragraph find(long id) {
        return em.find(Paragraph.class, Integer.valueOf((int) id));
    }

    @Override
    public Collection<Paragraph> findAll() {        
        return em.createNamedQuery("Author.findAll").getResultList();
    }

    @Override
    public void deleteAll() {
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.createNamedQuery("Author.deleteAll").executeUpdate();
        et.commit();
    }

    @Override
    public void close() {
        em.close();
    }
}
