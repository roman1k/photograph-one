package com.example.photographone.models;

public class Search {
    private String city ;
    private int priceLower ;
    private  int priceHigher ;
    private SortedPhotographs sortedPhotographs;

    public Search(String city, int priceLower, int priceHigher, SortedPhotographs sortedPhotographs) {
        this.city = city;
        this.priceLower = priceLower;
        this.priceHigher = priceHigher;
        this.sortedPhotographs = sortedPhotographs;

    }

    public Search() {
    }

    public Search(String city, int priceHigher, SortedPhotographs sortedPhotographs) {
        this.city = city;
        this.priceHigher = priceHigher;
        this.sortedPhotographs =sortedPhotographs;
    }

    public Search(int priceLower, int priceHigher, SortedPhotographs sortedPhotographs) {
        this.priceLower = priceLower;
        this.priceHigher = priceHigher;
        this.sortedPhotographs =sortedPhotographs;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPriceLower() {
        return priceLower;
    }

    public void setPriceLower(int priceLower) {
        this.priceLower = priceLower;
    }

    public int getPriceHigher() {
        return priceHigher;
    }

    public void setPriceHigher(int priceHigher) {
        this.priceHigher = priceHigher;
    }

    @Override
    public String toString() {
        return "Search{" +
                "city=" + city  +
                ", priceLower=" + priceLower +
                ", priceHigher=" + priceHigher +
                '}';
    }
}
