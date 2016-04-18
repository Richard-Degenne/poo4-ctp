/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import model.Information;

/**
 *
 * @author richou
 */
public class InformationJpaDao extends JpaDao<Information> implements InformationDao {
    
    private static InformationJpaDao instance;
    
    private InformationJpaDao() {
        
    }
    
    protected static InformationJpaDao getInstance() {
        if(instance == null)
            instance = new InformationJpaDao();
        return instance;
    }

    @Override
    public Information find(long id) {
        return em.find(Information.class, Integer.valueOf((int) id));
    }

    @Override
    public Collection<Information> findAll() {        
        return em.createNamedQuery("Information.findAll").getResultList();
    }

    @Override
    public void deleteAll() {
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.createNamedQuery("Information.deleteAll").executeUpdate();
        et.commit();
    }

    @Override
    public void close() {
        em.close();
    }
}
