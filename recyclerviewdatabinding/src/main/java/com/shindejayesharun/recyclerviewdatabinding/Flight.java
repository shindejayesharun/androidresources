package com.shindejayesharun.recyclerviewdatabinding;

public class Flight {
    private int id;
    private String name,fromLocation,toLocation,startTime,reachTime,price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getReachTime() {
        return reachTime;
    }

    public void setReachTime(String reachTime) {
        this.reachTime = reachTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Flight() {
    }

    public Flight(int id, String name, String fromLocation, String toLocation, String startTime, String reachTime, String price) {
        this.id = id;
        this.name = name;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.startTime = startTime;
        this.reachTime = reachTime;
        this.price = price;
    }
}
