/*
   Code monkey: Wiz
Version: demo

 */

import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Blackjack{

    int playerhand[];
    int playerCount = 0;
    int PlayerTotal = 0;
    boolean didBustP = false;

    public Blackjack( int intro){

        if (intro == 1){    
            System.out.printf ("\nWelcome to Kevin's Blackjack table.\n");
            System.out.printf ("Here are the rules (these will only be displayed once):\n");
            System.out.printf ("(1) Player will attempt to reach twenty-one in any way possible.\n");
        }

    }

    public void dealPlayer(){ 

        Random gen = new Random();
        playerhand = new int[7];

        for (int x = 0; x < playerhand.length-1; x++){
            playerhand[x] = gen.nextInt(14);   
        }
        System.out.println();
        playerCount = 2;

        System.out.printf ("\tYour current hand contains: \n");
        printHand(playerhand, playerCount);
        System.out.println();
    }

    public void printHand(int currenthand[], int currentCount){

        for (int x = 0; x < currentCount; x++){
            if (currenthand[x] == 0)
                System.out.printf ("\tAce ");
            if (currenthand[x] == 1)
                System.out.printf ("\tOne ");
            if (currenthand[x] == 2)
                System.out.printf ("\tTwo ");
            if (currenthand[x] == 3)
                System.out.printf ("\tThree ");
            if (currenthand[x] == 4)
                System.out.printf ("\tFour ");
            if (currenthand[x] == 5)
                System.out.printf ("\tFive ");
            if (currenthand[x] == 6)
                System.out.printf ("\tSix ");
            if (currenthand[x] == 7)
                System.out.printf ("\tSeven ");
            if (currenthand[x] == 8)
                System.out.printf ("\tEight ");
            if (currenthand[x] == 9)
                System.out.printf ("\tNine ");
            if (currenthand[x] == 10)
                System.out.printf ("\tTen ");
            if (currenthand[x] == 11)
                System.out.printf ("\tJack ");
            if (currenthand[x] == 12)
                System.out.printf ("\tQueen ");
            if (currenthand[x] == 13)
                System.out.printf ("\tKing ");
        }
        System.out.println();
    }

    public void hitORstay(){

        Scanner input = new Scanner (System.in);
        char playerResponse = 'A';

        PlayerTotal = countHand();

        System.out.printf ("Current hand total: %d\n", PlayerTotal);
        do {
            System.out.printf ("\nWould you like to hit? [y/n] ");
            playerResponse = input.next().charAt(0);

            if (playerResponse == 'y'){
                System.out.printf ("\nHit in progress.\n");
                playerCount++;
                printHand(playerhand, playerCount);
                PlayerTotal = countHand();
                System.out.printf ("\nCurrent hand total: %d\n", PlayerTotal);
            }
            else if (playerResponse == 'n'){
                System.out.printf ("\nStay in progress.\n");
            }
            else
                System.out.printf ("\n!!\tError in input, retry.\n");

            if (PlayerTotal > 21){
                didBustP = true;
                break;
            }

        }while(playerResponse != 'n');

    }

    public int countHand(){

        int total = 0;

        for ( int x = 0; x < playerCount; x++)
        {
            if (playerhand[x] >= 10)
                total += 10;
            if (playerhand[x] < 10)
                total += playerhand[x];
            if (playerhand[x] == 0)
                total += 11;
            if (total > 21)
                didBustP = true;
        }

        for (int x = 0; x < playerCount; x++){
            if (total > 21){
                if (playerhand[x] == 0)
                    total-= 10;
            }
        }

        return total;
    }

    public int Winner (int currentCash, int bet){

        Random gen = new Random();
        int DealerTotal = 0;
        DealerTotal = gen.nextInt(5)+17;

        if (didBustP){
            System.out.printf ("\n##\tPlayer busted.\n");
            return (currentCash - bet);
        }
        else{
            if (DealerTotal > PlayerTotal){
                System.out.printf ("\n##\tDealer wins with a hand of %d\n", DealerTotal);
                return (currentCash - bet);
            }
            else if (DealerTotal < PlayerTotal){
                System.out.printf ("\n##\tPlayer wins, beats dealer hand of %d\n", DealerTotal);
                return (currentCash + bet);
            }
            else{
                System.out.printf ("\n##\tGame push. Dealer had %d\n", DealerTotal);
                return currentCash;
            }
        }

    }
}
