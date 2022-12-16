package skypro.java.course2.animals;

import java.util.Objects;

public abstract class Mammal extends Animal{
    private String areal;
    private final double speed;

    public Mammal(String name, int age, String areal, double speed) {
        super(name, age);
        this.areal = validateAreal(areal);
        this.speed = validateSpeed(speed);
    }

    protected void walk() {
        System.out.println("Млекопитающее гуляет! Сейчас " + getName() + " гуляет.");
    }

    private String validateAreal(String areal) {
        return areal == null || areal.isEmpty() || areal.isBlank() ? "неизвестно" : areal;
    }

    private double validateSpeed(double speed) {
        return speed <= 0 ? 10 : speed;
    }

    public final String getAreal() {
        return areal;
    }

    public final void setAreal(String areal) {
        this.areal = validateAreal(areal);
    }

    public final double getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mammal mammal = (Mammal) o;
        return Double.compare(mammal.speed, speed) == 0 && Objects.equals(areal, mammal.areal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), areal, speed);
    }

    @Override
    public String toString() {
        return super.toString() + "Млекопитающее. Среда обитания - " + areal + ", скорость перемещения - " + speed + " км/ч. ";
    }

}
