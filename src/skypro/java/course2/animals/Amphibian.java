package skypro.java.course2.animals;

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

    public String getAreal() {
        return areal;
    }

    public void setAreal(String areal) {
        this.areal = validateAreal(areal);
    }

    @Override
    public String toString() {
        return super.toString() + "Земноводное. Среда обитания - " + areal + ". ";
    }

}
