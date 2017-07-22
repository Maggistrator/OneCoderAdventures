package logic;

import java.util.HashMap;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import it.marteEngine.entity.Entity;

public class Anonimus extends Entity {

	public static final int EASY = 100;
	public static final int MID = 50;
	public static final int HARD = 25;
	public static final int IMPOSSIBURU = 5;
	private Rectangle graphic = new Rectangle(0, 0, 50, 50);
	public int uncorruptedSectors = 100;
	public final String CORRUPT = "corrupt";
	int currentidx = 0;
	Entity self = this;
	Player player;
	String code = "";
	HashMap<String, String> commands = new HashMap<String, String>();
	boolean isCoding = false;
	int level;
	int delay = 150;
	public boolean isAlive = true;

	public Anonimus(float x, float y, Player player, int level) {
		super(x, y);
		name = "anon";
		setHitBox(0, 0, 50, 50);
		this.player = player;
		this.level = level;
		delay = level;
		graphic.setX(x);
		graphic.setY(y);
		commands.put("corrupt", "enemy.core.write(0x00);");
		commands.put("heal", "self.repare();");
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		if (isAlive) {
			g.setColor(Color.red);
			g.draw(graphic);
			if (isCoding) {
				g.drawString("Good sectors: " + this.uncorruptedSectors + "%", x - hitboxWidth - 10, y + hitboxHeight + 20 * 1);
				g.drawString("Console: " + this.code, x - hitboxWidth - 10, y - 20 * 3);
			} else
				g.drawString("Good sectors: " + this.uncorruptedSectors + "%", x - hitboxWidth - 10, y + hitboxHeight + 20 * 1);
				g.drawString("Anonimus: Haker", x - hitboxWidth / 2, y - 20 * 1);
		}

	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (isAlive) {
			if (Math.abs(self.x/2 - player.x) < 50 && Math.abs(self.y/2 - player.y) < 50) {
				
			/*if (Math.abs(self.x/2 - player.x) < 50) {
				if (self.x < player.x)
					self.x++;
				else
					self.x--;
				isCoding = true;
				isCoding = true;
			}
			if (Math.abs(self.y/2 - player.y) < 50) {
				if (self.y < player.y)
					self.y--;
				else
					self.y++;
				isCoding = true;
			} else {
				isCoding = false;
				code = "";
			}
			*/
				isCoding = true;
				}

			if (delay < 0 && isCoding) {
				if(uncorruptedSectors<50&&code.equals(""));
				if (code.equals(commands.get(CORRUPT)) && isCoding) {
					if (player.UncorruptedSectors > 20)
						player.UncorruptedSectors -= 20;
					else {
						player.text1 = "Virtual machine destroyed.";
						player.text2 = "Player is disconnecting...";
						player.isAlive = false;
					}
					code = "";
					currentidx = 0;
				} else
					code += commands.get(CORRUPT).toCharArray()[currentidx];
				currentidx++;
				delay = level;
			} else
				delay--;
		}
	}
}
