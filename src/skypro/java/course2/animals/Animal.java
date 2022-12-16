package skypro.java.course2.animals;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = validateName(name);
        this.age = validateAge(age);
    }

    protected abstract void eat();

    protected abstract void go();

    protected void sleep() {
        System.out.println("Животное спит! Сейчас " + getName() + " спит.");
    }

    private String validateName(String name) {
        return name == null || name.isEmpty() || name.isBlank() ? "Животное" : name;
    }

    private int validateAge(int age) {
        return age < 0 ? 0 : age;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = validateName(name);
    }

    public final int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Животное. Имя - " + name + ", возраст - " + age + ". ";
    }
}
