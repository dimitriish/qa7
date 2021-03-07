package com.company;

import java.util.Scanner;

public class Main {
    public enum Country {
        RUSSIA("Россия", true),
        USA("США", false),
        FRANCE("Франция", true),
        GERMANY("Германия", false),
        JAPAN("Япония", true);

        private final String ruName;
        private final boolean isOpen;


        Country(final String ruName, final boolean isOpen) {
            this.ruName = ruName;
            this.isOpen = isOpen;
        }


        @Override
        public String toString() {
            return (name() + " (" + ruName + ")");
        }

        static Country getByRuName(final String ru) throws NoSuchCountryException {
            for (Country c
                    : values()) {
                if (c.ruName.equals(ru)) {
                    return c;
                }
            }
            throw new NoSuchCountryException(ru);
        }
    }


    public static void main(final String[] args) {
        for (Country c
                : Country.values()) {
            System.out.println(c.toString());
        }

        System.out.println("Введите название страны");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        Country aim = null;
        try {
            aim = Country.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + ": название страны - пустая строка");
        }

        if (aim == null) {
            try {
                aim = Country.getByRuName(input);
            } catch (NoSuchCountryException e) {
                System.out.println("Страны '" + input + "' не существует"); 
            }
        }

        if (aim != null) {
            if (aim.isOpen) {
                System.out.println("Страна [" + aim + "] открыта для посещения");
            } else {
                System.out.println("Страна [" + aim + "] закрыта для посещения");
            }
        }


    }
}
