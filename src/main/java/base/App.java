/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Dillon Flaschner
 */

package base;

import java.util.Scanner;

public class App {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        int height = myApp.heightInput();
        int weight = myApp.weightInput();

        double BMI = myApp.BMICalc(height, weight);

        String output = myApp.buildOutput(BMI);
        myApp.printOutput(output);
    }

    public int heightInput() {
        System.out.print("What is your height in inches? ");
        return checkValidInput();
    }

    public int weightInput() {
        System.out.print("What is your weight in pounds? ");
        return checkValidInput();
    }

    public int checkValidInput() {
        boolean check = false;

        while (!check) {
            check = input.hasNextInt();

            if (!check) {
                input.nextLine();
                System.out.println("Please enter an integer.");
            }
        }
        return input.nextInt();
    }

    public double BMICalc(int height, int weight) {
        float heightFloat = height;
        float weightFloat = weight;
        return (weightFloat / (heightFloat * heightFloat)) * 703;
    }

    public String buildOutput(double BMI) {
        String BMIString = String.format("Your BMI is %.1f%n", BMI);
        String endString;

        if (BMI > 25) {
            endString = "You are overweight. You should see your doctor.";
        } else if (BMI < 18.5) {
            endString = "You are underweight. You should see your doctor.";
        } else {
            endString = "You are within the ideal weight range.";
        }

        return BMIString + endString;
    }

    public void printOutput(String output) {
        System.out.print(output);
    }
}