package com.controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import com.entity.IKunde;
import com.model.BuchungTypSucheModel;
import com.view.IObjektView;

/**
 * 
 * @author michi
 *
 */
public class BuchungTypSucheStrg implements IController {

	private BuchungTypSucheModel model;
	private IObjektView view;

	public BuchungTypSucheStrg(BuchungTypSucheModel smodel) {
		model = smodel;

	}

	public void fetchTypen(int knr, String talking, String searchtxt, IKunde kunde) {

		model.holeTypen(knr, talking, searchtxt, kunde);

	}

	@Override
	public void anfrage() {
		// TODO Auto-generated method stub

	}
}
