package skypro.java.course2.transport;

import java.time.LocalDate;
import java.util.regex.Pattern;

import static skypro.java.course2.transport.ValidateUtils.validateBoolean;
import static skypro.java.course2.transport.ValidateUtils.validateString;

public class Car extends Transport {

    public class Key {  // вложенный класс "Ключ"
        final private boolean remoteEngineStart;  // удаленный запуск двигателя, true или false
        final private boolean keylessAccess;  // бесключевой доступ, true или false

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = validateBoolean(remoteEngineStart, false);
            this.keylessAccess = validateBoolean(keylessAccess, false);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }

        @Override
        public String toString() {
            return "Ключ: удаленный запуск двигателя — " + remoteEngineStart + ", бесключевой доступ — " + keylessAccess;
        }
    }

    public class Insurance {   // вложенный класс "Страховка"
        final private LocalDate validityPeriod;   // срок действия страховки (дата окончания действия страховки)
        final private double cost;   // стоимость страховки
        final private String number;   // номер страховки (9-ое число)

        public Insurance(LocalDate validityPeriod, double cost, String number) {
            this.validityPeriod = validityPeriod;   // проверка на валидность не требуется, тк предусмотрена у LocalDate, допускается ввод просроченной страховки
            this.cost = validateCost(cost);
            this.number = validateNumber(number);
        }

        private double validateCost(double cost) {
            return  cost <= 0 ? 10_000 : cost;
            }

        private String validateNumber(String number) {  // пусть номер страховки состоит из 9 цифр
            if (Pattern.matches("[0-9]{9}", number)) {
                return number;
            } else {
                return "000000000";
            }
        }

        public void checkValidityPeriod() { // проверка даты окончания действия страховки (пользователь может ввести устаревшую)
            if (LocalDate.now().isAfter(validityPeriod)) {
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
            return "Страховка: дата окончания действия страховки — " + validityPeriod + ", цена — " + cost + ", номер — " + number +".";
        }
    }

    private double engineVolume;    // объем двигателя в литрах
    private String transmission;    // коробка передач
    final private String bodyType;    // тип кузова
    private String registrationNumber;    // регистрационный номер
    final private int numberOfSeats;  // количество мест
    private boolean summerTires;  // летняя резина (летняя - true, зимняя - false)

    private Key key;
    private Insurance insurance;

    public Car(String brand, String model, int year, String country, String color, double maxSpeed, double engineVolume, String transmission, String bodyType, String registrationNumber, int numberOfSeats, boolean summerTires) {   // добавлена проверка в конструкторе
        super(brand, model, year, country, color, maxSpeed);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.transmission = validateTransmission(transmission);
        this.bodyType = validateBodyType(bodyType);
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
        this.numberOfSeats = validateNumberOfSeats(numberOfSeats);
        this.summerTires = validateSummerTires(summerTires);
    }

// region validation
    private double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }

    private String validateTransmission(String value) {
        return validateString(value, "default");
    }

    private String validateBodyType(String value) {
        return validateString(value, "default");
    }

    private String validateRegistrationNumber(String registrationNumber) {  // номре в формате X000XX000
        if (Pattern.matches("[ABEKMHOPCTXАВЕКМНОРСТХ][0-9]{3}[ABEKMHOPCTXАВЕКМНОРСТХ]{2}[0-9]{3}", registrationNumber)) { //допскается ввод букв на русском и английском
            return registrationNumber;
        } else {
            return "X000XX000";
        }
    }

    private int validateNumberOfSeats(int numberOfSeats) {
        return numberOfSeats <= 0 ? 2 : numberOfSeats;
    }

    private Boolean validateSummerTires(Boolean summerTires) {
        return validateBoolean(summerTires, false);
    }
// endregion

    public boolean changeTiresForSeasonalOnes() {  // метод позволяет сменить резину на сезонную автоматически
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

// region getters and setters
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
        this.engineVolume = validateEngineVolume(engineVolume);
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = validateTransmission(transmission);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
    }

    public boolean isSummerTires() {
        return summerTires;
    }

    public void setSummerTires(boolean summerTires) {
        this.summerTires = validateSummerTires(summerTires);
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
// endregion

    @Override
    public String toString() {  // необходимый формат вывода
        return getBrand() + " " + getModel() + ", " + getYear() + " год выпуска, страна сборки — " + getCountry() + ", цвет кузова — " +
                getColor() + ", максимальная скорость передвижения — " + getMaxSpeed() + ", объем двигателя — " + this.engineVolume + " л., кробка передач — " + this.transmission +
                ", тип кузова — " + this.bodyType + ", регистрационный номер — " + this.registrationNumber + ", количество мест — " + this.numberOfSeats +
                ", летняя резина — " + this.summerTires + ". " + key + ". " + insurance;
    }

}
