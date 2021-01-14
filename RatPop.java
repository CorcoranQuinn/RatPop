import java.applet.Applet;
import java.awt.*;
import java.util.Random;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class RatPop extends JApplet implements ActionListener
{
	Timer t1;
	Image SR;
	Image FR;
	Image ZR;
	int counter;
	JButton breed;
	JButton feed;
	JButton spray;
	JButton useHoly;
	JButton zombify;
	JButton sendCat;
	JButton nuke;
	SkinnyRatManager skinny;
	ZombieRatManager zombie;
	FatRatManager fatty;
	Random r;
	public void init()
	{
		breed = new JButton("Breed");
		feed = new JButton("Feed");
		spray = new JButton("Spray");
		useHoly = new JButton("Use Holy");
		zombify = new JButton("Zombify");
		sendCat = new JButton("Send Cat");
		nuke = new JButton("Nuke");

		SR = getImage(getDocumentBase(),"COMEONSTEPITUP.png");
		FR = getImage(getDocumentBase(),"PRESSBTOMAKEEVERYONECRY.png");
		ZR = getImage(getDocumentBase(),"YOURETOOSLOW.png");
		t1 = new Timer(1000,this);
		t1.start();
		r = new Random();
		skinny = new SkinnyRatManager(10.00,SR);
		fatty = new FatRatManager(10.00,FR);
		zombie = new ZombieRatManager(3,ZR);
		setContentPane(new drawing_Panel());
		add(breed);
		add(feed);
		add(spray);
		add(useHoly);
		add(zombify);
		add(sendCat);
		add(nuke);
		feed.addActionListener(this);
		breed.addActionListener(this);
		spray.addActionListener(this);
		useHoly.addActionListener(this);
		zombify.addActionListener(this);
		sendCat.addActionListener(this);
		nuke.addActionListener(this);
	}
	public class drawing_Panel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			skinny.draw(g);
			fatty.draw(g);
			zombie.draw(g);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == t1)
		{
			counter++;
			if(counter == 3)
			{
				if(skinny.getSkinny() + fatty.getFat() >= 2)
				{
					skinny.setSkinny(skinny.getSkinny() + (skinny.getSkinny() + fatty.getFat())*.15);
					System.out.println("skinny pop: " + skinny.getSkinny());
				}
				if(zombie.getZombie() >= 1)
				{
					if(skinny.getSkinny() >= 1)
					{
						skinny.setSkinny(skinny.getSkinny()*.94);
						fatty.setFat(fatty.getFat()*.97);
						zombie.setZombie(skinny.getSkinny()*.06 + fatty.getFat()*.03);
						System.out.println("skinny pop: " + skinny.getSkinny());
						System.out.println("fat pop: " + fatty.getFat());
						System.out.println("Zombie pop: " + zombie.getZombie());
					}
					if(skinny.getSkinny() <= 1)
					{
						fatty.setFat(fatty.getFat()*.953);
						zombie.setZombie(fatty.getFat()*.047);
					}
				}
				counter = 0;
			}
			repaint();
		}
		if(e.getSource() == feed)
		{
			fatty.feed(skinny.feed());
			System.out.println("fat pop: " + fatty.getFat());
			System.out.println("skinny pop: " + skinny.getSkinny());
			repaint();
		}
		if(e.getSource() == breed)
		{
			skinny.breed(fatty.getFat());
			System.out.println("skinny pop: " + skinny.getSkinny());
			repaint();
		}
		if(e.getSource() == zombify)
		{
			zombie.zombify(fatty.zombify());
			System.out.println("fat pop: " + fatty.getFat());
			System.out.println("Zombie pop: " + zombie.getZombie());
			repaint();
		}
		if(e.getSource() == spray)
		{
			skinny.spray();
			System.out.println("skinny pop: " + skinny.getSkinny());
			repaint();
		}
		if(e.getSource() == useHoly)
		{
			fatty.useHoly(zombie.useHoly());
			System.out.println("fat pop: " + fatty.getFat());
			System.out.println("Zombie pop: " + zombie.getZombie());
			repaint();
		}
		if(e.getSource() == sendCat)
		{
			skinny.sendCat(fatty.sendCat(skinny.getSkinny()),fatty.getFat(),fatty.Full());
		}
		if(e.getSource() == nuke)
		{
			int x = r.nextInt(2)+1;
			if(x == 1)
			{
				zombie.setZombie(0);
				fatty.setFat(0);
				skinny.setSkinny(0);
			}

			else if(x == 2)
			{
				zombie.setZombie(0);
				fatty.setFat(0);
				skinny.setSkinny(0);
			}

			else if(x == 3)
			{
				zombie.setZombie(0);
				fatty.setFat(0);
				skinny.setSkinny(0);
			}
			repaint();
		}
	}

}