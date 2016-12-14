package Main;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {

	private final int MAZE_SIZE = 5;
	
	private MainCharAnimation bunny;
	private MainChar mage;
	private Background bg;
	private Maze maze;
	private int[][] map;

	Boolean moving = false;

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		Image set = new Image("images/walls1.png").getSubImage(0, 0, 192, 128);
		set.setFilter(Image.FILTER_NEAREST);
		Image setScale = set.getScaledCopy(300, 200);
		SpriteSheet tiles = new SpriteSheet(setScale, 100, 100);
		
		//bunny = new MainChar(new SpriteSheet("images/BunnySpriteSheet.png", 100, 100), MainStates.X_RES, MainStates.Y_RES, 100, 100);
		
		set = new Image("images/Mage.png");
		//set.setFilter(Image.FILTER_LINEAR);
		setScale = set.getScaledCopy(400, 100);
		SpriteSheet mageSheet = new SpriteSheet(setScale,100,100);
		
		mage = new MainChar(mageSheet, MainStates.X_RES, MainStates.Y_RES, 100, 100);
		
		bg = new Background(tiles, mage);

		maze = new Maze(MAZE_SIZE);
		map = maze.map();
		
		set = new Image("images/walls1.png").getSubImage(352, 192, 64, 64);
		set.setFilter(Image.FILTER_NEAREST);
		setScale = set.getScaledCopy(100, 100);
		
		bg.addTexture(setScale);
		
	}
	
	public void update(GameContainer gc, StateBasedGame arg1, int delta) throws SlickException {
		bg.update(gc, delta, map, arg1);
		mage.update(gc, delta, bg.getMoving());
		
	}

	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		bg.render(gc, g, map);
		mage.render(gc, g, bg.getDir());
		
	}

	@Override
	public int getID() {
		return 0;
	}
}
