/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author richou
 */
public class JpaDaoFactory extends DaoFactory {
    
    protected JpaDaoFactory() {
        
    }
    
    /**
     * Get an instance of DAO for Author class, using JPA.
     * 
     * @return An instance of Author DAO using JPA
     */
    @Override
    public AuthorJpaDao getAuthorDao() {
        return AuthorJpaDao.getInstance();
    }
    
    /**
     * Get an instance of DAO for Category class, using JPA.
     * 
     * @return An instance of Category DAO using JPA
     */
    @Override
    public CategoryJpaDao getCategoryDao() {
        return CategoryJpaDao.getInstance();
    }
    
    /**
     * Get an instance of DAO for Category class, using JPA.
     * 
     * @return An instance of Category DAO using JPA
     */
    @Override
    public InformationJpaDao getInformationDao() {
        return InformationJpaDao.getInstance();
    }
    
    /**
     * Get an instance of DAO for Category class, using JPA.
     * 
     * @return An instance of Category DAO using JPA
     */
    @Override
    public ParagraphJpaDao getParagraphDao() {
        return ParagraphJpaDao.getInstance();
    }
}
