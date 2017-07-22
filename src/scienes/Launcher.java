package scienes;

import javax.swing.JOptionPane;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import logic.Anonimus;

public class Launcher extends StateBasedGame {
	
	public static int Level = Anonimus.EASY;
	public static String Name;
	
	public Launcher(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new Menu(0));
		addState(new Level1(1));
		enterState(0);
		Music music = new Music("res/Kuroi Light.ogg");
		music.loop();
		music.play();
	}

	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new Launcher("One coder's adventures"));
			app.setDisplayMode(512, 512, false);
			app.setTargetFrameRate(30);
			app.start();
		} catch (SlickException e1) {
			JOptionPane.showMessageDialog(null, "Произошла ошибка загрузки библиотеки Slic2d");
			e1.printStackTrace();
		}

	}

}
