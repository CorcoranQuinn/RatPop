import java.awt.*;
import java.util.Random;
public class ZombieRatManager
{
	private double ZPop;
	private Image ZR;
	Random r = new Random();
	private int x;
	private int y;
	public ZombieRatManager(double pop, Image x)
	{
		ZR = x;
		ZPop = pop;
	}
	void setZombie(double x)
	{
		ZPop = x;
	}
	public double getZombie()
	{
		return ZPop;
	}

	void nuke()
	{
		ZPop = 1;
	}
	public double useHoly()
	{
		ZPop = ZPop * .89;
		double holy = ZPop * .11;
		return holy;
	}
	void zombify(double x)
	{
		ZPop = ZPop + x;
	}
	public void draw(Graphics g)
	{
		int p = (int)(ZPop);

		for(int a = 0; a <= p; a++)
		{
			x = r.nextInt(1000);
			y = r.nextInt(600)+100;
			g.drawImage(ZR,x,y,null);
		}
	}
}