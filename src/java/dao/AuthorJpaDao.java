/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import model.Author;

/**
 *
 * @author richou
 */
public class AuthorJpaDao extends JpaDao<Author> implements AuthorDao {
    
    private static AuthorJpaDao instance;
    
    private AuthorJpaDao() {
        
    }
    
    protected static AuthorJpaDao getInstance() {
        if(instance == null)
            instance = new AuthorJpaDao();
        return instance;
    }

    @Override
    public Author find(long id) {
        return em.find(Author.class, Integer.valueOf((int) id));
    }

    @Override
    public Collection<Author> findAll() {        
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
