package skypro.java.course2.transport.smth;

// проверяемое исключение, поэтому наследует Exception
public class TransportTypeException extends Exception {

    // достаточно одного конструктора для вывода сообщения об ошибке
    public TransportTypeException(String message) {
        super(message);
    }

}
