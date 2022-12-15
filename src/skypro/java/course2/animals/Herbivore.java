package skypro.java.course2.animals;

public class Herbivore extends Mammal {
    private final String typeOfFood;

    public Herbivore(String name, int age, String areal, double speed, String typeOfFood) {
        super(name, age, areal, speed);
        this.typeOfFood = validateTypeOfFood(typeOfFood);
    }

    protected void graze() {
        System.out.println("Травоядное пасется! Значит, " + getName()+ " пасется.");
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

    public String getTypeOfFood() {
        return typeOfFood;
    }

    @Override
    public String toString() {
        return super.toString() + "Травоядное. Тип пищи - " + typeOfFood + ". ";
    }
}
