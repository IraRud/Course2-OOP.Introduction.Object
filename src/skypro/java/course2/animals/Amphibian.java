package skypro.java.course2.animals;

import java.util.Objects;

public class Amphibian extends Animal {
    private String areal;

    public Amphibian(String name, int age, String areal) {
        super(name, age);
        this.areal = validateAreal(areal);
    }

    protected void hunt() {
        System.out.println("Земноводные охотятся! Значит, " + getName() + " охотится.");
    }

    @Override
    protected void eat() {
        System.out.println("Земноводные едят разную пищу! ");
    }

    @Override
    protected void go() {
        System.out.println("Как правило, земноводные перемещаются по суше и воде. Возможно, " + getName()+ " тоже перемещается по суше и воде.");
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
        Amphibian amphibian = (Amphibian) o;
        return Objects.equals(areal, amphibian.areal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), areal);
    }

    @Override
    public String toString() {
        return super.toString() + "Земноводное. Среда обитания - " + areal + ". ";
    }

}
