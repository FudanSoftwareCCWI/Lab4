package wm.view.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import wm.config.Constants;

public class WMListBox extends JComponent {

	private JTextField field;
	private JScrollPane scrollPane;
	private JPanel comboBox;

	private int width;
	private int height;
	private int currentIndex;
	private boolean isComboShow;
	/* Dictionary list */
	private List<String> dictist;

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public void setDictist(List<String> dictist) {
		this.dictist = dictist;
		field.setText(dictist.get(currentIndex));
	}

	public WMListBox(int width, int height) {
		this.width = width;
		this.height = height;
		this.isComboShow = false;

		initWMComboBox();
		initComboListener();
	}

	private void initWMComboBox() {
		field = new JTextField();
		comboBox = new JPanel();
		scrollPane = new JScrollPane(comboBox);

		field.setBorder(new MatteBorder(1, 0, 1, 0, Color.WHITE));
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUI(null);
		field.setFont(new Font(Constants.LABEL_FONT, Font.PLAIN,
				Constants.LABEL_TINY));
		field.setForeground(Color.WHITE);
		field.setBackground(new Color(0, 0, 0, 0));
		field.setEditable(false);

		this.setLayout(null);
		this.add(field);
		this.add(scrollPane);
		field.setBounds(0, 0, width, height);
		scrollPane.setBounds(0, height + 5, width, 2 * height);
		hideComboBox();
	}

	public String getPrefix() {
		return field.getText();
	}

	private void initComboListener() {
		field.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (isComboShow) {
					hideComboBox();
				} else {
					setComboBox();
				}
			}
		});
	}

	public void setComboBox() {
		comboBox.removeAll();
		comboBox.setLayout(new GridLayout(dictist.size(), 1));
		if (dictist.size() == 0)
			return;
		WMBlock tempBlock;
		String tempname;
		Iterator<String> it = dictist.iterator();
		while (it.hasNext()) {
			tempname = it.next();
			tempBlock = new WMBlock(width, 20, 1, 1);
			tempBlock.addLeftLabel(tempname, Constants.LABEL_TINY);
			tempBlock.setColor(Constants.LIGHTGREEN, Constants.NOTEALPHA);
			comboBox.add(tempBlock);
		}
		comboBox.setPreferredSize(new Dimension(scrollPane.getWidth() - 50,
				dictist.size() * (Constants.LABEL_SMALL + 3)));
		setListBlockListener();
		showComboBox();
	}

	public void showComboBox() {
		isComboShow = true;
		scrollPane.setVisible(true);
	}

	public void hideComboBox() {
		isComboShow = false;
		scrollPane.setVisible(false);
	}

	private void setListBlockListener() {
		for (final Component block : comboBox.getComponents()) {
			block.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int oldIndex = currentIndex;
					setCurrentBlock((WMBlock) block);
					field.setText(dictist.get(currentIndex));
					// Fire chosen
					System.out.println("WMListBox:" +Constants.PROPERTY_DICTCHANGE);
					WMListBox.this.firePropertyChange(
							Constants.PROPERTY_DICTCHANGE,
							new Integer(oldIndex), new Integer(currentIndex));
				}
			});
		}
	}

	private void setCurrentBlock(WMBlock clickedBlock) {
		Component[] siblings = comboBox.getComponents();
		int i = 0;
		for (Component block : siblings) {
			if (clickedBlock.equals((WMBlock) block)) {
				this.currentIndex = i;
				continue;
			}
			((WMBlock) block).release();
			((WMBlock) block).paintLocal();
			i++;
		}
		clickedBlock.paintPress();
		clickedBlock.fix();
		hideComboBox();
	}

	protected JTextField getField() {
		return field;
	}

	protected void setText(String text) {
		field.setText(text);
	}

}