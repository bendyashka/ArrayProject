import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] coordinates = new int[3];
        int minimum = 1;
        int maximum = 7;
        randomNum(coordinates);
        for (int i = 0; i < coordinates.length; i++) {
            System.out.print(coordinates[i] + " ");
        }
        System.out.println();
        int[] checkCoordinates = new int[3];
        checkingCoordinates(checkCoordinates,coordinates);


    }

    private static void checkingCoordinates(int[] checkCoordinates ,int[] coordinates) {
        Scanner scanner = new Scanner(System.in);

        boolean firstcord = false;
        boolean secondcord = false;
        boolean thirdcord = false;
        boolean result = false;

        int tryies = 0;

        while (result == false) {
            for (int i = 0; i < checkCoordinates.length; i++) {
                checkCoordinates[i] = scanner.nextInt();
            }

            for (int i = 0; i < 3; i++) {

                if (coordinates[0] == checkCoordinates[0] || coordinates[0] == checkCoordinates[1] || coordinates[0] == checkCoordinates[2]) {
                    firstcord = true;
                } else {

                }

                if (coordinates[1] == checkCoordinates[0] || coordinates[1] == checkCoordinates[1] || coordinates[1] == checkCoordinates[2]) {
                    secondcord = true;
                } else {

                }

                if (coordinates[2] == checkCoordinates[0] || coordinates[2] == checkCoordinates[1] || coordinates[2] == checkCoordinates[2]) {
                    thirdcord = true;
                } else {

                }
            }
            if (firstcord && secondcord && thirdcord) {
                System.out.println("You find boxes!");
                result = true;
            } else {
                System.out.println("You dont find boxes, try again!");
                firstcord = false;
                secondcord = false;
                thirdcord = false;
                tryies++;
            }
            if (tryies == 5){
                randomNum(coordinates);
                for (int i = 0; i < coordinates.length; i++) {
                    System.out.print(coordinates[i] + " ");
                }
                System.out.println();
            }

        }
    }

    private static int[] randomNum(int[] coordinates) {
        Random random = new Random();
        int minimum = 1;
        int maximum = 7;
        for (int i = 0; i < coordinates.length; i++){
            int randomNum = random.nextInt(maximum - minimum + 1) + minimum;
            coordinates[i] = randomNum;
        }
        while(coordinates[0] == coordinates[1]){
            coordinates[1] = random.nextInt(maximum - minimum + 1) + minimum;
        }
        while(coordinates[1] == coordinates[2]){
            coordinates[2] = random.nextInt(maximum - minimum + 1) + minimum;
        }
        while(coordinates[0] == coordinates[2]){
            coordinates[0] = random.nextInt(maximum - minimum + 1) + minimum;
        }

        return coordinates;

    }
}