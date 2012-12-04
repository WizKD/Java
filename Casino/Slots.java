/*

   Code monkey: Wiz
   Version 1.0

 */

import java.util.Random;

public class Slots{

    int slots[][] = new int[4][4];

    public Slots(int intro){

        if (intro == 1){
            System.out.printf ("\nWelcome to Kevin's slot machines.\n");
            System.out.printf ("Here are the rules (these will only be displayed once):\n");
            System.out.printf ("(1) Payspot 1 will count for any wins for ROWS\n");
            System.out.printf ("(2) Payspot 2 will count for any wins for ROWS and ");
            System.out.printf("COLUMNS.\n");
            System.out.printf ("(3) Payspot 3 will count for ROWS, COLUMNS and DIAGONALS\n"); 
        }
    }
    public int Add (int currentCash, int addAmount){
        return (currentCash + addAmount);
    }
    public void Randomize(){

        Random generator = new Random();

        double displace = Math.random();

        for (int x = 0; x < slots.length; x++){
            for (int y = 0; y < slots.length; y++){
                slots[x][y] = generator.nextInt(3) + (int) Math.abs(displace);
            }
        }


    }
    public void runSlots(){
        System.out.println();
        System.out.printf (" - - - - - - - - - - - - \n");
        for (int x = 0; x < slots.length-1; x++){
            for (int y = 0; y < slots.length-1; y++){
                if (slots[x][y] == 0)
                    System.out.printf (" Joker |", slots[x][y]);
                else if (slots[x][y] == 1)
                    System.out.printf (" Queen |", slots[x][y]);
                else if (slots[x][y] == 2)
                    System.out.printf (" Seven |", slots[x][y]);
            }

            System.out.println();
        }
        System.out.printf (" - - - - - - - - - - - - \n");

    }

    public int betAmount (int currentTotal, int bet, int paySpots){
        return (currentTotal - (bet*paySpots));
    }

    public int checkWinner (int currentTotal, int bet, int paySpots){

        boolean winner = false;
        int totalWins = 0;

        // Row one
        if (paySpots >= 1){
            if (slots[0][0] == 0 && slots[0][1] == 0 && slots[0][2] == 0){
                System.out.printf ("\n!!\tWinner - row one");
                winner = true;
                totalWins++;
            }
            if (slots[0][0] == 1 && slots[0][1] == 1 && slots[0][2] == 1){
                System.out.printf ("\n!!\tWinner - row one");
                winner = true;
                totalWins++;
            }   
            if (slots[0][0] == 2 && slots[0][1] == 2 && slots[0][2] == 2){
                System.out.printf ("\n!!\tWinner - row one");
                winner = true;
                totalWins++;
            }
            // Row two
            if (slots[1][0] == 0 && slots[1][1] == 0 && slots[1][2] == 0){
                System.out.printf ("\n!!\tWinner - row two");
                winner = true;
                totalWins++;
            }
            if (slots[1][0] == 1 && slots[1][1] == 1 && slots[1][2] == 1){
                System.out.printf ("\n!!\tWinner - row two");
                winner = true;
                totalWins++;
            }
            if (slots[1][0] == 2 && slots[1][1] == 2 && slots[1][2] == 2){
                System.out.printf ("\n!!\tWinner - row two");
                winner = true;
                totalWins++;
            }

            // Row three
            if (slots[2][0] == 0 && slots[2][1] == 0 && slots[2][2] == 0){
                System.out.printf ("\n!!\tWinner - row three");
                winner = true;
                totalWins++;
            }
            if (slots[2][0] == 1 && slots[2][1] == 1 && slots[2][2] == 1){
                System.out.printf ("\n!!\tWinner - row three");
                winner = true;
                totalWins++;
            }
            if (slots[2][0] == 2 && slots[2][1] == 2 && slots[2][2] == 2){
                System.out.printf ("\n!!\tWinner - row three");
                winner = true;
                totalWins++;
            }
        }
        // ----------- Columns ------------------ \\
        // Col 1
        if (paySpots >= 2){
            if (slots[0][0] == 0 && slots[1][0] == 0 && slots[2][0] == 0){
                System.out.printf ("\n!!\tWinner - column one");
                winner = true;
                totalWins++;
            }
            if (slots[0][0] == 1 && slots[1][0] == 1 && slots[2][0] == 1){
                System.out.printf ("\n!!\tWinner - column one");
                winner = true;
                totalWins++;
            }
            if (slots[0][0] == 2 && slots[1][0] == 2 && slots[2][0] == 2){
                System.out.printf ("\n!!\tWinner - column one");
                winner = true;
                totalWins++;
            }

            // Col 2
            if (slots[0][1] == 0 && slots[1][1] == 0 && slots[2][1] == 0){
                System.out.printf ("\n!!\tWinner - column two");
                winner = true;
                totalWins++;
            }

            if (slots[0][1] == 1 && slots[1][1] == 1 && slots[2][1] == 1){
                System.out.printf ("\n!!\tWinner - column two");
                winner = true;
                totalWins++;
            }

            if (slots[0][1] == 2 && slots[1][1] == 2 && slots[2][1] == 2){
                System.out.printf ("\n!!\tWinner - column two");
                winner = true;
                totalWins++;
            }

            // Col 3
            if (slots[0][2] == 0 && slots[1][2] == 0 && slots[2][2] == 0){
                System.out.printf ("\n!!\tWinner - column three");
                winner = true;
                totalWins++;
            }

            if (slots[0][2] == 1 && slots[1][2] == 1 && slots[2][2] == 1){
                System.out.printf ("\n!!\tWinner - column three");
                winner = true;
                totalWins++;
            }

            if (slots[0][2] == 2 && slots[1][2] == 2 && slots[2][2] == 2){
                System.out.printf ("\n!!\tWinner - column three");
                winner = true;
                totalWins++;
            }
        }

        // ----------------- Diagonals ---------------
        if (paySpots == 3){
            if (slots[0][0] == 0 && slots[1][1] == 0 && slots[2][2] == 0){
                System.out.printf ("\n!!\tWinner - diagonal (left to right)");
                winner = true;
                totalWins++;
            }
            if (slots[0][0] == 1 && slots[1][1] == 1 && slots[2][2] == 1){
                System.out.printf ("\n!!\tWinner - diagonal (left to right)");
                winner = true;
                totalWins++;
            }

            if (slots[0][0] == 2 && slots[1][1] == 2 && slots[2][2] == 2){
                System.out.printf ("\n!!\tWinner - diagonal (left to right)");
                winner = true;
                totalWins++;
            }

            if (slots[0][2] == 0 && slots[1][1] == 0 && slots[2][0] == 0){
                System.out.printf ("\n!!\tWinner - diagonal (right to left)");
                winner = true;
                totalWins++;
            }
            if (slots[0][2] == 1 && slots[1][1] == 1 && slots[2][0] == 1){
                System.out.printf ("\n!!\tWinner - diagonal (right to left)");
                winner = true;
                totalWins++;
            }
            if (slots[0][2] == 2 && slots[1][1] == 2 && slots[2][0] == 2){
                System.out.printf ("\n!!\tWinner - diagonal (right to left)");
                winner = true;
                totalWins++;
            }
        }

        if (winner){
            /*  System.out.printf ("\n\t\tCurrent sent to slots: %d\n", currentTotal);
                System.out.printf ("\t\tCurrent bet amount: %d spots: %d\n", bet, paySpots);
                System.out.printf ("\t\tWhat was won: %d\n", (bet*paySpots));
                System.out.printf ("\t\tWhat is ACTUALLY returning: %d\n", currentTotal);*/
            currentTotal += (bet*paySpots);
            currentTotal += (bet*totalWins);
            
            System.out.printf ("\n!!\tTotal wins this betting period: %d", totalWins);

            return (currentTotal);
        }
        else{
            System.out.printf ("\nLost bet.\n");
            return (currentTotal);
        }

    }


}
