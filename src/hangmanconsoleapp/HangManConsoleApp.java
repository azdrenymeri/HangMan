/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanconsoleapp;

/**
 *
 * @author Azdren
 */
public class HangManConsoleApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game game = new Game("hello");
        
        Prompter prompter = new Prompter(game);
        
        while(game.getRemainingTries()>0 && !game.isWon()){
        
        prompter.displayProgress();
        prompter.promptForGuess();
        }
        prompter.displayOutCome();
      
        
        
    }
    
}
