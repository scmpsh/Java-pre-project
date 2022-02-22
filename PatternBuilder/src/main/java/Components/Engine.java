package Components;

public class Engine {
    private double force;

    public Engine(double force) {
        this.force = force;
    }

    @Override
    public String toString() {
        return "force=" + force;
    }
}
