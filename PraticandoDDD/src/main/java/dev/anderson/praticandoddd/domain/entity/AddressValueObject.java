package dev.anderson.praticandoddd.domain.entity;

public class AddressValueObject {

    private String street;
    private String number;
    private String zipCode;
    private String city;


    public AddressValueObject(String street, String number, String city, String zipCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipCode = zipCode;
        this.validate();
    }

    public void validate() {
        if (this.street == null || this.street.trim().equals("")) {
            throw new IllegalArgumentException("Rua do endereço é obrigatório");
        }
        if (this.number == null || this.number.trim().equals("")) {
            throw new IllegalArgumentException("Número do endereço é obrigatório");
        }
        if (this.city == null || this.city.trim().equals("")) {
            throw new IllegalArgumentException("Cidade do endereço é obrigatório");
        }
        if (this.zipCode == null || this.zipCode.trim().equals("")) {
            throw new IllegalArgumentException("CEP do endereço é obrigatório");
        }
    }

    public String toString() {
        return this.street + ", " + this.number + ", " + this.city + ", " + this.zipCode;
    }
}
