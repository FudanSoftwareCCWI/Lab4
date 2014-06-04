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
public class WMLabel extends JLabel implements Cloneable {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -867913135824250509L;

	public WMLabel(String text, int size) {
		this.setText(text);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font(Constants.LABEL_FONT, Font.PLAIN, size));
		this.setForeground(Color.WHITE);
	}

	public WMLabel clone() {
		WMLabel o = null;
		try {
			o = (WMLabel) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}
