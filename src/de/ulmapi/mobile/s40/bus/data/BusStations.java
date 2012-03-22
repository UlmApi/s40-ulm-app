package de.ulmapi.mobile.s40.bus.data;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import de.ioexception.me.util.Wgs84Coordinate;

/**
 * Static class for stations.
 * 
 * @author Benjamin Erb
 */
public class BusStations
{
	private static final Hashtable stations = new Hashtable();

	static
	{
		stations.put("9001552", new BusStation(9001552, "Firma Rheinzink", "Donautal", "1552|Firma Rheinzink|Donautal|9001552", new Wgs84Coordinate(48.356118d, 9.925563d)));
		stations.put("9001551", new BusStation(9001551, "Haltepunkt", "Donautal", "1551|Haltepunkt|Donautal|9001551", new Wgs84Coordinate(48.366234d, 9.940214d)));
		stations.put("9001550", new BusStation(9001550, "Firma Nanz", "Donautal", "1550|Firma Nanz|Donautal|9001550", new Wgs84Coordinate(48.367272d, 9.944066d)));
		stations.put("9001555", new BusStation(9001555, "Firma Wieland", "Donautal", "1555|Firma Wieland|Donautal|9001555", new Wgs84Coordinate(48.356394d, 9.944756d)));
		stations.put("9001554", new BusStation(9001554, "Firma UPS", "Donautal", "1554|Firma UPS|Donautal|9001554", new Wgs84Coordinate(48.353468d, 9.927431d)));
		stations.put("9001395", new BusStation(9001395, "Barbaralinde", "Ulm", "1395|Barbaralinde|Ulm|9001395", new Wgs84Coordinate(48.378964d, 9.950560d)));
		stations.put("9001391", new BusStation(9001391, "Oberer Kuhberg", "Ulm", "1391|Oberer Kuhberg|Ulm|9001391", new Wgs84Coordinate(48.381910d, 9.952113d)));
		stations.put("9001390", new BusStation(9001390, "Kuhberg Schulzentrum", "Ulm", "1390|Kuhberg Schulzentrum|Ulm|9001390", new Wgs84Coordinate(48.383247d, 9.954541d)));
		stations.put("9001393", new BusStation(9001393, "Grimmelfinger Weg", "Ulm", "1393|Grimmelfinger Weg|Ulm|9001393", new Wgs84Coordinate(48.381722d, 9.953001d)));
		stations.put("9001392", new BusStation(9001392, "Am Hochstr‰ﬂ", "Ulm", "1392|Am Hochstr‰ﬂ|Ulm|9001392", new Wgs84Coordinate(48.380480d, 9.948766d)));
		stations.put("9001772", new BusStation(9001772, "Danziger Straﬂe", "Ludwigsfeld", "1772|Danziger Straﬂe|Ludwigsfeld|9001772", new Wgs84Coordinate(48.370723d, 10.011037d)));
		stations.put("9001771", new BusStation(9001771, "Oberfeld", "Ludwigsfeld", "1771|Oberfeld|Ludwigsfeld|9001771", new Wgs84Coordinate(48.363744d, 10.011047d)));
		stations.put("9001605", new BusStation(9001605, "Kapelle", "Wiblingen", "1605|Kapelle|Wiblingen|9001605", new Wgs84Coordinate(48.360497d, 9.984128d)));
		stations.put("9001602", new BusStation(9001602, "Alte Siedlung", "Wiblingen", "1602|Alte Siedlung|Wiblingen|9001602", new Wgs84Coordinate(48.353841d, 9.983163d)));
		stations.put("9001601", new BusStation(9001601, "Oberer Wirt", "Wiblingen", "1601|Oberer Wirt|Wiblingen|9001601", new Wgs84Coordinate(48.356201d, 9.985962d)));
		stations.put("9001600", new BusStation(9001600, "Pranger", "Wiblingen", "1600|Pranger|Wiblingen|9001600", new Wgs84Coordinate(48.360362d, 9.988323d)));
		stations.put("9001608", new BusStation(9001608, "Ostermahdweg", "Wiblingen", "1608|Ostermahdweg|Wiblingen|9001608", new Wgs84Coordinate(48.365099d, 9.990695d)));
		stations.put("9001940", new BusStation(9001940, "Winterstraﬂe", "Pfuhl", "1940|Winterstraﬂe|Pfuhl|9001940", new Wgs84Coordinate(48.411880d, 10.043733d)));
		stations.put("9001942", new BusStation(9001942, "Schulzentrum", "Pfuhl", "1942|Schulzentrum|Pfuhl|9001942", new Wgs84Coordinate(48.414209d, 10.053561d)));
		stations.put("9001540", new BusStation(9001540, "Hans-Lorenser-Straﬂe", "Donautal", "1540|Hans-Lorenser-Straﬂe|Donautal|9001540", new Wgs84Coordinate(48.348770d, 9.937815d)));
		stations.put("9001544", new BusStation(9001544, "Firma Sanacorp", "Donautal", "1544|Firma Sanacorp|Donautal|9001544", new Wgs84Coordinate(48.359863d, 9.949367d)));
		stations.put("9001549", new BusStation(9001549, "Firma Merckle/Ratiopharm", "Donautal", "1549|Firma Merckle/Ratiopharm|Donautal|9001549", new Wgs84Coordinate(48.359796d, 9.938948d)));
		stations.put("9001382", new BusStation(9001382, "Egginger Weg", "Ulm", "1382|Egginger Weg|Ulm|9001382", new Wgs84Coordinate(48.385485d, 9.964412d)));
		stations.put("9001383", new BusStation(9001383, "Kˆnigstraﬂe/Gewerbeschulen", "Ulm", "1383|Kˆnigstraﬂe/Gewerbeschulen|Ulm|9001383", new Wgs84Coordinate(48.384714d, 9.960982d)));
		stations.put("9001380", new BusStation(9001380, "Saarlandstraﬂe", "Ulm", "1380|Saarlandstraﬂe|Ulm|9001380", new Wgs84Coordinate(48.387980d, 9.970441d)));
		stations.put("9001381", new BusStation(9001381, "Robert-Dick-Weg", "Ulm", "1381|Robert-Dick-Weg|Ulm|9001381", new Wgs84Coordinate(48.386244d, 9.967248d)));
		stations.put("9002702", new BusStation(9002702, "Galgenbergstraﬂe", "Blaustein", "2702|Galgenbergstraﬂe|Blaustein|9002702", new Wgs84Coordinate(48.414911d, 9.916025d)));
		stations.put("9002701", new BusStation(9002701, "Bahnhof/Rathaus", "Blaustein", "2701|Bahnhof/Rathaus|Blaustein|9002701", new Wgs84Coordinate(48.415503d, 9.918481d)));
		stations.put("9002704", new BusStation(9002704, "Kalte Herberge", "Blaustein", "2704|Kalte Herberge|Blaustein|9002704", new Wgs84Coordinate(48.418261d, 9.908601d)));
		stations.put("9002708", new BusStation(9002708, "Am Blaugarten", "Blaustein", "2708|Am Blaugarten|Blaustein|9002708", new Wgs84Coordinate(48.410934d, 9.929719d)));
		stations.put("9001166", new BusStation(9001166, "Gehrnstraﬂe", "Jungingen (Ulm)", "1166|Gehrnstraﬂe|Jungingen (Ulm)|9001166", new Wgs84Coordinate(48.445771d, 9.992305d)));
		stations.put("9001167", new BusStation(9001167, "Donau-Iller-Werkst‰tten", "Jungingen (Ulm)", "1167|Donau-Iller-Werkst‰tten|Jungingen (Ulm)|9001167", new Wgs84Coordinate(48.447747d, 9.984260d)));
		stations.put("9001164", new BusStation(9001164, "Schwarzenbergstraﬂe", "Jungingen (Ulm)", "1164|Schwarzenbergstraﬂe|Jungingen (Ulm)|9001164", new Wgs84Coordinate(48.448747d, 9.986144d)));
		stations.put("9001165", new BusStation(9001165, "Fichtenstraﬂe", "Jungingen (Ulm)", "1165|Fichtenstraﬂe|Jungingen (Ulm)|9001165", new Wgs84Coordinate(48.449389d, 9.990996d)));
		stations.put("9001162", new BusStation(9001162, "Albstraﬂe", "Jungingen (Ulm)", "1162|Albstraﬂe|Jungingen (Ulm)|9001162", new Wgs84Coordinate(48.434827d, 9.985969d)));
		stations.put("9001163", new BusStation(9001163, "Rathaus", "Jungingen (Ulm)", "1163|Rathaus|Jungingen (Ulm)|9001163", new Wgs84Coordinate(48.442753d, 9.986677d)));
		stations.put("9001160", new BusStation(9001160, "Hˆrvelsinger Weg", "Jungingen (Ulm)", "1160|Hˆrvelsinger Weg|Jungingen (Ulm)|9001160", new Wgs84Coordinate(48.426156d, 9.986220d)));
		stations.put("9001161", new BusStation(9001161, "Franzenhauserweg", "Jungingen (Ulm)", "1161|Franzenhauserweg|Jungingen (Ulm)|9001161", new Wgs84Coordinate(48.429076d, 9.985520d)));
		stations.put("9001768", new BusStation(9001768, "Hafnerweg", "Ludwigsfeld", "1768|Hafnerweg|Ludwigsfeld|9001768", new Wgs84Coordinate(48.366335d, 10.018063d)));
		stations.put("9001769", new BusStation(9001769, "Reichenberger Straﬂe", "Ludwigsfeld", "1769|Reichenberger Straﬂe|Ludwigsfeld|9001769", new Wgs84Coordinate(48.368950d, 10.015240d)));
		stations.put("9001765", new BusStation(9001765, "Hasenweg", "Ludwigsfeld", "1765|Hasenweg|Ludwigsfeld|9001765", new Wgs84Coordinate(48.366949d, 10.010679d)));
		stations.put("9001766", new BusStation(9001766, "Katholische Kirche", "Ludwigsfeld", "1766|Katholische Kirche|Ludwigsfeld|9001766", new Wgs84Coordinate(48.367292d, 10.013520d)));
		stations.put("9001767", new BusStation(9001767, "Allg‰uer Straﬂe", "Ludwigsfeld", "1767|Allg‰uer Straﬂe|Ludwigsfeld|9001767", new Wgs84Coordinate(48.363893d, 10.013493d)));
		stations.put("9001574", new BusStation(9001574, "IVECO", "Donautal", "1574|IVECO|Donautal|9001574", new Wgs84Coordinate(48.359837d, 9.929503d)));
		stations.put("9002710", new BusStation(9002710, "Hofstraﬂe", "Blaustein", "2710|Hofstraﬂe|Blaustein|9002710", new Wgs84Coordinate(48.415152d, 9.922946d)));
		stations.put("9001281", new BusStation(9001281, "Stachelbeerweg", "Ulm", "1281|Stachelbeerweg|Ulm|9001281", new Wgs84Coordinate(48.407526d, 9.956022d)));
		stations.put("9001280", new BusStation(9001280, "Beim T¸rmle", "Ulm", "1280|Beim T¸rmle|Ulm|9001280", new Wgs84Coordinate(48.405774d, 9.956814d)));
		stations.put("9001025", new BusStation(9001025, "Frauenstraﬂe/DRK", "Ulm", "1025|Frauenstraﬂe/DRK|Ulm|9001025", new Wgs84Coordinate(48.406546d, 9.993108d)));
		stations.put("9001020", new BusStation(9001020, "Karlstraﬂe", "Ulm", "1020|Karlstraﬂe|Ulm|9001020", new Wgs84Coordinate(48.404247d, 9.987458d)));
		stations.put("9001594", new BusStation(9001594, "Firma Seeberger", "Donautal", "1594|Firma Seeberger|Donautal|9001594", new Wgs84Coordinate(48.358930d, 9.951307d)));
		stations.put("9001590", new BusStation(9001590, "Kastbr¸cke", "Donautal", "1590|Kastbr¸cke|Donautal|9001590", new Wgs84Coordinate(48.361882d, 9.962873d)));
		stations.put("9001621", new BusStation(9001621, "Fischerhauser Weg", "Wiblingen", "1621|Fischerhauser Weg|Wiblingen|9001621", new Wgs84Coordinate(48.360475d, 9.976233d)));
		stations.put("9001620", new BusStation(9001620, "Erenlauh", "Wiblingen", "1620|Erenlauh|Wiblingen|9001620", new Wgs84Coordinate(48.358459d, 9.971067d)));
		stations.put("9001349", new BusStation(9001349, "J‰gerstraﬂe", "Ulm", "1349|J‰gerstraﬂe|Ulm|9001349", new Wgs84Coordinate(48.400102d, 9.955505d)));
		stations.put("9001964", new BusStation(9001964, "Glˆcklerstraﬂe", "Burlafingen", "1964|Glˆcklerstraﬂe|Burlafingen|9001964", new Wgs84Coordinate(48.416326d, 10.064980d)));
		stations.put("9001962", new BusStation(9001962, "Dorfplatz", "Burlafingen", "1962|Dorfplatz|Burlafingen|9001962", new Wgs84Coordinate(48.415098d, 10.068399d)));
		stations.put("9001961", new BusStation(9001961, "Bahnhof", "Burlafingen", "1961|Bahnhof|Burlafingen|9001961", new Wgs84Coordinate(48.410799d, 10.069336d)));
		stations.put("9001968", new BusStation(9001968, "Schule", "Burlafingen", "1968|Schule|Burlafingen|9001968", new Wgs84Coordinate(48.412627d, 10.070131d)));
		stations.put("9001561", new BusStation(9001561, "Graf-Arco-Straﬂe", "Donautal", "1561|Graf-Arco-Straﬂe|Donautal|9001561", new Wgs84Coordinate(48.358105d, 9.942264d)));
		stations.put("9001366", new BusStation(9001366, "Beim B'scheid", "Ulm", "1366|Beim B'scheid|Ulm|9001366", new Wgs84Coordinate(48.401778d, 9.974296d)));
		stations.put("9001367", new BusStation(9001367, "Auf der Gˆlde", "Ulm", "1367|Auf der Gˆlde|Ulm|9001367", new Wgs84Coordinate(48.400583d, 9.967831d)));
		stations.put("9001360", new BusStation(9001360, "Rˆmerplatz", "Ulm", "1360|Rˆmerplatz|Ulm|9001360", new Wgs84Coordinate(48.390334d, 9.974914d)));
		stations.put("9002728", new BusStation(9002728, "Bahnhof", "Herrlingen", "2728|Bahnhof|Herrlingen|9002728", new Wgs84Coordinate(48.417950d, 9.897774d)));
		stations.put("9002720", new BusStation(9002720, "Lindenstraﬂe", "Blaustein", "2720|Lindenstraﬂe|Blaustein|9002720", new Wgs84Coordinate(48.408435d, 9.935130d)));
		stations.put("9001103", new BusStation(9001103, "Junginger Straﬂe", "Lehr", "1103|Junginger Straﬂe|Lehr|9001103", new Wgs84Coordinate(48.436209d, 9.971616d)));
		stations.put("9001299", new BusStation(9001299, "Sedanstraﬂe", "Ulm", "1299|Sedanstraﬂe|Ulm|9001299", new Wgs84Coordinate(48.392246d, 9.960368d)));
		stations.put("9001296", new BusStation(9001296, "Neunkirchenweg", "Ulm", "1296|Neunkirchenweg|Ulm|9001296", new Wgs84Coordinate(48.386351d, 9.959892d)));
		stations.put("9001297", new BusStation(9001297, "Sulzbachweg", "Ulm", "1297|Sulzbachweg|Ulm|9001297", new Wgs84Coordinate(48.388951d, 9.959671d)));
		stations.put("9001742", new BusStation(9001742, "Dietrich-Kino", "Neu-Ulm", "1742|Dietrich-Kino|Neu-Ulm|9001742", new Wgs84Coordinate(48.383762d, 10.004936d)));
		stations.put("9001743", new BusStation(9001743, "Neue Hochschule", "Neu-Ulm", "1743|Neue Hochschule|Neu-Ulm|9001743", new Wgs84Coordinate(48.379537d, 10.008836d)));
		stations.put("9001741", new BusStation(9001741, "Fachoberschule", "Neu-Ulm", "1741|Fachoberschule|Neu-Ulm|9001741", new Wgs84Coordinate(48.388099d, 10.002673d)));
		stations.put("9001030", new BusStation(9001030, "Kliniken Michelsberg", "Ulm", "1030|Kliniken Michelsberg|Ulm|9001030", new Wgs84Coordinate(48.411237d, 9.992483d)));
		stations.put("9001031", new BusStation(9001031, "Frauensteige", "Ulm", "1031|Frauensteige|Ulm|9001031", new Wgs84Coordinate(48.409618d, 9.990412d)));
		stations.put("9001032", new BusStation(9001032, "Schillerhˆhe", "Ulm", "1032|Schillerhˆhe|Ulm|9001032", new Wgs84Coordinate(48.407719d, 9.988471d)));
		stations.put("9001039", new BusStation(9001039, "Kienlesberg", "Ulm", "1039|Kienlesberg|Ulm|9001039", new Wgs84Coordinate(48.405813d, 9.983152d)));
		stations.put("9001586", new BusStation(9001586, "DEUTZ AG", "Donautal", "1586|DEUTZ AG|Donautal|9001586", new Wgs84Coordinate(48.361606d, 9.933071d)));
		stations.put("9001634", new BusStation(9001634, "Tannenplatz Zentrum", "Wiblingen", "1634|Tannenplatz Zentrum|Wiblingen|9001634", new Wgs84Coordinate(48.351347d, 9.972942d)));
		stations.put("9001635", new BusStation(9001635, "Reutlinger Straﬂe", "Wiblingen", "1635|Reutlinger Straﬂe|Wiblingen|9001635", new Wgs84Coordinate(48.354619d, 9.969982d)));
		stations.put("9001632", new BusStation(9001632, "Kemptener Straﬂe", "Wiblingen", "1632|Kemptener Straﬂe|Wiblingen|9001632", new Wgs84Coordinate(48.346470d, 9.973254d)));
		stations.put("9001633", new BusStation(9001633, "Saulgauer Straﬂe", "Wiblingen", "1633|Saulgauer Straﬂe|Wiblingen|9001633", new Wgs84Coordinate(48.348005d, 9.968278d)));
		stations.put("9001631", new BusStation(9001631, "St.-Gallener-Straﬂe", "Wiblingen", "1631|St.-Gallener-Straﬂe|Wiblingen|9001631", new Wgs84Coordinate(48.349752d, 9.978673d)));
		stations.put("9001087", new BusStation(9001087, "Egertweg", "Ulm", "1087|Egertweg|Ulm|9001087", new Wgs84Coordinate(48.425589d, 10.012139d)));
		stations.put("9001539", new BusStation(9001539, "Ernst-Abbe-Straﬂe", "Donautal", "1539|Ernst-Abbe-Straﬂe|Donautal|9001539", new Wgs84Coordinate(48.350105d, 9.932928d)));
		stations.put("9001359", new BusStation(9001359, "Haﬂlerstraﬂe", "Ulm", "1359|Haﬂlerstraﬂe|Ulm|9001359", new Wgs84Coordinate(48.389648d, 9.978412d)));
		stations.put("9001351", new BusStation(9001351, "Bl¸cherstraﬂe", "Ulm", "1351|Bl¸cherstraﬂe|Ulm|9001351", new Wgs84Coordinate(48.393828d, 9.973293d)));
		stations.put("9001350", new BusStation(9001350, "Ehinger Tor", "Ulm", "1350|Ehinger Tor|Ulm|9001350", new Wgs84Coordinate(48.394661d, 9.981128d)));
		stations.put("9001353", new BusStation(9001353, "Magirusstraﬂe", "Ulm", "1353|Magirusstraﬂe|Ulm|9001353", new Wgs84Coordinate(48.394399d, 9.964216d)));
		stations.put("9001352", new BusStation(9001352, "Westplatz", "Ulm", "1352|Westplatz|Ulm|9001352", new Wgs84Coordinate(48.394725d, 9.968260d)));
		stations.put("9001354", new BusStation(9001354, "Blautal-Center", "Ulm", "1354|Blautal-Center|Ulm|9001354", new Wgs84Coordinate(48.400574d, 9.961416d)));
		stations.put("9001001", new BusStation(9001001, "Steinerne Br¸cke", "Ulm", "1001|Steinerne Br¸cke|Ulm|9001001", new Wgs84Coordinate(48.397186d, 9.987659d)));
		stations.put("9001003", new BusStation(9001003, "Rosengasse", "Ulm", "1003|Rosengasse|Ulm|9001003", new Wgs84Coordinate(48.400416d, 9.996851d)));
		stations.put("9001002", new BusStation(9001002, "Rathaus", "Ulm", "1002|Rathaus|Ulm|9001002", new Wgs84Coordinate(48.397494d, 9.994687d)));
		stations.put("9001005", new BusStation(9001005, "Haus der Begegnung", "Ulm", "1005|Haus der Begegnung|Ulm|9001005", new Wgs84Coordinate(48.397641d, 9.997431d)));
		stations.put("9001004", new BusStation(9001004, "Pauluskirche", "Ulm", "1004|Pauluskirche|Ulm|9001004", new Wgs84Coordinate(48.404784d, 9.995072d)));
		stations.put("9001006", new BusStation(9001006, "G‰nsturm", "Ulm", "1006|G‰nsturm|Ulm|9001006", new Wgs84Coordinate(48.398824d, 10.001020d)));
		stations.put("9001009", new BusStation(9001009, "Hafengasse", "Ulm", "1009|Hafengasse|Ulm|9001009", new Wgs84Coordinate(48.398193d, 9.995957d)));
		stations.put("9001008", new BusStation(9001008, "Hauptbahnhof", "Ulm", "1008|Hauptbahnhof|Ulm|9001008", new Wgs84Coordinate(48.399375d, 9.984122d)));
		stations.put("9001903", new BusStation(9001903, "Ortsstraﬂe", "Offenhausen (Neu-Ulm)", "1903|Ortsstraﬂe|Offenhausen (Neu-Ulm)|9001903", new Wgs84Coordinate(48.401871d, 10.022648d)));
		stations.put("9001906", new BusStation(9001906, "Roseggerstraﬂe", "Offenhausen (Neu-Ulm)", "1906|Roseggerstraﬂe|Offenhausen (Neu-Ulm)|9001906", new Wgs84Coordinate(48.401667d, 10.024413d)));
		stations.put("9001346", new BusStation(9001346, "Franz-Wiedemeier-Straﬂe", "Ulm", "1346|Franz-Wiedemeier-Straﬂe|Ulm|9001346", new Wgs84Coordinate(48.398933d, 9.936914d)));
		stations.put("9001345", new BusStation(9001345, "F¸nf-B‰ume-Weg", "Ulm", "1345|F¸nf-B‰ume-Weg|Ulm|9001345", new Wgs84Coordinate(48.396480d, 9.948645d)));
		stations.put("9001342", new BusStation(9001342, "Clarissenstraﬂe", "Ulm", "1342|Clarissenstraﬂe|Ulm|9001342", new Wgs84Coordinate(48.398970d, 9.953202d)));
		stations.put("9001343", new BusStation(9001343, "Sportzentrum TSG", "Ulm", "1343|Sportzentrum TSG|Ulm|9001343", new Wgs84Coordinate(48.397896d, 9.944876d)));
		stations.put("9001340", new BusStation(9001340, "Riedwiesenweg", "Ulm", "1340|Riedwiesenweg|Ulm|9001340", new Wgs84Coordinate(48.401833d, 9.945152d)));
		stations.put("9001341", new BusStation(9001341, "St.-Jakob-Straﬂe", "Ulm", "1341|St.-Jakob-Straﬂe|Ulm|9001341", new Wgs84Coordinate(48.400497d, 9.950097d)));
		stations.put("9001015", new BusStation(9001015, "Herdbruckerstraﬂe", "Ulm", "1015|Herdbruckerstraﬂe|Ulm|9001015", new Wgs84Coordinate(48.397117d, 9.995652d)));
		stations.put("9001010", new BusStation(9001010, "Theater", "Ulm", "1010|Theater|Ulm|9001010", new Wgs84Coordinate(48.401080d, 9.987694d)));
		stations.put("9001011", new BusStation(9001011, "Justizgeb‰ude", "Ulm", "1011|Justizgeb‰ude|Ulm|9001011", new Wgs84Coordinate(48.402004d, 9.993168d)));
		stations.put("9001651", new BusStation(9001651, "Zollbr¸cke", "Gˆgglingen", "1651|Zollbr¸cke|Gˆgglingen|9001651", new Wgs84Coordinate(48.343084d, 9.941461d)));
		stations.put("9001652", new BusStation(9001652, "Hoher Berg", "Gˆgglingen", "1652|Hoher Berg|Gˆgglingen|9001652", new Wgs84Coordinate(48.338579d, 9.939152d)));
		stations.put("9001653", new BusStation(9001653, "Riedlenstraﬂe", "Gˆgglingen", "1653|Riedlenstraﬂe|Gˆgglingen|9001653", new Wgs84Coordinate(48.335022d, 9.936402d)));
		stations.put("9001102", new BusStation(9001102, "Loherstraﬂe", "Lehr", "1102|Loherstraﬂe|Lehr|9001102", new Wgs84Coordinate(48.432181d, 9.969364d)));
		stations.put("9001939", new BusStation(9001939, "Trissinoplatz", "Pfuhl", "1939|Trissinoplatz|Pfuhl|9001939", new Wgs84Coordinate(48.406859d, 10.033081d)));
		stations.put("9001938", new BusStation(9001938, "Stauffenbergstraﬂe", "Pfuhl", "1938|Stauffenbergstraﬂe|Pfuhl|9001938", new Wgs84Coordinate(48.405658d, 10.030639d)));
		stations.put("9001934", new BusStation(9001934, "Kirchstraﬂe", "Pfuhl", "1934|Kirchstraﬂe|Pfuhl|9001934", new Wgs84Coordinate(48.407819d, 10.042286d)));
		stations.put("9001937", new BusStation(9001937, "Platzgasse", "Pfuhl", "1937|Platzgasse|Pfuhl|9001937", new Wgs84Coordinate(48.408546d, 10.035506d)));
		stations.put("9001936", new BusStation(9001936, "Altes Rathaus", "Pfuhl", "1936|Altes Rathaus|Pfuhl|9001936", new Wgs84Coordinate(48.410251d, 10.039904d)));
		stations.put("9001933", new BusStation(9001933, "Leipheimer Straﬂe", "Pfuhl", "1933|Leipheimer Straﬂe|Pfuhl|9001933", new Wgs84Coordinate(48.407023d, 10.045781d)));
		stations.put("9001333", new BusStation(9001333, "Torstraﬂe", "Ulm", "1333|Torstraﬂe|Ulm|9001333", new Wgs84Coordinate(48.395158d, 9.951955d)));
		stations.put("9001332", new BusStation(9001332, "Maienweg", "Ulm", "1332|Maienweg|Ulm|9001332", new Wgs84Coordinate(48.389744d, 9.948654d)));
		stations.put("9001248", new BusStation(9001248, "Hochschule Eselsberg", "Ulm", "1248|Hochschule Eselsberg|Ulm|9001248", new Wgs84Coordinate(48.418754d, 9.937913d)));
		stations.put("9001247", new BusStation(9001247, "Wilhelm-Runge-Straﬂe", "Ulm", "1247|Wilhelm-Runge-Straﬂe|Ulm|9001247", new Wgs84Coordinate(48.419872d, 9.943041d)));
		stations.put("9001246", new BusStation(9001246, "Uni West", "Ulm", "1246|Uni West|Ulm|9001246", new Wgs84Coordinate(48.421342d, 9.947013d)));
		stations.put("9001245", new BusStation(9001245, "Kliniken Wissenschaftsstadt", "Ulm", "1245|Kliniken Wissenschaftsstadt|Ulm|9001245", new Wgs84Coordinate(48.423580d, 9.950338d)));
		stations.put("9001244", new BusStation(9001244, "Staudingerstraﬂe", "Ulm", "1244|Staudingerstraﬂe|Ulm|9001244", new Wgs84Coordinate(48.424689d, 9.953331d)));
		stations.put("9001241", new BusStation(9001241, "Botanischer Garten", "Ulm", "1241|Botanischer Garten|Ulm|9001241", new Wgs84Coordinate(48.424813d, 9.956739d)));
		stations.put("9001240", new BusStation(9001240, "Universit‰t S¸d", "Ulm", "1240|Universit‰t S¸d|Ulm|9001240", new Wgs84Coordinate(48.421751d, 9.956195d)));
		stations.put("9001061", new BusStation(9001061, "Albecker Steige", "Ulm", "1061|Albecker Steige|Ulm|9001061", new Wgs84Coordinate(48.414201d, 10.004199d)));
		stations.put("9001060", new BusStation(9001060, "Safranberg", "Ulm", "1060|Safranberg|Ulm|9001060", new Wgs84Coordinate(48.412954d, 10.001824d)));
		stations.put("9001066", new BusStation(9001066, "EKZ Haslacher Weg", "Ulm", "1066|EKZ Haslacher Weg|Ulm|9001066", new Wgs84Coordinate(48.430026d, 10.016808d)));
		stations.put("9001744", new BusStation(9001744, "Washingtonallee", "Neu-Ulm", "1744|Washingtonallee|Neu-Ulm|9001744", new Wgs84Coordinate(48.379839d, 10.011299d)));
		stations.put("9001320", new BusStation(9001320, "Krankenhaus Sˆflingen", "Ulm", "1320|Krankenhaus Sˆflingen|Ulm|9001320", new Wgs84Coordinate(48.394947d, 9.948089d)));
		stations.put("9001321", new BusStation(9001321, "Schongauer Weg", "Ulm", "1321|Schongauer Weg|Ulm|9001321", new Wgs84Coordinate(48.393902d, 9.948327d)));
		stations.put("9001322", new BusStation(9001322, "Leonberger Weg", "Ulm", "1322|Leonberger Weg|Ulm|9001322", new Wgs84Coordinate(48.391833d, 9.949476d)));
		stations.put("9001323", new BusStation(9001323, "Gleiﬂelstetten", "Ulm", "1323|Gleiﬂelstetten|Ulm|9001323", new Wgs84Coordinate(48.387970d, 9.947919d)));
		stations.put("9001324", new BusStation(9001324, "F¸nf-B‰ume-Weg Mitte", "Ulm", "1324|F¸nf-B‰ume-Weg Mitte|Ulm|9001324", new Wgs84Coordinate(48.396429d, 9.945038d)));
		stations.put("9001325", new BusStation(9001325, "Maienweg Nord", "Ulm", "1325|Maienweg Nord|Ulm|9001325", new Wgs84Coordinate(48.395061d, 9.945188d)));
		stations.put("9001326", new BusStation(9001326, "Waidstraﬂe", "Ulm", "1326|Waidstraﬂe|Ulm|9001326", new Wgs84Coordinate(48.392796d, 9.951601d)));
		stations.put("9001329", new BusStation(9001329, "Oberer Roter Berg", "Ulm", "1329|Oberer Roter Berg|Ulm|9001329", new Wgs84Coordinate(48.401445d, 9.936555d)));
		stations.put("9001258", new BusStation(9001258, "Sonnenfeld", "Ulm", "1258|Sonnenfeld|Ulm|9001258", new Wgs84Coordinate(48.414180d, 9.937464d)));
		stations.put("9001254", new BusStation(9001254, "Lise-Meitner-Straﬂe", "Ulm", "1254|Lise-Meitner-Straﬂe|Ulm|9001254", new Wgs84Coordinate(48.418763d, 9.935725d)));
		stations.put("9001255", new BusStation(9001255, "Heilmeyersteige", "Ulm", "1255|Heilmeyersteige|Ulm|9001255", new Wgs84Coordinate(48.413725d, 9.950249d)));
		stations.put("9001256", new BusStation(9001256, "Virchowstraﬂe", "Ulm", "1256|Virchowstraﬂe|Ulm|9001256", new Wgs84Coordinate(48.414030d, 9.945986d)));
		stations.put("9001257", new BusStation(9001257, "Sˆflinger Weinberge", "Ulm", "1257|Sˆflinger Weinberge|Ulm|9001257", new Wgs84Coordinate(48.412291d, 9.941928d)));
		stations.put("9001251", new BusStation(9001251, "Kelternweg", "Ulm", "1251|Kelternweg|Ulm|9001251", new Wgs84Coordinate(48.413445d, 9.960065d)));
		stations.put("9001548", new BusStation(9001548, "Firma Meiller", "Donautal", "1548|Firma Meiller|Donautal|9001548", new Wgs84Coordinate(48.361446d, 9.936185d)));
		stations.put("9001078", new BusStation(9001078, "Ludwig-Beck-Straﬂe", "Ulm", "1078|Ludwig-Beck-Straﬂe|Ulm|9001078", new Wgs84Coordinate(48.422395d, 10.007185d)));
		stations.put("9001079", new BusStation(9001079, "Eichenplatz", "Ulm", "1079|Eichenplatz|Ulm|9001079", new Wgs84Coordinate(48.420228d, 10.004075d)));
		stations.put("9001070", new BusStation(9001070, "Ostpreuﬂenweg", "Ulm", "1070|Ostpreuﬂenweg|Ulm|9001070", new Wgs84Coordinate(48.433914d, 10.031670d)));
		stations.put("9001072", new BusStation(9001072, "Mecklenburgweg", "Ulm", "1072|Mecklenburgweg|Ulm|9001072", new Wgs84Coordinate(48.434271d, 10.022893d)));
		stations.put("9001073", new BusStation(9001073, "Th¸ringenweg", "Ulm", "1073|Th¸ringenweg|Ulm|9001073", new Wgs84Coordinate(48.433275d, 10.019616d)));
		stations.put("9001074", new BusStation(9001074, "Haslacher Weg", "Ulm", "1074|Haslacher Weg|Ulm|9001074", new Wgs84Coordinate(48.430206d, 10.013839d)));
		stations.put("9001672", new BusStation(9001672, "Illerkirchberger Straﬂe", "Donaustetten", "1672|Illerkirchberger Straﬂe|Donaustetten|9001672", new Wgs84Coordinate(48.328400d, 9.932397d)));
		stations.put("9001671", new BusStation(9001671, "Wasserturm", "Donaustetten", "1671|Wasserturm|Donaustetten|9001671", new Wgs84Coordinate(48.331444d, 9.932965d)));
		stations.put("9001311", new BusStation(9001311, "Kˆnigstraﬂe", "Ulm", "1311|Kˆnigstraﬂe|Ulm|9001311", new Wgs84Coordinate(48.394470d, 9.961139d)));
		stations.put("9001310", new BusStation(9001310, "Sonnenstraﬂe", "Ulm", "1310|Sonnenstraﬂe|Ulm|9001310", new Wgs84Coordinate(48.394580d, 9.957697d)));
		stations.put("9001864", new BusStation(9001864, "Mutschler", "Neu-Ulm", "1864|Mutschler|Neu-Ulm|9001864", new Wgs84Coordinate(48.395774d, 10.016584d)));
		stations.put("9001261", new BusStation(9001261, "Traminerweg", "Ulm", "1261|Traminerweg|Ulm|9001261", new Wgs84Coordinate(48.411483d, 9.957002d)));
		stations.put("9001260", new BusStation(9001260, "Rul‰nderweg", "Ulm", "1260|Rul‰nderweg|Ulm|9001260", new Wgs84Coordinate(48.409167d, 9.955405d)));
		stations.put("9001265", new BusStation(9001265, "Veltlinerweg", "Ulm", "1265|Veltlinerweg|Ulm|9001265", new Wgs84Coordinate(48.409831d, 9.950257d)));
		stations.put("9001266", new BusStation(9001266, "Ehrensteiner Feld", "Ulm", "1266|Ehrensteiner Feld|Ulm|9001266", new Wgs84Coordinate(48.411188d, 9.948108d)));
		stations.put("9001044", new BusStation(9001044, "Neuer Friedhof", "Ulm", "1044|Neuer Friedhof|Ulm|9001044", new Wgs84Coordinate(48.415883d, 9.986575d)));
		stations.put("9001046", new BusStation(9001046, "Wilhelmsburgkaserne", "Ulm", "1046|Wilhelmsburgkaserne|Ulm|9001046", new Wgs84Coordinate(48.417727d, 9.984396d)));
		stations.put("9001049", new BusStation(9001049, "Congress Centrum", "Ulm", "1049|Congress Centrum|Ulm|9001049", new Wgs84Coordinate(48.401273d, 10.003823d)));
		stations.put("9001048", new BusStation(9001048, "÷rlinger Straﬂe", "Ulm", "1048|÷rlinger Straﬂe|Ulm|9001048", new Wgs84Coordinate(48.408863d, 10.001717d)));
		stations.put("9001232", new BusStation(9001232, "Lehrer Tal", "Ulm", "1232|Lehrer Tal|Ulm|9001232", new Wgs84Coordinate(48.406529d, 9.976102d)));
		stations.put("9001339", new BusStation(9001339, "Am Roten Berg", "Ulm", "1339|Am Roten Berg|Ulm|9001339", new Wgs84Coordinate(48.400774d, 9.940527d)));
		stations.put("9001300", new BusStation(9001300, "Sˆflingen", "Ulm", "1300|Sˆflingen|Ulm|9001300", new Wgs84Coordinate(48.394943d, 9.955071d)));
		stations.put("9001301", new BusStation(9001301, "Ottiliengasse", "Ulm", "1301|Ottiliengasse|Ulm|9001301", new Wgs84Coordinate(48.396666d, 9.955535d)));
		stations.put("9001871", new BusStation(9001871, "Lessingstraﬂe", "Neu-Ulm", "1871|Lessingstraﬂe|Neu-Ulm|9001871", new Wgs84Coordinate(48.396415d, 10.023390d)));
		stations.put("9001052", new BusStation(9001052, "Donaustadion", "Ulm", "1052|Donaustadion|Ulm|9001052", new Wgs84Coordinate(48.404856d, 10.007486d)));
		stations.put("9001053", new BusStation(9001053, "Wohnpark Friedrichsau", "Ulm", "1053|Wohnpark Friedrichsau|Ulm|9001053", new Wgs84Coordinate(48.408386d, 10.008947d)));
		stations.put("9001050", new BusStation(9001050, "Willy-Brandt-Platz", "Ulm", "1050|Willy-Brandt-Platz|Ulm|9001050", new Wgs84Coordinate(48.402608d, 10.000257d)));
		stations.put("9001051", new BusStation(9001051, "Staufenring", "Ulm", "1051|Staufenring|Ulm|9001051", new Wgs84Coordinate(48.403427d, 10.004338d)));
		stations.put("9001054", new BusStation(9001054, "Donauhalle", "Ulm", "1054|Donauhalle|Ulm|9001054", new Wgs84Coordinate(48.411418d, 10.010858d)));
		stations.put("9001058", new BusStation(9001058, "Ostplatz", "Ulm", "1058|Ostplatz|Ulm|9001058", new Wgs84Coordinate(48.405946d, 10.001079d)));
		stations.put("9001059", new BusStation(9001059, "Steinhˆvelstraﬂe", "Ulm", "1059|Steinhˆvelstraﬂe|Ulm|9001059", new Wgs84Coordinate(48.410506d, 10.004140d)));
		stations.put("9001451", new BusStation(9001451, "Kirche Harthausen", "Ulm", "1451|Kirche Harthausen|Ulm|9001451", new Wgs84Coordinate(48.390726d, 9.914038d)));
		stations.put("9001249", new BusStation(9001249, "Science Park II", "Ulm", "1249|Science Park II|Ulm|9001249", new Wgs84Coordinate(48.424578d, 9.937291d)));
		stations.put("9001202", new BusStation(9001202, "Multscherschule", "Ulm", "1202|Multscherschule|Ulm|9001202", new Wgs84Coordinate(48.408607d, 9.967632d)));
		stations.put("9001201", new BusStation(9001201, "Fort Unterer Eselsberg", "Ulm", "1201|Fort Unterer Eselsberg|Ulm|9001201", new Wgs84Coordinate(48.411503d, 9.965445d)));
		stations.put("9001200", new BusStation(9001200, "Eselsberg Hasenkopf", "Ulm", "1200|Eselsberg Hasenkopf|Ulm|9001200", new Wgs84Coordinate(48.414516d, 9.963178d)));
		stations.put("9001422", new BusStation(9001422, "Rathaus", "Eggingen b Ulm", "1422|Rathaus|Eggingen b Ulm|9001422", new Wgs84Coordinate(48.363922d, 9.878942d)));
		stations.put("9001421", new BusStation(9001421, "Ringinger Straﬂe", "Eggingen b Ulm", "1421|Ringinger Straﬂe|Eggingen b Ulm|9001421", new Wgs84Coordinate(48.361037d, 9.879769d)));
		stations.put("9001736", new BusStation(9001736, "Wiley-Club", "Neu-Ulm", "1736|Wiley-Club|Neu-Ulm|9001736", new Wgs84Coordinate(48.381067d, 10.007759d)));
		stations.put("9001735", new BusStation(9001735, "Marlene-Dietrich-Straﬂe", "Neu-Ulm", "1735|Marlene-Dietrich-Straﬂe|Neu-Ulm|9001735", new Wgs84Coordinate(48.384648d, 10.009517d)));
		stations.put("9001734", new BusStation(9001734, "Bradleystraﬂe", "Neu-Ulm", "1734|Bradleystraﬂe|Neu-Ulm|9001734", new Wgs84Coordinate(48.385725d, 10.011820d)));
		stations.put("9001733", new BusStation(9001733, "Riedstraﬂe", "Neu-Ulm", "1733|Riedstraﬂe|Neu-Ulm|9001733", new Wgs84Coordinate(48.387874d, 10.010918d)));
		stations.put("9001732", new BusStation(9001732, "Escheugraben", "Neu-Ulm", "1732|Escheugraben|Neu-Ulm|9001732", new Wgs84Coordinate(48.387908d, 10.005990d)));
		stations.put("9001731", new BusStation(9001731, "Steubenstraﬂe", "Neu-Ulm", "1731|Steubenstraﬂe|Neu-Ulm|9001731", new Wgs84Coordinate(48.390051d, 10.007761d)));
		stations.put("9001210", new BusStation(9001210, "Burgunderweg", "Ulm", "1210|Burgunderweg|Ulm|9001210", new Wgs84Coordinate(48.408820d, 9.961517d)));
		stations.put("9001218", new BusStation(9001218, "Lupferbr¸cke", "Ulm", "1218|Lupferbr¸cke|Ulm|9001218", new Wgs84Coordinate(48.403589d, 9.956813d)));
		stations.put("9001504", new BusStation(9001504, "Maybachstraﬂe", "Donautal", "1504|Maybachstraﬂe|Donautal|9001504", new Wgs84Coordinate(48.361299d, 9.946412d)));
		stations.put("9001506", new BusStation(9001506, "Benzstraﬂe", "Donautal", "1506|Benzstraﬂe|Donautal|9001506", new Wgs84Coordinate(48.366520d, 9.942581d)));
		stations.put("9001507", new BusStation(9001507, "Boschstraﬂe", "Donautal", "1507|Boschstraﬂe|Donautal|9001507", new Wgs84Coordinate(48.371010d, 9.954285d)));
		stations.put("9001500", new BusStation(9001500, "Steinbeisstraﬂe", "Donautal", "1500|Steinbeisstraﬂe|Donautal|9001500", new Wgs84Coordinate(48.368617d, 9.953350d)));
		stations.put("9001501", new BusStation(9001501, "Liststraﬂe", "Donautal", "1501|Liststraﬂe|Donautal|9001501", new Wgs84Coordinate(48.369639d, 9.949306d)));
		stations.put("9001502", new BusStation(9001502, "Daimlerstraﬂe", "Donautal", "1502|Daimlerstraﬂe|Donautal|9001502", new Wgs84Coordinate(48.366813d, 9.952898d)));
		stations.put("9001503", new BusStation(9001503, "Heuweg", "Donautal", "1503|Heuweg|Donautal|9001503", new Wgs84Coordinate(48.364653d, 9.951967d)));
		stations.put("9001431", new BusStation(9001431, "Allewind", "Ermingen", "1431|Allewind|Ermingen|9001431", new Wgs84Coordinate(48.376577d, 9.892699d)));
		stations.put("9001432", new BusStation(9001432, "Panoramastraﬂe", "Ermingen", "1432|Panoramastraﬂe|Ermingen|9001432", new Wgs84Coordinate(48.377860d, 9.896488d)));
		stations.put("9001433", new BusStation(9001433, "Waldstraﬂe", "Ermingen", "1433|Waldstraﬂe|Ermingen|9001433", new Wgs84Coordinate(48.381906d, 9.897760d)));
		stations.put("9001724", new BusStation(9001724, "Memminger Straﬂe", "Neu-Ulm", "1724|Memminger Straﬂe|Neu-Ulm|9001724", new Wgs84Coordinate(48.385156d, 10.003938d)));
		stations.put("9001725", new BusStation(9001725, "Edisoncenter", "Neu-Ulm", "1725|Edisoncenter|Neu-Ulm|9001725", new Wgs84Coordinate(48.379277d, 10.006765d)));
		stations.put("9001723", new BusStation(9001723, "Gartenstraﬂe", "Neu-Ulm", "1723|Gartenstraﬂe|Neu-Ulm|9001723", new Wgs84Coordinate(48.392755d, 9.999847d)));
		stations.put("9001729", new BusStation(9001729, "Meininger Allee", "Neu-Ulm", "1729|Meininger Allee|Neu-Ulm|9001729", new Wgs84Coordinate(48.395163d, 10.008348d)));
		stations.put("9001528", new BusStation(9001528, "Gasthof Donautal", "Donautal", "1528|Gasthof Donautal|Donautal|9001528", new Wgs84Coordinate(48.375119d, 9.955523d)));
		stations.put("9001225", new BusStation(9001225, "Bleicher Hag", "Ulm", "1225|Bleicher Hag|Ulm|9001225", new Wgs84Coordinate(48.405972d, 9.971837d)));
		stations.put("9001220", new BusStation(9001220, "Bahnhof Sˆflingen", "Ulm", "1220|Bahnhof Sˆflingen|Ulm|9001220", new Wgs84Coordinate(48.402765d, 9.958621d)));
		stations.put("9001222", new BusStation(9001222, "Beringerbr¸cke", "Ulm", "1222|Beringerbr¸cke|Ulm|9001222", new Wgs84Coordinate(48.404687d, 9.966423d)));
		stations.put("9001081", new BusStation(9001081, "Eichberg", "Ulm", "1081|Eichberg|Ulm|9001081", new Wgs84Coordinate(48.422967d, 10.005493d)));
		stations.put("9001080", new BusStation(9001080, "Eugen-Bolz-Straﬂe", "Ulm", "1080|Eugen-Bolz-Straﬂe|Ulm|9001080", new Wgs84Coordinate(48.420368d, 10.017764d)));
		stations.put("9001083", new BusStation(9001083, "Alfred-Delp-Weg", "Ulm", "1083|Alfred-Delp-Weg|Ulm|9001083", new Wgs84Coordinate(48.423206d, 10.014172d)));
		stations.put("9001082", new BusStation(9001082, "Eichberg Nord", "Ulm", "1082|Eichberg Nord|Ulm|9001082", new Wgs84Coordinate(48.425860d, 10.006929d)));
		stations.put("9001532", new BusStation(9001532, "Siemensstraﬂe", "Donautal", "1532|Siemensstraﬂe|Donautal|9001532", new Wgs84Coordinate(48.362284d, 9.954622d)));
		stations.put("9001534", new BusStation(9001534, "Voithstraﬂe", "Donautal", "1534|Voithstraﬂe|Donautal|9001534", new Wgs84Coordinate(48.367523d, 9.956191d)));
		stations.put("9001404", new BusStation(9001404, "Erbacher Straﬂe", "Grimmelfingen", "1404|Erbacher Straﬂe|Grimmelfingen|9001404", new Wgs84Coordinate(48.366825d, 9.940508d)));
		stations.put("9001401", new BusStation(9001401, "H‰berlinweg", "Grimmelfingen", "1401|H‰berlinweg|Grimmelfingen|9001401", new Wgs84Coordinate(48.373203d, 9.941287d)));
		stations.put("9001400", new BusStation(9001400, "Rathausstraﬂe", "Grimmelfingen", "1400|Rathausstraﬂe|Grimmelfingen|9001400", new Wgs84Coordinate(48.371852d, 9.936106d)));
		stations.put("9001403", new BusStation(9001403, "Eisenbahnstraﬂe", "Grimmelfingen", "1403|Eisenbahnstraﬂe|Grimmelfingen|9001403", new Wgs84Coordinate(48.370271d, 9.937022d)));
		stations.put("9001710", new BusStation(9001710, "Rathaus", "Neu-Ulm", "1710|Rathaus|Neu-Ulm|9001710", new Wgs84Coordinate(48.395202d, 10.000746d)));
		stations.put("9001713", new BusStation(9001713, "Augsburger Tor", "Neu-Ulm", "1713|Augsburger Tor|Neu-Ulm|9001713", new Wgs84Coordinate(48.398055d, 10.004664d)));
		stations.put("9001714", new BusStation(9001714, "Kasernstraﬂe", "Neu-Ulm", "1714|Kasernstraﬂe|Neu-Ulm|9001714", new Wgs84Coordinate(48.396705d, 10.006785d)));
		stations.put("9001719", new BusStation(9001719, "Waldeck", "Neu-Ulm", "1719|Waldeck|Neu-Ulm|9001719", new Wgs84Coordinate(48.394330d, 10.009979d)));
		stations.put("9001412", new BusStation(9001412, "Ensostraﬂe", "Einsingen", "1412|Ensostraﬂe|Einsingen|9001412", new Wgs84Coordinate(48.352517d, 9.905744d)));
		stations.put("9001413", new BusStation(9001413, "Hirsch", "Einsingen", "1413|Hirsch|Einsingen|9001413", new Wgs84Coordinate(48.352273d, 9.900167d)));
		stations.put("9001414", new BusStation(9001414, "Kirche", "Einsingen", "1414|Kirche|Einsingen|9001414", new Wgs84Coordinate(48.354120d, 9.895140d)));
		stations.put("9002761", new BusStation(9002761, "Gasthof Blautal", "Arnegg b Ulm", "2761|Gasthof Blautal|Arnegg b Ulm|9002761", new Wgs84Coordinate(48.415479d, 9.881317d)));
		stations.put("9002763", new BusStation(9002763, "Bildstˆckle", "Arnegg b Ulm", "2763|Bildstˆckle|Arnegg b Ulm|9002763", new Wgs84Coordinate(48.413331d, 9.874052d)));
		stations.put("9001097", new BusStation(9001097, "Neutorstraﬂe", "Ulm", "1097|Neutorstraﬂe|Ulm|9001097", new Wgs84Coordinate(48.402846d, 9.986161d)));
		stations.put("9001092", new BusStation(9001092, "Im Lehrer Feld West", "Lehr", "1092|Im Lehrer Feld West|Lehr|9001092", new Wgs84Coordinate(48.453659d, 9.967934d)));
		stations.put("9001093", new BusStation(9001093, "Im Lehrer Feld S¸d", "Lehr", "1093|Im Lehrer Feld S¸d|Lehr|9001093", new Wgs84Coordinate(48.452043d, 9.970797d)));
		stations.put("9001090", new BusStation(9001090, "Eiselauer Weg", "Lehr", "1090|Eiselauer Weg|Lehr|9001090", new Wgs84Coordinate(48.452255d, 9.973477d)));
		stations.put("9001091", new BusStation(9001091, "Im Lehrer Feld Nord", "Lehr", "1091|Im Lehrer Feld Nord|Lehr|9001091", new Wgs84Coordinate(48.455079d, 9.970233d)));
		stations.put("9001708", new BusStation(9001708, "Petrusplatz", "Neu-Ulm", "1708|Petrusplatz|Neu-Ulm|9001708", new Wgs84Coordinate(48.394612d, 9.998290d)));
		stations.put("9001706", new BusStation(9001706, "Sch¸tzenstraﬂe", "Neu-Ulm", "1706|Sch¸tzenstraﬂe|Neu-Ulm|9001706", new Wgs84Coordinate(48.393683d, 9.997610d)));
		stations.put("9001707", new BusStation(9001707, "Donaucenter", "Neu-Ulm", "1707|Donaucenter|Neu-Ulm|9001707", new Wgs84Coordinate(48.394344d, 9.997043d)));
		stations.put("9001704", new BusStation(9001704, "Illerbr¸cke", "Neu-Ulm", "1704|Illerbr¸cke|Neu-Ulm|9001704", new Wgs84Coordinate(48.372680d, 9.989695d)));
		stations.put("9001705", new BusStation(9001705, "Amtsgericht", "Neu-Ulm", "1705|Amtsgericht|Neu-Ulm|9001705", new Wgs84Coordinate(48.391803d, 9.994522d)));
		stations.put("9001702", new BusStation(9001702, "Atlantis", "Neu-Ulm", "1702|Atlantis|Neu-Ulm|9001702", new Wgs84Coordinate(48.385149d, 9.987088d)));
		stations.put("9001703", new BusStation(9001703, "Jakobsruhe", "Neu-Ulm", "1703|Jakobsruhe|Neu-Ulm|9001703", new Wgs84Coordinate(48.381644d, 9.989909d)));
		stations.put("9001700", new BusStation(9001700, "ZUP", "Neu-Ulm", "1700|ZUP|Neu-Ulm|9001700", new Wgs84Coordinate(48.392097d, 10.003129d)));
		stations.put("9001701", new BusStation(9001701, "Donaubad", "Neu-Ulm", "1701|Donaubad|Neu-Ulm|9001701", new Wgs84Coordinate(48.388616d, 9.988694d)));
	}

	/**
	 * Returns a bus station by station id or null, if not found.
	 * 
	 * @param id
	 * @return
	 */
	public static BusStation getStation(int id)
	{
		return (BusStation) stations.get("" + id);
	}
	
	public static BusStation getDefaultStation(){
		return getStation(9001008);
	}

	/**
	 * Returns stations that contain the given prefix, result list is limited
	 * 
	 * @param prefix
	 * @param limit
	 * @return a vector of {@link BusStation}s
	 */
	public static Vector getStationsByPrefix(String prefix, int limit)
	{
		Vector hits = new Vector();
		
		for(Enumeration e = stations.keys(); e.hasMoreElements() && hits.size() < limit;)
		{
			String id = (String) e.nextElement();
			BusStation station = (BusStation) stations.get(id);
			
			if(station.contains(prefix))
			{
				hits.addElement(station);
			}
		}
		
		return hits;
	}

	
}
