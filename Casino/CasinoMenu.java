/*
Name: Kevin Dolphin
Class: CIST 1620 - 004
Program #: 7 
Due Date: April 29, 2010 

Honor pledge: On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received any unauthorized help on this homework assignment.

Signed: Kevin Dolphin

Collaborators: PPT Slides

Description of assignment: Menu

 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class CasinoMenu
{
    // THIS MENU WAS TAKEN FROM THE SLIDES.

    private String options[];

    public CasinoMenu(String[] opts){ 

        options = new String [opts.length]; // allocate memory for the array.

        for (int x = 0; x < opts.length; x++)
            options[x] = opts[x];

    }

    public int RunMenu(){ // displays the menu.

        Scanner input = new Scanner (System.in);

        int opt = -1;

        do{
            System.out.printf("\n\nChoose from the following: \n"); // displays the interface
            try{
                for (int x = 1; x < options.length; x++)
                    System.out.printf ("\t%d\t%s\n", x, options[x]);
                // ----------------------------------------------------- \\

                System.out.printf("\t%d\t%s\n",0,options[0]); //display 0th as exit

                // ------------------------------------------------------ \\

                // get option from EU \\
                System.out.printf ("\n\tChoice: ");
                opt = input.nextInt();
                input.nextLine();

                if (opt < 0 || opt >= options.length)
                    System.err.printf("\n!!\tInvalid menu option - try again\n");

            }
            catch (InputMismatchException ime){
                System.err.println("\n!!\tInvalid menu option - try again");
                input.nextLine();
            }
        }while (opt < 0 || opt >= options.length);

        return opt;

    }
}
