import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var scan = new Scanner(System.in);
        var animalCount = readInt(scan); // обработать ошибку
        if (animalCount <= 0) {
            return;
        }
        scan.nextLine();
        var animalList = new ArrayList<Animal>();
        processAnimal(scan, animalCount, animalList);
        animalList.forEach(s -> System.out.println(s.toString() + "\n"));
    }

    private static void processAnimal(Scanner scan, int animalCount, ArrayList<Animal> animalList) {
        for (int i = 0; i < animalCount; i++) {
            var animalType = scan.nextLine();
            var animal = getAnimalInfo(animalType, scan);
            if (animal != null) animalList.add(animal);
        }
    }

    public static Animal getAnimalInfo(String type, Scanner scan) {
        if (type.equals("dog") || type.equals("cat")) {
            var name = scan.nextLine();
            var age = readInt(scan);
            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                return null;
            }
            if (type.equals("dog")) return new Dog(name, age);
            else return new Cat(name, age);
        } else {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }
    }

    public static int readInt(Scanner in) {
        while (true) {
            try {
                return in.nextInt();
            } catch (Exception ex) {
                System.out.println("Incorrect input. Age <= 0");
                in.next();
            }
        }
    }
}
