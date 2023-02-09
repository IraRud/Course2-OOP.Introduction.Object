package skypro.java.course2.animals;

public class Main {
    public static void main(String[] args) {
        Herbivore gazelle = new Herbivore("Газель", 0, null, 40, "трава и кустраники");
        System.out.println(gazelle);
        Herbivore giraffe = new Herbivore("Жираф", 7, "Саванна", 20, "кустраники");
        System.out.println(giraffe);
        Herbivore horse = new Herbivore("Лошадь", 10, "повсеместно", 60, "предпочтительно трава");
        System.out.println(horse);
        Predator hyena = new Predator("Гиена", -100, "где-то", 40, "падаль");
        System.out.println(hyena);
        Predator tiger = new Predator("Тигр", 3, "Саванна", 40, "свежее мясо");
        System.out.println(tiger);
        Predator bear = new Predator("Медведь", 12, "леса", 30, "свежее мясо, ягоды");
        System.out.println(bear);
        Amphibian frog = new Amphibian("Лягушка", -1, "средняя полоса");
        System.out.println(frog);
        Amphibian snake = new Amphibian("", 15, "средняя полоса");
        System.out.println(snake);
        Flightless penguin = new Flightless("Пингвин", 4, "Антарктида", "пешком и вплавь");
        System.out.println(penguin);
        Flightless peacock = new Flightless("Павлин", 7, "", "пешком");
        System.out.println(peacock);
        Flightless dodo = new Flightless("", 0, "", null);
        System.out.println(dodo);
        Flying seagull = new Flying("Чайка", 3, "прибалтика", "полеты");
        System.out.println(seagull);
        Flying albatross = new Flying("Альбатрос", 8, "прибалтика", "полеты");
        System.out.println(albatross);
        Flying falcon = new Flying("Сокол", 3, "горы", "полеты");
        System.out.println(falcon);
        Herbivore gazelle2 = new Herbivore("Газель", 0, null, 40, "трава и кустраники");
        System.out.println(gazelle2);
        compareObjects(gazelle, seagull);
        compareObjects(gazelle, gazelle2);
        checkMethods(gazelle, tiger, frog, penguin, seagull);   // проверка методов для объекта из каждого класса
    }

    public static void compareObjects(Animal obj1, Animal obj2) {
        specialSymbol();
        System.out.println("Сравним два объекта?");
        if (obj1.equals(obj2)) {
            System.out.println(obj1.getName() + " и " + obj2.getName() + " идентичны! Животные дублируют друг друга.");
        } else {
            System.out.println(obj1.getName() + " и " + obj2.getName() + " отличаются! Речь идет о разных животных.");
        }
    }

    public static void checkMethods(Herbivore gazelle, Predator tiger, Amphibian frog, Flightless penguin, Flying seagull) {
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
        specialSymbol();
        seagull.go();
        seagull.sleep();
        seagull.eat();
        seagull.hunt();
        seagull.fly();
    }

    public static void specialSymbol() {
        System.out.println("--------------- + + + ---------------");
    }
}
