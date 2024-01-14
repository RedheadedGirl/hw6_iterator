package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[]{new Cat(), new Cat()};
        System.out.println(iterate(cats));

        String[] strings = new String[]{"lol", "kek"};
        System.out.println(iterate(strings));

        Integer[] ints = new Integer[]{5,8,12};
        System.out.println(iterate(ints));
    }

    public static List<Object> iterate(Object[] array) {
        // допустим наш итератор складывает значения в лист и возвращает его
        // При этом если список оказался пустым, пусть кидает исключение (чтоб тесты интереснее были)
        List<Object> list = new ArrayList<>();
        Iterator<?> iter = Arrays.stream(array).iterator();
        while(iter.hasNext()){
            list.add(iter.next());
        }
        if (list.isEmpty()) {
            throw new EmptyListException();
        }
        return list;
    }

    public static class Cat {
        private final String sound;
        private final String color;

        public Cat() {
            this.sound = "meow";
            this.color = "black";
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "sound='" + sound + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}