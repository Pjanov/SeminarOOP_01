package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // TODO: инициализация данных
        Person myName = new Person("Андрей Анатольевич"); // Корень(личность)
        Person father = new Person("Анатолий Николаевич"); // Папа
        Person mother = new Person("Надежда Петровна"); // Мама
        Person sister = new Person("Виктория Анатольевна"); // Сестра
        Person brother = new Person("Сергей Анатольевич"); // Брат
        Person paternalGrandFather = new Person("Николай Николаевич");  // дедушка по отцовской линии
        Person paternalGrandMother = new Person("Анастасия Борисовна");  // бабушка по отцовской линии
        Person maternalGrandFather = new Person("Петр Иванович");  // дедушка по материнской линии
        Person maternalGrandMother = new Person("Анастасия Александровна");  // бабушка по материнской линии

        father.setFather(paternalGrandFather);
        father.setMother(paternalGrandMother);
        mother.setFather(maternalGrandFather);
        mother.setMother(maternalGrandMother);
        myName.setFather(father);
        myName.setMother(mother);

        sister.setFather(father);
        sister.setMother(mother);
        brother.setFather(father);
        brother.setMother(mother);

        ArrayList<Person> children = new ArrayList<>();
        ArrayList<Person> brothers = new ArrayList<>();
        ArrayList<Person> sisters = new ArrayList<>();

        Collections.addAll(children, sister, brother);
        Collections.addAll(brothers, brother);
        Collections.addAll(sisters, sister);
        myName.setSisters(sisters);
        myName.setBrothers(brothers);
        father.setChildren(children);
        mother.setChildren(children);

        // TODO: меню
        getDataByParameter(myName);

    }

    /**
     * <h3>Получить имена детей</h3>
     *
     * @param personality личность
     */
    private static void getAllChildren(Person personality) {
        try {
            int length = personality.getChildren().size();
            for (int i = 0; i < length; i++) {
                String c = personality.getChildren().get(i).name;
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println("Не указано или отсутствуют");
        }

    }

    /**
     * <h3>Получить имена братьев</h3>
     *
     * @param personality личность
     */
    public static void getAllBrother(Person personality) {
        try {
            int length = personality.getBrothers().size();
            for (int i = 0; i < length; i++) {
                String br = personality.getBrothers().get(i).name;
                System.out.println(br);
            }
        } catch (Exception e) {
            System.out.println("Не указано или отсутствуют");
        }
    }

    /**
     * <h3>Получить имена сестер</h3>
     *
     * @param personality личность
     */
    public static void getAllSisters(Person personality) {
        try {
            int length = personality.getSisters().size();
            for (int i = 0; i < length; i++) {
                String st = personality.getSisters().get(i).name;
                System.out.println(st);
            }
        } catch (Exception e) {
            System.out.println("Не указано или отсутствуют");
        }
    }

    /**
     * <h3>Получить данные личности по указанному параметру</h3>
     *
     * @param personality личность
     */
    public static void getDataByParameter(Person personality) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер из списка по коториму вывести данные личности:\n" +
                "1 - сестры\n" +
                "2 - братья\n" +
                "3 - дети\n" +
                "4 - показать генеалогическое древо");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num == 1) {
                getAllSisters(personality);
            } else if (num == 2) {
                getAllBrother(personality);
            } else if (num == 3) {
                getAllChildren(personality);
            } else if (num == 4) {
                System.out.println(personality);
            } else {
                System.out.println("Такого параметра нет");
            }
        } else {
            System.out.println("Это не число!");
        }
        scanner.close();
    }
}