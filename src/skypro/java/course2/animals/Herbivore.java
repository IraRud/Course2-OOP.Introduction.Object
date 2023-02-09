package skypro.java.course2.animals;

import java.util.Objects;

public class Herbivore extends Mammal {
    private final String typeOfFood;

    public Herbivore(String name, int age, String areal, double speed, String typeOfFood) {
        super(name, age, areal, speed);
        this.typeOfFood = validateTypeOfFood(typeOfFood);
    }

    protected void graze() {
        System.out.println("Травоядные пасутся! Значит, " + getName()+ " пасется.");
    }
    @Override
    protected void eat() {
        System.out.println("Травоядные едят траву! " + "Что предпочитает " + getName() + "? Видимо, это " + typeOfFood + ".");
    }

    @Override
    protected void go() {
        System.out.println("Как правило, травоядные перемещаются по суше. Возможно, " + getName()+ " тоже перемещается по суше.");
    }

    private String validateTypeOfFood(String typeOfFood) {
        return typeOfFood == null || typeOfFood.isEmpty() || typeOfFood.isBlank() ? "растительность" : typeOfFood;
    }

    public final String getTypeOfFood() {
        return typeOfFood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Herbivore herbivore = (Herbivore) o;
        return Objects.equals(typeOfFood, herbivore.typeOfFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfFood);
    }

    @Override
    public String toString() {
        return super.toString() + "Травоядное. Тип пищи - " + typeOfFood + ". ";
    }
}
