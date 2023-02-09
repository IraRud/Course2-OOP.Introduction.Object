package skypro.java.course2.transport;

public class Bus extends Transport {

    public Bus(String brand, String model, int year, String country) {
        super(brand, model, year, country, "белый", 40, 100);
    }

    public Bus(String brand, String model, int year, String country, String color, double maxSpeed, double fuelPercentage) {
        super(brand, model, year, country, color, maxSpeed, fuelPercentage);
    }

    @Override
    public void refill() {
        System.out.println("Автобусы можно заправлять бензином или дизелем на заправке!");
        setFuelPercentage(100.00);
    }

    @Override
    public String toString() {
        return "Автобус: " + super.toString();
    }
}
