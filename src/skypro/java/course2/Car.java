package skypro.java.course2;

public class Car {
    String brand;   // марка
    String model;   // модель
    double engineVolume;    // объем двигателя в литрах
    String color;   // цвет кузова
    int year;   // год производства
    String country; // страна сборки

    public Car(String brand, String model, int year, String country, String color, double engineVolume) {   // добавлена проверка в конструкторе
        this.brand = checkBrandModelCountry(brand);
        this.model = checkBrandModelCountry(model);

        if (year <= 0) {    // проверка года производства
            this.year = 2000;
        } else {
            this.year = year;
        }

        this.country = checkBrandModelCountry(country);

        if (color == null || color.isBlank()) {    // проверка цвета кузова, если null и пустая строка
            this.color = "белый";
        } else {
            this.color = color;
        }

        if (engineVolume <= 0) {    // проверка объема двигателя
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    @Override
    public String toString() {  // необходимый формат вывода
        return this.brand + " " + this.model + ", " + this.year + " год выпуска, страна сборки — " + this.country + ", цвет кузова — " +
                this.color + ", объем двигателя — " + this.engineVolume + " л.";
    }

    String checkBrandModelCountry (String str) {    // проверка для марки, модели, страны сборки
        if (str == null || str.isBlank()) {    // если null и пустые строки
            str = "default";
        }
        return str;
    }

}
