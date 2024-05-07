package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class TruckImpl extends VehicleImpl implements Truck {

    public static final int MAKE_NAME_LEN_MIN = 2;
    public static final int MAKE_NAME_LEN_MAX = 15;
    private static final String MAKE_NAME_LEN_ERR = format(
            "Make must be between %s and %s characters long!",
            MAKE_NAME_LEN_MIN,
            MAKE_NAME_LEN_MAX);
    public static final int MODEL_NAME_LEN_MIN = 1;
    public static final int MODEL_NAME_LEN_MAX = 15;
    private static final String MODEL_NAME_LEN_ERR = format(
            "Model must be between %s and %s characters long!",
            MODEL_NAME_LEN_MIN,
            MODEL_NAME_LEN_MAX);
    public static final double PRICE_VAL_MIN = 0;
    public static final double PRICE_VAL_MAX = 1000000;
    private static final String PRICE_VAL_ERR = format(
            "Price must be between %.1f and %.1f!",
            PRICE_VAL_MIN,
            PRICE_VAL_MAX);
    public static final int WEIGHT_CAP_MIN = 1;
    public static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);

    private static final int TRUCK_COUNT_WHEELS = 8;

    private int weightCapacity;

    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make, model, price);
        setWeightCapacity(weightCapacity);
    }

    @Override
    protected void validateVehicleMake(String make) {
        ValidationHelpers.validateStringLength(make, MAKE_NAME_LEN_MIN, MAKE_NAME_LEN_MAX, MAKE_NAME_LEN_ERR);
    }

    @Override
    protected void validateVehicleModel(String model) {
        ValidationHelpers.validateStringLength(model, MODEL_NAME_LEN_MIN, MODEL_NAME_LEN_MAX, MODEL_NAME_LEN_ERR);
    }

    @Override
    protected void validatePrice(double price) {
        ValidationHelpers.validateDecimalRange(price, PRICE_VAL_MIN, PRICE_VAL_MAX, PRICE_VAL_ERR);
    }

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }

    @Override
    public int getWheels() {
        return TRUCK_COUNT_WHEELS;
    }


    @Override
    public String toString() {
        return """
                %s
                Weight Capacity: %dt
                """.formatted(super.toString(), weightCapacity);
    }

    private void setWeightCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(weightCapacity, WEIGHT_CAP_MIN, WEIGHT_CAP_MAX, WEIGHT_CAP_ERR);
        this.weightCapacity = weightCapacity;
    }

}