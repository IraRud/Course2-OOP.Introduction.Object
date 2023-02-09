package skypro.java.course2.animals;

import java.util.Objects;

public class Flightless extends Bird{
    private final String typeOfMovement;

    public Flightless(String name, int age, String areal, String typeOfMovement) {
        super(name, age, areal);
        this.typeOfMovement = validateTypeOfMovement(typeOfMovement);
    }

    protected void walk() {
        System.out.println("Нелетающая птица гуляет! Сейчас " + getName() + " гуляет.");
    }

    @Override
    protected void eat() {
        System.out.println("Нелетающие птицы едят разную пищу! ");
    }

    @Override
    protected void go() {
        System.out.println("Как правило, нелетающие птицы перемещаются по суше и воде, но не в воздухе. Возможно, " + getName()+ " тоже перемещается только по суше и воде.");
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
        Flightless that = (Flightless) o;
        return Objects.equals(typeOfMovement, that.typeOfMovement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfMovement);
    }

    @Override
    public String toString() {
        return super.toString() + "Нелетающая птица. Тип передвижения - " + typeOfMovement + ". ";
    }
}
