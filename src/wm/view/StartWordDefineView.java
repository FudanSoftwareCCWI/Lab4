package wm.view;

import java.util.List;


/**
 * Class StartWordDefineView appears when the user want to start
 * by the input word, the user can input the word he want to start
 * with and go to next stop. 
 * 
 * @author Sidney Fan
 * 
 */
<<<<<<< HEAD
public class StartWordDefineView extends WMView {
	
	
=======
public class StartWordDefineView extends ReciteProcessView {
>>>>>>> origin/version2.1

	/**
	 * 
	 */
	private static final long serialVersionUID = -3052539781672180377L;
<<<<<<< HEAD
=======
	
	private WMComboBox searchBox;
	private JButton nextBtn;
	private WMLabel nextTip;
	private int nextTag;
	private static int TOSIZEVIEW = 1;
	private static int TOSTARTBYFIRSTVIEW = 2;
>>>>>>> origin/version2.1

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @param word
	 */
<<<<<<< HEAD
	public void setWordListTextarea(List word){
		
=======
	public void setWordListTextarea(List word) {

	}

	public WMComboBox getSearchBox() {
		return searchBox;
	}

	public void invalidInput() {
		nextBtn.setVisible(true);
		nextTip.setVisible(true);
		nextTip.setText(Constants.CHIN_NO_MATCH);
	}

	public void validInput() {
		nextBtn.setVisible(true);
		nextTip.setVisible(true);
		nextTip.setText(Constants.CHIN_NEXT_TO_CHOOSE_SIZE);
	}

	protected class WMComboBox extends JComponent {

		JTextField field;
		JScrollPane scrollPane;
		JPanel comboBox;

		int width;
		int height;
		int currentDictIndex;

		List<String> list;

		ArrayList<String> result;

		WMComboBox(int width, int height) {
			this.width = width;
			this.height = height;

			result = new ArrayList<String>();
			result.add("abandon");
			result.add("abase");
			result.add("abash");
			result.add("abate");
			result.add("abbreviate");
			result.add("abdicate");

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
					// setComboBox(controller.getAvailableWordList(text)); TODO
					setComboBox(result);
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

>>>>>>> origin/version2.1
	}

}
