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
public class Game {
    public static final int MAX_MISSES = 7;
    private String answer;  // this is the answer for the game that should given the first time we create the object of the game
    private String hits;
    private String misses;
    
    public Game(String answer){
        this.answer = answer;
        hits = "";
        misses = "";
    }
    
    private char normalizeGuess(char letter){
        if(!Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
         if(misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1){
            throw new IllegalArgumentException(letter+" has already been guessed");
        }
         return letter;
    }
    
    public boolean applyGuess(String letters){
        if(letters.length() == 0){
            throw new IllegalArgumentException("No letter Fount");
        }
        
        return applyGuess(letters.charAt(0));
        
    }
    
    public boolean applyGuess(char letter){
        letter = normalizeGuess(letter);
        boolean  isHit = answer.indexOf(letter)  != -1;
        if(isHit){
            hits += letter;
        } else {
            misses += letter;
        }
        return isHit;
    }
    
    public String getCurrentProgress(){
        String progress = "";
        for(char letter : answer.toCharArray()){
            char display = '-';
            if(hits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
            
        }
        
        return progress;
    }
    
    public boolean isWon(){
        return getCurrentProgress().indexOf("-") == -1;
    }
    
    public String getAnswer(){
        return answer;
    }
    
    public void setAnswer(String answer){
        this.answer = answer;
    }
    
    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }
    
}
