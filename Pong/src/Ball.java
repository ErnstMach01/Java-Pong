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

public class Ball extends Sprite {

    public Ball(int x, int y) {
        super(x, y, 1, 1, 15, 15, false, false);
    }

    public void update() {                                                        //Constantly change the position of the ball on the screen
        setX(X() + XA());
        setY(Y() + YA());
    }

    public void paint(Graphics g) {
        g.fillOval(X(), Y(), Width(), Height());
    }   //Draw the circle for the ball
}