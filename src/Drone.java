import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Drone.java
 *
 * @author Lovejit Kharod
 * Last edited: October 31st, 2018
 * Purpose: attributes and methods of the drone, which will be controlled by the user.
 * works in conjunction with the timer class in order to update the position of the drone.
 */

public class Drone extends JLabel {
	private int w, h, x, y;
	int dx, dy;
	private ArrayList<Missile> missiles;

	/**
	 * Drone()
	 * creates a new arraylist to store the missiles, creates an image icon, inits w,h,x and y
	 */
	public Drone() {
		missiles = new ArrayList<>();
		x = 50;
		y = 90;
		//resize the image and create the icon
		ImageIcon ii = new ImageIcon(new ImageIcon(getClass().getResource("resources/DroneSprite.png")).getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH));
		w = ii.getImage().getWidth(null);
		h = ii.getImage().getHeight(null);
		//this will draw the image as the icon for this jlabel
		this.setIcon(ii);
	}

	/**
	 * move()
	 * changes the x and y position of the drone
	 */
	void move() {
		//x += dx;
		y += dy;
		for (Missile m : missiles)
			m.move();
	}

	/**
	 * fire()
	 * creates a new missile and adds it to the list.
	 */
	public void fire() {
		missiles.add(new Missile(x, y));
	}

	/**
	 * keyPressed()
	 *
	 * @param e as long as the user is holding down a key, it will continue to change the
	 *          x or y position in the right direction.
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: //if the user presses the up arrow
				dy = -2;
			case KeyEvent.VK_DOWN: //if the user presses the down arrow
				dy = 2;
		}
	}

	/**
	 * keyReleased()
	 *
	 * @param e once the key is released, it will stop moving the drone.
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				dy = 0;
			case KeyEvent.VK_DOWN:
				dy = 0;
		}
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}
}
