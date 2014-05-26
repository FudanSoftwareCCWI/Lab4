package config;

import java.awt.Color;

public interface InterfaceParam {
	/* Frame parameters */
	static int UNITHEIGHT = 100;
	static int UNITLONGWIDTH = 450;
	static int UNITSHORTWIDTH = 320;
	static int NUM_ROW = 6;
	static int WIDTH = UNITLONGWIDTH+UNITSHORTWIDTH;
	static int HEIGHT = NUM_ROW*UNITHEIGHT;
	/* String parameters */
	static String APPNAME = "WordMaster";
	/* Label */
	static int SMALLLABEL = 15;
	static int MIDDLELABEL = 35;
	static int LARGELABEL = 80;
	static int UNITLINEHEIGHT = 20;
	static String LABELFONT = "Helvetica";
	/* Colors */
	static Color LIGHTGREEN = new Color(140,224,73);//8ce049
	static Color NORMALGREEN = new Color(89,150,57); //599639
	static Color DARKGREEN = new Color(54,96,43);//36602b
}