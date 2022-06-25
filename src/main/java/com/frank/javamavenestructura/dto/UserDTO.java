package com.frank.javamavenestructura.dto;


public class UserDTO {
    //Attributes
    private Long id;
    private String name;
    private String lastName;
    private String nickName;
    private String email;
    private String password;

    //constructors
    public UserDTO() {
    }

    public UserDTO(Long id, String name, String lastName, String nickName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }
    
    //GettersAndSetters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //tostring
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", nickName=" + nickName + ", email=" + email + ", password=" + password + '}';
    }
}
