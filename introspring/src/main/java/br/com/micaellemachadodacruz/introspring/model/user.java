package br.com.micaellemachadodacruz.introspring.model;

public class user {
    public int id;
    private String fullName;
    private String nickName;
    private String password;
    private byte age;
    

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFullName(){
        return this.fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getNickName(){
        return this.nickName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public byte getAge(){
        return this.age;
    }

    public void setAge(byte age){
        this.age = age;
    }
}
