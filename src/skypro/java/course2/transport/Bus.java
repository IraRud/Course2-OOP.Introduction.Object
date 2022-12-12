package skypro.java.course2.transport;

public class Bus extends Transport {

    public Bus(String brand, String model, int year, String country) {
        super(brand, model, year, country);
    }

    public Bus(String brand, String model, int year, String country, String color, double maxSpeed) {
        super(brand, model, year, country, color, maxSpeed);
    }

    @Override
    public String toString() {
        return "Автобус: " + super.toString();
    }
}
