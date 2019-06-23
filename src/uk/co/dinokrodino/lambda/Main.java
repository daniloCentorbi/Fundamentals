package uk.co.dinokrodino.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Employee danilo = new Employee("Danilo Krodino", 37);
        Employee tim = new Employee("Tim", 26);
        Employee jhon = new Employee("Jhon", 44);
        Employee sidney = new Employee("Sidney", 22);

        List<Employee> list = new ArrayList<>();
        list.add(danilo);
        list.add((tim));
        list.add(jhon);
        list.add(sidney);
        //Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        Collections.sort(list, Comparator.comparing(Employee::getName));

        //accept(T) > perform body operation on given argument T
        //we create an 'effectively final' obj every loop
        list.forEach(employee -> {
            System.out.println(employee.getName());
        });

        //anonimous class implementing interface
        String myNewString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + " " + s2.toUpperCase();
            }
        }, list.get(0).getName(), list.get(1).getName());
        System.out.println(myNewString + " print from anonimous class implementation");

        //lambda
        UpperConcat up = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String lambdaString = doStringStuff(up, list.get(0).getName(), list.get(1).getName());

        System.out.println(lambdaString + " print from lambda");
        System.out.println("================================");

        //use Predicate interface
        printEmployeeByAge(list, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeeByAge(list, "Employees under 30", employee -> employee.getAge() <= 30);
        //old style anonimous class
        printEmployeeByAge(list, "Employees under 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        //more predicate and chaining
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        //System.out.println(greaterThan15.and(lessThan100).test(50));
        //System.out.println(greaterThan15.and(lessThan100).test(15));



        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };
        Function<Employee, String> getFirstName = employee ->
        {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };
        //what run depends on application state or on our needs passing appropriate function
        System.out.println(getName(getLastName, list.get(0)) + " " + getName(getFirstName, list.get(0)) + " Printed from functional interface");

        //chaining function
        Function<Employee, String> upperCaseName = employee -> {
            return employee.getName().toUpperCase();
        };
        Function<String, String> firstName = name -> {
            return name.substring(0, name.indexOf(' '));
        };
        Function chainedFunction = upperCaseName.andThen(firstName);
        System.out.println(chainedFunction.apply(list.get(0)) + " Printed from Chained Function");


        BiFunction<String, Employee, String> concatAge = (name, employee) -> {
            return name.concat(" " + employee.getAge());
        };
        String upperName = upperCaseName.apply(list.get(0));
        System.out.println(concatAge.apply(upperName,list.get(0)) + " Printed from BIFunction");

        //TODO
        //some lambda stream example

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }

    public static void printEmployeeByAge(List<Employee> employees,
                                          String message,
                                          Predicate<Employee> ageCondition) {
        System.out.println(message);
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }

    public static String getName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

}