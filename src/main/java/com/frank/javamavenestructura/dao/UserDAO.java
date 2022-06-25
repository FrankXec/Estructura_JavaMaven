package com.frank.javamavenestructura.dao;

import com.frank.javamavenestructura.config.MYSQLConnection;
import com.frank.javamavenestructura.dto.UserDTO;
import com.frank.javamavenestructura.interfaces.ICRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements ICRUD<UserDTO>{
    private String query;
    private Connection con;

    @Override
    public List<UserDTO> getAll() {
        query = "SELECT * FROM USER";
        con = MYSQLConnection.getConnection();
        if(con != null){
            List<UserDTO> list = new ArrayList<>();
            try{
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    list.add(new UserDTO(
                            resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    ));
                }
                con.close();
                statement.close();
                resultSet.close();
                return list;
            }catch(Exception ex){
                System.out.println("Error.User.getAll: "+ex);
            }
        }
        return null;
    }

    @Override
    public UserDTO getOneById(String id) {
        query = "SELECT * FROM USER WHERE ID = ?"; 
        con = MYSQLConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement prepareStatement = con.prepareStatement(query);
                prepareStatement.setInt(1, Integer.parseInt(id));
                
                ResultSet result = prepareStatement.executeQuery();
                UserDTO user = null;
                while(result.next()){
                    user = new UserDTO(
                            result.getLong(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getString(5),
                            result.getString(6)
                    );
                }
                con.close();
                prepareStatement.close();
                result.close();
                return user;
            }catch(Exception ex){
                System.out.println("Error.User.getOneById: "+ex);
            }
        }
        return null;
    }

    @Override
    public boolean create(UserDTO entity) {
        query = "INSERT INTO USER(NAME,LASTNAME,NICKNAME,EMAIL,PASSWORD) VALUES(?,?,?,?,?)";
        con = MYSQLConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getLastName());
                ps.setString(3, entity.getNickName());
                ps.setString(4, entity.getEmail());
                ps.setString(5, entity.getPassword());
                
                int status = ps.executeUpdate();
                if(status == 1){
                    return true;
                }
            }catch(Exception ex){
                System.out.println("Error.User.Create: "+ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(UserDTO entity) {
        query = "UPDATE USER SET NAME = ?, NICKNAME = ?, PASSWORD = ? WHERE ID = ?";
        con = MYSQLConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getNickName());
                ps.setString(3, entity.getPassword());
                ps.setLong(4, entity.getId());
                
                int status = ps.executeUpdate();
                con.close();
                ps.close();
                if(status == 1){
                    return true;
                }
            }catch(Exception ex){
                System.out.println("Error.User.Update: "+ex);
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        query = "DELETE FROM USER WHERE ID = ?";
        con = MYSQLConnection.getConnection();
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
                System.out.println("Error.User.Delete: "+ex);
            }
        }
        return false;
    }
    
}
