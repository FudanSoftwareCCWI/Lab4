package wm.config;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Constants {
	/* Frame parameters */
	public final static int UNITHEIGHT = 128;
	public final static int UNITLONGWIDTH = 630;
	public final static int UNITSHORTWIDTH = 394;
	public final static int NUM_ROW = 26;
	public final static int GLOBAL_WIDTH = 1024;
	public final static int GLOBAL_HEIGHT = 768;
	/* String parameters */
	public final static String APPNAME = "WordMaster";
	/* Label */
	public final static int SMALLLABEL = 15;
	public final static int SMALLERLABEL = 25;
	public final static int MIDDLELABEL = 35;
	public final static int NORMALLABEL = 50;
	public final static int LARGELABEL = 80;
	public final static int UNITLINEHEIGHT = 20;
	public final static String LABELFONT = "Abandon";
	/* Colors */
	public final static Color LIGHTGREEN = new Color(89, 150, 57);
	public final static Color NORMALGREEN = new Color(78, 137, 47);
	public final static Color DARKGREEN = new Color(54, 96, 43);
	public final static Color NOTEALPHA = new Color(1, 1, 1, 0.5f);
	/* Icon */
	public final static int ICON_TINY = 32;
	public final static int ICON_SMALL = 64;
	public final static int ICON_MIDDLE = 256;
	public final static int ICON_LARGE = 512;
	public final static int ICON_BORDER = 10;
	public final static ImageIcon QUITICON = new ImageIcon("icon/quit-32.png");
	public final static ImageIcon HOMEICON = new ImageIcon("icon/home-32.png");
	public final static ImageIcon NEXTICON = new ImageIcon("icon/next-32.png");
	public final static ImageIcon PIEICON = new ImageIcon("icon/pie-128.png");
	public final static ImageIcon PIEICON256 = new ImageIcon(new ImageIcon(
			"icon/pie-512.png").getImage().getScaledInstance(ICON_MIDDLE, ICON_MIDDLE, Image.SCALE_DEFAULT));
	/* Command */
	public final static int HOME_TO_STATISTIC = 0;
	public final static int HOME_TO_UNIT = 1;
	public final static int UNIT_TO_HOME = 2;
	/* Chinese */
	public final static String CHIN_STAETBYFIRST = "<html>从第一个<br>单词开始</html>";
	public final static String CHIN_STARTBYLAST = "<html>从上次背到<br的地方开始</html>";
	public final static String CHIN_STARTBYCUSTOM = "<html>自定义<br起点</html>";
	public final static String CHIN_SELECTSTARTMETHOD = "<html>选择背诵起点</html>";

}