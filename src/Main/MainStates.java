package Main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainStates extends StateBasedGame {

	public final static int X_RES = 1920;
	public final static int Y_RES = 1080;

	public MainStates(String name) {
		super(name);
	}

	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new MainStates("Test"));

			appgc.setVSync(true);
			appgc.setDisplayMode(X_RES, Y_RES, true);
			appgc.setShowFPS(true);

			appgc.start();

		} catch (SlickException ex) {
			Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		BasicGameState game = new GameState();
		BasicGameState game2 = new GameOverState();
		
		this.addState(game);
		this.addState(game2);
	}

}
