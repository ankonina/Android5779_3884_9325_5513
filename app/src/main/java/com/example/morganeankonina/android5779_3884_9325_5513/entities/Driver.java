package com.example.morganeankonina.android5779_3884_9325_5513.entities;

import java.util.Objects;

/**
 * the Driver class describes the properties of the driver
 */
public class Driver {
    private String familyName;
    private String name;
    private int id;
    private int phone;
    private String email;
    private int visaCard;

    /**
     * Empty ctor
     * */
    public Driver() {
        this.familyName = "";
        this.name = "";
        this.id = 0;
        this.phone = 0;
        this.email = "";
        this.visaCard = 0;
    }
    /**
     * Ctor
     */
    public Driver(String familyName, String name, int id, int phone, String email, int visaCard) {
        this.familyName = familyName;
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.visaCard = visaCard;
    }
    /**-------------------------Getters-------------------------------------------------------------
     */
    public String getFamilyName() {
        return familyName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    public int getVisaCard() {
        return visaCard;
    }
    /**-------------------------Setters-------------------------------------------------------------
     * */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVisaCard(int visaCard) {
        this.visaCard = visaCard;
    }

    /**
     * toString function that represents the class Driver
     * @return String
     */
    @Override
    public String toString() {
        return "Driver{" +
                "familyName='" + familyName + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", visaCard=" + visaCard +
                '}';
    }

    /**
     * equals function chesks if two drivers are equal
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return getId() == driver.getId();
    }
}
