package com.hexlan.main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Level 
{
	int x = Game.WIDTH/2;
	int y = Game.HEIGHT/2;
	
	int width = 10;
	int height = 10;
	
	boolean left = false;
	boolean right = false;
	boolean up = false;
	boolean down = false;
	
	public Level()
	{
		// Initialization
	}
	
	public void handleInput()
	{
		// Input Logic
		if(Input.isDown(Input.LEFT)) { left = true; }
		if(Input.isDown(Input.RIGHT)) { right = true;  }
		if(Input.isDown(Input.UP)) { up = true;  }
		if(Input.isDown(Input.DOWN)) { down = true ; }
		
		if(Input.isReleased(Input.LEFT)) { left = false; }
		if(Input.isReleased(Input.RIGHT)) { right = false;  }
		if(Input.isReleased(Input.UP)) { up = false;  }
		if(Input.isReleased(Input.DOWN)) { down = false; }
	}
	
	public void update()
	{
		handleInput();
		
		// Game Logic
		if(left) { x-=4; }
		if(right) { x+=4; }
		if(up) { y-=4; }
		if(down) { y+=4; }
		
		if(x - width/2 < 0)
		{
			x = width/2;
		}
		
		if(x + width/2 > Game.WIDTH)
		{
			x = Game.WIDTH - width/2;
		}
		
		if(y - height/2 < 0)
		{
			y = height/2;
		}
		
		if(y + height/2 > Game.HEIGHT)
		{
			y = Game.HEIGHT - height/2;
		}
	}
	
	public void draw(Graphics2D g)
	{
		// Render Logic
		g.setColor(new Color(100, 190, 030));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.setColor(new Color(210, 210, 80));
		g.fillRect(x - width/2, y - height/2, width, height);
	}
}
