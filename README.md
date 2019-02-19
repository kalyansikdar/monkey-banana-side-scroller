This project was part of my Software Design Pattern course under Dr. David Kung in The University of Texas at Arlington.

Project Description:

The game is described as follows. A monkey enters into a wonderland, which is a square yard fully covered with grass. 
This can be visualized as a big green square, conceptually divided into N x N small squares. Initially, the
monkey and a single banana are placed in the yard at randomly determined, two separate positions. When the
game is started, the player can move the monkey from one square to an adjacent square using the Up, Down,
Left and Right keys of the keyboard. The monkey moves to the adjacent square accordingly. When the monkey
is in the square containing the banana, it grasps it and consumes it immediately. At this time, another banana
appears at another randomly determined position, and the game repeats as described above.

The game has the following rules:

1. The player can move the monkey horizontally or vertically. This is controlled by the Up, Down, Left and
Right keys of the keyboard. These keys can be pressed or clicked to advance the monkey continuously or
one step at a time. The monkey moves from one small square to another. For this homework, set N=50.
2. The monkey needs time to move from one small square to another, this is controlled by using a timer
(e.g., the java.util.Timer API).
3. The monkey must get and eat the banana in a preset period of time, measured from the occurrence of
the banana. If this is accomplished, the player gets 10 points. If the monkey does not get the banana
within this time period, the banana is placed at another randomly determined position, and the time is
recounted .
4. The game finishes with:
(a) success, if the monkey eats K bananas within a given time period, or
(b) failure, otherwise

In either of above case, the total score is displayed, and optionally a sound is played and/or an image is
displayed.
