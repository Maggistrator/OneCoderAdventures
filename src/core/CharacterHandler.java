package core;

import org.newdawn.slick.Input;

public class CharacterHandler {
	public static char HandleInput(Input input) {
		if (input.isKeyDown(Input.KEY_LSHIFT) && input.isKeyPressed(Input.KEY_9))
			return '(';
		if (input.isKeyDown(Input.KEY_LSHIFT) && input.isKeyPressed(Input.KEY_0))
			return ')';
		if (input.isKeyDown(Input.KEY_LSHIFT) && input.isKeyPressed(Input.KEY_MINUS))
			return '_';
		if (input.isKeyPressed(Input.KEY_A))
			return 'a';
		if (input.isKeyPressed(Input.KEY_B))
			return 'b';
		if (input.isKeyPressed(Input.KEY_C))
			return 'c';
		if (input.isKeyPressed(Input.KEY_D))
			return 'd';
		if (input.isKeyPressed(Input.KEY_E))
			return 'e';
		if (input.isKeyPressed(Input.KEY_F))
			return 'f';
		if (input.isKeyPressed(Input.KEY_G))
			return 'g';
		if (input.isKeyPressed(Input.KEY_H))
			return 'h';
		if (input.isKeyPressed(Input.KEY_I))
			return 'i';
		if (input.isKeyPressed(Input.KEY_J))
			return 'j';
		if (input.isKeyPressed(Input.KEY_K))
			return 'k';
		if (input.isKeyPressed(Input.KEY_L))
			return 'l';
		if (input.isKeyPressed(Input.KEY_M))
			return 'm';
		if (input.isKeyPressed(Input.KEY_N))
			return 'n';
		if (input.isKeyPressed(Input.KEY_O))
			return 'o';
		if (input.isKeyPressed(Input.KEY_P))
			return 'p';
		if (input.isKeyPressed(Input.KEY_Q))
			return 'q';
		if (input.isKeyPressed(Input.KEY_R))
			return 'r';
		if (input.isKeyPressed(Input.KEY_S))
			return 's';
		if (input.isKeyPressed(Input.KEY_T))
			return 't';
		if (input.isKeyPressed(Input.KEY_U))
			return 'u';
		if (input.isKeyPressed(Input.KEY_V))
			return 'v';
		if (input.isKeyPressed(Input.KEY_W))
			return 'w';
		if (input.isKeyPressed(Input.KEY_X))
			return 'x';
		if (input.isKeyPressed(Input.KEY_Y))
			return 'y';
		if (input.isKeyPressed(Input.KEY_Z))
			return 'z';
		if (input.isKeyPressed(Input.KEY_0))
			return '0';
		if (input.isKeyPressed(Input.KEY_1))
			return '1';
		if (input.isKeyPressed(Input.KEY_2))
			return '2';
		if (input.isKeyPressed(Input.KEY_3))
			return '3';
		if (input.isKeyPressed(Input.KEY_4))
			return '4';
		if (input.isKeyPressed(Input.KEY_5))
			return '5';
		if (input.isKeyPressed(Input.KEY_6))
			return '6';
		if (input.isKeyPressed(Input.KEY_7))
			return '7';
		if (input.isKeyPressed(Input.KEY_8))
			return '8';
		if (input.isKeyPressed(Input.KEY_9))
			return '9';
		if (input.isKeyPressed(Input.KEY_UNDERLINE))
			return '_';
		if (input.isKeyPressed(Input.KEY_SPACE))
			return ' ';
		if (input.isKeyPressed(Input.KEY_MULTIPLY))
			return '*';
		if (input.isKeyPressed(Input.KEY_MINUS))
			return '-';
		if (input.isKeyPressed(Input.KEY_ADD))
			return '+';
		if (input.isKeyPressed(Input.KEY_BACKSLASH))
			return '\\';
		if (input.isKeyPressed(Input.KEY_SLASH))
			return '/';
		if (input.isKeyPressed(Input.KEY_COMMA))
			return ',';
		if (input.isKeyPressed(Input.KEY_ENTER))
			return '\n';
		if (input.isKeyPressed(Input.KEY_PERIOD))
			return '.';

		if (input.isKeyPressed(Input.KEY_BACK))
			return '%';
		return '`';
	}
}
