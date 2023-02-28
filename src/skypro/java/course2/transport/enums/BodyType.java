package skypro.java.course2.transport.enums;

public enum BodyType {  // перечисление типа кузова для легковушек (Car)
    SEDAN("седан"),
    HATCHBACK("хетчбэк"),
    COUPE("купе"),
    STATION_WAGON("универсал"),
    OFF_ROAD("внедорожник"),
    CROSSOVER("кроссовер"),
    PICKUP("пикап"),
    VAN("фургон"),
    MINIVAN("минивэн");
    private final String body;

    BodyType(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Тип кузова: " + body;
    }
}
