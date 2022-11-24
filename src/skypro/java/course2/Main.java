package skypro.java.course2;

public class Main {
    public static void main(String[] args) {
        /*Максим из города Минск, который родился в 1988 году;
        Аня из города Москва, которая родилась в 1993 году;
        Катя из города Калининград, которая родилась в 1992 году;;
        Артем из города Москва, который родился в 1995 году.*/

        Person maksim = new Person();
        maksim.name = "Максим";
        maksim.town = "Минск";
        maksim.yearOfBirth = 1988;
        maksim.jobTitle = "бренд-менеджер";
        System.out.println(maksim.toString());

        Person anya = new Person();
        anya.name = "Аня";
        anya.town = "Москва";
        anya.yearOfBirth = 1993;
        anya.jobTitle = "методист образовательных программ";
        System.out.println(anya.toString());

        Person katya = new Person();
        katya.name = "Катя";
        katya.town = "Калиниград";
        katya.yearOfBirth = 1992;
        katya.jobTitle = "продакт-менеджер";
        System.out.println(katya.toString());

        Person artem = new Person();
        artem.name = "Артем";
        artem.town = "Москва";
        artem.yearOfBirth = 1995;
        artem.jobTitle = "директор по развитию бизнеса";
        System.out.println(artem.toString());
    }
}
