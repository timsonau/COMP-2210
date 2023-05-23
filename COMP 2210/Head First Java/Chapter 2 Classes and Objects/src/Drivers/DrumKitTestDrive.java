package Drivers;

import Classes.DrumKit;

public class DrumKitTestDrive {
    public static void main(String[] args) {
        DrumKit d = new DrumKit();

        if(d.isSnareAvailable()) {
            System.out.println(d.playSnare());
        }

        if(d.isTopHatAvailable()) {
            System.out.print(d.playTopHat());
        }

    }
}
