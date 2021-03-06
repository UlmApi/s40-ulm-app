package de.ulmapi.mobile.s40.view;

import java.io.IOException;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import de.ulmapi.mobile.s40.Main;


public final class HomeView extends Canvas implements CommandListener
{
	private final Main midlet;

	private int selected;

	private Image imageStationListView;
//	private Image imageFavoriteListView;
	private Image imageMapSearchView;
	private Image imageGeocodingSearchView;
	private Image imagePostboxView;


	private Command help2Command;
	private Command itemCommand;
	private Command exitCommand;

	private boolean pressedField = false;

	public HomeView(Main midlet)
	{
		super();

		this.midlet = midlet;

		setTitle(Main.HOME_VIEW_TITLE);

		//help2Command = new Command("Informationen", Command.HELP, 1);
		itemCommand = new Command("OK", Command.ITEM, 1);
		exitCommand = new Command("Ende", Command.EXIT, 1);

		
		//addCommand(help2Command);
		addCommand(itemCommand);
		addCommand(exitCommand);
		setCommandListener(this);

		selected = Main.STATION_LIST_VIEW;

		try
		{
			imageStationListView = Image.createImage("/stationListView.png");
//			imageFavoriteListView = Image.createImage("/favoriteListView.png");
			imageMapSearchView = Image.createImage("/mapSearchView.png");
			imageGeocodingSearchView = Image.createImage("/geocodingSearchView.png");
			imagePostboxView = Image.createImage("/postboxView.png");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	protected void paint(Graphics g)
	{
		g.setColor(0xFAFAFA);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(0xDDDDDD);
		g.setStrokeStyle(Graphics.SOLID);
		g.drawLine(0, 0, getWidth(), 0);

		if(!pressedField)
		{
			g.setColor(0xE5E5E5);
		}
		else
		{
			pressedField = false;
			g.setColor(0xBCBCBC);
		}
		
		//TODO: fix menu rendering when menu is final

		if(selected == Main.STATION_LIST_VIEW)
		{
			g.fillRect(0, 1, getWidth() / 2, getHeight() / 2);
		}
		else if(selected == Main.POSTBOX_VIEW)
		{
			g.fillRect(getWidth() / 2 + 1, 1, getWidth(), getHeight() / 2);
		}
		else if(selected == Main.OPENTIMES_VIEW)
		{
			g.fillRect(0, getHeight() / 2 + 1, getWidth() / 2, getHeight());
		}
//		else if(selected == Main.GEOCODING_SEARCH_VIEW)
//		{
//			g.fillRect(getWidth() / 2 + 1, getHeight() / 2 + 1, getWidth(), getHeight());
//		}

		g.setColor(0x000000);
		g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
		g.drawImage(imageStationListView, 60, 40, Graphics.HCENTER | Graphics.VCENTER);
		g.drawString(Main.STATION_LIST_VIEW_TITLE, 60, 80, Graphics.HCENTER | Graphics.TOP);
		
		g.drawImage(imagePostboxView, 180, 40, Graphics.HCENTER | Graphics.VCENTER);
		g.drawString(Main.POSTBOX_VIEW_TITLE, 180, 80, Graphics.HCENTER | Graphics.TOP);
		
		g.drawImage(imageMapSearchView, 60, 160, Graphics.HCENTER | Graphics.VCENTER);
		g.drawString(Main.OPENTIMES_VIEW_TITLE, 60, 200, Graphics.HCENTER | Graphics.TOP);
		
		g.drawImage(imageGeocodingSearchView, 180, 160, Graphics.HCENTER | Graphics.VCENTER);
		g.drawString(Main.INFO_VIEW_TITLE, 180, 200, Graphics.HCENTER | Graphics.TOP);
	}

	public void commandAction(Command c, Displayable d)
	{
		/*if(c == help2Command)
		{
			midlet.setView(Main.INFO_VIEW);
		}
		else 
		*/if(c == itemCommand)
		{
			pressedField = true;
			repaint();
			serviceRepaints();
			midlet.setView(selected);
		}
		else if(c == exitCommand)
		{
			midlet.destroyApp(false);
			midlet.notifyDestroyed();
		}
	}

	public void pointerPressed(int x, int y)
	{
		//TODO: fix touch navigation when navigation is final
		
		pressedField = true;

		if(x <= getWidth() / 2 && y > 0 && y <= getHeight() / 2)
		{
			selected = Main.STATION_LIST_VIEW;
			repaint();
			serviceRepaints();
			midlet.setView(selected);
		}
		else if(x > getWidth() / 2 && y > 0 && y <= getHeight() / 2)
		{
			selected = Main.POSTBOX_VIEW;
			repaint();
			serviceRepaints();
			//PostboxView postboxView = (PostboxView) midlet.getView(Main.POSTBOX_VIEW);
			//PostkastenView postboxView = (PostkastenView) midlet.getView(Main.POSTBOX_VIEW);
			//postboxView.updatePostboxes();
			//postboxView.showPostboxes();
			midlet.setView(selected);
		}
		else if(x <= getWidth() / 2 && y > getHeight() / 2 && y <= getHeight())
		{
			selected = Main.OPENTIMES_VIEW;
			repaint();
			serviceRepaints();
			//((OpentimesView) midlet.getView(selected)).isChangeOriginHome(true);
			midlet.setView(selected);
		}
		else if(x > getWidth() / 2 && y > getHeight() / 2 && y <= getHeight())
		{
//			selected = Main.GEOCODING_SEARCH_VIEW;
			selected = Main.INFO_VIEW;
			repaint();
			serviceRepaints();
			midlet.setView(selected);
		}
	}

	public void keyPressed(int keyCode)
	{
		//TODO: fix keypad navigation when menu is final
		
		if(keyCode == Canvas.KEY_NUM5 || keyCode == Canvas.FIRE)
		{
			pressedField = true;
			repaint();
			serviceRepaints();
			midlet.setView(selected);
		}
		else if(keyCode == Canvas.KEY_NUM2 || keyCode == Canvas.UP || keyCode == Canvas.KEY_NUM8 || keyCode == Canvas.DOWN)
		{
//			if(selected == Main.STATION_LIST_VIEW)
//			{
//				selected = Main.MAP_SEARCH_VIEW;
//			}
//			else if(selected == Main.FAVORITE_LIST_VIEW)
//			{
//				selected = Main.GEOCODING_SEARCH_VIEW;
//			}
//			else if(selected == Main.MAP_SEARCH_VIEW)
//			{
//				selected = Main.STATION_LIST_VIEW;
//			}
//			else if(selected == Main.GEOCODING_SEARCH_VIEW)
//			{
//				selected = Main.FAVORITE_LIST_VIEW;
//			}

			repaint();
		}
		else if(keyCode == Canvas.KEY_NUM4 || keyCode == Canvas.LEFT || keyCode == Canvas.KEY_NUM6 || keyCode == Canvas.RIGHT)
		{
//			if(selected == Main.STATION_LIST_VIEW)
//			{
//				selected = Main.FAVORITE_LIST_VIEW;
//			}
//			else if(selected == Main.FAVORITE_LIST_VIEW)
//			{
//				selected = Main.STATION_LIST_VIEW;
//			}
//			else if(selected == Main.MAP_SEARCH_VIEW)
//			{
//				selected = Main.GEOCODING_SEARCH_VIEW;
//			}
//			else if(selected == Main.GEOCODING_SEARCH_VIEW)
//			{
//				selected = Main.MAP_SEARCH_VIEW;
//			}

			repaint();
		}
	}
}