package wm.config;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Constants {
	/* Frame parameters */
	public final static int UNITHEIGHT = 100;
	public final static int UNITLONGWIDTH = 500;
	public final static int UNITSHORTWIDTH = 300;
	public final static int NUM_ROW = 26;
	public final static int GLOBAL_WIDTH = 800;
	public final static int GLOBAL_HEIGHT = 600;
	/* String parameters */
	public final static String APPNAME = "WordMaster";
	/* Label */
	public final static int LABEL_TINY = 15;
	public final static int LABEL_SMALL = 20;
	public final static int LABEL_MIDDLE = 30;
	public final static int LABEL_NORMAL = 40;
	public final static int LABEL_LARGE = 70;
	public final static int UNITLINEHEIGHT = 20;
	public final static String LABEL_FONT = "Abandon";
	/* Colors */
	public final static Color LIGHTGREEN = new Color(89, 150, 57);
	public final static Color NORMALGREEN = new Color(78, 137, 47);
	public final static Color DARKGREEN = new Color(54, 96, 43);
	public final static Color NOTEALPHA = new Color(1, 1, 1, 0.5f);
	/* Icon */
	public final static int ICON_TINY = 32;
	public final static int ICON_SMALL = 64;
	public final static int ICON_RECORD = 96;
	public final static int ICON_MIDDLE = 200;
	public final static int ICON_LARGE = 512;
	public final static int ICON_BORDER = 10;
	public final static ImageIcon QUITICON = new ImageIcon("icon/quit-32.png");
	public final static ImageIcon HOMEICON = new ImageIcon("icon/home-32.png");
	public final static ImageIcon NEXTICON = new ImageIcon("icon/next-32.png");
	public final static ImageIcon PIEICON96 = new ImageIcon(new ImageIcon(
			"icon/pie-128.png").getImage().getScaledInstance(ICON_RECORD, ICON_RECORD, Image.SCALE_DEFAULT));
	public final static ImageIcon BARICON96 = new ImageIcon(new ImageIcon(
			"icon/bar-128.png").getImage().getScaledInstance(ICON_RECORD, ICON_RECORD, Image.SCALE_DEFAULT));
	public final static ImageIcon TABLEICON96 = new ImageIcon(new ImageIcon(
			"icon/table-128.png").getImage().getScaledInstance(ICON_RECORD, ICON_RECORD, Image.SCALE_DEFAULT));
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
	public final static String CHIN_CUMSTOMIMPUT = "<html>自定义起点</html>";
	public final static String CHIN_NEXT_TO_CHOOSE_SIZE = "<html>选择背诵单词数量</html>";
	public final static String CHIN_NO_MATCH = "<html>找不到匹配，默认从第一个单词开始！</html>";
	public final static String CHIN_SELECT_SZIE = "<html>选择要背的单词数量</html>";
	public final static String CHIN_COMFIRM_TO_START = "<html>确认并开始背诵</html>";
	public final static String CHIN_RECITING = "<html>正在背诵</html>";
	public final static String CHIN_DICTNAME = "词库名";
	public final static String CHIN_TOTAL = "单词总数";
	public final static String CHIN_RECITED = "已背";
	public final static String CHIN_CORRECT = "正确";
	public final static String CHIN_WRONG = "错误";
	public final static String CHIN_RATE = "正确率";
	public final static String CHIN_CORRECT_WRONG_RATIO = "正确与错误比例";
	public final static String CHIN_RECITE_PIE = "已背饼图";

}