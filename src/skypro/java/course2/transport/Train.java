package skypro.java.course2.transport;

import java.time.LocalTime;

import static skypro.java.course2.transport.ValidateUtils.validateString;

public class Train extends Transport {
    private double cost;   // цена поездки
    final private LocalTime time;     // время поездки
    final private String departureStation;    // название станции отбытия
    final private String finalStation;    // конечная остановка
    private int numberOfWagons;     // количество вагонов

    public Train(String brand, String model, int year, String country, String color, double maxSpeed, double cost, LocalTime time, String departureStation, String finalStation, int numberOfWagons) {
        super(brand, model, year, country, color, maxSpeed);
        this.cost = validateCost(cost);
        this.time = validateTime(time);
        this.departureStation = validateStringValue(departureStation);
        this.finalStation = validateStringValue(finalStation);
        this.numberOfWagons = validateNumberOfWagons(numberOfWagons);
    }

    private double validateCost(double cost) {
        return cost <= 0 ? 1_000 : cost;
    }

    private String validateStringValue(String value) {
        return validateString(value, "default");
    }

    private LocalTime validateTime(LocalTime time) {
        return time == null ? LocalTime.of(1, 15) : time;
    }

    private int validateNumberOfWagons(int numberOfWagons) {
        return numberOfWagons < 3 ? 3 : numberOfWagons;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = validateCost(cost);
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getFinalStation() {
        return finalStation;
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    public void setNumberOfWagons(int numberOfWagons) {
        this.numberOfWagons = validateNumberOfWagons(numberOfWagons);
    }

    @Override
    public String toString() {
        return "Поезд: " + super.toString() + " Стоимость поездки — " + cost + " p., время поездки — " + time + ", станиция отправления — " +
                departureStation + ", конечная станиция — " + finalStation + ", количество вагонов — " + numberOfWagons + ".";
    }
}
