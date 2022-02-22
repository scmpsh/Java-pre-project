package Cars;

import Components.Engine;

public class Car {

    private CarType carType;
    private Engine engine;
    private int seats;

    public Car(CarType carType, Engine engine, int seats) {
        this.carType = carType;
        this.engine = engine;
        this.seats = seats;
    }

    public CarType getCarType() {
        return carType;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getSeats() {
        return seats;
    }
}
