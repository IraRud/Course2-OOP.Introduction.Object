package skypro.java.course2;

public class Person {
    /* По условию 1 задания: свойства объектов можно объявить как public и использовать прямой доступ к свойствам для
    того, чтобы их заполнить.*/
    public int yearOfBirth;
    public String name;
    public String town;

    @Override
    public String toString() {
        return "Привет! Меня зовут " + this.name + ". Я из города " + this.town + ". Я родился в " + this.yearOfBirth + " году. Будем знакомы!";
    }

}
