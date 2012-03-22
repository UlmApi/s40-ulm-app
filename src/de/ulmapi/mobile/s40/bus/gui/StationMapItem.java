package de.ulmapi.mobile.s40.bus.gui;

import java.io.IOException;

import javax.microedition.lcdui.CustomItem;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * A {@link CustomItem} that displays a small map indicating the station
 * location.
 * 
 * @author Benjamin Erb
 */
public class StationMapItem extends CustomItem
{
	private final Image mapImage;
	private final Image pin;

	public StationMapItem(Image mapImage)
	{
		super("");
		
		this.mapImage = mapImage;

		Image i = null;
		
		try
		{
			i = Image.createImage("/station_icon.png");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		pin = i;
	}

	protected int getMinContentHeight()
	{
		return 96;
	}

	protected int getMinContentWidth()
	{
		return 225;
	}

	protected int getPrefContentHeight(int arg0)
	{
		return 96;
	}

	protected int getPrefContentWidth(int arg0)
	{
		return 225;
	}

	protected void paint(Graphics g, int w, int h)
	{
		g.drawImage(mapImage, 0, 0, Graphics.TOP | Graphics.LEFT);
		g.drawImage(pin, w / 2, h / 2, Graphics.HCENTER | Graphics.VCENTER);
	}
}
