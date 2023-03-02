package skypro.java.course2.transport.smth;

import skypro.java.course2.transport.Transport;

import java.util.LinkedList;
import java.util.Queue;

// класс «Станция техобслуживания»
public class ServiceStation {

    // очередь на техобслуживание
    private final Queue<Transport> maintenanceQueue = new LinkedList<>();

    // добавить авто в очередь
    public void addToMaintenanceQueue(Transport transport) {
        checkQueue(transport);
        maintenanceQueue.add(transport);
    }

    // проверка, что не автобус (напоминание: не могут проходить диагностику)
    private void checkQueue(Transport transport) {
        try {
            transport.passDiagnostics();
        } catch (TransportTypeException e) {
            // вывод сообщения об ошибке (с подсветкой)
            System.err.println(e.getMessage() + " Автобус " + transport.getBrand() + " " + transport.getModel()
                    + " не должен быть указан в очереди на диагностику!");
            // выход из системы
            System.exit(0);
        }
    }

    // провести техосмотр авто, удалить из очереди после проверки
    public void carryOutMaintenanceOfCar() {
        Transport queue;
        if (maintenanceQueue.peek() == null) {
            System.out.println("Очередь пока пуста.");
            return;
        }
        System.out.println("Проводится техобслуживание текущей очереди:");
        while ((queue = maintenanceQueue.poll()) != null) {
            System.out.println("Авто " + queue.getBrand() + " " + queue.getModel() + " прошло техобслуживание");
        }
        System.out.println("Конец очереди.");
    }

    public Queue<Transport> getMaintenanceQueue() {
        return maintenanceQueue;
    }
}
