package skypro.java.course2.animals;

import java.util.Objects;

public class Flying extends Bird {
    private final String typeOfMovement;

    public Flying(String name, int age, String areal, String typeOfMovement) {
        super(name, age, areal);
        this.typeOfMovement = validateTypeOfMovement(typeOfMovement);
    }

    protected void fly() {
        System.out.println("Удивительно, летающая птица умеет летать! Сейчас " + getName() + " летает.");
    }

    @Override
    protected void eat() {
        System.out.println("Летающие птицы едят разную пищу! ");
    }

    @Override
    protected void go() {
        System.out.println("Летающие птицы могут перемещаются по суше, воде и в воздухе! Возможно, " + getName()+ " тоже так умеет.");
    }

    private String validateTypeOfMovement(String typeOfMovement) {
        return typeOfMovement == null || typeOfMovement.isEmpty() || typeOfMovement.isBlank() ? "пешком" : typeOfMovement;
    }

    public final String getTypeOfMovement() {
        return typeOfMovement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Flying flying = (Flying) o;
        return Objects.equals(typeOfMovement, flying.typeOfMovement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfMovement);
    }

    @Override
    public String toString() {
        return super.toString() + "Летающая птица. Тип передвижения - " + typeOfMovement + ". ";
    }
}
