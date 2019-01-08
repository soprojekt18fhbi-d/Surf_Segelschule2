package com.testing;

import static org.junit.Assert.*;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.junit.Test;

import com.controller.KundeAnlegenStrg;
import com.model.BuchungAnzeigeModel;
import com.view.KundeAnlegenGUI;



public class PreisberechnungAusleihe {

	
	
	public void testBuchungAnzeige() {
		
		BuchungAnzeigeModel testBuchungAnzeige = new BuchungAnzeigeModel();
		int[] tageStunden = new int[2];
		tageStunden = testBuchungAnzeige.holeTageStunden("2018-12-31 14:34:22", "2019-12-22 14:34:22");
		
		for(int i = 0; i < 2; i++) {
			System.out.println(tageStunden[i]);
		}

		
	}
	
	
	
	
	
	
}
