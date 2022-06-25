package com.frank.javamavenestructura;

import com.frank.javamavenestructura.controller.*;
import com.frank.javamavenestructura.dto.*;
import java.util.List;

public class JavaMavenEstructura {

    public static void main(String[] args) {
        var controller = new ProductTypeController();
        boolean exito;
        System.out.println("Hola Mundo");
        //MYSQL
        //findAll
        /*List<UserDTO> users = controller.getAll();
        if(users != null){
            for(UserDTO item: users){
                System.out.println(users.toString());
            }
        }else{
            System.out.println("No hay datos");
        }*/
        //findOne
        /*UserDTO user = controller.getOneById("1");
        if(user != null){
            System.out.println(user.toString());
        }else{
            System.out.println("Usuario no encontrado");
        }*/
        //crate
        /*UserDTO userCreate = new UserDTO();
        userCreate.setName("Rolando");
        userCreate.setLastName("Jacinto");
        userCreate.setNickName("rolandoJ");
        userCreate.setEmail("rolando@outlook.es");
        userCreate.setPassword("123455");
        exito = controller.create(userCreate);
        if(exito){
            System.out.println("Guardado con exito!");
        }else{
            System.out.println("Error al guardar");
        }*/
        //update
        /*UserDTO userUpdate = controller.getOneById("7");
        userUpdate.setName("Antonio");
        userUpdate.setNickName("antonioBanderas");
        userUpdate.setPassword("admin456");
        exito = controller.update(userUpdate);
        if(exito){
            System.out.println("Editado con exito");
        }else{
            System.out.println("Error al editar");
        }*/
        //delete
        /*exito = controller.delete("7");
        if(exito){
            System.out.println("Eliminado con exito");
        }else{
            System.out.println("Error al eliminar");
        }*/
        
        //SQLSERVER
        //findAll
        List<ProductTypeDTO> productTypes = controller.getAll();
        if(productTypes != null){
            for(ProductTypeDTO item: productTypes){
                System.out.println(productTypes.toString());
            }
        }else{
            System.out.println("No hay datos");
        }
        //findOne
        /*UserDTO user = controller.getOneById("1");
        if(user != null){
            System.out.println(user.toString());
        }else{
            System.out.println("Usuario no encontrado");
        }*/
        //crate
        /*UserDTO userCreate = new UserDTO();
        userCreate.setName("Rolando");
        userCreate.setLastName("Jacinto");
        userCreate.setNickName("rolandoJ");
        userCreate.setEmail("rolando@outlook.es");
        userCreate.setPassword("123455");
        exito = controller.create(userCreate);
        if(exito){
            System.out.println("Guardado con exito!");
        }else{
            System.out.println("Error al guardar");
        }*/
        //update
        /*UserDTO userUpdate = controller.getOneById("7");
        userUpdate.setName("Antonio");
        userUpdate.setNickName("antonioBanderas");
        userUpdate.setPassword("admin456");
        exito = controller.update(userUpdate);
        if(exito){
            System.out.println("Editado con exito");
        }else{
            System.out.println("Error al editar");
        }*/
        //delete
        /*exito = controller.delete("7");
        if(exito){
            System.out.println("Eliminado con exito");
        }else{
            System.out.println("Error al eliminar");
        }*/
    }
}
