package de.ulmapi.mobile.s40.bus.gui;

import javax.microedition.lcdui.CustomItem;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

/**
 * A simple {@link CustomItem} that display a "Loading..." message. Should be
 * added to the Form on start loading and removed when async action finishes.
 * 
 * @author Benjamin Erb
 */
public class LoadItem extends CustomItem
{
	public LoadItem()
	{
		super("");
	}

	protected int getMinContentHeight()
	{
		return 120;
	}

	protected int getMinContentWidth()
	{
		return 225;
	}

	protected int getPrefContentHeight(int arg0)
	{
		return 120;
	}

	protected int getPrefContentWidth(int arg0)
	{
		return 225;
	}

	protected void paint(Graphics g, int w, int h)
	{
		g.setColor(0x2b80be);
		g.fillRect(0, 45, 225, 60);

		g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
		g.setColor(0xFFFFFF);
		g.drawString("Lade Daten...", 5, 54, Graphics.TOP | Graphics.LEFT);
	}
}
