package wm.view.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import wm.config.InterfaceParam;

public class WMLabel extends JLabel implements InterfaceParam {

	public WMLabel(String text, int size) {
		this.setText(text);
		this.setHorizontalAlignment(JLabel.CENTER);;
		this.setFont(new Font(LABELFONT,Font.PLAIN,size));
		this.setForeground(Color.WHITE);
	}
}
