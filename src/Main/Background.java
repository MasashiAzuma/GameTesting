package Main;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class Background {

	private MainCharAnimation characterAnimation;
	private MainChar character;
	private ArrayList<Image> tileSet;
	
	public int dir = 3;

	Boolean moving = false;

	private int x_fin, y_fin;
	private int x, y;

	private ArrayList<Integer> canCollide;

	public Background(SpriteSheet tiles, MainCharAnimation character) {
		this.characterAnimation = character;

		x = character.midX - (character.bunX * character.frameX);
		y = character.midY - (character.bunY * character.frameY);
		x_fin = x;
		y_fin = y;

		tileSet = new ArrayList<Image>();

		for (int i = 0; i < tiles.getHorizontalCount(); i++) {
			for (int j = 0; j < tiles.getVerticalCount(); j++) {
				tileSet.add(tiles.getSubImage(i, j));
			}
		}

		canCollide = new ArrayList<Integer>();
		canCollide.add(5);
		canCollide.add(6);
	}
	
	public Background(SpriteSheet tiles, MainChar character) {
		this.character = character;

		x = character.midX - (character.bunX * character.frameX);
		y = character.midY - (character.bunY * character.frameY);
		x_fin = x;
		y_fin = y;

		tileSet = new ArrayList<Image>();

		for (int i = 0; i < tiles.getHorizontalCount(); i++) {
			for (int j = 0; j < tiles.getVerticalCount(); j++) {
				tileSet.add(tiles.getSubImage(i, j));
			}
		}

		canCollide = new ArrayList<Integer>();
		canCollide.add(5);
		canCollide.add(6);
	}

	public void addTexture(Image target) {
		tileSet.add(target);
	}

	public boolean collision(int[][] map, ArrayList<Integer> collide, int x, int y) {
		for (int i = 0; i < collide.size(); i++) {
			if (map[x][y] == collide.get(i))
				return true;
		}
		return false;
	}
	
	public int getDir()
	{
		return dir;
	}

	public boolean getMoving()
	{
		return moving;
	}
	
	public void init(GameContainer gc) throws SlickException {
	}

	public void updateAnimation(GameContainer gc, int delta, int[][] map, StateBasedGame sbg) throws SlickException {
		Input input = gc.getInput();

		if (moving == false) {
			if (map[characterAnimation.bunX][characterAnimation.bunY] == 6) {
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			} else if (input.isKeyDown(Input.KEY_UP)) {
				dir = 1;
				if (this.collision(map, canCollide, characterAnimation.bunX, characterAnimation.bunY - 1)) {
					y_fin = y + 100;
					moving = true;
					characterAnimation.bunY -= 1;
					
				}
			} else if (input.isKeyDown(Input.KEY_DOWN)) {
				dir = 3;
				if (this.collision(map, canCollide, characterAnimation.bunX, characterAnimation.bunY + 1)) {
					y_fin = y - 100;
					moving = true;
					characterAnimation.bunY += 1;
					
				}
			} else if (input.isKeyDown(Input.KEY_LEFT)) {
				dir = 4;
				if (this.collision(map, canCollide, characterAnimation.bunX - 1, characterAnimation.bunY)) {
					x_fin = x + 100;
					moving = true;
					characterAnimation.bunX -= 1;
					
				}
			} else if (input.isKeyDown(Input.KEY_RIGHT)) {
				dir = 2;
				if (this.collision(map, canCollide, characterAnimation.bunX + 1, characterAnimation.bunY)) {
					x_fin = x - 100;
					moving = true;
					characterAnimation.bunX += 1;
					
				}
			}
		} else if (moving == true) {
			if (y_fin != y || x_fin != x) {
				y += Integer.signum(y_fin - y) * 10;
				x += Integer.signum(x_fin - x) * 10;
			} else {
				moving = false;
			}
		}
	}
	
	public void update(GameContainer gc, int delta, int[][] map, StateBasedGame sbg) throws SlickException {
		Input input = gc.getInput();

		if (moving == false) {
			if (map[character.bunX][character.bunY] == 6) {
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			} else if (input.isKeyDown(Input.KEY_UP)) {
				if (this.collision(map, canCollide, character.bunX, character.bunY - 1)) {
					y_fin = y + 100;
					moving = true;
					character.bunY -= 1;
					dir = 1;
				}
			} else if (input.isKeyDown(Input.KEY_DOWN)) {
				if (this.collision(map, canCollide, character.bunX, character.bunY + 1)) {
					y_fin = y - 100;
					moving = true;
					character.bunY += 1;
					dir = 3;
				}
			} else if (input.isKeyDown(Input.KEY_LEFT)) {
				if (this.collision(map, canCollide, character.bunX - 1, character.bunY )) {
					x_fin = x + 100;
					moving = true;
					character.bunX -= 1;
					dir = 4;
				}
			} else if (input.isKeyDown(Input.KEY_RIGHT)) {
				if (this.collision(map, canCollide, character.bunX + 1, character.bunY)) {
					x_fin = x - 100;
					moving = true;
					character.bunX += 1;
					dir = 2;
				}
			}
		} else if (moving == true) {
			if (y_fin != y || x_fin != x) {
				y += Integer.signum(y_fin - y) * 10;
				x += Integer.signum(x_fin - x) * 10;
			} else {
				moving = false;
			}
		}
	}

	public void render(GameContainer gc, Graphics g, int[][] map) throws SlickException {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				tileSet.get(map[i][j]).draw(x + (i * 100), y + (j * 100));
			}
		}
	}
}
