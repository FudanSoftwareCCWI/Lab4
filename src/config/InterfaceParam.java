package config;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public interface InterfaceParam {
	/* Frame parameters */
	final static int UNITHEIGHT = 128;
	final static int UNITLONGWIDTH = 630;
	final static int UNITSHORTWIDTH = 394;
	final static int NUM_ROW = 26;
	final static int GLOBAL_WIDTH = 1024;
	final static int GLOBAL_HEIGHT = 768;
	/* String parameters */
	final static String APPNAME = "WordMaster";
	/* Label */
	final static int SMALLLABEL = 15;
	final static int SMALLERLABEL = 25;
	final static int MIDDLELABEL = 35;
	final static int NORMALLABEL = 50;
	final static int LARGELABEL = 80;
	final static int UNITLINEHEIGHT = 20;
	final static String LABELFONT = "Abandon";
	/* Colors */
	final static Color LIGHTGREEN = new Color(89, 150, 57);
	final static Color NORMALGREEN = new Color(78, 137, 47);
	final static Color DARKGREEN = new Color(54, 96, 43);
	final static Color NOTEALPHA = new Color(1, 1, 1, 0.5f);
	/* Icon */
	final static int ICON_TINY = 32;
	final static int ICON_SMALL = 64;
	final static int ICON_LARGE = 512;
	final static ImageIcon QUITICON = new ImageIcon("icon/quit-32.png");
	final static ImageIcon HOMEICON = new ImageIcon("icon/home-32.png");
	final static ImageIcon PIEICON = new ImageIcon("icon/pie-128.png");
	final static ImageIcon PIEICON256 = new ImageIcon(new ImageIcon(
			"icon/pie-512.png").getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT));
	/* Command */
	final static int HOME_TO_STATISTIC = 0;
	final static int HOME_TO_UNIT = 1;
	final static int UNIT_TO_HOME = 2;

}