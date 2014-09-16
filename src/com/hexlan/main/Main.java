package com.hexlan.main;

import javax.swing.JFrame;

public class Main 
{
	public static JFrame window;
	
	public static void main(String[] args)
	{
		window = new JFrame("Window");
		window.add(new Game());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
