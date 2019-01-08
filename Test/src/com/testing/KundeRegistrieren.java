//package com.testing;
//
//import static org.junit.Assert.*;
//
//import javax.swing.JCheckBox;
//import javax.swing.JTextField;
//
//import org.junit.Test;
//
//import com.controller.KundeAnlegenStrg;
//import com.gui.KundeAnlegenGUI;
//import com.model.KundeAnlegenModel;
//
//
//
//public class KundeRegistrieren {
//	
//	private JTextField txtNname;
//	private JTextField txtVname;
//	private JTextField txtPlzH;
//	private JTextField txtOrtH;
//	private JTextField txtStrasseH;
//	private JTextField txtHnrH;
//	private JTextField txtPlzU;
//	private JTextField txtOrtU;
//	private JTextField txtStrasseU;
//	private JTextField txtHnrU;
//	private JTextField emailTextField;
//	
//	KundeAnlegenModel model;
//	KundeAnlegenStrg controller;
//	
//	@Test
//	public void testKundeAnlegenGUI() {
//		
//		
//		KundeAnlegenGUI kundeAnlegen = new KundeAnlegenGUI(model, controller);
//		
//		txtNname.setText("String");
//		txtVname.setText("String");
//		emailTextField.setText("String");
//		txtPlzH.setText("12345");
//		txtOrtH.setText("String");
//		txtStrasseH.setText("String");
//		txtHnrH.setText("String");
//		txtPlzU.setText("12345");
//		txtOrtU.setText("String");
//		txtStrasseU.setText("String");
//		txtHnrU.setText("String");
//		JCheckBox chckbxSurfschein;
//		JCheckBox chckbxSegelschein;
//		JCheckBox chckbxMotorbootschein;
//		kundeAnlegen.KundeErstellen(chckbxSurfschein, chckbxSegelschein, chckbxMotorbootschein);
//		
//		//assertTrue();
//		//fail("Not yet implemented");
//	}
//
//}
