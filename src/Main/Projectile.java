package Main;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Projectile {

	private Animation projectile;
	
	public Projectile(SpriteSheet images){
		projectile = new Animation(images, 100);
	}
	
	public Projectile() throws SlickException{
		Image projectileIMG = new Image("images/fireball.png");
		SpriteSheet sprite = new SpriteSheet(projectileIMG, 100, 100);
		projectile = new Animation(sprite, 100);
	}
	
	public void update(GameContainer gc, StateBasedGame arg1, int delta) throws SlickException {
		projectile.update(delta);
		
	}
	public void render(GameContainer gc, Graphics g, int dir, Position pos, MainChar character) throws SlickException {
		projectile.draw(50, 50);
	}
	
}
