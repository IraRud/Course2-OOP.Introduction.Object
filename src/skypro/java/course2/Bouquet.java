package skypro.java.course2;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Bouquet {
    private Flower[] flowers;

    public Bouquet(Flower[] flowers) {  // конструктор
        this.flowers = flowers;
    }

    public Flower[] getFlowers() {  // геттер
        if (flowers == null) {
            flowers = new Flower[0];
        }
        return flowers;
    }

    public void addFlower(Flower flower) {  // добавление цветка к существующему букету
//        копирование массива: 1 - тот котрый копируем (изначальный), 2 - длинна нового массива
        this.flowers = Arrays.copyOf(this.flowers, getFlowers().length + 1);
//        this.flowers.length - 1 -- последний элемент массива; this.flowers.length - не getFlowers(), тк уже проверили, что не null
        this.flowers[this.flowers.length - 1] = flower;
    }

    public String keepInformationOfFlowersOfBouquet() { // вывод информации по цветкам букета
        String informationOfFlowersOfBouquet = "";
        for (Flower element : flowers) {
            informationOfFlowersOfBouquet = informationOfFlowersOfBouquet + "\n" + element.toString();
        }
        return informationOfFlowersOfBouquet;
    }

    public double calculateCostOfBouquet() {    // стоимость букета
        double cost = 0;
//        (стоимость цветка * количество цветков в букете + стоимость другого цветка * количество цветков в букете )
//        + 10% от суммы = финальная стоимость букета для покупателя.
        for (Flower element : flowers) {
            cost += element.getCost();
        }
        cost += cost * 0.1; // + 10% от суммы
        return cost;
    }

    public int findLifeSpan() { // сколько дней простит букет
        int lifeSpan = 0;   // меньше 0 не может быть по условию
        for (Flower element : flowers) {
            if (element.getLifeSpan() < lifeSpan) {
                lifeSpan = element.getLifeSpan();
            }
        }
        return lifeSpan;
    }

    @Override
    public String toString() {
        return "Цветы букета: " + keepInformationOfFlowersOfBouquet() + "\nСтоимость букета  — "
                + new DecimalFormat("#.##").format(calculateCostOfBouquet()) + " рублей, срок хранения  — " + findLifeSpan() + ".";
    }
}
