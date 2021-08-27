package com.model;

public class Person {
    private Long id;
    private String name;
    private String identityCard;
    private String ward;
    private String district;

    public Person() {
    }

    public Person(Long id, String name, String identityCard, String ward, String district) {
        this.id = id;
        this.name = name;
        this.identityCard = identityCard;
        this.ward = ward;
        this.district = district;
    }

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

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", IdentityCard='" + identityCard + '\'' +
                ", ward='" + ward + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
