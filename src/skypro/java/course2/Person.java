package skypro.java.course2;

public class Person {
    public int yearOfBirth;
    public String name;
    public String town;
    public String jobTitle;

    public Person(String name, String town, int yearOfBirth, String jobTitle) { // добавляем конструктор
        this.name = name;
        this.town = town;
        this.yearOfBirth = yearOfBirth;
        this.jobTitle = jobTitle;
    }
    @Override
    public String toString() {
        return "Привет! Меня зовут " + this.name + ". Я из города " + this.town + ". Я родился в " + this.yearOfBirth
                + " году. Я работаю на должности " + this.jobTitle + ". Будем знакомы!";
    }

}
