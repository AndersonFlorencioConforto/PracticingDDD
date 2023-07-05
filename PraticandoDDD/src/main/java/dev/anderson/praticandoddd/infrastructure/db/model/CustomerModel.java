package dev.anderson.praticandoddd.infrastructure.db.model;

import dev.anderson.praticandoddd.domain.entity.AddressValueObject;
import dev.anderson.praticandoddd.domain.entity.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerModel {

    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "reward_points", nullable = false)
    private Integer rewardPoints;

    public CustomerModel() {
    }

    private CustomerModel(String id, String name, String street, String number, String zipCode, String city, boolean active, Integer rewardPoints) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.active = active;
        this.rewardPoints = rewardPoints;
    }

    public static CustomerModel from(Customer customer) {
        return new CustomerModel(
                customer.getId(),
                customer.getName(),
                customer.getAddress().getStreet(),
                customer.getAddress().getNumber(),
                customer.getAddress().getZipCode(),
                customer.getAddress().getCity(),
                customer.isActive(),
                customer.getRewards());
    }

    public Customer toAggregate() {
        Customer customer = new Customer(this.id, this.name);
        customer.setAddress(new AddressValueObject(this.street, this.number, this.zipCode, this.city));
        customer.addRewards(this.rewardPoints);
        if (this.active) {
            customer.activate();
        }
        return customer;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public boolean isActive() {
        return active;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }
}
