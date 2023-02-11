package skypro.java.course2.transport;
import static skypro.java.course2.transport.ValidateUtils.validateString;

public abstract class Transport {
    final private String brand;   // марка
    final private String model;   // модель
/*    final private int year;   // год выпуска
    final private String country; // страна производства
    private String color;   // цвет кузова
    private double maxSpeed;    // максимальная скорость передвижения
    private double fuelPercentage;  // количество топлива в процентах*/

    public Transport(String brand, String model, int year, String country, String color, double maxSpeed) {
        this(brand, model, year, country, "белый", 40, 100);
    }
    public Transport(String brand, String model, int year, String country, String color, double maxSpeed, double fuelPercentage) {
        this.brand = validateStringValue(brand);
        this.model = validateStringValue(model);
        this.year = validateYear(year);
        this.country = validateStringValue(country);
        this.color = validateColor(color);
        this.maxSpeed = validateSpeed(maxSpeed);
        this.fuelPercentage = validateFuelPercentage(fuelPercentage);
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

    private double validateFuelPercentage(double fuelPercentage) {
        return fuelPercentage <= 0 || fuelPercentage > 100 ? 100 : fuelPercentage;
    }

    public abstract void refill();  // вывод на экран то, какими видами топлива заправляется транспорт, и установка значения поля в 100%

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

    public double getFuelPercentage() {
        return fuelPercentage;
    }

    protected void setFuelPercentage(double fuelPercentage) {   // изменение доступно в классах наследниках
        this.fuelPercentage = validateFuelPercentage(fuelPercentage);
    }

    @Override
    public String toString() {
        return brand + " " + model + ", " + year + " год выпуска, страна сборки — " + country + ", цвет кузова — " +
                color + ", максимальная скорость передвижения — " + maxSpeed + " км/ч, количество топлива — " + fuelPercentage + "%.";
    }
}