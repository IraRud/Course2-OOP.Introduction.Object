package skypro.java.course2.transport.enums;

public enum Capacity {   // перечисление по типу вместимости для автобусов (Bus)
    VERY_SMALL(0, 10),  // особо малая (до 10 мест)
    SMALL(0, 25),   // малая (до 25)
    AVERAGE(40, 50),    // средняя (25–50)
    BIG(60, 80),    // большая (50–80)
    VERY_BIG(100, 120); // особо большая (80–120 мест)
    private final Integer lowCapacity;  // нижняя граница
    private final Integer highCapacity; // верхняя граница

    Capacity(Integer lowCapacity, Integer highCapacity) {
        this.lowCapacity = lowCapacity;
        this.highCapacity = highCapacity;
    }

    public Integer getLowCapacity() {
        return lowCapacity;
    }

    public Integer getHighCapacity() {
        return highCapacity;
    }

    @Override
    public String toString() {
        return (lowCapacity == 0) ? "Вместимость до " + highCapacity + " человек"
                : "Вместимость от " + lowCapacity + " человек " + ((highCapacity == 0) ? ""
                : "до " + highCapacity + " человек");
    }
}
