package de.ulmapi.mobile.s40.bus.gui;

import javax.microedition.lcdui.CustomItem;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

/**
 * A {@link CustomItem} that represents a big and a small header.
 * 
 * @author Benjamin Erb
 */
public class HeadingItem extends CustomItem
{
	private final String s1;
	private final String s2;

	/**
	 * Creates a {@link HeadingItem}.
	 * 
	 * @param s1 Main header
	 * @param s2 Small sub header
	 */
	public HeadingItem(String s1, String s2)
	{
		super("");
		
		this.s1 = s1;
		this.s2 = s2;
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
		if(s1 != null)
		{
			g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
			g.setColor(0xb20000);
			g.drawString(s1, 0, 0, Graphics.TOP | Graphics.LEFT);
		}
		if(s2 != null)
		{
			g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
//			g.setColor(0x333333);
			g.setColor(0xFFFFFF);
			g.drawString(s2, 2, 22, Graphics.TOP | Graphics.LEFT);
		}
	}
}
