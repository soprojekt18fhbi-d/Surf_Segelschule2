 /*
  *  @author Michael Schmidt
  */

package com.controller;

import com.entity.GeraeteTyp;
import com.model.TypAnlegenModel;
import com.view.IAnlegenView;


public class TypAnlegenStrg implements IController{

	
	private GeraeteTyp typ;
	private TypAnlegenModel model;
	private IAnlegenView view;
	
	public TypAnlegenStrg (TypAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void typUebergeben(String talking, int id, String name, String führerschein) {
		String idS = String.valueOf(id);
		String[] values = {talking, idS, name, führerschein};
		model.typAnlegen(values);
	}


	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
}

