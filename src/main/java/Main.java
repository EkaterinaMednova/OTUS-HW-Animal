import animals.Animal;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        String commandInput = null;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Введите одну из команд (add/list/exit):");
            commandInput = scanner.next().trim().toUpperCase();
            CommandsData commands;
            try {
                commands = CommandsData.valueOf(commandInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Вы ввели неверную команду! Пожалуйста, попробуйте еще раз!");
                continue;
            }

            switch(commands) {
                case ADD:
                    String type;
                    while (true) {
                        System.out.println("Какое животное вы выбрали (cat/dog/duck)?");
                        type = scanner.next().trim().toUpperCase();
                        if (!type.equals("CAT") && !type.equals("DOG") && !type.equals("DUCK")) {
                            System.out.println("Вы ввели неверный тип животного. Пожалуйста, попробуйте еще раз!");
                        } else {
                            break;
                        }
                    }

                    System.out.println("Введите имя питомца");
                    while (!scanner.hasNext("[a-zA-Z]*$")) {
                        System.out.println("Вводите, пожалуйста, только буквы!");
                        scanner.next();
                    }
                    String name = scanner.next().trim();


                    System.out.println("Введите возраст питомца");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Вводите, пожалуйста, только числа");
                        scanner.next();
                    }
                    int age = scanner.nextInt();

                    System.out.println("Введите вес питомца");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Вводите, пожалуйста, только целое число или дробное число с разделителем запятая");
                        scanner.next();
                    }
                    double weight = scanner.nextDouble();

                    System.out.println("Введите цвет питомца");
                    while (!scanner.hasNext("[a-zA-Z]*$")) {
                        System.out.println("Вводите, пожалуйста, только буквы!");
                        scanner.next();
                    }
                    String color = scanner.next().trim();

                    AnimalData data=  AnimalData.valueOf(type);
                    Animal an = new AnimalFactory(name, age, weight, color).created(data);
                    animals.add(an);
                    an.Say();

                    break;


                case LIST:
                    if (animals.size() == 0) {
                        System.out.println("В списке отсутствуют животные");
                    } else {
                        for (Animal a : animals) {
                            System.out.println(a.toString());
                        }
                    }
                    break;

                case EXIT:
                    scanner.close();
                    System.out.println("Выход из программы");
                    System.exit(0);
            }
        }
    }
}
