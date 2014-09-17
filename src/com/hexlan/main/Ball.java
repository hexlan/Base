package com.hexlan.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball 
{
	public PointF position;
	public PointF velocity;
	
	private int width;
	private int height;
	
	public Ball()
	{
		position = new PointF(Game.WIDTH/2, Game.HEIGHT/2);
		velocity = new PointF(1, 2.5);
		
		width = 10;
		height = 10;
	}
	
	public void update()
	{
		position.add(velocity);
		
		if(position.x < 0)
		{
			position = new PointF(Game.WIDTH/2, Game.HEIGHT/2);
			Level.p2_score++;
		}
		
		if(position.x > Game.WIDTH)
		{
			position = new PointF(Game.WIDTH/2, Game.HEIGHT/2);
			Level.p1_score++;
		}
		
		if(position.y + height/2 > Game.HEIGHT)
		{
			position.y = Game.HEIGHT - height/2;
			velocity.y *= -1;
		}
		
		if(position.y - height/2 < 0)
		{
			position.y = height/2;
			velocity.y *= -1;
		}
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(new Color(210, 210, 80));
		g.fillRect((int)position.x - width/2, (int)position.y - height/2, width, height);
	}

	public Rectangle getRectangle() { return new Rectangle((int)position.x - width/2, (int)position.y - height/2, width, height); }
}
