package TESTPACKAGE;

import Steuerung.IController;

public class TestController implements IController {
	
	private TestanbindungMVCBEISPIEL model;
	private TestframeMVCBeispiel view;
	
	public TestController(TestanbindungMVCBEISPIEL smodel)
	{
		model = smodel;
		
	}
	
	
	/**
	 * Der Button wurde gedrückt und es sollen Kunden geholt werden.
	 * 
	 */
	public void fetchKunden() {
		
		model.holeKunden();
		
		
	}
}
