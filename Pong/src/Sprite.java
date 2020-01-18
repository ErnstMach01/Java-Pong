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

public class Sprite {
    private int x, y, xa, ya, width, height;                //Initialize all the variables that all the sprites will use
    private boolean up, down;

    public Sprite(int x_, int y_, int xa_, int ya_, int width_, int height_, boolean up_, boolean down_) {
        x = x_;                                             //X position of the sprite
        y = y_;                                             //Y position of the sprite
        xa = xa_;                                           //Acceleration of the sprite in the X axis
        ya = ya_;                                           //Acceleration of the sprite in the Y axis
        width = width_;                                     //Width of the sprite
        height = height_;                                   //Height of the sprite
        up = up_;                                           //Boolean to see if sprite is moving up
        down = down_;                                       //Boolean to see if sprite is moving down
    }

    public int X() {
        return x;
    }                             //Get the current X position of the sprite

    public int Y() {
        return y;
    }                             //Get the current Y position of the sprite

    public int XA() {
        return xa;
    }                           //Get the current X acceleration of the sprite

    public int YA() {
        return ya;
    }                           //Get the current Y acceleration of the sprite

    public int Height() {
        return height;
    }                   //Get the height of the sprite

    public int Width() {
        return width;
    }                     //Get the width of the sprite

    public boolean UP() {
        return up;
    }                       //Get if the sprite is moving up or not

    public boolean DOWN() {
        return down;
    }                   //Get if the sprite is moving down or not

    public void setX(int x_) {
        x = x_;
    }                     //Set the X position of the sprite

    public void setY(int y_) {
        y = y_;
    }                     //Set the Y position of the sprite

    public void setXA(int xa_) {
        xa = xa_;
    }                 //Set the X acceleration of the sprite

    public void setYA(int ya_) {
        ya = ya_;
    }                 //Set the Y acceleration of the sprite

    public void setUP(boolean up_) {
        up = up_;
    }             //Can change the boolean to show if the sprite is moving up

    public void setDOWN(boolean down_) {
        down = down_;
    }                 //Can change the boolean to show if the sprite is moving down
}