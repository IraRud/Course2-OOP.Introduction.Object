package skypro.java.course2.animals;

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
    public String toString() {
        return super.toString() + "Птица. Среда обитания - " + areal + ". ";
    }
}
