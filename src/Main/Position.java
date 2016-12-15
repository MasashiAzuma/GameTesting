package Main;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Position {

	public int bunX = 4;
	public int bunY = 4;
	private int[][] map;
	private int dir = 3;
	private ArrayList<Integer> canCollide;
	private Boolean moving = false;
	public int x_fin, y_fin;
	public int x, y;

	public Position(MainChar character, int[][] map) {
		x = character.midX - (character.bunX * character.frameX);
		y = character.midY - (character.bunY * character.frameY);
		x_fin = x;
		y_fin = y;

		canCollide = new ArrayList<Integer>();
		canCollide.add(5);
		canCollide.add(6);

		this.map = map;
	}

	public boolean collision(int[][] map, ArrayList<Integer> collide, int x,
			int y) {
		for (int i = 0; i < collide.size(); i++) {
			if (map[x][y] == collide.get(i))
				return true;
		}
		return false;
	}

	public boolean collision(int[][] map, int collide, int x, int y) {
		if (map[x][y] == collide)
			return true;

		return false;
	}

	public void update(GameContainer gc, StateBasedGame sbg, Background bg, MainChar mage) throws SlickException {
		Input input = gc.getInput();

		mage.update(gc, sbg);
		
		if (moving == false) {
			if (this.collision(map, 6, bunX, bunY)) {
				sbg.enterState(1);
			} else if (input.isKeyDown(Input.KEY_UP)) {
				if (dir == 1) {
					if (this.collision(map, canCollide, bunX, bunY - 1)) {
						y_fin = y + 100;
						moving = true;
						bunY -= 1;
					}
				} else {
					dir = 1;
				}
			} else if (input.isKeyDown(Input.KEY_RIGHT)) {
				if (dir == 2) {
					if (this.collision(map, canCollide, bunX + 1, bunY)) {
						x_fin = x - 100;
						moving = true;
						bunX += 1;
					}
				} else {
					dir = 2;
				}
			} else if (input.isKeyDown(Input.KEY_DOWN)) {
				if (dir == 3) {
					if (this.collision(map, canCollide, bunX, bunY + 1)) {
						y_fin = y - 100;
						moving = true;
						bunY += 1;
					}
				} else {
					dir = 3;
				}
			} else if (input.isKeyDown(Input.KEY_LEFT)) {
				if (dir == 4) {
					if (this.collision(map, canCollide, bunX - 1, bunY)) {
						x_fin = x + 100;
						moving = true;
						bunX -= 1;
					}
				} else {
					dir = 4;
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

	public void render(GameContainer gc, Graphics g, Background bg,
			MainChar mage) throws SlickException {
		bg.render(gc, g, map, x, y);
		mage.render(gc, g, dir, this);

	}
}
