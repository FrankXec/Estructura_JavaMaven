package com.frank.javamavenestructura.controller;

import com.frank.javamavenestructura.dao.ProductDAO;
import com.frank.javamavenestructura.dto.ProductDTO;
import java.util.List;

public class ProductController {
    private ProductDAO dao;
    
    public ProductController(){
        dao = new ProductDAO();
    }
    
    public List<ProductDTO> getAll(){
        return dao.getAll();
    }
    
    public ProductDTO getOneById(String id){
        return dao.getOneById(id);
    }
    
    public boolean create(ProductDTO entity){
        return dao.create(entity);
    }
    
    public boolean update(ProductDTO entity){
        return dao.update(entity);
    }
    
    public boolean delete(String id){
        return dao.delete(id);
    }
}
