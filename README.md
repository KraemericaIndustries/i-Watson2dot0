# i-Watson2dot0 (IntelliJ project - WIP)
Revised assistant, to play 'Dad's Infamous Word Guessing Game' - Version 2.0.0  
![i-Watson2dot0](https://user-images.githubusercontent.com/124509173/230769717-d2512875-c4ec-4daf-aea1-52ebf71658a0.png)

# In the beginning...
I've always been a bit of a wordsmith. Growing up, I had a strong vocabulary and spelling skills, and I always enjoyed crafty, eloquent humor and saw (and still see) a strong use of spoken language as a way to convey thoughtfulness, and intellect.

This aptitude stayed with me over the years. Letters and words for whatever reason, just come naturally to me and 'leap off the page' - so much so most of my family members don't dare to play me in 'Scrabble' or any other word based game, as I tend to be deadly at them.

A few years ago, I was introduced to 'Dad's Infamous Word Guessing Game'. It really does not have a name, as apparently he and Mom played it either before I was born, or when I was very young. So - what is this game? It plays a little like 'Wordle' - only I maintain that this 'Wordle' variant is harder.

The basic gameplay is like this: Your opponent will choose a familiar 5 letter word. The word is to be made up of 5 different letters - no letter can appear more than ONCE.  See if you can guess the word! Each time you make a guess, your opponent will respond with a number. The number represents the number of letters in your guess that appear in the word chosen by your opponent.  (Example: If the opponent chooses 'LOSER' and you guess 'POSED' the response would be 3 ('O' makes 1, 'S' makes 2, and 'E' makes 3.) With this knowledge - can you determine your opponents word, more quickly than they can determine a word you have selected which they will try to guess?

I was first introduced to this game a few years ago (right around the time I decided to go 'all in' on the pursuit of a career change to software development. IMMEDIATELY after being introduced to this game, my very first thought was: "I bet I can write a computer program that can play this game better than I can!"

# Watson2dot0 (WIP): A major improvement, and a complete overhaul to the code base...
Where Watson1dot0 is not capable of spelling, or increasing it's vocabulary, Watson2dot0 WILL BE. Why Watson? This is an homage to the IBM AI computer of the same name, that once took on (and beat) a pair of Jeopardy 'Super Champions' - Brad Rutter and Ken Jennings (oh, yeah - I'm also a Jeopardy nut. RIP Alex Trebek)

# Watson2dot0 (WIP): What it can (and can't do)...
Watson2dot0 improves on the shortcomings of Watson1dot0 in the following ways:
 - Watson1dot0 couldn't determine the correct order of letters in order to spell a word.  Watson2dot0 is backed by a database - so it WILL identify words that can be made with the existing letters.  
 - Watson1dot0 had no vocabulary whatsoever.  Watson2dot0 maintains a vocabulary of 'known words'.  In the event a valid word is played that is unknown, it is added to the database to be included the next time the program is run.  
 - Watson2dot0 can't play the game 'all by itself'.  Version 3.0 may remove the human element of entering a guess, and guess words based on it's own logic.  
 - Watson2dot0 can't 'play against itself'.  Future versions may spawn an opponent that may randomly select a word from the database.  A version of Watson that 'plays against itself' should be within grasp, and may come in future releases.  

Why is this years in the making?
 - I have a full time job (in the technology field - but not in software development (yet)
 - I have 2 young kids at home (under the age of 14)
 - I have twice the number of dogs (we LOVE Siberean Huskies)
 - I have a house to run, and a spouse that works shift
 - I am studying for a new career (in software development) at the same time
 
 If you have come this far - I hope you have taken a look at the improvement in the code maturity between versions 1 and 2 and can see an evolution.  I can, and I continue to push evolution as I expand my skill set :)
