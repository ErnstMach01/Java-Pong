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

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Paddle extends Sprite {
    private final Pong game;

    public Paddle(Pong game, int x, int y) {
        super(x, y, 1, 1, 10, 60, false, false);
        this.game = game;
    }

    public void KeyPressed(KeyEvent e) {                                          //Checks if a key is pressed
        int keyCode = e.getKeyCode();                                             //Stores the pressed key as an integer variable

        if (keyCode == KeyEvent.VK_UP){                                           //If the key is the up key
            setUP(true);                                                          //Paddle is being moved up
        }

        if (keyCode == KeyEvent.VK_DOWN) {                                        //If the key is the down key
            setDOWN(true);                                                        //Paddle is being moved down
        }
    }

    public void KeyReleased(KeyEvent e) {                                         //Checks if a key is released
        int keyCode = e.getKeyCode();                                             //Stores the released key as an integer variable

        if (keyCode == KeyEvent.VK_UP) {                                          //If the key is the up key
            setUP(false);                                                         //Paddle has stopped being moved up
        }

        if (keyCode == KeyEvent.VK_DOWN) {                                        //If the key is the down key
            setDOWN(false);                                                       //Paddle has stopped being moved down
        }
    }

    public void update() {                                                        //Checks if the paddle is within the frame
        if (Y() + YA() >= 0 && UP() == true) {                                    //If paddle is not at the top of the frame
            setY(Y() - YA());                                                     //Allow the paddle to move up
        }

        if(Y() + YA() < game.getHeight()- 35 - Height() && DOWN() == true) {      //If the paddle is not at the bottom of the frame
            setY(Y() + YA());                                                     //Allow the paddle to move down
        }
    }

    public void paint(Graphics g) {
        g.fillRect(X(), Y(), Width(), Height());
    }    //Draws the rectangle for the paddle
}
