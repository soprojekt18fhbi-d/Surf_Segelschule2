package GUI;

import Datenbankmodels.IModel;
import Datenbankmodels.IModelSuche;

public interface IView {

	
	/**
	 * Die aktualisieren Methode aktualisiert die View.
	 * 
	 */
	public void aktualisieren(IModel model);

	public void aktualisierenSuche(IModelSuche model);
	
	
}
