package com.hexlan.main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Level 
{
	int ball_x = Game.WIDTH/2;
	int ball_y = Game.HEIGHT/2;
	
	int left_x = Game.WIDTH/8;
	int left_y = Game.HEIGHT/2;
	
	int right_x = (Game.WIDTH/2)+((Game.WIDTH/8)*3);
	int right_y = Game.HEIGHT/2;
	
	int ball_width = 10;
	int ball_height = 10;
	
	int left_width = 10;
	int left_height = 40;
	
	int right_width = 10;
	int right_height = 40;
	
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
		if(left) { ball_x-=1; }
		if(right) { ball_x+=1; }
		if(up) { ball_y-=1; }
		if(down) { ball_y+=1; }
		
		if(ball_x - ball_width/2 < 0)
		{
			ball_x = Game.WIDTH/2;
		}
		
		if(ball_x + ball_width/2 > Game.WIDTH)
		{
			ball_x = Game.WIDTH/2;
		}
		
		if(ball_y - ball_height/2 < 0)
		{
			ball_y = ball_height/2;
		}
		
		if(ball_y + ball_height/2 > Game.HEIGHT)
		{
			ball_y = Game.HEIGHT - ball_height/2;
		}
	}
	
	public void draw(Graphics2D g)
	{
		// Render Logic
		g.setColor(new Color(100, 190, 30));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.setColor(new Color(210, 210, 80));
		g.fillRect(ball_x - ball_width/2, ball_y - ball_height/2, ball_width, ball_height);
		
		g.setColor(new Color(210, 80, 80));
		g.fillRect(left_x - left_width/2, left_y - left_height/2, left_width, left_height);
		
		g.setColor(new Color(80, 210, 210));
		g.fillRect(right_x - right_width/2, right_y - right_height/2, right_width, right_height);
	}
}
