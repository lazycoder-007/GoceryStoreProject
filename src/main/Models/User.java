package main.Models;

public class User {
    private String name;
    private String address;
    private Double walletAmount;

    public User(String name, String address, Double walletAmount) {
        this.name = name;
        this.address = address;
        this.walletAmount = walletAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(Double walletAmount) {
        this.walletAmount = walletAmount;
    }

    public void decreaseWalletAmount(Double value)
    {
        this.walletAmount = this.walletAmount - value;
    }

    public void increaseWalletAmount(Double value)
    {
        this.walletAmount = this.walletAmount + value;
    }
}
