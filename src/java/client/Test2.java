/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dao.AuthorJpaDao;
import dao.CategoryJpaDao;
import dao.DaoFactory;
import dao.InformationJpaDao;
import dao.JpaDaoFactory;
import dao.ParagraphJpaDao;
import java.util.Date;
import model.*;

/**
 * Test for the JPA/DAO layer.
 * @author richou
 */
public class Test2 {
    public static void main(String[] args) {
        
        // Creating test data set
                System.out.println("Creating test data set... ");
        Category c = new Category("International");
        Author a = new Author("Richou", "Degenne", "richou", "richdeg2@gmail.com");
        Paragraph p = new Paragraph("Un CTP pas facile", "Le CTP de Java n'est pas facile.");
        Information i = new Information(new Date(), "CTP de Java à l'IG2I", c, a, Information.MainInformation);
        i.addParagraph(p);
                System.out.println("OK.");
                
                
        // Instanciating DAOs
                System.out.println("Instanciating DAOs...");
        JpaDaoFactory jdf = (JpaDaoFactory) DaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA);
        AuthorJpaDao ajd = jdf.getAuthorDao();
        CategoryJpaDao cjd = jdf.getCategoryDao();
        InformationJpaDao ijd = jdf.getInformationDao();
        ParagraphJpaDao pjd = jdf.getParagraphDao();
                System.out.println("OK.");

                
        // Clearing data
                System.out.println("Clearing data...");
        ajd.deleteAll();
        cjd.deleteAll();
        ijd.deleteAll();
        pjd.deleteAll();
                System.out.println("OK.");

        // Inserting test data set
                System.out.println("Inserting test data set...");
        ijd.create(i);
                System.out.println("OK.");
        
    }
}
