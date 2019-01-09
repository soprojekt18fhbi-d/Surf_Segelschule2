/*
 *  @author Michael Schmidt
 */

package com.controller;

import com.entity.GeraeteModell;
import com.entity.GeraeteTyp;
import com.model.ModellAnlegenModel;
import com.view.IAnlegenView;
import com.view.ModellAnlegenGUI;

public class ModellAnlegenStrg implements IController {

	private GeraeteModell modell;
	private ModellAnlegenModel model;
	private ModellAnlegenGUI view;

	public ModellAnlegenStrg(ModellAnlegenModel smodel) {
		model = smodel;

	}

	public void anfrageModellhinzufuegen(String talking, String name, String typ, int preis, int id) {

		String[] values = { name, typ, "" + preis, "" + id };
		model.anfrage(talking, values);
	}

	@Override
	public void anfrage() {
		// TODO Auto-generated method stub

	}

}