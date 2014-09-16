package com.hexlan.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable, KeyListener
{
	// Dimensions
	public static final int WIDTH = 160;
	public static final int HEIGHT = 144;
	public static int SCALE = 2;
	
	// Game Thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	// Image
	private BufferedImage image;
	private Graphics2D g;
	
	// Game State Manager
	private Level level;
	
	// Input
	public static Input input;
	
	public Game()
	{
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	// Method that runs when the Game is added to the window context.
	// Creates the thread the game runs on and adds a keyListener.
	public void addNotify()
	{
		super.addNotify();
		if(thread==null)
		{
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init()
	{
		// Initializes image to render to
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D)image.getGraphics();
		
		running = true;
		level = new Level();
	}
	
	public void run()
	{
		init();
		
		// Times to manage how often the loop is run (60 times per second)
		long start;
		long elapsed;
		long wait;
		
		// Game Loop
		while(running)
		{
			start = System.nanoTime();
			
			update();
			draw();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			if(wait < 0)
			{
				wait = 5;
			}
			
			// Causes the game to pause to keep it running at a constant 60 FPS
			try
			{
				Thread.sleep(wait);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void update()
	{
		level.update();
		Input.update();
	}
	
	// Draws the game to the screen using a backbuffer to remove flickering
	private void draw()
	{
		level.draw(g);
		
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {}
	
	public void keyPressed(KeyEvent key) 
	{
		if(key.getKeyCode() == KeyEvent.VK_UP) Input.setKey(Input.UP, true);
		if(key.getKeyCode() == KeyEvent.VK_DOWN) Input.setKey(Input.DOWN, true);
		if(key.getKeyCode() == KeyEvent.VK_LEFT) Input.setKey(Input.LEFT, true);
		if(key.getKeyCode() == KeyEvent.VK_RIGHT) Input.setKey(Input.RIGHT, true);
		if(key.getKeyCode() == KeyEvent.VK_SPACE) Input.setKey(Input.SELECT, true);
		if(key.getKeyCode() == KeyEvent.VK_ENTER) Input.setKey(Input.START, true);
		if(key.getKeyCode() == KeyEvent.VK_ESCAPE) Input.setKey(Input.ESCAPE, true);
		if(key.getKeyCode() == KeyEvent.VK_Z) Input.setKey(Input.A, true);
		if(key.getKeyCode() == KeyEvent.VK_X) Input.setKey(Input.B, true);

	}
	public void keyReleased(KeyEvent key) 
	{
		if(key.getKeyCode() == KeyEvent.VK_UP) Input.setKey(Input.UP, false);
		if(key.getKeyCode() == KeyEvent.VK_DOWN) Input.setKey(Input.DOWN, false);
		if(key.getKeyCode() == KeyEvent.VK_LEFT) Input.setKey(Input.LEFT, false);
		if(key.getKeyCode() == KeyEvent.VK_RIGHT) Input.setKey(Input.RIGHT, false);
		if(key.getKeyCode() == KeyEvent.VK_SPACE) Input.setKey(Input.SELECT, false);
		if(key.getKeyCode() == KeyEvent.VK_ENTER) Input.setKey(Input.START, false);
		if(key.getKeyCode() == KeyEvent.VK_ESCAPE) Input.setKey(Input.ESCAPE, false);
		if(key.getKeyCode() == KeyEvent.VK_Z) Input.setKey(Input.A, false);
		if(key.getKeyCode() == KeyEvent.VK_X) Input.setKey(Input.B, false);
	}
}
