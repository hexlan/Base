package com.hexlan.main;

public class PointF 
{
	public double x;
	public double y;
	
	public PointF(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void add(PointF p)
	{
		x += p.x;
		y += p.y;
	}
}
