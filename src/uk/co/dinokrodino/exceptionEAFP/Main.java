package uk.co.dinokrodino.exceptionEAFP;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
            try {
            int result = divide();
            System.out.println(result);
        } catch(ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
          //  e.printStackTrace();
        }
    }

    private static int divide() {
        int x, y;
//        try {
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
  //No possible handle ^D or divide by 0, the main will prinit the Stacktrace
//        } catch(NoSuchElementException e) {
//            throw new ArithmeticException("no suitable input");
//        } catch(ArithmeticException e) {
//            throw new ArithmeticException("attempt to divide by zero");
//        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while(true) {
            try {
                return s.nextInt();
            } catch(InputMismatchException e) {
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9 ");
            }
        }
    }

    //Java 7 multiple try-with-resource statement (resource needs to implement AutoClosable).
    //Need to handle or specify all exceptions that might be thrown while closing the resource.
      public void automaticallyCloseResource() {
        File file = new File("./tmp.txt");
          try(BufferedReader br = new BufferedReader(new FileReader(file));
              FileInputStream inputStream = new FileInputStream(file);
              BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            // use the inputStream to read a file
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //Checked exception
    public void countUsers() throws TooManyUsersException {
        int numberOfUsers = 0;
        while(numberOfUsers < 500) {
            // some code
            numberOfUsers++;
        }
        throw new TooManyUsersException("The number of users exceeds our maximum amount.");
    }

    public class TooManyUsersException extends Exception {
        public TooManyUsersException(String message) {
            super(message);
        }
    }

    //Unchecked exception
    public void authenticateUser(String username) throws UserNotAuthenticatedException {
        if(false) {
            throw new UserNotAuthenticatedException("User is not authenticated!");
        }
    }

    public class UserNotAuthenticatedException extends RuntimeException {
        public UserNotAuthenticatedException(String message) {
            super(message);
        }
    }

}