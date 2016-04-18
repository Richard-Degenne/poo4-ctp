/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author richou
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Paragraph.findAll", query = "SELECT p FROM Paragraph p"),
    @NamedQuery(name = "Paragraph.findById", query = "SELECT p FROM Paragraph p WHERE p.id = :id"),
    @NamedQuery(name = "Paragraph.findByTitle", query = "SELECT p FROM Paragraph p WHERE p.title = :title"),
    @NamedQuery(name = "Paragraph.deleteAll", query = "DELETE FROM Paragraph")})
public class Paragraph implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /*
    Attributes
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;
    
    private String text;
    
    @JoinColumn(name = "id_information", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Information information;
    /*
    Constructors
    */
    
    public Paragraph() {
        
    }

    public Paragraph(String title, String text) {
        this.title = title;
        this.text = text;
    }
    
    
    /*
    Getters
    */
    
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Information getInformation() {
        return information;
    }

    
    /*
    Setters
    */
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setInformation(Information information) {
        if(this.information != null)
            this.information.removeParagraph(this);
        this.information = information;
    }
    
    
    /*
    Methods
    */
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paragraph)) {
            return false;
        }
        Paragraph other = (Paragraph) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Paragraph[ id=" + id + " ]";
    }
    
}
