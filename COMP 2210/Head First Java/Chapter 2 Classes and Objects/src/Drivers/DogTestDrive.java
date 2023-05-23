package Drivers;

import Classes.Dog;

import java.util.Scanner;

public class DogTestDrive {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the number to convert: ");
        int intNumber = Integer.parseInt(userInput.nextLine());

        String binaryNumber = Integer.toBinaryString(intNumber);
        int i = binaryNumber.length();

        for(int j = i-1; j >= 0; j--) {
            System.out.print(binaryNumber.charAt(j));
        }

    }
}
