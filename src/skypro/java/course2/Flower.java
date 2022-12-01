package skypro.java.course2;

public class Flower {
    final private String flowerName;  // название цветка
    final private String country;     // страна происхождения
    final private double cost;        // стоимость
    private int lifeSpan;             // срок стояния, указанный в целых днях

    public Flower(String flowerName, String country, double cost, int lifeSpan) {   // констуктор
        if (flowerName != null && !flowerName.isBlank()) {
            this.flowerName = flowerName;
        } else {
            this.flowerName = "- тип цветка не указан - ";  // по дефолту
        }

        if (country != null && !flowerName.isBlank()) {
            this.country = country;
        } else {
            this.country = "Россия";    // по дефолту
        }

        if (cost > 0) {
            this.cost = cost;
        } else {
            this.cost = 1;  // по дефолту
        }

    }

}
