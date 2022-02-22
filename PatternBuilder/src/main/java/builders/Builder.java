package builders;

import Cars.CarType;
import Components.Engine;

public interface Builder {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);
}
