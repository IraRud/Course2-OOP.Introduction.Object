package skypro.java.course2.transport;
import static skypro.java.course2.transport.ValidateUtils.validateString;

public class Transport {
    final private String brand;   // марка
    final private String model;   // модель
    final private int year;   // год выпуска
    final private String country; // страна производства
    private String color;   // цвет кузова
    private double maxSpeed;    // максимальная скорость передвижения

    public Transport(String brand, String model, int year, String country, String color, double maxSpeed) {
        this.brand = validateStringValue(brand);
        this.model = validateStringValue(model);
        this.year = validateYear(year);
        this.country = validateStringValue(country);
        this.color = validateColor(color);
        this.maxSpeed = validateSpeed(maxSpeed);
    }

    private String validateStringValue(String value) {
        return validateString(value, "default");
    }

    private int validateYear(int year) {
        return year <= 0 ? 2000 : year;
    }

    private String validateColor(String value) {
        return validateString(value, "белый");
    }

    private double validateSpeed(double maxSpeed) {
        return maxSpeed < 40 ? 40 : maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = validateColor(color);
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed =  validateSpeed(maxSpeed);
    }
}