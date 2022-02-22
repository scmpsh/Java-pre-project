package builders;

import Cars.Car;
import Cars.CarType;
import Components.Engine;

public class CarBuilder implements Builder {

    private CarType type;
    private Engine engine;
    private int seats;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
        System.out.println("set type " + type);
    }

    @Override
    public void setSeats(int number) {
        this.seats = number;
        System.out.println("set seats " + number);
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("set engine " + engine);
    }

    public Car getCar() {
        return new Car(type, engine, seats);
    }

}
