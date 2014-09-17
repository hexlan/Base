package com.hexlan.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Paddle 
{
	private PointF position;
	private boolean up;
	private boolean down;
	
	private Color color;
	private int width;
	private int height;
	
	private int up_button;
	private int down_button;
	
	public Paddle(PointF p, Color c, int b1, int b2)
	{
		position = p;
		up = false;
		down = false;
		
		color = c;
		width = 10;
		height = 30;
		
		up_button = b1;
		down_button = b2;
	}
	
	public void handleInput()
	{
		if(Input.isDown(up_button)) { up = true; }
		if(Input.isDown(down_button)) { down = true; }
		
		if(Input.isReleased(up_button)) { up = false; }
		if(Input.isReleased(down_button)) { down = false; }
	}

	public void update()
	{
		handleInput();
		
		// Logic
		if(up) { position.y-=2; }
		if(down) { position.y+=2; }
		
		if(position.y - height/2 < 0) { position.y = height/2; }
		if(position.y + height/2 > Game.HEIGHT) { position.y = Game.HEIGHT - height/2; }
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(color);
		g.fillRect((int)position.x - width/2, (int)position.y - height/2, width, height);
	}
	
	public Rectangle getRectangle() { return new Rectangle((int)position.x - width/2, (int)position.y - height/2, width, height); }
}
