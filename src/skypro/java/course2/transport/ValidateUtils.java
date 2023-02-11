package skypro.java.course2.transport;

public class ValidateUtils {

    public static String validateString (String value, String substitution) {    // проверка для строковых значений
        return value == null || value.isBlank() || value.isEmpty() ? substitution : value;   // если null и пустые строки
    }

/*    public static double validateDoubleEngineVolume(double value, double substitution, double min, double max) {    // проверка для объема двигателя
        return value <= min || value >= max ? substitution : value;
    }*/
}
