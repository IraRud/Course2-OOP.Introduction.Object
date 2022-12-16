package skypro.java.course2.animals;

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

    public String getAreal() {
        return areal;
    }

    public void setAreal(String areal) {
        this.areal = validateAreal(areal);
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return super.toString() + "Млекопитающее. Среда обитания - " + areal + ", скорость перемещения - " + speed + " км/ч. ";
    }

}
