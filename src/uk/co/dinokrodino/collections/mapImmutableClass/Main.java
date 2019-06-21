package uk.co.dinokrodino.collections.mapImmutableClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loc = 1;
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");

        while (true) {
            System.out.println(locations.get(loc).getDescription());

            if (loc == 0) {
                System.out.println("Program Exit");
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available location are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + " , ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1) {
                String[] command = direction.split(" ");
                for (String item : command) {
                    if (vocabulary.containsKey(item)) {
                        direction = vocabulary.get(item);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else{
                System.out.println("Not valid direction");


                "pluto".equals("");
            }
        }
    }
}
