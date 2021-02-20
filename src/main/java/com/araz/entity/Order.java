package com.araz.entity;

import java.util.Date;
import java.util.Objects;

public class Order {
    private int id;
    private String fromCity;
    private String toCity;
    private int distance;
    private Time time;
    private String baggageWeight;
    private float cost;
    private String userId;
    private String status;
    private String date;

    public Order() {

    }

    public Order(int id, String fromCity, String toCity, int distance, Time time, String baggageWeight, float cost, String userId) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
        this.time = time;
        this.baggageWeight = baggageWeight;
        this.cost = cost;
        this.userId = userId;
    }

    public Order(String fromCity, String toCity, int distance, Time time, String baggageWeight, float cost) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
        this.time = time;
        this.baggageWeight = baggageWeight;
        this.cost = cost;
    }

    public Order(int id, String fromCity, String toCity, int distance, Time time, String baggageWeight, float cost, String userId, String status) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
        this.time = time;
        this.baggageWeight = baggageWeight;
        this.cost = cost;
        this.userId = userId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(String baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                distance == order.distance &&
                Float.compare(order.cost, cost) == 0 &&
                Objects.equals(fromCity, order.fromCity) &&
                Objects.equals(toCity, order.toCity) &&
                Objects.equals(time, order.time) &&
                Objects.equals(baggageWeight, order.baggageWeight) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(status, order.status) &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromCity, toCity, distance, time, baggageWeight, cost, userId, status, date);
    }

    public static class Time{

        private String hour;
        private String minute;

        public Time(String hour, String minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public String getMinute() {
            return minute;
        }

        public void setMinute(String minute) {
            this.minute = minute;
        }

        @Override
        public String toString() {
            return hour + " hour " + minute + " minets";
        }
    }

}
