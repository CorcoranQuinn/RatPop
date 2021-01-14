import java.awt.*;
import java.util.Random;
public class SkinnyRatManager
{
	private double SPop;
	private Image SR;
	Random r = new Random();
	private int x;
	private int y;
	public SkinnyRatManager(double pop, Image x)
	{
		SR = x;
		SPop = pop;
	}
	void setSkinny(double x)
	{
		SPop = x;
	}
	double getSkinny()
	{
		return SPop;
	}
	void spray()
	{
		SPop = SPop * .91;
	}
	void nuke()
	{
		SPop = 1;
	}
	void sendCat(boolean x,double y,double z)
	{
		if(x == false)
		{
		}
		if(x == true)
		{
			SPop = SPop - (SPop * (2*z));
		}
	}
	public double feed()
	{
		SPop = SPop * .82;
		double feed = SPop * .18;
		return feed;
	}
	void breed(double x)
	{
		if(SPop + x >= 2)
		{
			SPop = (SPop + x)/2 + SPop;
		}
	}
	public void draw(Graphics g)
	{
		int p = (int)(SPop);

		for(int a = 0; a <= p; a++)
		{
			x = r.nextInt(1000);
			y = r.nextInt(600)+100;
			g.drawImage(SR,x,y,null);
		}
	}
}