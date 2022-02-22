package Director;

import Cars.CarType;
import Components.Engine;
import builders.Builder;

public class Director {
    public void buildSportCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(2.0));
    }

    public void buildHatchbackCar(Builder builder) {
        builder.setCarType(CarType.HATCHBACK);
        builder.setSeats(4);
        builder.setEngine(new Engine(1.5));
    }
}
