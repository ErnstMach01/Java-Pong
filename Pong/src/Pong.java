/**
 * Assignment Name: Pong
 * Author: Ernst Mach
 * Date: February 20, 2017
 * Description: Simple single player pong game, the user controls the paddle with the
 * up and down arrow keys. The ball will bounce off all the walls except for the left one,
 * and at the top of the screen is a scoreboard to keep track of the number of points
 * that the user has earned. Each time the ball bounces off the paddle the user gains a
 * point. If the user misses the ball, the game is over and a dialogue box will open
 * showing the user their score and asking if they want to play again.
 */

import javax.swing.JFrame;

public class Pong extends JFrame {
    private static final int HEIGHT = 500, WIDTH = 900;              //Variables used to set the original size of the screen

    public Pong() {
        super("Pong");                                              //Set the title to Pong
        setSize(WIDTH, HEIGHT);                                     //Set the size of the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Frame(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        //Entry point into the program
        new Pong();
    }
}