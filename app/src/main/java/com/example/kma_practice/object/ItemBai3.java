package com.example.kma_practice.object;

public class ItemBai3 {

    private String name;
    private String phoneNumber;
    private int image;

    public ItemBai3(String name, String phoneNumber, int image) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ItemBai3{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", image=" + image +
                '}';
    }
}
