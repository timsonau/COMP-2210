public class Tester {
    public static void main (String[] args) {
        String[] wordListOne = {"24/7", "multi-Tier", "30,000 foot", "B-to-B", "win-win"
                , "front-end", "web-based", "pervasive", "smart", "six-sigma", "critical-path"
                , "dynamic"};

        String[] wordListTwo = {"empowered", "sticky", "value-added", "oriented", "centric"
                , "distributed", "clustered", "branded", "outside-the-box", "positioned"
                , "networked", "focused", "leveraged", "aligned", "targeted", "shared"
                , "cooperative", "accelerated"};

        String[] wordListThree = {"process", "tipping-point", "solution", "architecture"
                , "core competency", "strategy", "mindshare", "portal", "space", "vision"
                , "paradigm", "mission"};

        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength); //will give value between (0,11.9999) then cast to an Int
        int rand2 = (int) (Math.random() * twoLength); //will give value between (0,17.9999) then cast to an Int
        int rand3 = (int) (Math.random() * threeLength); //will give value between (0,11.9999) then cast to an Int

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
        System.out.println("What we need is a " + phrase);

    }
}
