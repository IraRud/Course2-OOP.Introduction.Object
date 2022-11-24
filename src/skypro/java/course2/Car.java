package skypro.java.course2;

public class Car {
    String brand;   // марка
    String model;   // модель
    double engineVolume;    // объем двигателя в литрах
    String color;   // цвет кузова
    int year;   // год производства
    String country; // страна сборки

    public Car(String brand, String model, int year, String country, String color, double engineVolume) {   // задание 2 из ДЗ-2 было выпонено в ДЗ-1, конструктор создан
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.country = country;
        this.color = color;
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {  // необходимый формат вывода
        return this.brand + " " + this.model + ", " + this.year + " год выпуска, страна сборки — " + this.country + ", цвет кузова — " +
                this.color + ", объем двигателя — " + this.engineVolume + " л.";
    }
}
