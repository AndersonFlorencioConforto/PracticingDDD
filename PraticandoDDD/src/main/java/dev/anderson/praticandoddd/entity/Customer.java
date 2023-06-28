package dev.anderson.praticandoddd.entity;

public class Customer {

    private String id;
    private String name;
    private String address;
    private boolean active;

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    //regra de negócio
    public void changeName(String name){
        this.name = name;
    }

    //regra de negócio
    public void activate(){
        this.active = true;
    }

    //regra de negócio
    public void deactivate(){
        this.active = false;
    }





}
