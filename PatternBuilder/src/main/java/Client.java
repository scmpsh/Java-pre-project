
import Director.Director;
import builders.CarBuilder;
import builders.CarManualBuilder;

public class Client {
    public static void main(String[] args) {

        CarBuilder carBuilder = new CarBuilder();
        Director director = new Director();
        director.buildHatchbackCar(carBuilder);
        System.out.println(carBuilder.getCar().getCarType());

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.buildSportCar(carManualBuilder);
        System.out.println(carManualBuilder.getManual());
    }
}
