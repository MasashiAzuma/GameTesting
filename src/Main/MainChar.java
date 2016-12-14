package Main;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class MainChar {

	private SpriteSheet character;
	public int midX, midY;
	public int bunX = 4;
	public int bunY = 4;
	public int frameX, frameY;
	private int dir = 3;

	public MainChar(SpriteSheet images, int X_RES, int Y_RES, int frameX, int frameY) {
		this.frameX = frameX;
		this.frameY = frameY;
		this.character = images;

		midX = (X_RES - frameX) / 2;
		midY = (Y_RES - frameY) / 2;
	}

	public void init(GameContainer gc) throws SlickException {
	}

	public void update(GameContainer gc, int delta, boolean moving) throws SlickException {
		/*Input input = gc.getInput();
		if (moving == false) {
			if (input.isKeyDown(Input.KEY_UP)) {
				dir = 1;
			} else if (input.isKeyDown(Input.KEY_RIGHT)) {
				dir = 2;
			} else if (input.isKeyDown(Input.KEY_DOWN)) {
				dir = 3;
			} else if (input.isKeyDown(Input.KEY_LEFT)) {
				dir = 4;
			}
		}*/

	}

	public void render(GameContainer gc, Graphics g, int dir) throws SlickException {
		if (dir == 1) {
			character.getSubImage(1, 0).draw(midX, midY);
		} else if (dir == 2) {
			character.getSubImage(3, 0).draw(midX, midY);
		} else if (dir == 3) {
			character.getSubImage(0, 0).draw(midX, midY);
		} else if (dir == 4) {
			character.getSubImage(2, 0).draw(midX, midY);
		}
	}
}
