/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import model.Category;
import model.Information;

/**
 *
 * @author richou
 */
public interface CategoryDao extends Dao<Category> {
    
    /**
     * Fetches all Informations in the category.
     * 
     * @param c The category to look up
     * @return A container with all Information of the category
     */
    public Collection<Information> findInformations(Category c);
}
