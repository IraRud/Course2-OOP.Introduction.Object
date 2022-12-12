package skypro.java.course2;

public class Person {
    private int yearOfBirth;
    public String name;
    private String town;
    public String jobTitle;

    public Person(String name, String town, int yearOfBirth, String jobTitle) { // проверка полей town, yearOfBirth вынесена в сеттеры
        this.name = checkValue(name);
        setTown(town);  // поле town не помечено модификатором доступа final, можно использовать сеттер в конструкторе и убрать дублирование кода для проверок
        setYearOfBirth(yearOfBirth); // поле yearOfBirth не помечено модификатором доступа final, можно использовать сеттер в конструкторе и убрать дублирование кода для проверок
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

    // геттеры и сеттеры полей town, yearOfBirth
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth >= 0) { // год рождения не может быть отрицательным
            this.yearOfBirth = yearOfBirth;
        } else {
            this.yearOfBirth = 0;   // в противном случае 0
        }
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = checkValue(town);
    }
}
