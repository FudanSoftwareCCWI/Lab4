package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cmp.*;
import model.MainFrameModel;

public class MainFrame extends MainFrameModel {
	WMView startView;
	WMView statisticView;
	WMView unitView;
	WMView reciteView;
	
	public static void main(String[] args) {
		// Call Constructor
		MainFrame mainFrame = new MainFrame();
	}
	
	/*
	 * MainFrame()
	 * Constructor of Application
	 */
	
	public MainFrame(){
		// init size or something
		super();
		// init components
		initComponent();
		// set listeners
		setListener();
		// init actions
		initActions();
		try{
			// start application
			super.start();
		}catch (Exception e) {
			// Exit with exception
		
		}
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		initStartView();
		
		
		showUnitView();
	}
	
	private void initStartView() {
		// TODO Auto-generated method stub
		startView = new StartView();
		unitView = new UnitView();
		
	}

	private void showStartView() {
		this.getContentPane().removeAll();
		this.getContentPane().add(startView);
	}
	
	private void showUnitView() {
		this.getContentPane().removeAll();
		this.getContentPane().add(unitView);
	}

	private void setListener() {
		// TODO Auto-generated method stub
		
	}
	
	private void initActions() {
		// TODO Auto-generated method stub
		
	}
	
}
