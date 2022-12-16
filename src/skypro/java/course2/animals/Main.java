package skypro.java.course2.animals;

public class Main {
    public static void main(String[] args) {
        Herbivore gazelle = new Herbivore("Газель", 0, null, 40, "трава и кустраники");
        System.out.println(gazelle);
        Predator tiger = new Predator("Тигр", 3, "Саванна", 40, "свежее мясо");
        System.out.println(tiger);
        Amphibian frog = new Amphibian("Лягушка", -1, "средняя полоса");
        System.out.println(frog);
        Flightless penguin = new Flightless("Пингвин", 4, "Антарктида", "пешком и вплавь");
        System.out.println(penguin);
        checkMethods(gazelle, tiger, frog, penguin);
    }

    public static void checkMethods(Herbivore gazelle, Predator tiger, Amphibian frog, Flightless penguin) {
        specialSymbol();
        gazelle.eat();
        gazelle.sleep();
        gazelle.go();
        gazelle.walk();
        gazelle.graze();
        specialSymbol();
        tiger.go();
        tiger.sleep();
        tiger.eat();
        tiger.walk();
        tiger.hunt();
        specialSymbol();
        frog.go();
        frog.sleep();
        frog.eat();
        frog.hunt();
        specialSymbol();
        penguin.go();
        penguin.sleep();
        penguin.eat();
        penguin.hunt();
        penguin.walk();
    }

    public static void specialSymbol() {
        System.out.println("--------------- + + + ---------------");
    }
}
