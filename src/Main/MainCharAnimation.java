package Main;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class MainCharAnimation {

	private SpriteSheet character;
	private Animation charAnimation;
	public int midX, midY;
	public int bunX = 4;
	public int bunY = 4;
	public int frameX, frameY;

	public MainCharAnimation(SpriteSheet images, int X_RES, int Y_RES, int frameX, int frameY) {
		this.frameX = frameX;
		this.frameY = frameY;
		this.character = images;
		
		midX = (X_RES - frameX)/2;
		midY = (Y_RES - frameY)/2;
		charAnimation = new Animation(character,100);
	}

	public void init(GameContainer gc) throws SlickException {
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		charAnimation.update(delta);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		charAnimation.draw(midX, midY);
	}
}
