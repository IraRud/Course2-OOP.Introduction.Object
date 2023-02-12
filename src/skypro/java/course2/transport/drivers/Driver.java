package skypro.java.course2.transport.drivers;

import skypro.java.course2.transport.Car;

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

    //region ГЕТТЕРЫ И СЕТТЕРЫ
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
    //endregion

    @Override
    public String toString() {
        return "ФИО: " + fullName + ", наличие водительских прав: " + driversLicense + ", стаж: " + experience + ".";
    }
}
