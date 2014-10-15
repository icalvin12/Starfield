import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle[] bob = new Particle[2000];
public final static int num = 1999;
boolean backgroundShow = true;
public void setup()
{	
	noStroke();
	size(500,500);
	for(int i=0;i<(num-1);i++)
	{
		bob[i] = new NormalParticle();
	}
	bob[num-1] = new OddballParticle();
	background(0);
}
public void draw()
{
	if(backgroundShow==false)
	{
		background(0);
	}
	for(int i=0;i<num;i++)
	{
		bob[i].show();
		bob[i].move();
	}
}
public void mousePressed()
{
	backgroundShow = !backgroundShow;
}
class NormalParticle implements Particle
{
	int r,g,b;
	double x,y,speed,angle;
	NormalParticle()
	{
		x = 250;
		y = 250;
		//speed = Math.random()*5;
		speed = 5;
		angle = (Math.random()*2*(Math.PI));
		r = (int)(Math.random()*255);
		g = (int)(Math.random()*255);
		b = (int)(Math.random()*255);
	}
	public void show()
	{
		ellipse((float)x,(float)y,10,10);
		fill(r,g,b);
	}
	public void move()
	{
		x = x + (Math.cos(angle)*speed);
		y = y + (Math.sin(angle)*speed);
		angle = angle + 0.027f;
	}
}
interface Particle
{
	public void show();
	public void move();
}
class OddballParticle implements Particle
{
	int r,g,b;
	double x,y,speed,angle;
	OddballParticle()
	{
		x = 250;
		y = 250;
		//speed = Math.random()*5;
		speed = 5;
		angle = (Math.random()*2*(Math.PI));
		r = (int)(Math.random()*255);
		g = (int)(Math.random()*255);
		b = (int)(Math.random()*255);
	}
	public void show()
	{
		r = (int)(Math.random()*255);
		g = (int)(Math.random()*255);
		b = (int)(Math.random()*255);
		fill(r,g,b);
		ellipse((float)x,(float)y,10,10);
	}
	public void move()
	{
		x = x + (Math.cos(angle)*speed);
		y = y + (Math.sin(angle)*speed);
		angle = angle + 0.027f;
	}
		
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
