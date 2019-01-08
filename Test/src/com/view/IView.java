package com.view;

import com.model.IModel;
import com.model.IModelSuche;

public interface IView {

	
	/**
	 * Die aktualisieren Methode aktualisiert die View.
	 * 
	 */
	public void aktualisieren(IModel model);

	public void aktualisierenSuche(IModelSuche model);
	
	
}
