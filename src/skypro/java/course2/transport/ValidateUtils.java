package skypro.java.course2.transport;

public class ValidateUtils {

    public static String validateString (String value, String substitution) {    // проверка для строковых значений
        return value == null || value.isBlank() || value.isEmpty() ? substitution : value;   // если null и пустые строки
    }

    public static Boolean validateBoolean (Boolean value, Boolean substitution) {    // проверка для строковых значений
        return value == null ? substitution : value;   // если null и пустые строки
    }
}
