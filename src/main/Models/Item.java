package main.Models;

public class Item {
    private Integer pid;
    private String brand;
    private String category;
    private Double price;
    private Integer stock;

    public Item() {
    }

    public Item(Integer pid, String category, String brand, Double price, Integer stock) {
        this.pid = pid;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}