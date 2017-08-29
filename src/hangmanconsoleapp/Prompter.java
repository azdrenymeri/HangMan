/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanconsoleapp;

import java.util.Scanner;

/**
 *
 * @author Azdren
 */
public class Prompter {
    
    private Game game;
    
    public Prompter(Game game){
        this.game = game;
    }
    
    public boolean promptForGuess(){
        Scanner scanner = new Scanner(System.in); 
        boolean isHit = false;
        boolean isAcceptable = false;
         
       do{
            System.out.print("Enter a letter: ");
            String guessInput = scanner.nextLine();

          

            try{
              isHit = game.applyGuess(guessInput); 
              isAcceptable = true;
            }catch(IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
       }while(!isAcceptable);
       
        return isHit;
        
    }
    
    public void displayProgress(){
        System.out.printf("You have %d tries left to solve %s%n",game.getRemainingTries(), game.getCurrentProgress());
    }
    
    public void displayOutCome(){
        if(game.isWon()){
            System.out.printf("Congrats you won the game with %s tries remaing ",game.getRemainingTries());
           switch(game.getRemainingTries()){
               case 7:
                   System.out.println("You are a MASTER");
                   break;
               case 6:
                   System.out.println("Bravo");
                   break;
               case 5:
                   System.out.println("Well Done");
                   break;
               case 4:
                   System.out.println("Very Good");
                   break;
               case 3:
                   System.out.println("Good");
                   break;
               case 2:
                   System.out.println("Enough");
                   break;
               case 1:
                   System.out.println("Weak");
                   break;
           }
        }else{
            System.out.println("Sorry you lost the game \nHere is the ANSWER: "+game.getAnswer());
        }
    }
    
}
