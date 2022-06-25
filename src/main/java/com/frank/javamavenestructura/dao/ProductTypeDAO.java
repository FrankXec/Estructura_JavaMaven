package com.frank.javamavenestructura.dao;

import com.frank.javamavenestructura.config.SQLSERVERConnection;
import com.frank.javamavenestructura.dto.ProductTypeDTO;
import com.frank.javamavenestructura.interfaces.ICRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDAO implements ICRUD<ProductTypeDTO>{
    private String query;
    private Connection con;

    @Override
    public List<ProductTypeDTO> getAll() {
        query = "SELECT * FROM PRODUCTTYPE";
        con = SQLSERVERConnection.getConnection();
        if(con != null){
            List<ProductTypeDTO> list = new ArrayList<>();
            try{
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    list.add(new ProductTypeDTO(
                            resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    ));
                }
                con.close();
                statement.close();
                resultSet.close();
                return list;
            }catch(Exception ex){
                System.out.println("Error.ProductType.getAll: "+ex);
            }
        }
        return null;
    }

    @Override
    public ProductTypeDTO getOneById(String id) {
        query = "SELECT * FROM PRODUCTTYPE WHERE ID = ?"; 
        con = SQLSERVERConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement prepareStatement = con.prepareStatement(query);
                prepareStatement.setInt(1, Integer.parseInt(id));
                
                ResultSet result = prepareStatement.executeQuery();
                ProductTypeDTO user = null;
                while(result.next()){
                    user = new ProductTypeDTO(
                            result.getLong(1),
                            result.getString(2),
                            result.getString(3)
                    );
                }
                con.close();
                prepareStatement.close();
                result.close();
                return user;
            }catch(Exception ex){
                System.out.println("Error.ProductType.getOneById: "+ex);
            }
        }
        return null;
    }

    @Override
    public boolean create(ProductTypeDTO entity) {
        query = "INSERT INTO PRODUCTTYPE(NAME,DESCRIPTION) VALUES(?,?,?,?,?)";
        con = SQLSERVERConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getDescription());
                
                int status = ps.executeUpdate();
                if(status == 1){
                    return true;
                }
            }catch(Exception ex){
                System.out.println("Error.ProductType.Create: "+ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(ProductTypeDTO entity) {
        query = "UPDATE PRODUCTTYPE SET NAME = ?, DESCRIPTION = ? WHERE ID = ?";
        con = SQLSERVERConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getDescription());
                ps.setLong(3, entity.getId());
                
                int status = ps.executeUpdate();
                con.close();
                ps.close();
                if(status == 1){
                    return true;
                }
            }catch(Exception ex){
                System.out.println("Error.ProductType.Update: "+ex);
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        query = "DELETE FROM PRODUCTTYPE WHERE ID = ?";
        con = SQLSERVERConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.setLong(1, Long.parseLong(id));
                
                int status = ps.executeUpdate();
                con.close();
                ps.close();
                if(status == 1){
                    return true;
                }
            }catch(Exception ex){
                System.out.println("Error.ProductType.Delete: "+ex);
            }
        }
        return false;
    }
}
