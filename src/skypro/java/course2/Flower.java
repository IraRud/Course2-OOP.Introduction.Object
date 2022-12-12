package skypro.java.course2;

import java.text.DecimalFormat;

public class Flower {
    final private String flowerName;  // название цветка
    final private String country;     // страна происхождения
    final private double cost;        // стоимость
    private int lifeSpan;             // срок стояния, указанный в целых днях

    public Flower(String flowerName, String country, double cost) { // конструктор без lifeSpan
        this(flowerName, country, cost, 3); // если срок не указан, то по дефолту 3 дня
    }

    public Flower(String flowerName, String country, double cost, int lifeSpan) {   // полный констуктор
        if (flowerName != null && !flowerName.isBlank()) {
            this.flowerName = flowerName;
        } else {
            this.flowerName = "- тип цветка не указан - ";  // по дефолту
        }

        if (country != null && !country.isBlank()) {
            this.country = country;
        } else {
            this.country = "Россия";    // по дефолту
        }

        if (cost > 0) {
            this.cost = cost;
        } else {
            this.cost = 1;  // по дефолту
        }

        setLifeSpan(lifeSpan);
    }
    // геттеры
    public String getFlowerName() {
        return flowerName;
    }

    public String getCountry() {
        return country;
    }

    public double getCost() {
        return cost;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    // сеттер для поля, не имеющего модификатор
    public void setLifeSpan(int lifeSpan) {
        if (lifeSpan >= 0) {
            this.lifeSpan = lifeSpan;
        } else {
            this.lifeSpan = Math.abs(lifeSpan);
        }
    }

    @Override
    public String toString() {
        return this.flowerName + ", страна происхождения — " + this.country + ", стоимость штуки — " +
                new DecimalFormat("#.##").format(this.cost) + " рублей, срок стояния — " + this.lifeSpan + " (в днях)."; // new DecimalFormat( "#.##" ).format(obj)
    }
}
