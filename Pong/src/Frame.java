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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel {
    private Paddle paddle;                                      //Paddle
    private Ball ball;                                          //Ball
    private int score = 0;                                      //Variable to hold the score
    private Image dbImage;                                      //Variable to print old image
    private Graphics dbg;                                       //Variable to hold new image

    public Frame(Pong game) {
        paddle = new Paddle(game, 15, game.getHeight() / 2);    //Created the paddle
        ball = new Ball(200, 200);                              //Created the ball

        Timer timer = new Timer(5, new Time());                 //Timer used to control framerate
        timer.start();

        addKeyListener(new KeyHandler());
        setFocusable(true);
    }

    private class Time implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }       //Update screen when an action occurs
    }

    //Image buffering to avoid flickering
    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintC(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintC(Graphics g) {
        super.paint(g);                                         //Draw the frame
        paddle.paint(g);                                        //Draw the paddle
        ball.paint(g);                                          //Draw the ball
        g.setFont(new Font("sansserif", Font.PLAIN, 30));       //Set the properties of the text
        g.drawString("" + score, this.getWidth() / 2, 50);      //Draw the score
    }

    private void BallSideCollision() {
        if (ball.X() > getWidth() - ball.Width() - (getInsets().left + getInsets().right)) {                                            //Checks if the ball touches the right side of the screen
            ball.setXA(-ball.XA());                                                                                                     //Changes the horizontal direction of the ball's movement
        }
        else if (ball.Y() < 0 || ball.Y() > getHeight() - ball.Height()) {                                                              //Checks if the ball touches the top or bottom of the screen
            ball.setYA(-ball.YA());                                                                                                     //Changes the vertical direction of the ball's movement
        } else if (ball.X() < 0) {                                                                                                      //Checks if the ball touches the left side of the screen
            JOptionPane.showMessageDialog(null, "Game Over. You scored " + score + ".", "Pong", JOptionPane.INFORMATION_MESSAGE);       //Shows game over dialog
            int choice = JOptionPane.showConfirmDialog(null, "Play Again?", "Pong", JOptionPane.YES_NO_OPTION);                         //Ask's user if they want to play again
                if (choice == JOptionPane.YES_OPTION) {                                                                                 //If user says yes
                    ball.setY(this.getHeight() / 2);                                                                                    //Resets the ball back to the center of the screen
                    ball.setX(this.getWidth() / 2);
                    paddle.setY(this.getHeight() / 2);                                                                                  //Resets the paddle back to the middle
                    paddle.setUP(false);                                                                                                //Sets the paddle movement to false
                    paddle.setDOWN(false);
                    score = 0;                                                                                                          //Reset the score to 0
            } else {                                                                                                                    //If user says no
                System.exit(0);                                                                                                         //Game exits
            }
        }
    }

    private void PaddleCollision() {
        if (ball.X() == paddle.X() + paddle.Width() && ball.Y() >= paddle.Y() && ball.Y() <= paddle.Y() + paddle.Height()) {            //Checks if the ball collides with the paddle
            ball.setXA(-ball.XA());                                                                                                     //Changes the horizontal movement of the ball to the opposite direction
            score++;                                                                                                                    //Increases the score
        }
    }

    //All methods go here
    private void update() {
        paddle.update();
        ball.update();
        BallSideCollision();
        PaddleCollision();
        repaint();
    }

    private class KeyHandler implements KeyListener {                       //Class to deal with all keyboard inputs
        @Override
        public void keyPressed(KeyEvent e) {
            paddle.KeyPressed(e);
        }        //Checks if key is pressed

        @Override
        public void keyReleased(KeyEvent e) {
            paddle.KeyReleased(e);
        }      //Checks if key is released

        @Override
        public void keyTyped(KeyEvent e) {
            //Not putting anything into this method
        }
    }
}