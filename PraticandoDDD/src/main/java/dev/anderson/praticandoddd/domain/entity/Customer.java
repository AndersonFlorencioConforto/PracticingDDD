package dev.anderson.praticandoddd.domain.entity;

//Entidade focada em negócio , diferente de entidade de banco de dados ORM que é focada em persistência
public class Customer {

    private String id;
    private String name;
    private AddressValueObject address;
    private int rewards = 0;
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

    public void addRewards(double value){
        this.rewards += value;
    }

    public int getRewards() {
        return rewards;
    }

    public String getId() {
        return id;
    }

    //Não tem problema ter um setAddress pois ele é um value object, ou seja, sempre vai receber um Address.
    public void setAddress(AddressValueObject addressValueObject) {
        this.address = addressValueObject;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public AddressValueObject getAddress() {
        return address;
    }

    public String toString(){
        return this.id + ", " + this.name + ", " + this.address.toString() + ", " + this.active;
    }
}
