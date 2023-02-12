package skypro.java.course2.transport;

public interface Competing {    //"Соревнующийся"

    void pitStop(); // пит-стоп

    void bestLapTime(int seconds); // лучшее время прохождения круга

    void maxSpeed(double speed);  // максимальная скорость

}
