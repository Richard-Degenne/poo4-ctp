/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author richou
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Information.findAll", query = "SELECT i FROM Information i"),
    @NamedQuery(name = "Information.findById", query = "SELECT i FROM Information i WHERE i.id = :id"),
    @NamedQuery(name = "Information.findByTitle", query = "SELECT i FROM Information i WHERE i.title = :title"),
    @NamedQuery(name = "Information.deleteAll", query = "DELETE FROM Information")})
public class Information implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int MainInformation = 1;
    public static final int SecondaryInformation = 2;
    
    
    /*
    Attributes
    */
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date releaseDate;
    
    @Column(nullable=false)
    private String title;
    
    @Column(nullable=false)
    private int views;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable=false)
    private Category category;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable=false)
    private Author author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "information")
    private Collection<Paragraph> paragraphs;
    
    @Column(nullable=false)
    private int informationType;
    
    @Column
    private String summary;
    
    /*
    Constructors
    */
    
    public Information() {
        paragraphs = new ArrayList<>();
        views = 0;
    }

    public Information(Date releaseDate, String title, Category category, Author author, int informationType) {
        this();
        this.releaseDate = releaseDate;
        this.title = title;
        this.category = category;
        this.author = author;
        this.informationType = informationType;
    }

    public Information(Date releaseDate, String title, Category category, Author author, int informationType, String summary) {
        this();
        this.releaseDate = releaseDate;
        this.title = title;
        this.category = category;
        this.author = author;
        this.informationType = informationType;
        this.summary = summary;
    }
    
    
    
    
    /*
    Getters
    */
    
    public Long getId() {
        return id;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public int getViews() {
        return views;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public Collection<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public int getInformationType() {
        return informationType;
    }

    public String getSummary() {
        return summary;
    }
    
    
    /*
    Setters
    */
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setInformationType(int informationType) {
        this.informationType = informationType;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    
    /*
    Methods
    */
    
    public void addParagraph(Paragraph p) {
        if(paragraphs.add(p))
            p.setInformation(this);
    }
    
    public void removeParagraph(Paragraph p) {
        if(paragraphs.remove(p))
            p.setInformation(null);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Information)) {
            return false;
        }
        Information other = (Information) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Information[ id=" + id + ", title=" + title + " ]";
    }
    
}
