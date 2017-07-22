package scienes;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

import core.CharacterHandler;
import it.marteEngine.World;
import logic.Anonimus;

public class Menu extends World {
	Font font = new Font("Courier New", Font.PLAIN, 16);
	Font menuFont = new Font("Courier New", Font.BOLD, 20);
	Font activeFont = new Font("Courier New", Font.BOLD, 18);
	TrueTypeFont slickMenuFont;
	TrueTypeFont slicFont;
	TrueTypeFont slicActiveFont;
	int selected = 1;
	StateBasedGame game;
	String text = "Player1";
	String level = "Easy";
	

	public Menu(int id) {
		super(id);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
			super.init(container, game);
			this.game = game;
			slicFont = new TrueTypeFont(font, true,("éöóêåíãøùçõúôûâàïðîëäæýÿ÷ñìèòüáþ".toUpperCase()+"éöóêåíãøùçõúôûâàïðîëäæýÿ÷ñìèòüáþ").toCharArray());
			slicActiveFont = new TrueTypeFont(activeFont, true,("éöóêåíãøùçõúôûâàïðîëäæýÿ÷ñìèòüáþ".toUpperCase()+"éöóêåíãøùçõúôûâàïðîëäæýÿ÷ñìèòüáþ").toCharArray());
			slickMenuFont = new TrueTypeFont(menuFont, true,("éöóêåíãøùçõúôûâàïðîëäæýÿ÷ñìèòüáþ".toUpperCase()+"éöóêåíãøùçõúôûâàïðîëäæýÿ÷ñìèòüáþ").toCharArray());
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setFont(slickMenuFont);
		g.drawString("Choose level: ", 10, 50);		
		g.setFont(slicFont);
		if(selected==1){
			g.drawString("Easy-peasy!",200, 80);		
			g.drawString("Opponents are slow, and silly.",200, 100);		
			g.setColor(Color.green);
			g.setFont(slicActiveFont);
		}
		else {
			g.setFont(slicFont);
			g.setColor(Color.white);
		}
		g.drawString("Easy",10, 80);		
		if(selected==2){
			g.drawString("Middle.",200, 80);			
			g.drawString("Nothing specical.",200, 100);			
			g.setFont(slicActiveFont);
			g.setColor(Color.green);
		}
		else {
			g.setFont(slicFont);
			g.setColor(Color.white);
		}
		g.drawString("Middle", 10, 110);
		if(selected==3){
			g.drawString("Hard level.",200, 80);		
			g.drawString("Opponents are fast, but",200, 100);		
			g.drawString("nothing can stop ya!!1!",200, 120);		
			g.setFont(slicActiveFont);
			g.setColor(Color.green);
		}
		else {
			g.setFont(slicFont);
			g.setColor(Color.white);
		}
		g.drawString("Hard", 10, 140);
		if(selected==4){
			g.drawString("Damn..",200, 80);		
			g.drawString("Are you sure, little one?",200, 100);		
			g.setFont(slicActiveFont);
			g.setColor(Color.green);
		}
		else {
			g.setFont(slicFont);
			g.setColor(Color.white);
		}
		g.drawString("Impossiburu", 10, 170);
		if(selected==5){
			g.drawString("Enter your nickname,", 200, 80);	
			g.drawString("young Coder!", 200, 100);	
			g.setFont(slicActiveFont);
			g.setColor(Color.green);
		}
		else {
			g.setFont(slicFont);
			g.setColor(Color.white);
		}
		g.drawString(">> "+text, 10, 200);
		if(selected==6){
			g.drawString("Tap to start your adventures!", 200, 80);	
			g.setFont(slickMenuFont);
			g.setColor(Color.green);
		}
		else {
			g.setFont(slicFont);
			g.setColor(Color.white);		
		}
		g.drawString("PLAY", 10, 400);
		g.setFont(slicFont);
		g.setColor(Color.yellow);
		g.drawString("Your level is: "+level, 10, 450);
		g.drawString("Your name is: "+text, 10, 470);
		g.setColor(Color.white);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		super.update(container, game, delta);
		if(selected==5){
			char inp = CharacterHandler.HandleInput(container.getInput());
			if (inp != '%')
				if (inp != '`')
					if (inp != '\n')
					text += inp;
					else;
				else;
			else if (text.length() != 0)
				text = text.substring(0, text.length() - 1);
		}
	}
		
	@Override
	public void keyPressed(int key, char c){
		if(key == Input.KEY_UP&&selected>0)selected--; 
		if(key == Input.KEY_DOWN&&selected<7)selected++;
		if(key == Input.KEY_ENTER)
			switch(selected){
			case 1: 
				Launcher.Level = Anonimus.EASY;
				level = "Easy";
				break;
			case 2: 
				Launcher.Level = Anonimus.MID;
				level = "Middle";
				break;
			case 3: 
				Launcher.Level = Anonimus.HARD;
				level = "Hard";
				break;
			case 4: 
				Launcher.Level = Anonimus.IMPOSSIBURU;
				level = "Impossiburu";
				break;
			case 5: 
				selected++;
				break;
			case 6: 
				Launcher.Name = text;
				game.enterState(1);
				break;
			}
			
	}

}