package Main;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState{

	private TrueTypeFont ttf;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		ttf = new TrueTypeFont(font, true);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		
		ttf.drawString((float)MainStates.X_RES/2-50, (float)MainStates.Y_RES/2-50, "Winning", Color.green);
	
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
