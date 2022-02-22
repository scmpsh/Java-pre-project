package builders;

import Cars.Car;
import Cars.CarType;
import Cars.Manual;
import Components.Engine;

public class CarManualBuilder implements Builder {
    private CarType type;
    private Engine engine;
    private int seats;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
        System.out.println("set type manual " + type);
    }

    @Override
    public void setSeats(int number) {
        this.seats = number;
        System.out.println("set seats manual" + number);
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("set engine manual" + engine);
    }

    public Manual getManual() {
        return new Manual(type, engine, seats);
    }
}
