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
public abstract class DaoFactory {
    public enum PersistenceType {
        JPA,
        JDBC,
        XML
    };
    
    public static DaoFactory getDaoFactory(PersistenceType type) {
        switch(type) {
            case JPA:
                return new JpaDaoFactory();
            case JDBC:
                throw new UnsupportedOperationException("Not implemented yet.");
            case XML:
                throw new UnsupportedOperationException("Not implemented yet.");
            default:
                return null;
        }
    }
    
    public abstract AuthorDao getAuthorDao();
    
    public abstract CategoryDao getCategoryDao();
    public abstract InformationDao getInformationDao();
    public abstract ParagraphDao getParagraphDao();
}
