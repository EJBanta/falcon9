import edu.fcps.karel2.*;

public class RandomNumbers {
    public static void main(String[] args) {
        diceGame();
        manyCoinFlipper(1000);
        coinGame();
    }

    public static void diceGame() {
        int result = (int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1);
        if (result >= 2 && result <= 6) {
            System.out.println("sounds like a skill issue");
        } else if (result == 7) {
            System.out.println("les go");
            Display.openWorld("");
            Display.setSpeed(10);
            for (int i = 0; i < 100; i++) {
                Robot a = new Robot((int)(Math.random() * 10 + 1), (int)(Math.random() * 10 + 1), 0, 0);
                a.explode();
            }
        } else if (result >= 8) {
            System.out.println("ez dubs");
        }
    }

    public static int manyCoinFlipper(int num) {
        int heads = 0;
        int tails = 0;

        for (int i = 0; i < num; i++) {
            switch((int)(Math.random() * 2)) {
                case 0: {heads++; break;}

                case 1: {tails++; break;}
            }
        }

        System.out.println("Heads: " + heads);
        System.out.println("Tails: " + tails);

        return heads;
    }

    @SuppressWarnings("unused")
    public static int coinFlipper(int num) {
        int heads = 0;
        int tails = 0;

        for (int i = 0; i < num; i++) {
            switch((int)(Math.random() * 2)) {
                case 0: {heads++; break;}

                case 1: {tails++; break;}
            }
        }

        return heads;
    }

    public static void coinGame() {
        int aStreak = 0;
        int bStreak = 0;
        while (aStreak < 3 && bStreak < 3) {
            if (coinFlipper(1) == 1) {
                aStreak++;
                System.out.print("Coin 1: Heads");
            } else {
                System.out.print("Coin 1: Tails");
            }

            if (coinFlipper(1) == 1) {
                bStreak++;
                System.out.print(" Coin 2: Heads");
            } else {
                System.out.print(" Coin 2: Tails");
            }

            System.out.println();
        }
        if (aStreak == 3) {
            System.out.println("Coin 2: *loses*");
            System.out.println("Coin 1: ur bad");
            System.out.println("Coin 2: *cries*");
        } else {
            System.out.println("Coin 1: *doesn't win*");
            System.out.println("Coin 2: sounds like a skill issue");
            System.out.println("Coin 1: *sobs morosely*");
        }

        System.exit(0);

    }
}
