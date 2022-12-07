package skypro.java.course2.transport;

import java.time.LocalDate;

public class Car {
    final private String brand;   // марка
    final private String model;   // модель
    private double engineVolume;    // объем двигателя в литрах
    private String color;   // цвет кузова
    final private int year;   // год производства
    final private String country; // страна сборки
    private String transmission;    // коробка передач
    final private String bodyType;    // тип кузова
    private String registrationNumber;    // регистрационный номер !!!!!!!!!!!!!!!
    final private int numberOfSeats;  // количество мест
    private boolean summerTires;  // летняя резина (летняя - true, зимняя - false)


    public Car(String brand, String model, int year, String country, String color, double engineVolume, String transmission, String bodyType, String registrationNumber, int numberOfSeats, boolean summerTires) {   // добавлена проверка в конструкторе
        this.brand = checkStringValue(brand);
        this.model = checkStringValue(model);

        if (year <= 0) {    // проверка года производства
            this.year = 2000;
        } else {
            this.year = year;
        }

        this.country = checkStringValue(country);
        setColor(color);
        setEngineVolume(engineVolume);
        setTransmission(transmission);
        this.bodyType = checkStringValue(bodyType);
        setRegistrationNumber(registrationNumber);

        if (numberOfSeats <= 0) {    // проверка количества мест
            this.numberOfSeats = 2;  // по дефолту 2
        } else {
            this.numberOfSeats = numberOfSeats;
        }

        setSummerTires(summerTires);
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

    public String getBodyType() {
        return bodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {    // проверка объема двигателя
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.isBlank()) {    // проверка цвета кузова, если null и пустая строка
            this.color = "белый";
        } else {
            this.color = color;
        }
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = checkStringValue(transmission);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isSummerTires() {
        return summerTires;
    }

    public void setSummerTires(boolean summerTires) {
        this.summerTires = summerTires;
    }

    @Override
    public String toString() {  // необходимый формат вывода
        return this.brand + " " + this.model + ", " + this.year + " год выпуска, страна сборки — " + this.country + ", цвет кузова — " +
                this.color + ", объем двигателя — " + this.engineVolume + " л., кробка передач — " + this.transmission +
                ", тип кузова — " + this.bodyType + ", регистрационный номер — " + this.registrationNumber + ", количество мест — " + this.numberOfSeats +
                ", летняя резина — " + this.summerTires + ".";
    }

    public boolean changeTiresForSeasonalOnes() {  // метод позволяет сменить резину на сезонную
        int month = LocalDate.now().getMonthValue();
        switch (month) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 9:
            case 10:
            case 11:
            case 12:
                this.summerTires = false;
                break;
            case 6:
            case 7:
            case 8:
                this.summerTires = true;
                break;
        }
        return this.summerTires;
    }

    public boolean checkRegistrationNumber() {  // проверка номера регистрации на валидность (по условию необходимо вынести в отдельный метод) (только на правильность формата ввода - х000хх000)
        boolean isRegistrationNumber = false;
        char[] arr = registrationNumber.toCharArray();
        if (arr.length > 9 || arr.length < 8) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == 4 || i == 5) {
                isRegistrationNumber = Character.isDigit(arr[i]);
                if (isRegistrationNumber == true) {
                    break;
                }
            } else {
                isRegistrationNumber = Character.isDigit(arr[i]);
                if (isRegistrationNumber == false) {
                    break;
                }
            }
        }
        return isRegistrationNumber;
    }

    String checkStringValue (String str) {    // проверка для строковых значений, кроме цвета кузова и регистрационного номера
        if (str == null || str.isBlank() || str.isEmpty()) {    // если null и пустые строки
            str = "default";
        }
        return str;
    }

}
