package skypro.java.course2.transport;

import java.time.LocalDate;

public class Car {

    public class Key {  // вложенный класс "Ключ"
        final private boolean remoteEngineStart;  // удаленный запуск двигателя, true или false
        final private boolean keylessAccess;  // бесключевой доступ, true или false

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    public class Insurance {   // вложенный класс "Страховка"
        final private LocalDate validityPeriod;   // срок действия страховки (дата окончания действия страховки)
        final private double cost;   // стоимость страховки
        final private String number;   // номер страховки (9-ое число)

        public Insurance(LocalDate validityPeriod, double cost, String number) {
            this.validityPeriod = validityPeriod;   // проверка на валидность не требуется, тк предусмотрена у LocalDate
            if (cost <= 0) {    // при стоимости 0 или отрицательном значении
                this.cost = 10_000;  // при некорректном вводе устаналивается базовый тариф в 10 000р
            } else {
                this.cost = cost;
            }
            if (number == null || number.isBlank() || number.isEmpty()) {    // если номер - null и пустые строки
                this.number = "000000000";  // по умолчанию
            } else if (number.matches("[0-9]+")) {  // номер не содержит ничего кроме цифр
                this.number = number;
            } else {
                this.number = "000000000";  // по умолчанию
            }
        }

        public void checkValidityPeriod() { // проверка даты окончания действия страховки
            if (validityPeriod.getYear() < LocalDate.now().getYear()) {
                System.out.println("Необходимо оформить новую страховку!");
            } else if (validityPeriod.getYear() == LocalDate.now().getYear() && validityPeriod.getDayOfYear() < LocalDate.now().getDayOfYear()) {
                System.out.println("Необходимо оформить новую страховку!");
            }
        }

        public void checkNumber() { // проверка длины номера страховки
            if (number.length() != 9) {
                System.out.println("Номер страховки некорректный!");
            }
        }

        public LocalDate getValidityPeriod() {
            return validityPeriod;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        @Override
        public String toString() {
            return "Insurance{" +
                    "validityPeriod=" + validityPeriod +
                    ", cost=" + cost +
                    ", number='" + number + '\'' +
                    '}';
        }
    }

    final private String brand;   // марка
    final private String model;   // модель
    private double engineVolume;    // объем двигателя в литрах
    private String color;   // цвет кузова
    final private int year;   // год производства
    final private String country; // страна сборки
    private String transmission;    // коробка передач
    final private String bodyType;    // тип кузова
    private String registrationNumber;    // регистрационный номер
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
