/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Author;
import model.Category;
import model.Information;
import model.Paragraph;

/**
 * Test for the JPA interface.
 * 
 * @author richou
 */
public class Test1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POO_CTPPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        Category c = new Category("International");
        Author a = new Author("Richou", "Degenne", "richou", "richdeg2@gmail.com");
        Paragraph p = new Paragraph("Un CTP pas facile", "Le CTP de Java n'est pas facile.");
        
        Information i = new Information(new Date(), "CTP de Java à l'IG2I", c, a, Information.MainInformation);
        i.addParagraph(p);
        
        em.persist(i);
        et.commit();
        System.out.println("Done.");
    }
}
