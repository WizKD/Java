/*
   Code monkey: Wiz
   Version 1.0 (4/22/11)
   Slot machine - DONE - Wiz
   Black Jack - progress


 */
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CasinoGames{

    public static void main (String args[]){

        Scanner input = new Scanner (System.in);
        int choiceVar = 0;
        int totalCash = 0;
        int intro = 0;
        int intoBlack = 0;


        String opts[] = {"Exit", "Add more money", "Current Cash", "Spin slots", "Deal Blackjack"};
        CasinoMenu menu = new CasinoMenu(opts);
        Slots slots = new Slots(intro);
        Blackjack blackjack = new Blackjack(intro);
        intro++;
        intoBlack++;
        System.out.printf ("\nWelcome to Kevin's casino.\n");

        do {
            choiceVar = menu.RunMenu();
            switch (choiceVar){

                case 1 : // Add more money
                    int addedCash = 0;
                    do{
                        try{
                            System.out.printf ("\nYou currently have $%d, ", totalCash);
                            System.out.printf("how much would you like to add: $");
                            addedCash = input.nextInt();
                            totalCash =+ slots.Add(totalCash, addedCash);
                        }
                        catch (InputMismatchException ime){
                            System.out.printf ("\n!!\tThere was an error in your input.");
                            System.out.printf (" Try again.\n");
                            input.nextLine();
                        }
                    }while (addedCash <= -1);

                    break;

                case 3: // Play slots

                    slots = new Slots(intro);
                    intro++;

                    if ( totalCash > 0){
                        int bet = 0;
                        int paySpots = 0;
                        do{

                            try{
                                System.out.printf ("\n##\tHow much would you like");
                                System.out.printf(" to wager on this spin per pay spot(>0): $");
                                bet = input.nextInt();
                            }
                            catch (InputMismatchException ime){
                                System.out.printf ("\n!!\tError during input. Try again.\n");
                                input.nextLine();
                            }

                            try{
                                System.out.printf ("\n##\tHow many pay spots would you ");
                                System.out.printf ("like to use: ");
                                paySpots = input.nextInt();
                            }
                            catch (InputMismatchException ime){
                                System.out.printf ("\n!!\tError during input.");
                                System.out.printf (" Try again.\n");
                                input.nextLine();
                            }

                            if (bet <= 0){
                                System.out.printf ("\n!!\tYou cannot not wager that ");
                                System.out.printf ("low of an amount. Try again.\n");
                            }
                            if (paySpots <= 0){
                                System.out.printf ("\n!!\tYou cannot have that few ");
                                System.out.printf ("pay spots.\n");
                            }
                            if (totalCash - (bet*paySpots) < 0){
                                System.out.printf ("\n!!\tYou cannot wager more than you ");
                                System.out.printf ("have ($%d). Try again.\n", totalCash);
                                bet = 0;
                            }
                        }while (bet <= 0 || paySpots <= 0);

                        totalCash = slots.betAmount(totalCash, bet, paySpots);
                        slots.Randomize();
                        slots.runSlots();
                        totalCash = slots.checkWinner(totalCash, bet, paySpots);
                    }
                    else{
                        System.out.printf ("\n!!\tYou have %d, and must have", totalCash);
                        System.out.printf(" at least $1 to play slots. ");
                        System.out.printf ("Please add money to play.\n");
                    }

                    break;
                case 2: // get current cash
                    System.out.printf ("\nYou have $%d on hand.\n", totalCash);
                    break;

                case 4: // deal blackjack

                    blackjack = new Blackjack(intoBlack);
                    intoBlack++;

                    if ( totalCash > 0){
                        int bet = 0;

                        do{

                            try{
                                System.out.printf ("\n##\tHow much would you like");
                                System.out.printf(" to wager (>0): $");
                                bet = input.nextInt();
                            }
                            catch (InputMismatchException ime){
                                System.out.printf ("\n!!\tError during input. Try again.\n");
                                input.nextLine();
                            }

                            if (bet <= 0){
                                System.out.printf ("\n!!\tYou cannot not wager that ");
                                System.out.printf ("low of an amount. Try again.\n");
                            }

                            if (totalCash - bet < 0){
                                System.out.printf ("\n!!\tYou cannot wager more than you ");
                                System.out.printf ("have ($%d). Try again.\n", totalCash);
                                bet = 0;
                            }
                        }while (bet <= 0);
                        blackjack.dealPlayer();
                        blackjack.hitORstay();
                        totalCash = blackjack.Winner(totalCash, bet);

                    }
                    else{
                        System.out.printf ("\n!!\tYou have %d, and must have", totalCash);
                        System.out.printf(" at least $1 to play slots. ");
                        System.out.printf ("Please add money to play.\n");
                    }


                    break;

            }   
        }while (choiceVar != 0); 

    }

}

