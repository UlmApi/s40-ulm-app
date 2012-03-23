package de.ulmapi.mobile.s40.bus.gui;

import javax.microedition.lcdui.CustomItem;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

/**
 * A {@link CustomItem} that display bus line, destination and departure
 * information as a graphics.
 * 
 * @author Benjamin Erb
 */
public class StationItem extends CustomItem
{
	private final String line;
	private final String target;
	private final int departure;

	public StationItem(String line, String target, int departure)
	{
		super("");
		
		this.line = line;
		this.target = target;
		this.departure = departure;
	}

	protected int getMinContentHeight()
	{
		return 52;
	}

	protected int getMinContentWidth()
	{
		return 225;
	}

	protected int getPrefContentHeight(int arg0)
	{
		return 52;
	}

	protected int getPrefContentWidth(int arg0)
	{
		return 225;
	}

	protected void paint(Graphics g, int w, int h)
	{
		g.setColor(0xb20000);
		g.fillRect(0, 0, 40, 52);
		g.fillRect(0, 0, 225, 2);

		g.setColor(210, 210, 210);
		g.fillRect(40, 2, 225, 28);

		g.setColor(255, 255, 255);
		g.fillRect(40, 28, 225, 22);

		Font defaultFont = g.getFont();

		g.setColor(255, 255, 255);
		Font lineFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
		g.setFont(lineFont);
		g.drawString(line, 20, 12, Graphics.TOP | Graphics.HCENTER);

		g.setColor(0xFFFFFF);
		//g.setColor(0x000000);

		g.setFont(defaultFont);
		g.drawString(target, 44, 4, Graphics.TOP | Graphics.LEFT);

		if(departure > 0)
		{
			g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
			g.drawString("in " + departure + " Minuten", 44, 30, Graphics.TOP | Graphics.LEFT);
		}
		else
		{
			g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD | Font.STYLE_ITALIC, Font.SIZE_SMALL));
			g.drawString("jetzt", 44, 30, Graphics.TOP | Graphics.LEFT);
		}
	}

	public String getLine()
	{
		return line;
	}

	public String getTarget()
	{
		return target;
	}

	public int getDeparture()
	{
		return departure;
	}
}
