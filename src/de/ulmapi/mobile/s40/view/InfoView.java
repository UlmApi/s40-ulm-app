package de.ulmapi.mobile.s40.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.StringItem;

import de.ulmapi.mobile.s40.Main;

public final class InfoView extends Form implements CommandListener, ItemStateListener
{
	private final Main midlet;

	private final Command itemCommand;

	private StringItem stringItem = null;
	private StringItem mitItem = null;
	private StringItem privacyItem = null;

	private Font stdFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);

	//TODO: anpassen
	private final String infoTxt = "Diese Anwendung bietet vereinfachten Zugriff auf einige Datenquellen rund um die Stadt Ulm " + "und wurde im Rahmen des Nokia HackCamps 2012 entwickelt.\n\n" + "Die Anwendung stellt kein offizielles Angebot der Stadt Ulm dar.\n\n" + "Der Quelltext ist zur freien Verwendung unter MIT-Lizenz veröffentlicht:\n\n" + "https://github.com/UlmAPI/s40-ulm-app\n \n";

	//TODO: anpassen
	private final String mitLicense = "Copyright (c) 2012\n\n" + "    Benjamin Erb\n    Michael Müller\n    Juliane Wessalowski\n\n" + "Hiermit wird unentgeltlich, jeder Person, die eine Kopie der Software und der zugehörigen Dokumentationen (die \"Software\") erhält, die Erlaubnis erteilt, uneingeschränkt zu benutzen, inklusive und ohne Ausnahme, dem Recht, sie zu verwenden, kopieren, ändern, fusionieren, verlegen, verbreiten, unterlizenzieren und/oder zu verkaufen, und Personen, die diese Software erhalten, diese Rechte zu geben, unter den folgenden Bedingungen:\n\n" + "Der obige Urheberrechtsvermerk und dieser Erlaubnisvermerk sind in allen Kopien oder Teilkopien der Software beizulegen.\n\n" + "DIE SOFTWARE WIRD OHNE JEDE AUSDRÜCKLICHE ODER IMPLIZIERTE GARANTIE BEREITGESTELLT, EINSCHLIESSLICH DER GARANTIE ZUR BENUTZUNG FÜR DEN VORGESEHENEN ODER EINEM BESTIMMTEN ZWECK SOWIE JEGLICHER RECHTSVERLETZUNG, JEDOCH NICHT DARAUF BESCHRÄNKT. IN KEINEM FALL SIND DIE AUTOREN ODER COPYRIGHTINHABER FÜR JEGLICHEN SCHADEN ODER SONSTIGE ANSPRÜCHE HAFTBAR ZU MACHEN, OB INFOLGE DER ERFÜLLUNG EINES VERTRAGES, EINES DELIKTES ODER ANDERS IM ZUSAMMENHANG MIT DER SOFTWARE ODER SONSTIGER VERWENDUNG DER SOFTWARE ENTSTANDEN.";

	//TODO: anpassen
	private final String privacy = "Diese Anwendung speichert die Favoritenliste lokal im Speicher des Telefons. Für die Orts- und Kartenabfragen sowie die Abfahrtszeiten werden Web-Dienste von Microsoft Corporation und SWU Stadtwerke Ulm/Neu-Ulm GmbH genutzt. Hierfür gelten die dortigen Datenschutzbestimmungen.";

	public InfoView(Main midlet)
	{
		super(Main.INFO_VIEW_TITLE);

		this.midlet = midlet;

		itemCommand = new Command("Zurück", Command.ITEM, 1);

		addCommand(itemCommand);

		stringItem = new StringItem("Über diese Anwendung", infoTxt);
		stringItem.setFont(stdFont);
		append(stringItem);

		//privacyItem = new StringItem("Datenschutz", privacy);
		//privacyItem.setFont(stdFont);
		//append(privacyItem);

		mitItem = new StringItem("Lizenz", mitLicense);
		mitItem.setFont(stdFont);
		append(mitItem);

		setCommandListener(this);
	}

	public void commandAction(Command c, Displayable d)
	{
		if(c == itemCommand)
		{
			midlet.setView(Main.HOME_VIEW);
		}
	}

	public void refresh()
	{
		
	}

	public void itemStateChanged(Item arg0)
	{
		
	}
}