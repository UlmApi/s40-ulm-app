package de.ulmapi.mobile.s40.view;

import java.io.IOException;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import de.ulmapi.mobile.s40.Main;

public class SplashView extends Canvas implements Runnable
{
	private final Main midlet;

	private Image image;

	private boolean changeView;

	public SplashView(Main midlet)
	{
		this.midlet = midlet;

		this.setFullScreenMode(true);

		changeView = false;

		try
		{
			image = Image.createImage("/splashView.png");

			Thread thread = new Thread(this);
			thread.start();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void keyPressed(int keyCode)
	{
		
	}

	public void pointerPressed(int x, int y)
	{
		
	}

	public void paint(Graphics g)
	{
		g.setColor(0xFAFAFA);
		g.fillRect(0, 0, getWidth(), getHeight());

		if(!changeView)
		{
			g.drawImage(image, getWidth() / 2, getHeight() / 2 + 20, Graphics.HCENTER | Graphics.VCENTER);
		}
	}

	public void run()
	{
		try
		{
			Thread.sleep(4000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		changeView = true;

		if(isShown())
		{
			repaint();

			midlet.setView(Main.HOME_VIEW);
		}
	}
}
