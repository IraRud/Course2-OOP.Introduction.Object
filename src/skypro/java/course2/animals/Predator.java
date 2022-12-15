package skypro.java.course2.animals;

public class Predator extends Mammal {
    private final String typeOfFood;

    public Predator(String name, int age, String areal, double speed, String typeOfFood) {
        super(name, age, areal, speed);
        this.typeOfFood = validateTypeOfFood(typeOfFood);
    }

    protected void hunt() {
        System.out.println("Хищники охотятся! Значит, " + getName()+ " охотится.");
    }
    @Override
    protected void eat() {
        System.out.println("Хищники едят мясо! " + "Что предпочитает " + getName() + "? Видимо, это " + typeOfFood + ".");
    }

    @Override
    protected void go() {
        System.out.println("Как правило, хищники перемещаются по суше. Возможно, " + getName()+ " тоже перемещается по суше.");
    }

    private String validateTypeOfFood(String typeOfFood) {
        return typeOfFood == null || typeOfFood.isEmpty() || typeOfFood.isBlank() ? "растительность" : typeOfFood;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    @Override
    public String toString() {
        return super.toString() + "Хищник. Тип пищи - " + typeOfFood + ". ";
    }
}
