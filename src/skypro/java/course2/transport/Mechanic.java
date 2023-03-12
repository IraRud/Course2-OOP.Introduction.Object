package skypro.java.course2.transport;

import static skypro.java.course2.transport.ValidateUtils.validateString;

// класс для механиков
// один механик может работать с несколькими машинами.
public class Mechanic {
    private final String name;
    private final String surname;
    private String company;

    public Mechanic(String name, String surname, String company) {
        this.name = validateString(name, "No name");
        this.surname = validateString(surname, "No surname");
        this.company = validateCompanyValue(company);
    }

    // проверка для ввода компании
    private String validateCompanyValue(String value) {
        return validateString(value, "No company");
    }

    // метод для проведения техобслуживания
    public void performMaintenance() {
        System.out.println("Механик " + name + " " + surname + " из компании " + company + " проводит техобслуживание! ");
    }

    // метод для починки машины
    public void fixCar() {
        System.out.println("Механик " + name + " " + surname + " из компании " + company + " чинит транспорт! ");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = validateCompanyValue(company);
    }

    @Override
    public String toString() {
        return "Механик " + name + " " + surname + " из компании " + company;
    }
}
