package scienes;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import it.marteEngine.World;
import logic.Anonimus;
import logic.Player;

public class Level1 extends World {

	Font font = new Font("Courier New", Font.PLAIN, 20);
	Player player;
	Anonimus enemy;
	Rectangle rectangle = new Rectangle(0, 0, 512, 512);

	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		player = new Player(50, 200, game);
		enemy = new Anonimus(512, 512, player, Launcher.Level);
		this.add(player, World.GAME);
		this.add(enemy, World.GAME);
	}

	public Level1(int id) {
		super(id);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		player.render(container, g);
		g.translate(-player.x, -player.y);
		enemy.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		player.update(container, delta);
		enemy.update(container, delta);
		if (Math.abs(enemy.x / 2 - player.x) < 50 && Math.abs(enemy.y / 2 - player.y) < 70 && enemy.isAlive)
			player.currentEnemy = enemy;
		else
			player.currentEnemy = null;
	}

}
