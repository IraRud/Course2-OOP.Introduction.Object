package skypro.java.course2.animals;

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
    public String toString() {
        return super.toString() + "Летающая птица. Тип передвижения - " + typeOfMovement + ". ";
    }
}
