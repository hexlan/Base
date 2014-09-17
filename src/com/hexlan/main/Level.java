package com.hexlan.main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Level 
{
	private Ball ball;
	private Paddle p1, p2;
	
	public static int p1_score;
	public static int p2_score;
	
	public Level()
	{
		// Initialization
		ball = new Ball();
		p1 = new Paddle(new PointF(15, Game.HEIGHT/2), new Color(210, 80, 80), Input.W, Input.S);
		p2 = new Paddle(new PointF(Game.WIDTH - 15, Game.HEIGHT/2), new Color(80, 210, 210), Input.UP, Input.DOWN);
	}
	
	public void update()
	{
		ball.update();
		p1.update();
		p2.update();
		
		if(ball.getRectangle().intersects(p1.getRectangle()) || ball.getRectangle().intersects(p2.getRectangle())) ball.velocity.x *= -1;
	}
	
	public void draw(Graphics2D g)
	{
		// Render Logic
		g.setColor(new Color(100, 190, 30));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.setColor(Color.white);
		g.drawString(""+p1_score, 25, 10);
		g.drawString(""+p2_score, Game.WIDTH - 35, 10);
		
		ball.draw(g);
		p1.draw(g);
		p2.draw(g);
	}
}
