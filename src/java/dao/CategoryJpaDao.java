/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import model.Category;

/**
 *
 * @author richou
 */
public class CategoryJpaDao extends JpaDao<Category> implements CategoryDao {
    
    private static CategoryJpaDao instance;
    
    private CategoryJpaDao() {
        
    }
    
    protected static CategoryJpaDao getInstance() {
        if(instance == null)
            instance = new CategoryJpaDao();
        return instance;
    }

    @Override
    public Category find(long id) {
        return em.find(Category.class, Integer.valueOf((int) id));
    }

    @Override
    public Collection<Category> findAll() {        
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    @Override
    public void deleteAll() {
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.createNamedQuery("Category.deleteAll").executeUpdate();
        et.commit();
    }

    @Override
    public void close() {
        em.close();
    }
}
