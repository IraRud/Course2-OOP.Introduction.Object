package skypro.java.course2.animals;

public class Main {
    public static void main(String[] args) {
        Herbivore gazelle = new Herbivore("Газель", 0, null, 40, "трава и кустраники");
        System.out.println(gazelle);
/*        gazelle.graze();
        gazelle.sleep();
        gazelle.walk();
        gazelle.eat();
        gazelle.go();*/
        Predator tiger = new Predator("Тигр", 3, "Саванна", 40, "свежее мясо");
        System.out.println(tiger);
/*        tiger.go();
        tiger.sleep();
        tiger.walk();
        tiger.hunt();
        tiger.eat();*/
    }
}
