package skypro.java.course2.transport.enums;

public enum Type {
    CAR("Легковая машина"),
    TRUCK("Грузовик"),
    BUS("Автобус");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
