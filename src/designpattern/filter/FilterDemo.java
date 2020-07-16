package designpattern.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @todo: 以不同的标准过滤一组对象，通过逻辑运算解耦组合
 * @author: hbw
 * @date: 2020/7/16
 **/
public class FilterDemo {
    static class Person {
        private String name;
        private String gender;
        private String marry;

        public String getName() {
            return name;
        }

        public Person setName(String name) {
            this.name = name;
            return this;
        }

        public String getGender() {
            return gender;
        }

        public Person setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public String getMarry() {
            return marry;
        }

        public Person setMarry(String marry) {
            this.marry = marry;
            return this;
        }

        public static Person create () {
            return new Person();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", marry='" + marry + '\'' +
                    '}';
        }
    }

    static class PersonBuilder {
        List<Person> people;
        private PersonBuilder () {
            people = new ArrayList<>(16);
        }

        public PersonBuilder addPerson (Person person) {
            people.add(person);
            return this;
        }

        public static PersonBuilder create () {
            return new PersonBuilder();
        }

        public List<Person> getPeople () {
            return people;
        }
    }

    interface Filter {
        /**
         * 过滤
         * @param people
         * @return
         */
        List<Person> filter (List<Person> people);
    }

    static class MaleFilter implements Filter {
        @Override
        public List<Person> filter(List<Person> people) {
            return people.stream().filter(person -> "male".equals(person.getGender())).collect(Collectors.toList());
        }
    }

    static class FemaleFilter implements Filter {
        @Override
        public List<Person> filter(List<Person> people) {
            return people.stream().filter(person -> "female".equals(person.getGender())).collect(Collectors.toList());
        }
    }

    static class MarryFilter implements Filter {
        @Override
        public List<Person> filter(List<Person> people) {
            return people.stream().filter(person -> "married".equals(person.getMarry())).collect(Collectors.toList());
        }
    }

    static class AndFilter implements Filter {
        private Filter filter1;
        private Filter filter2;

        public AndFilter (Filter filter1, Filter filter2) {
            this.filter1 = filter1;
            this.filter2 = filter2;
        }

        @Override
        public List<Person> filter(List<Person> people) {
            return filter2.filter(filter1.filter(people));
        }
    }

    static class OrFilter implements Filter {
        private Filter filter1;
        private Filter filter2;

        public OrFilter (Filter filter1, Filter filter2) {
            this.filter1 = filter1;
            this.filter2 = filter2;
        }

        @Override
        public List<Person> filter(List<Person> people) {
            List<Person> f1 = filter1.filter(people);
            filter2.filter(people).forEach(person -> {if (!f1.contains(person)) {f1.add(person);}});
            return f1;
        }
    }

    public static void main(String[] args) {
        PersonBuilder builder = PersonBuilder.create().addPerson(Person.create().setName("hello").setGender("male").setMarry("married"))
                .addPerson(Person.create().setName("good").setGender("female").setMarry("married"))
                .addPerson(Person.create().setName("jjiji").setGender("female").setMarry("nomarried"))
                .addPerson(Person.create().setName("kkkk").setGender("male").setMarry("married"));
        List<Person> people = builder.getPeople();

        AndFilter andFilter = new AndFilter(new MaleFilter(), new MarryFilter());

        System.out.println("male and married:");
        andFilter.filter(people).forEach(System.out::println);
        System.out.println();

        OrFilter orFilter = new OrFilter(new FemaleFilter(), new MarryFilter());

        System.out.println("female or married:");
        orFilter.filter(people).forEach(System.out::println);
    }
}
