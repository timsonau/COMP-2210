package Classes;

public class DrumKit {
    private boolean topHat;
    private boolean snare;

    public DrumKit() {
        topHat = true;
        snare = true;
    }

    public boolean isSnareAvailable() {
        return snare;
    }

    public String playSnare() {
        String snareSound = "bang bang ba-bang";
        return snareSound;
    }

    public boolean isTopHatAvailable() {
        return topHat;
    }

    public String playTopHat() {
        String topHatSound = "ding ding da-ding";
        return  topHatSound;
    }
}
