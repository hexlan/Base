package com.hexlan.main;

public class Input 
{
	// List of Keys
	public static final int NUM_KEYS = 4;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int W = 2;
	public static final int S = 3;
	
	// Key States (Current and Previous)
	private static boolean[] keys = new boolean[NUM_KEYS];
	private static boolean[] pkeys = new boolean[NUM_KEYS];
	
	// Static Class so no need for intialization
	public Input() {}
	
	// Set the previous keys to the current keys (Lets us differentiate pressed vs down)
	public static void update()
	{
		for(int i = 0; i < NUM_KEYS; i++)
		{
			pkeys[i] = keys[i];
		}
	}
	
	// Access Methods
	public static void setKey(int i, boolean b) { keys[i] = b; }
	public static boolean isDown(int i) { return keys[i]; }
	public static boolean isPressed(int i) { return keys[i] && !pkeys[i]; }
	public static boolean isReleased(int i) { return !keys[i] && pkeys[i]; }
}