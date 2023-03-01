package skypro.java.course2.transport;

import static skypro.java.course2.transport.ValidateUtils.validateString;
import skypro.java.course2.transport.enums.Type;

import java.util.List;

public abstract class Transport {
    final private String brand;   // марка
    private String model;   // модель, можно изменять
    private final double engineVolume;    // объем двигателя в литрах
    private List<Mechanic> mechanicList;    // переменная для списка механиков

    public Transport(String brand, String model, double engineVolume, List<Mechanic> mechanicList) {
        this.brand = validateStringValue(brand);
        this.model = validateStringValue(model);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.mechanicList = mechanicList;
    }

    // region VALIDATION
    // для разного типа авто - разный объем двигателя. отсюда разная проверка для наследников
    protected abstract double validateEngineVolume(double engineVolume);

    private String validateStringValue(String value) {
        return validateString(value, "default");
    }
    // endregion

    //region методы, к-ые имеет каждое авто
    protected void startMoving() {
        System.out.println(getBrand() + " " + getModel() + " начианет движение.");
    }

    protected void finishMoving() {
        System.out.println(getBrand() + " " + getModel() + " заканчивает движение.");
    }
    //endregion

    //region переопределяемые методы
    // необходимо переопределить в наследниках, возвращает тип транспортного средства (легковая машина, грузовик, автобус)
    protected abstract Type getType();

    // необходимо переопределить в наследниках, выводит в консоль значение типа транспортного средства
    // (в случае легковых это будет информация о типе кузова, у автобуса - вместимость и т.д. )
    protected abstract void printType();

    // необходимо переопределить в наследниках (урок Exception)
    // «Пройти диагностику». в сигнатуре указано исключение (может не использоваться в наследниках, если нет необходимости)
    protected abstract void passDiagnostics() throws TransportTypeException;
    //endregion

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public List<Mechanic> getMechanicList() {
        return mechanicList;
    }

    public void setMechanicList(List<Mechanic> mechanicList) {
        this.mechanicList = mechanicList;
    }

    public void setModel(String model) {
        this.model = validateStringValue(model);
    }

    @Override
    public String toString() {
        return "Бренд: " + brand + ", модель: " + model + ", объем двигателя: " + engineVolume + " л.";
    }
}