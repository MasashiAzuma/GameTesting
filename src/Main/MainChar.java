package Main;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class MainChar {

	private SpriteSheet character;
	private Animation animatedChar;
	public int midX, midY;
	public int bunX = 4;
	public int bunY = 4;
	public int frameX, frameY;
	
	private ArrayList<Projectile> projectile;

	public MainChar(SpriteSheet images, int X_RES, int Y_RES, int frameX, int frameY) {
		this.frameX = frameX;
		this.frameY = frameY;
		
		animatedChar = new Animation(images, 100);
		
		projectile = new ArrayList<Projectile>();

		midX = (X_RES - frameX) / 2;
		midY = (Y_RES - frameY) / 2;
	}
	
	public MainChar (Image image, int X_RES, int Y_RES, int frameX, int frameY)
	{
		this.frameX = frameX;
		this.frameY = frameY;
		
		character = new SpriteSheet(image, frameX, frameY);
		
		projectile = new ArrayList<Projectile>();
		
		midX = (X_RES - frameX) / 2;
		midY = (Y_RES - frameY) / 2;
	}

	public void update(GameContainer gc, StateBasedGame sbg)throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyPressed(input.KEY_SPACE))
		{
			projectile.add(new Projectile());
		}
	}
	
	public void render(GameContainer gc, Graphics g, int dir, Position pos) throws SlickException {
		if (dir == 1) {
			character.getSubImage(1, 0).draw(midX, midY);
		} else if (dir == 2) {
			character.getSubImage(3, 0).draw(midX, midY);
		} else if (dir == 3) {
			character.getSubImage(0, 0).draw(midX, midY);
		} else if (dir == 4) {
			character.getSubImage(2, 0).draw(midX, midY);
		}
		
		for (int i = 0; i < projectile.size(); i++)
		{
			projectile.get(i).render(gc, g, dir, pos, this);
		}
		
	}
}
