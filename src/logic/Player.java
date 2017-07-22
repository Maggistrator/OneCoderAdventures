package logic;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import core.CharacterHandler;
import it.marteEngine.entity.Entity;
import scienes.Launcher;

public class Player extends Entity {

	private Rectangle graphic = new Rectangle(0, 0, 50, 50);
	public int UncorruptedSectors = 100;
	String code = "";
	String fork = "";
	boolean isCoding = false;
	public Anonimus currentEnemy = null;
	ArrayList<String> commands = new ArrayList<String>();
	public boolean isAlive = true;
	public static final String ACTION = "ACTION";
	String text1 = "Console is waiting for commands";
	String text2 = "";
	Color color = Color.green;
	StateBasedGame game;

	public Player(float x, float y, StateBasedGame game) {
		super(x, y);
		this.game = game;
		name = Launcher.Name;
		setHitBox(0, 0, 50, 50);
		define("RIGHT", Input.KEY_D);
		define("LEFT", Input.KEY_A);
		define("UP", Input.KEY_W);
		define("DOWN", Input.KEY_S);
		define("HELP", Input.KEY_X);
		define("ACTION", Input.KEY_ENTER);
		define("TEST", Input.KEY_C);
		commands.add("localhost.clear()");
		commands.add("localhost.repair()");
		commands.add("localhost.fork()");
		commands.add("enemy.corrupt()");
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		if(isAlive){
		g.setColor(Color.white);
		g.draw(graphic);
		if (isCoding) {
			for (int i = 0; i < commands.size(); i++)
				g.drawString(commands.get(i), x - hitboxWidth - 10, y - 20 * (i+2));
			g.drawString("Good sectors: " + this.UncorruptedSectors + "%", x - hitboxWidth - 10, y + hitboxHeight);
		} else {
			g.drawString(name+": Progger", x - hitboxWidth - 10, y - 20 * 1);
			g.drawString("x = " + x, 10, 20 * 3);
			g.drawString("y = " + y, 10, 20 * 4);
			g.drawString("Good sectors: " + this.UncorruptedSectors + "%", x - hitboxWidth - 10, y + hitboxHeight);

		}
		/*
		 * g.drawString(code, x - hitboxWidth - 10, y + hitboxHeight + 20 * 1);
		 * g.setColor(color); g.drawString(text1, x - hitboxWidth - 10, y +
		 * hitboxHeight + 20 * 2); g.drawString(text2, x - hitboxWidth - 10, y +
		 * hitboxHeight + 20 * 3);
		 */
		g.drawString(code, 10, 512 - 20 * 3);
		g.setColor(color);
		g.drawString(text1, 10, 512 - 20 * 2);
		g.drawString(text2, 10, 512 - 20 * 1);

	}
		}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(isAlive){
		graphic.setX(x);
		graphic.setY(y);
		world.container = container;
		if (!isCoding) {
			if (check("RIGHT"))
				x++;
			if (check("LEFT"))
				x--;
			if (check("UP"))
				y--;
			if (check("DOWN"))
				y++;
		}
		if (check("TEST")){
			isCoding = true;
			text1 = "Type /help to start";
			text2 = "Type /end to exit";			
		}
		if (currentEnemy != null) {
			if (!isCoding)
				text1 = "Target connected, port:80";
			isCoding = true;
		}
		if (isCoding) {
			char inp = CharacterHandler.HandleInput(container.getInput());
			if (inp != '%')
				if (inp != '`')
					code += inp;
				else
					;
			else if (code.length() != 0)
				code = code.substring(0, code.length() - 1);
			if (check(ACTION)) {
				if (code.contains("enemy.corrupt()")&&currentEnemy!=null) {
					if (currentEnemy.uncorruptedSectors > 20) {
						currentEnemy.uncorruptedSectors -= 20;
						text1 = "Anonimus is corrupted!";
						color = Color.green;
						text2 = "";
					} else {
						text1 = "Anonimus is destroyed!";
						color = Color.green;
						text2 = "";
						currentEnemy.isAlive = false;
						world.remove(currentEnemy);
					}
				} else if (code.contains("localhost.repair()")&&UncorruptedSectors<=80) {
					UncorruptedSectors += 20;
					text1 = "HDD Repared!";
					color = Color.green;
					text2 = "";
				} else if (code.contains("localhost.clear()")&&currentEnemy!=null) {
					currentEnemy.code = "";
					currentEnemy.currentidx = 0;
					text1 = "Console cleared.";
					color = Color.green;
					text2 = "";
				}
			 else if (code.contains("localhost.fork()")) {
				code = fork;
				color = Color.green;
				text1 = "Thread doubled.";
				text2 = "Press 'Enter' to start it.";
				}
				else if (code.contains("localhost.fork/help")) {
					color = Color.green;
					text1 = "This command returns last used code.";
					text2 = "p.s. no matter working, or not";
			}
				else if (code.contains("enemy.corrupt/help")) {
					color = Color.green;
					text1 = "This command destroys 20% of opponent's HDD cells";
					text2 = "";
				}
				else if (code.contains("localhost.clear/help")) {
					color = Color.green;
					text1 = "This command clears all active consoles.";
					text2 = "";
				}
				else if (code.contains("localhost.repare/help")) {
					color = Color.green;
					text1 = "This command repares 20% of your HDD.";
					text2 = "May be used outside of battle, like 'fork', or 'help'";
				}
				else if (code.contains("/help")) {
					color = Color.green;
					text1 = "/helps are equal to commands, just add '/help'";
					text2 = "e.g. enemy.corrupt/help ";
				}
				else if (code.contains("/end")) {
					color = Color.green;
					isCoding = false;
					text1 = "Console closed.";
				}
				/*
				 * else { text1 = "Warning!"; text2 = "Error has been found!";
				 * color = Color.red; }
				 */
				fork = code;
				code = "";
			}

		} else {
			code = "";
			isCoding = false;
		}
	}
	}
}
