package de.ulmapi.mobile.s40.bus.gui;

import javax.microedition.lcdui.CustomItem;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

/**
 * A simple CustomItem displaying a single line, supporting Colors and Fonts.
 * 
 * @author Michael Mueller
 */
public class LineItem extends CustomItem
{
	private String line;
	private int color = 0x000000;
	private Font font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);

	public LineItem(String s)
	{
		super("");
		
		this.line = s;
	}

	public LineItem(String s, int c, Font f)
	{
		super("");
		
		line = s;
		color = c;
		font = f;
	}

	protected int getMinContentHeight()
	{
		return 40;
	}

	protected int getMinContentWidth()
	{
		return 225;
	}

	protected int getPrefContentHeight(int arg0)
	{
		return 40;
	}

	protected int getPrefContentWidth(int arg0)
	{
		return 225;
	}

	protected void paint(Graphics g, int w, int h)
	{
		if(line != null)
		{
			g.setFont(font);
			g.setColor(color);
			g.drawString(line, 0, 0, Graphics.TOP | Graphics.LEFT);
		}
	}
}
