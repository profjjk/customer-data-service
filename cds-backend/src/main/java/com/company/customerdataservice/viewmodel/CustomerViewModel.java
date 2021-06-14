package com.company.customerdataservice.viewmodel;

import java.util.Objects;

public class CustomerViewModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerViewModel that = (CustomerViewModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getState(), that.getState()) && Objects.equals(getZipcode(), that.getZipcode()) && Objects.equals(getLevel(), that.getLevel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getStreet(), getCity(), getState(), getZipcode(), getLevel());
    }

    @Override
    public String toString() {
        return "CustomerViewModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
