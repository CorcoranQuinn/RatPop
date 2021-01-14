import java.awt.*;
import java.util.Random;
public class FatRatManager
{
	private double FPop;
	private Image FR;
	Random r = new Random();
	private int x;
	private int y;
	private double full;
	public FatRatManager(double pop, Image x)
	{
		FR = x;
		FPop = pop;
	}
	void setFat(double x)
	{
		FPop = x;
	}
	double getFat()
	{
		return FPop;
	}
	void Spray()
	{
		FPop = FPop * .91;
	}
	void nuke()
	{
		FPop = 1;
	}
	void feed(double x)
	{
		FPop = FPop + x;
	}
	void useHoly(double x)
	{
		FPop = FPop + x;
	}
	public boolean sendCat(double x)
	{
		boolean cat;
		if(FPop >= (FPop + x) * .21)
		{
			FPop = FPop * .79;
			cat = false;
		}
		else
		{
			cat = true;
			full = .21 - FPop/(FPop + x);
			FPop = 0;
		}
		return cat;
	}
	public double Full()
	{
		return full;
	}
	public double zombify()
	{
		FPop = FPop * .96;
		double zombify = FPop * .04;
		return zombify;
	}
	public void draw(Graphics g)
	{
		int p = (int)(FPop);

		for(int a = 0; a <= p; a++)
		{
			x = r.nextInt(1000);
			y = r.nextInt(600)+100;
			g.drawImage(FR,x,y,null);
		}
	}
}