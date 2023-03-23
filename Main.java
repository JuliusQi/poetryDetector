import java.util.Scanner;

/*
[Main.java]
A program that takes an input of a poem and outputs what type of poem it is. It also outputs the total number of lines, the total number of syllables as well as the amount of syllables per line
Author: Julius Qi
March 3, 2023
*/

class Main {
  public static void main(String[] args) {
    
    //VARIABLES-------------------------------------------------
    Scanner input = new Scanner(System.in);
    int syllablePerWord = 0;
    int syllablePerLine = 0;
    int syllableTotal = 0;
    int lineCount = 0;
    String currentWord;
    String sentence = input.nextLine();
    String pattern = "";
    //This string helps because vowelList.indexOf(character) ==/!= -1 can determine if a character is a vowel
    String vowelList = "aeiouy";
    boolean prevVowel = false;
    boolean doneSentence = false;
    //----------------------------------------------------------

    //Three nested loops, one that loops once per line, one per word, and one per character
    //While loop that repeats for each line, getting the next line as input each time. Stops when input is "quit"
    while (sentence.compareTo("quit") != 0) {
      prevVowel = false;
      doneSentence = false;
      syllablePerLine = 0;
      lineCount = lineCount + 1;
      
      //Loops for each word and stops once the doneSentence boolean is set to true
      while (doneSentence == false) {
        syllablePerWord = 0;
        prevVowel = false;
        
        //if theres one word in the sentence, the currentWord is set to the singular word in the sentence string and doneSentence is set to true which makes this the last iteration of the loop. Otherwise, a word is split from the rest of the sentence to be examined in the character loop.
        if (sentence.indexOf(" ") == -1) {
          currentWord = sentence;
          doneSentence = true;
        } else {
          currentWord = sentence.substring(0, sentence.indexOf(" "));
          sentence = sentence.substring(sentence.indexOf(" ") + 1);
        }//-----------------------------------------------------

        
        //(Removes any commas, periods and puts the word lowercase)
        if (currentWord.indexOf(",") != -1) {
          currentWord = currentWord.substring(0, (currentWord.indexOf(",")));
        } else if (currentWord.indexOf(".") != -1) {
          currentWord = currentWord.substring(0, (currentWord.indexOf(".")));
        }
        currentWord = currentWord.toLowerCase();
        //------------------------------------------------------
        
        //Loops once per character
        for (int charIndex = 0; charIndex < currentWord.length(); charIndex++) {
          
          //(Checks if letter is a vowel)-----------------------
          if (vowelList.indexOf(currentWord.charAt(charIndex)) != -1) {
            syllablePerWord = syllablePerWord + 1;
        
            //Makes any row of vowels a single syllable---------
            if (prevVowel == true) {
              syllablePerWord = syllablePerWord -1;
            }//-------------------------------------------------


            
            //Used to make sure that the first letter is not the one being looked at (to prevent errors of looking for characters at an index of -1)
            if (charIndex != 0) {
              //If there is 'ua' add 1 syllable. If there is 'ia' that is not a part of 'cian', 'tian' or 'ial' endings, add 1 syllable.
              if (currentWord.charAt(charIndex) == 'a') {
                if (currentWord.charAt(charIndex - 1) == 'u') {
                  syllablePerWord = syllablePerWord + 1;
                } else if (currentWord.charAt(charIndex - 1) == 'i') {
                  if (charIndex + 2 != currentWord.length()) {
                    syllablePerWord = syllablePerWord + 1;
                    } else if (currentWord.charAt(charIndex + 1) != 'l') {
                      if (charIndex > 1) {
                        if ((currentWord.substring((charIndex - 2), (charIndex + 2)).compareTo("cian") != 0) && (currentWord.substring((charIndex - 2), (charIndex + 2)).compareTo("tian") != 0)) {
                          syllablePerWord = syllablePerWord + 1;
                        }
                      } else {
                        syllablePerWord = syllablePerWord + 1;
                      }
                    }
                  }
                //If there is 'io' that is not a part of 'ion', 'vior', 'ciou' or 'tiou'(cases where 'io' is just one syllable) add 1 syllable
            } else if ((currentWord.charAt(charIndex) == 'o') && (currentWord.charAt(charIndex - 1) == 'i')) {
              if (charIndex == currentWord.length() - 1) {
              syllablePerWord = syllablePerWord + 1;
              } else if (currentWord.charAt(charIndex + 1) != 'n') {
                if (charIndex < 2) {
                  syllablePerWord = syllablePerWord + 1;
                } else if ((currentWord.substring((charIndex - 2), (charIndex + 2)).compareTo("tiou") != 0) && (currentWord.substring((charIndex - 2), (charIndex + 2)).compareTo("ciou") != 0) && (currentWord.substring((charIndex - 2), (charIndex + 2)).compareTo("vior") != 0)) {
                  syllablePerWord = syllablePerWord + 1;
                }
              }
            }
              //Check for 'iu' --> add syllable
              if (currentWord.substring((charIndex - 1), (charIndex + 1)).equals("iu")) {
                syllablePerWord = syllablePerWord + 1;
              }
              //Check for 'eo' --> add syllable
              if (currentWord.substring((charIndex - 1), (charIndex + 1)).equals("eo")) {
                syllablePerWord = syllablePerWord + 1;
              }
              //Check for 'uu' in cases like continuum --> add syllable
              if (currentWord.substring((charIndex - 1), (charIndex + 1)).equals("uu")) {
                syllablePerWord = syllablePerWord + 1;
              }
            }

            
            //(Stores information about whether previous character was a vowel)
            if (currentWord.charAt(charIndex) != 'y') {
              prevVowel = true;
            } else {
              prevVowel = false;
            }//--------------------------------------------------------

            //END of if vowel statement --> else (not vowel)
          } else {
            
            //Checks for "iet" cases (two syllables)
            if (charIndex > 2) {
              if (currentWord.substring((charIndex - 2), (charIndex + 1)).equals("iet")) {
                syllablePerWord = syllablePerWord + 1;
              }
            }

            
            //Checks for "would've" and "couldn't" cases (extra syllables)
            if (charIndex != 0) {
              if ((currentWord.substring(charIndex, (charIndex + 1)).equals("'")) && (vowelList.indexOf(currentWord.charAt(charIndex - 1)) == -1)) {
                syllablePerWord = syllablePerWord + 1;
              }
            prevVowel = false;
          }}

          
          //case where x becomes syllables. Ex: "x-ray" (extra syllable)
          if (currentWord.length() > 1) {
            if (currentWord.charAt(charIndex) == 'x') {
              if ((prevVowel == false) && (vowelList.indexOf(currentWord.charAt(charIndex + 1)) == -1)) {
                syllablePerWord = syllablePerWord + 1;
              }
            }
          }
        }
        
        //(OCCURS ONCE PER WORD)--------------------------------
        //This part mainly deals with endings, since these rules do not apply to words are 3 or less letters this if statement is used, it also helps prevent erros with charAt and searching out of range
        if (currentWord.length() > 3) {
          
          //Whole chunk is for checking for silent 'e', 'es' & 'ed'. takes into consideration irregular 'ed', 'ue' and 'ues' cases
          //Logic: If the ending is either 'e' or 'es'
          if (((currentWord.charAt(currentWord.length() - 1) == 'e') || (currentWord.substring((currentWord.length() - 2), (currentWord.length())).equals("es")))) { 

            //Trying to see if there will be a silent 'e'. No silent e if there is an 'l' or a vowel ahead of the 'e' the exception being when the 'e' is preceded by a vowel + 'u'
            if (((vowelList.indexOf(currentWord.charAt(currentWord.lastIndexOf('e') - 1)) == -1) && (currentWord.charAt(currentWord.lastIndexOf('e') - 1) != 'l')) || ((currentWord.charAt(currentWord.lastIndexOf('e') - 1) == 'u')) && (vowelList.indexOf(currentWord.charAt(currentWord.lastIndexOf('e') - 2)) != -1)) {
              syllablePerWord = syllablePerWord - 1; 
            }
            //Looking for silent 'ed' endings. The exceptions/when not silent is when the 'ed' is preceded 't', 'd', 'tl' or any vowel
          } else if ((currentWord.substring((currentWord.length() - 2), (currentWord.length()))).equals("ed") && (currentWord.charAt(currentWord.length() - 3) != 'd') && (currentWord.charAt(currentWord.length() - 3) != 't') && (currentWord.substring((currentWord.length() - 4), (currentWord.length() - 2)).compareTo("tl") != 0) && (vowelList.indexOf(currentWord.charAt(currentWord.lastIndexOf('e') - 1)) == -1)) {
            syllablePerWord = syllablePerWord - 1;
            
          //Adds a syllable for 'thm' endings
          } else if (currentWord.substring((currentWord.length() - 3), (currentWord.length())).equals("thm")) {
            syllablePerWord = syllablePerWord + 1;
          }

          //If word is less than four letters it cannot have more than 1 syllable
        } else if (syllablePerWord > 1) {
          syllablePerWord = 1;
        }
        
        //(Checks for "eate" endings)---------------------------
        if (currentWord.length() > 3) {
          if (currentWord.substring(currentWord.length() - 4).equals("eate")) {
          syllablePerWord = syllablePerWord + 1;
          }
        }//-----------------------------------------------------

        
        //HARD CODED WORDS--------------------------------------
        if (currentWord.equals("wednesday")) {
          syllablePerWord = 2;
        }
        if (currentWord.equals("lonesome")) {
          syllablePerWord = 2;
        }
        if (currentWord.equals("colonel")) {
          syllablePerWord = 2;
        }
        if (currentWord.equals("cation")) {
          syllablePerWord = 3;
        }
        if (currentWord.equals("anion")) {
          syllablePerWord = 3;
        }//------------------------------------------------------

        //Saves syllablesPerWord to syllablesPerLine
        syllablePerLine = syllablePerLine + syllablePerWord;
      }//-------------------------------------------------------

      
      //(OCCURS ONCE PER LINE)----------------------------------
      //(Saves amount of syllables in current line to string)---
      pattern = pattern + Integer.toString(syllablePerLine) + " ";
      syllableTotal = syllableTotal + syllablePerLine;
      //--------------------------------------------------------
      sentence = input.nextLine();
    }//---------------------------------------------------------

    
    //Basic output----------------------------------------------
    System.out.println(lineCount + " lines");
    System.out.println(syllableTotal + " syllables");
    System.out.println(pattern);
    //----------------------------------------------------------

    
    //Poem type-------------------------------------------------
    if (pattern.equals("5 7 5 ")) {
      System.out.println("Haiku");
    } else if (pattern.equals("5 7 5 7 7 ")) {
      System.out.println("Tanka");
    } else if (pattern.equals("2 4 6 8 2 ")) {
      System.out.println("Cinquain");
    } else if (pattern.equals("9 8 7 6 5 4 3 2 1 ")) {
      System.out.println("Nonet");
      //Checks whether the poem consists of three lines, has 42-48 total syllables (inclusive) & whether each line as 14-16 syllables (inclusive)
    } else if ((lineCount == 3) && (syllableTotal >= 42) && (syllableTotal <= 48) && (Integer.parseInt(pattern.substring(0, 2)) >= 14) && (Integer.parseInt(pattern.substring(0, 2)) <= 16) && (Integer.parseInt(pattern.substring(3, 5)) >= 14) && (Integer.parseInt(pattern.substring(3, 5)) <= 16)  && (Integer.parseInt(pattern.substring(6, 8)) >= 14) && (Integer.parseInt(pattern.substring(6, 8)) <= 16)) {
      System.out.println("Sijo");
    //-----------------------------------------------------------

      
    } else {
      System.out.println("Unknown");
    }
    //-----------------------------------------------------------
    
    input.close();
  }
}