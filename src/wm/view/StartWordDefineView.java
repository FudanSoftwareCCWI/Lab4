package wm.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import wm.config.Constants;
import wm.controller.IReciteProcessController;
import wm.view.component.WMBlock;
import wm.view.component.WMLabel;
import wm.controller.IReciteProcessController;

/**
 * Class StartWordDefineView appears when the user want to start by the input
 * word, the user can input the word he want to start with and go to next stop.
 * 
 * @author Sidney Fan
 * 
 */
public class StartWordDefineView extends ReciteProcessView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3052539781672180377L;

	private WMComboBox searchBox;
	private JButton nextBtn;
	private WMLabel nextTip;
	private int nextTag;
	private static int TOSIZEVIEW = 1;
	private static int TOSTARTBYFIRSTVIEW = 2;

	public StartWordDefineView(IReciteProcessController controller) {
		super(controller);
		addComponents();
		addListener();
	}

	protected void addComponents() {
		setTip(Constants.CHIN_CUMSTOMIMPUT);

		searchBox = new WMComboBox(3 * Constants.UNITHEIGHT,
				Constants.UNITHEIGHT - PADDING);
		nextBtn = new JButton(Constants.NEXTICON);
		nextTip = new WMLabel("", Constants.LABEL_TINY);

		nextBtn.setBorder(null);
		nextBtn.setVisible(false);
		nextTip.setVisible(false);

		centerPanel.add(searchBox);
		centerPanel.add(nextBtn);
		centerPanel.add(nextTip);

		searchBox.setBounds(Constants.GLOBAL_WIDTH / 2
				- (int) (Constants.UNITHEIGHT * 1.5), Constants.UNITHEIGHT
				+ PADDING, 3 * Constants.UNITHEIGHT, 3 * Constants.UNITHEIGHT);
		nextBtn.setBounds((Constants.GLOBAL_WIDTH - Constants.ICON_TINY) / 2, 3
				* Constants.UNITHEIGHT + PADDING, Constants.ICON_TINY,
				Constants.ICON_TINY);
		nextTip.setBounds(0, 3 * Constants.UNITHEIGHT + PADDING + 5,
				Constants.GLOBAL_WIDTH, Constants.UNITHEIGHT);

	}

	protected void addListener() {
		nextTag = 0;
		nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (nextTag == TOSIZEVIEW) {
					controller.startByInput(searchBox.getPrefix()); // version
					
				} else if (nextTag == TOSTARTBYFIRSTVIEW) {
					controller.startByFirstWord();
				}
			}
		});
	}

	/**
	 * 
	 * @param word
	 */
	public void setWordListTextarea(List word) {

	}

	public WMComboBox getSearchBox() {
		return searchBox;
	}

	public void invalidInput() {
		nextBtn.setVisible(true);
		nextTip.setVisible(true);
		nextTip.setText(Constants.CHIN_NO_MATCH);
		nextTag = TOSTARTBYFIRSTVIEW;
	}

	public void validInput() {
		nextBtn.setVisible(true);
		nextTip.setVisible(true);
		nextTip.setText(Constants.CHIN_NEXT_TO_CHOOSE_SIZE);
		nextTag = TOSIZEVIEW;
	}

	protected class WMComboBox extends JComponent {

		JTextField field;
		JScrollPane scrollPane;
		JPanel comboBox;

		int width;
		int height;
		int currentDictIndex;

		List<String> list;

		WMComboBox(int width, int height) {
			this.width = width;
			this.height = height;

			initWMComboBox();
			initComboListener();
		}

		private void initWMComboBox() {
			field = new JTextField();
			comboBox = new JPanel();
			scrollPane = new JScrollPane(comboBox);

			field.setBorder(null);
			scrollPane.setBorder(null);
			scrollPane.getVerticalScrollBar().setUI(null);
			field.setFont(new Font(Constants.LABEL_FONT, Font.PLAIN,
					Constants.LABEL_MIDDLE));
			field.setForeground(Color.WHITE);
			field.setBackground(Constants.NOTEALPHA);

			this.setLayout(null);
			this.add(field);
			this.add(scrollPane);
			field.setBounds(0, 0, width, height);
			scrollPane.setBounds(PADDING / 2, height + 5, width - PADDING,
					2 * height);

			hideComboBox();
		}

		public String getPrefix() {
			return field.getText();
		}

		private void initComboListener() {
			field.addCaretListener(new CaretListener() {

				@Override
				public void caretUpdate(CaretEvent arg0) {
					String text = getPrefix();
					System.out.println(text);
					setComboBox(controller.getAvailableWordList(text));
					// setComboBox(result);
					if (list.contains(text)) {
						validInput();
					} else {
						invalidInput();
					}
				}
			});
		}

		public void setComboBox(List<String> list) {
			this.list = list;
			comboBox.removeAll();
			comboBox.setLayout(new GridLayout(list.size(), 1));
			if (list.size() == 0)
				return;
			WMBlock tempBlock;
			String tempname;
			Iterator<String> it = list.iterator();
			while (it.hasNext()) {
				tempname = it.next();
				tempBlock = new WMBlock(width, 20, 1, 1);
				tempBlock.addLeftLabel(tempname, Constants.LABEL_SMALL);
				tempBlock.setColor(Constants.LIGHTGREEN, Constants.NOTEALPHA);
				comboBox.add(tempBlock);
			}
			comboBox.setPreferredSize(new Dimension(scrollPane.getWidth() - 50,
					list.size() * (Constants.LABEL_SMALL + 3)));
			setListBlockListener();
			showComboBox();
			comboBox.revalidate();
		}

		public void showComboBox() {
			scrollPane.setVisible(true);
		}

		public void hideComboBox() {
			scrollPane.setVisible(false);
		}

		private void setListBlockListener() {
			for (final Component block : comboBox.getComponents()) {
				block.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						setCurrentBlock((WMBlock) block);
						field.setText(list.get(currentDictIndex));
					}
				});
			}
		}

		private void setCurrentBlock(WMBlock clickedBlock) {
			Component[] siblings = comboBox.getComponents();
			int i = 0;
			for (Component block : siblings) {
				if (clickedBlock.equals((WMBlock) block)) {
					this.currentDictIndex = i;
					continue;
				}
				((WMBlock) block).release();
				((WMBlock) block).paintLocal();
				i++;
			}
			clickedBlock.paintPress();
			clickedBlock.fix();
		}

		public JTextField getField() {
			return field;
		}

	}

}
