package wm.view.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import wm.config.Constants;

/**
 * 
 * @author Sidney Fan
 *
 */
public class WMLabel extends JLabel{

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -867913135824250509L;

	public WMLabel(String text, int size) {
		this.setText(text);
		this.setHorizontalAlignment(JLabel.CENTER);;
		this.setFont(new Font(Constants.LABELFONT,Font.PLAIN,size));
		this.setForeground(Color.WHITE);
	}
}
