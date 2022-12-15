package skypro.java.course2.animals;

public class Main {
    public static void main(String[] args) {
        Herbivore gazelle = new Herbivore("Газель", 0, null, 40, "трава и кустраники");
        System.out.println(gazelle);
        gazelle.eat();
        gazelle.go();
        Predator tiger = new Predator("Тигр", 3, "Саванна", 40, "антилопа");
        System.out.println(tiger);
        tiger.walk();
        tiger.hunt();
        tiger.eat();
    }
}
