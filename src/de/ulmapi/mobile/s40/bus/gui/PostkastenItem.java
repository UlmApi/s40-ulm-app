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
public class PostkastenItem extends CustomItem
{
	private final String name;
	/*
	private final String street;
	private final String plz;
	private final String tel;
	private final String www;
*/
	public PostkastenItem(String name) //, String street, String plz, String www, String tel)
	{
		super("");
		
		this.name = name;
		/*
		this.street = street;
		this.plz = plz;
		this.tel = tel;
		this.www = www;
		*/
	}

	protected int getMinContentHeight()
	{
		return 90;
	}

	protected int getMinContentWidth()
	{
		return 225;
	}

	protected int getPrefContentHeight(int arg0)
	{
		return 90;
	}

	protected int getPrefContentWidth(int arg0)
	{
		return 225;
	}

	protected void paint(Graphics g, int w, int h)
	{
		g.setColor(0xb20000);
		//g.fillRect(0, 0, 40, 52);
		//g.fillRect(0, 0, 225, 2);

		//g.setColor(210, 210, 210);
		//g.fillRect(5, 2, 225, 28);
		g.fillRect(5, 2, 225, 120);

		//g.setColor(255, 255, 255);
		//g.fillRect(5, 28, 225, 120);

		Font defaultFont = g.getFont();

		//g.setColor(0, 0, 0);
		g.setColor(255, 255, 255);
		Font lineFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
		g.setFont(lineFont);
		g.drawString(name, 20, 6, Graphics.TOP | Graphics.LEFT);

		g.setColor(0x000000);

		/*
		g.setFont(defaultFont);
		g.drawString(street, 20, 28, Graphics.TOP | Graphics.LEFT);
		g.drawString(plz, 20, 48, Graphics.TOP | Graphics.LEFT);

		if (tel.length() > 0)
			g.drawString(tel, 20, 68, Graphics.TOP | Graphics.LEFT);
		else if (www.length() > 0)
			g.drawString(www, 20, 68, Graphics.TOP | Graphics.LEFT);
			*/
	}

}
