package wm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import wm.config.Constants;
import wm.controller.IReciteProcessController;
import wm.view.component.WMLabel;

/**
 * Class StartSelectView represents three ways to start recite, the user can
 * choose what he want and go to next step.
 * 
 * @author Sidney Fan
 * 
 */
public class StartSelectView extends ReciteProcessView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4531368146481645750L;

	/* Components */
	/* Button */
	private SelectButton startByFirstBtn;
	private SelectButton startByLastBtn;
	private SelectButton startByCustomBtn;

	/**
	 * <b>StartSelectView</b>
	 * 
	 * <pre>
	 * <code>public StartSelectView(IReciteProcessController controller)</code>
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * Constructor of home view.
	 * </p>
	 * 
	 * @param controller
	 *            -controller of home view
	 * 
	 */
	public StartSelectView(IReciteProcessController controller) {
		super(controller);
		addComponents();
		addListener();
	}

	protected void addComponents() {
		// selector
		startByFirstBtn = new SelectButton(Constants.CHIN_STAETBYFIRST);
		startByLastBtn = new SelectButton(Constants.CHIN_STARTBYLAST);
		startByCustomBtn = new SelectButton(Constants.CHIN_STARTBYCUSTOM);
		
		centerPanel.add(startByFirstBtn);
		centerPanel.add(startByLastBtn);
		centerPanel.add(startByCustomBtn);
		
		startByFirstBtn.setBounds(PADDING, Constants.UNITHEIGHT + PADDING,
				Constants.ICON_MIDDLE, Constants.ICON_MIDDLE);
		startByLastBtn.setBounds(
				(Constants.GLOBAL_WIDTH - Constants.ICON_MIDDLE) / 2,
				Constants.UNITHEIGHT + PADDING, Constants.ICON_MIDDLE,
				Constants.ICON_MIDDLE);
		startByCustomBtn.setBounds(Constants.GLOBAL_WIDTH
				- Constants.ICON_MIDDLE - PADDING, Constants.UNITHEIGHT
				+ PADDING, Constants.ICON_MIDDLE, Constants.ICON_MIDDLE);
		
		setTip(Constants.CHIN_SELECTSTARTMETHOD);

	}

	protected void addListener() {
		
		startByFirstBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.startByFirstWord();
				
			}
		});
		
		startByLastBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.startByLastTime();
			}

		});
		startByCustomBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.switchToStartWordDefine();
			}

		});
	}

	public class SelectButton extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7507522887537228688L;
		private boolean hover;
		private WMLabel textLabel;
		
		public SelectButton(String text) {
			super();
			textLabel = new WMLabel(text,Constants.LABEL_SMALL);
			textLabel.setForeground(Constants.NORMALGREEN);
			this.setBackground(Constants.LIGHTGREEN);
			this.setLayout(null);
			this.add(textLabel);
			textLabel.setBounds(0, 0, Constants.ICON_MIDDLE, Constants.ICON_MIDDLE);
			hover = false;
			setMouseAction();
		}

		private void setMouseAction() {
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent arg0) {
					SelectButton.this.setForeground(Constants.NORMALGREEN);
					hover = false;
					textLabel.setForeground(Constants.NORMALGREEN);
					repaint();
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					SelectButton.this.setForeground(Color.WHITE);
					hover = true;
					textLabel.setForeground(Color.WHITE);
					repaint();
				}
			});
			
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (hover) {
				g.setColor(Constants.NORMALGREEN);
				g.fillArc(0, 0, Constants.ICON_MIDDLE, Constants.ICON_MIDDLE, 0,
						360);
				g.setColor(Constants.DARKGREEN);
				g.fillArc(Constants.ICON_BORDER, Constants.ICON_BORDER,
						Constants.ICON_MIDDLE - 2 * Constants.ICON_BORDER,
						Constants.ICON_MIDDLE - 2 * Constants.ICON_BORDER, 0, 360);
	        } else {
	        	g.setColor(Constants.NORMALGREEN);
				g.fillArc(0, 0, Constants.ICON_MIDDLE, Constants.ICON_MIDDLE, 0,
						360);
				g.setColor(Color.WHITE);
				g.fillArc(Constants.ICON_BORDER, Constants.ICON_BORDER,
						Constants.ICON_MIDDLE - 2 * Constants.ICON_BORDER,
						Constants.ICON_MIDDLE - 2 * Constants.ICON_BORDER, 0, 360);
	        }
			
			
		}
	}

	public SelectButton getStartByFirstBtn() {
		return startByFirstBtn;
	}

	public SelectButton getStartByLastBtn() {
		return startByLastBtn;
	}

	public SelectButton getStartByCustomBtn() {
		return startByCustomBtn;
	}
	
	
}
