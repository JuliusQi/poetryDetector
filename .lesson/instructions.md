**Important - See the Google Classroom for UpToDate assignment details**

# Introduction
  
As a CS student it's sometimes difficult to understand why poetry exists. It seems that the CS rules of being clear and concise do not apply and it is difficult to quantify that special something that makes a good poem.

Today you will be attempting to connect the worlds of cs and poetry by building a computer program that can recognize various poetic forms. Your program will analyze the structure of a text by examining the number of lines and syllables that occur to predict the type of poem that has been input.

The following list of poetic forms will be identified by your program:

  
**Haiku**<BR>
A haiku is a three line poem of Japanese origin. Traditionally, it follows a 5-7-5 syllable format, but this is not compulsory when writing in English as it is not a rhythmic language.


**Tanka**<BR>
The ultra-brief Japanese tanka is traditionally presented as a single unbroken sentence containing 31 speech sounds. However, most tanka poems that are written in English today are broken into five poetic lines with a certain number of syllables in each line. The basic structure of a tanka poem is 5 – 7 – 5 – 7 – 7
 

**Sijo**<BR>
A three-line poem that is believed to have first appeared in fourteenth-century Korea. Sijo poems follow a structure familiar to fans of Japanese haiku and tanka: There are three lines in total, each with about 14–16 syllables, for a total syllable count of 42–48.

  

**Cinquain**<BR>
In the early 1900s, an American poet named Adelaide Crapsey, inspired by Japanese haiku and tanka verse, created a simple five-line poetic form. The number of syllables increases by two with each line before abruptly decreasing: 2-4-6-8-2.

  
**Nonet**<BR>
A nonet is a poem of nine lines with each line having one syllable less. Line 9 has 1 syllables; line 2 has 8 syllables; line 3 has 7 syllables, etc.

  

*Disclaimer - I am a programmer and don’t know anything about poetry. Some of these forms have variations that might not strictly follow these rules. This is simply a collection of a few forms with a definition based on structure. For more info about poems please visit the English department.

  

## How will it work?

Your program will accept a poem via input from the keyboard. The user will enter one line at a time and type in ‘quit’ as the last line to mark the end of the poem. Your program will need to use two characteristics to determine if the input qualifies as one of the poetic forms listed above:
  
1. The number of lines
2. The syllables per line & total syllables

The program should output the type of poem which has been identified or if they form in unknown. It is recommended you copy & paste the poem examples from the text files directly into the java programs input to save timer rather than typing out each poem every time.

Determining the number of lines is not too difficult, but the syllables become a challenge. People typically sound out a word to determine the number of syllables it contains. We cannot do that so we are going to try and determine the number of syllables using the ‘written’ technique.

Essentially, you keep a counter for the number of syllables in a word. You add one to it for every vowel that exists in the word. Then you look for patterns to determine which vowels should not be counted as a syllable.

For example, the word “feed” has two vowels, but often when you have pairs of vowels (“ee”, “ea”, “oo”, etc) it only counts as one syllable so you need to subtract one from the counter. This is the process you should follow: Count vowels and then remove the count for vowels that don’t produce a syllable.

You should start with those rules and use the additional documentation to include other rules to make your program more accurate.

Here is a [Syllable Tool](https://syllablecounter.net/count)  you might find useful that uses a similar predictive algorithm. _It is not the perfect example and may fail on certain test cases!_


You have been provided a number of resources to help you with this project. Also, some sample poems have been provided that you should use to test your program. I encourage you to make your own examples to test out your program's effectiveness. Be careful searching for examples on the internet as many of these poetry forms are considered loose guidelines and many variations of these forms exist. 

I will include my own (secret) test cases when evaluating your program
  
## Implementation

The program you are making can be developed in stages to help manage the task at hand. You should build your program according to the order below and fully test your program once you meet each milestone
  
**Milestone #1 (level 1)** <BR>
Your program can determine the number of syllables in a single word

**Milestone #2 (level 2)** <BR>
Your program can determine the number of syllables in a full sentence

**Milestone #3 (level 3)** <BR>
Your program can accept multiple sentences, output the number of lines, and how many syllables occur on each line

**Milestone #4 (level 4)** <BR>
Your program can save the number of syllables that occurred on each line and output the pattern and number of syllables found.
(example: Line Count: 5 Total Syllables:12 Pattern: 2 3 2 5)

 **Milestone #5 (level 4+)** <BR>
Your program can identify the type of poetic form that the input matches or if the form is unknown.

 
### Important Information/Tips

The English language has many exceptions - this is predictive software we are making. The included examples have been chosen because they do not have special cases that should mess with your program. Your program should be able to make decent predictions for other poems other than the ones provided. 

Once again, you are restricted to using concepts and methods covered in the class thus far. This means that you will not be able to use methods, arrays, and other useful Java constructs. As a result your program will be fairly long with a number of nested loops. To be successful you should pay close attention to the organization of your program and strictly follow the development process outlined above. Think carefully before you code to prevent a program that is made up of a huge collection of hard-coded elements.

You might find the method _parseInt_ useful for this program. It is included in the Integer class (does not need to be imported) and works as follows to convert a String into an int:

_int x =Integer.parseInt("9");_ <BR>

You may use this method for this program if you wish.

Although it is discouraged to use _break_ in a program, you are permitted to use it **one** time in your program.

You will need to be creative with your use of Strings to complete milestones 4 & 5. Follow the order of the milestones!

Your program should be built in a way that one could add new code for new poetic forms without having to modify existing code that identifies forms. (To be successful you should not hard code every possibility, rather look for rules and patterns)

_This is a live document and additional tips may be added at a later date._