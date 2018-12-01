package TESTPACKAGE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataModelKlassen.IModel;
import GUI.IView;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestframeMVCBeispiel extends JFrame implements IView{
	
	TestanbindungMVCBEISPIEL model;
	TestController controller;
	JList list = new JList();
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	
	
	public static void main(String[] args) {
		TestanbindungMVCBEISPIEL model = new TestanbindungMVCBEISPIEL();
		TestController controller = new TestController(model);
		TestframeMVCBeispiel testFrame = new TestframeMVCBeispiel(model, controller);
	}

	/**
	 * Create the frame.
	 */
	public TestframeMVCBeispiel(TestanbindungMVCBEISPIEL smodel, TestController scontroller) {
		controller = scontroller;
		model = smodel;
		model.anmelden(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		
		
		
		
		contentPane.add(list, BorderLayout.CENTER);
		
		
		
		JButton btnNewButton = new JButton("getKunden");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controller.fetchKunden();
				
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

	@Override
	public void aktualisieren(IModel model) {
		/**
		 * @author Benkr
		 * Hier aktualisiert das Fenster sich nach jeder Änderung im Model
		 */
		DefaultListModel dlm = new DefaultListModel();
		list.removeAll();
		dlm = model.getKunden();
		list.setModel(dlm);
		
		
		
		
		
		
		
	}
	
	

}
