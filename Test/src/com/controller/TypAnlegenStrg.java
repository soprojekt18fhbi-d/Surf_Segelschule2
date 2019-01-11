/*
 *  @author Michael Schmidt
 */

package com.controller;

import com.entity.GeraeteTyp;
import com.model.TypAnlegenModel;
import com.view.IAnlegenView;

public class TypAnlegenStrg {

	private GeraeteTyp typ;
	private TypAnlegenModel model;
	private IAnlegenView view;

	public TypAnlegenStrg(TypAnlegenModel smodel) {
		model = smodel;

	}

	public void typUebergeben(String talking, int id, String name, String f�hrerschein) {
		String idS = String.valueOf(id);
		String[] values = { talking, idS, name, f�hrerschein };
		model.typAnlegen(values);
	}

	

}
