package skypro.java.course2.animals;

import java.util.Objects;

public abstract class Bird extends Animal{
    private String areal;

    public Bird(String name, int age, String areal) {
        super(name, age);
        this.areal = validateAreal(areal);
    }

    protected void hunt() {
        System.out.println("Птицы охотятся! Значит, " + getName() + " охотится.");
    }

    private String validateAreal(String areal) {
        return areal == null || areal.isEmpty() || areal.isBlank() ? "неизвестно" : areal;
    }

    public final String getAreal() {
        return areal;
    }

    public final void setAreal(String areal) {
        this.areal = validateAreal(areal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bird bird = (Bird) o;
        return Objects.equals(areal, bird.areal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), areal);
    }

    @Override
    public String toString() {
        return super.toString() + "Птица. Среда обитания - " + areal + ". ";
    }
}
