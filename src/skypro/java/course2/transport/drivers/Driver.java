package skypro.java.course2.transport.drivers;

import java.util.Objects;

import static skypro.java.course2.transport.ValidateUtils.validateBoolean;
import static skypro.java.course2.transport.ValidateUtils.validateString;

public abstract class Driver {
    final private String fullName;    // ФИО
    private boolean driversLicense; // наличие водительских прав
    private int experience;     // стаж

    public Driver(String fullName, boolean driversLicense, int experience) {
        this.fullName = validateString(fullName,"ФИО");
        this.driversLicense = validateBoolean(driversLicense, true);
        this.experience = validateExperience(experience);
    }

    private int validateExperience(int experience) {
        return experience < 0 || experience > 100 ? 1 : experience;
    }

    public abstract void startMoving(); // начать движение

    public abstract void stopMoving(); // остановиться

    public abstract void refuel(); // заправить авто

    //region ГЕТТЕРЫ, СЕТТЕРЫ, hashCode и equals
    public String getFullName() {
        return fullName;
    }

    public boolean isDriversLicense() {
        return driversLicense;
    }

    public int getExperience() {
        return experience;
    }

    public void setDriversLicense(boolean driversLicense) {
        this.driversLicense = validateBoolean(driversLicense, true);
    }

    public void setExperience(int experience) {
        this.experience = validateExperience(experience);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return driversLicense == driver.driversLicense && experience == driver.experience && Objects.equals(fullName, driver.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, driversLicense, experience);
    }
    //endregion

    @Override
    public String toString() {
        return "ФИО: " + fullName + ", наличие водительских прав: " + driversLicense + ", стаж: " + experience + ".";
    }
}
