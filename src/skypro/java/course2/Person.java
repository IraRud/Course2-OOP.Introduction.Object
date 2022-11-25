package skypro.java.course2;

public class Person {
    public int yearOfBirth;
    public String name;
    public String town;
    public String jobTitle;

    public Person(String name, String town, int yearOfBirth, String jobTitle) { // добавлена проверка в конструкторе
        this.name = checkValue(name);
        this.town = checkValue(town);
        if (yearOfBirth >= 0) { // год рождения не может быть отрицательным
            this.yearOfBirth = yearOfBirth;
        } else {
            this.yearOfBirth = 0;   // в противном случае 0
        }
        this.jobTitle = checkValue(jobTitle);
    }
    @Override
    public String toString() {
        return "Привет! Меня зовут " + this.name + ". Я из города " + this.town + ". Я родился в " + this.yearOfBirth
                + " году. Я работаю на должности " + this.jobTitle + ". Будем знакомы!";
    }

    String checkValue (String str) {    // проверка для строковых полей
        if (str == null || str.isBlank()) {    // если null и пустые строки
            str = "- информация не указана - ";
        }
        return str;
    }

}
