package Drivers;

import Classes.Movie;

public class MovieTestDrive {
    public static void main(String[] args) {
        String oneTitle = "Gone with the Stock";
        String oneGenre = "Tragic";
        int oneRating = -2;
        Movie movieOne = new Movie(oneTitle, oneGenre, oneRating);

        String twoTitle = "Lost in Cubicle Space";
        String twoGenre = "Comedy";
        int twoRating = 5;
        Movie movieTwo = new Movie(twoTitle, twoGenre, twoRating);

        String threeTitle = "Byte Club";
        String threeGenre = "Tragic but ultimately uplifting";
        int threeRating = 127;
        Movie movieThree = new Movie(threeTitle, threeGenre, threeRating);

        System.out.println(movieOne);
        System.out.println(movieTwo);
        System.out.println(movieThree);

    }
}
