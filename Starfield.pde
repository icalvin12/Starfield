Particle[] bob = new Particle[1000];
public final static int num = 999;
boolean backgroundShow = true;
void setup()
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
void draw()
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
void mousePressed()
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
	void show()
	{
		ellipse((float)x,(float)y,10,10);
		fill(r,g,b);
	}
	void move()
	{
		x = x + (Math.cos(angle)*speed);
		y = y + (Math.sin(angle)*speed);
		angle = angle + 0.027;
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
	void show()
	{
		r = (int)(Math.random()*255);
		g = (int)(Math.random()*255);
		b = (int)(Math.random()*255);
		fill(r,g,b);
		ellipse((float)x,(float)y,10,10);
	}
	void move()
	{
		x = x + (Math.cos(angle)*speed);
		y = y + (Math.sin(angle)*speed);
		angle = angle + 0.027;
	}
		
}


