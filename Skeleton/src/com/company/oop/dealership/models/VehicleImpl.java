package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.FormattingHelpers;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleImpl implements Vehicle {

    private String make;
    private String model;
    private double price;
    private final List<Comment> comments;

    public VehicleImpl(String make, String model, double price) {
        setMake(make);
        setModel(model);
        setPrice(price);
        this.comments = new ArrayList<>();
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return """
                Make: %s
                Model: %s
                Wheels: %d
                Price: $%s"""
                .formatted(make, model, getWheels(), FormattingHelpers.removeTrailingZerosFromDouble(price));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleImpl vehicle = (VehicleImpl) o;
        return price == vehicle.price &&
                make.equals(vehicle.make) &&
                model.equals(vehicle.model);
    }


    protected abstract void validateVehicleMake(String make);
    protected abstract void validateVehicleModel(String model);
    protected abstract void validatePrice(double price);


    private void setMake(String make) {
        validateVehicleMake(make);
        this.make = make;
    }

    private void setModel(String model) {
        validateVehicleModel(model);
        this.model = model;
    }

    private void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

}
