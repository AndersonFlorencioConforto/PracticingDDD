package dev.anderson.praticandoddd.entity;

//Entidade focada em negócio , diferente de entidade de banco de dados ORM que é focada em persistência
public class Customer {

    private String id;
    private String name;
    private Address address;
    private boolean active = false;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.validate();
    }

    //regra de negócio
    public void changeName(String name){
        this.name = name;
        this.validate();
    }

    //regra de negócio
    public void activate(){
        if (this.address == null){
            throw new IllegalArgumentException("Endereço do cliente é obrigatório");
        }
        this.active = true;
    }

    //regra de negócio
    public void deactivate(){
        this.active = false;
    }

    public void validate(){
        if(this.name == null || this.name.trim().equals("")){
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }
        if (this.id == null || this.id.trim().equals("")){
            throw new IllegalArgumentException("Id do cliente é obrigatório");
        }
    }

    //Não tem problema ter um setAddress pois ele é um value object, ou seja, sempre vai receber um Address.
    public void setAddress(Address address) {
        this.address = address;
    }
}
