package Main;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Background {
	
	private ArrayList<Image> tileSet;

	public Background(SpriteSheet tiles) {

		tileSet = new ArrayList<Image>();

		for (int i = 0; i < tiles.getHorizontalCount(); i++) {
			for (int j = 0; j < tiles.getVerticalCount(); j++) {
				tileSet.add(tiles.getSubImage(i, j));
			}
		}
	}

	public void addTexture(Image target) {
		tileSet.add(target);
	}



	public void render(GameContainer gc, Graphics g, int[][] map, int x, int y) throws SlickException {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				tileSet.get(map[i][j]).draw(x + (i * 100), y + (j * 100));
			}
		}
	}
}
