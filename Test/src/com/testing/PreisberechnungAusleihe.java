package com.testing;

import static org.junit.Assert.*;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Test;

import Datenbankmodels.BuchungAnzeigeModel;
import GUI.KundeAnlegenGUI;
import Steuerung.KundeAnlegenStrg;



public class PreisberechnungAusleihe {

	
	@Test
	public void testBuchungAnzeige() {
		
		BuchungAnzeigeModel testBuchungAnzeige = new BuchungAnzeigeModel();
		int[] tageStunden = new int[2];
		tageStunden = testBuchungAnzeige.holeTageStunden("2018-12-31 14:34:22", "2019-12-31 14:34:22");
		
		for(int i = 0; i < 2; i++) {
			System.out.println(tageStunden[i]);
		}
		int [] array=new int [2];
		array [0] = 365;
		array [1] = 0;
		Assert.assertArrayEquals(array, tageStunden);
		

		
	}
	
	
	
	
	
	
}
