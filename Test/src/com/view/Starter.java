package com.view;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import com.controller.BuchungBuchungAnzeigenStrg;
import com.controller.BuchungGeraetSucheStrg;
import com.controller.BuchungKundeSucheStrg;
import com.controller.BuchungModellSucheStrg;
import com.controller.BuchungTypSucheStrg;
import com.controller.GeraetAnlegenStrg;
import com.controller.KundeAnlegenStrg;
import com.controller.KundeSucheStrg;
import com.controller.ModellAnlegenStrg;
import com.controller.PreislisteAendernStrg;
import com.controller.PreislisteSucheStrg;
import com.controller.RechnungAnzeigeStrg;
import com.controller.StandortStrg;
import com.controller.WirtschaftlichkeitStrg;
import com.model.BuchungAnzeigeModel;
import com.model.BuchungGeraetSucheModel;
import com.model.BuchungKundeSucheModel;
import com.model.BuchungModellSucheModel;
import com.model.BuchungTypSucheModel;
import com.model.DBConnectorSingleton;
import com.model.GeraetAnlegenModel;
import com.model.KundeAnlegenModel;
import com.model.KundeSucheModel;
import com.model.ModellAnlegenModel;
import com.model.PreislisteAendernModel;
import com.model.PreislisteSucheModel;
import com.model.RechnungAnzeigenModel;
import com.model.StandortModel;
import com.model.WirtschaftlichkeitModel;

public class Starter { //Ben Kröncke

	public static void main(String[] args) { 

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					StandortModel standortModel = new StandortModel();
					StandortStrg standortStrg = new StandortStrg(standortModel);

					StandortGUI frame = new StandortGUI(standortModel, standortStrg);
					frame.setVisible(true);
					frame.setTitle("Surf- & Segelcenter");

					// Models erzeugen:
					KundeSucheModel kundeSucheModel = new KundeSucheModel();
					KundeAnlegenModel kundeAnlegenModel = new KundeAnlegenModel();
					BuchungKundeSucheModel buchungKundeSucheModel = new BuchungKundeSucheModel();
					BuchungTypSucheModel buchungTypSucheModel = new BuchungTypSucheModel();
					BuchungModellSucheModel buchungModellSucheModel = new BuchungModellSucheModel();
					BuchungGeraetSucheModel buchungGeraetSucheModel = new BuchungGeraetSucheModel();
					ModellAnlegenModel modellHinzufuegenModel = new ModellAnlegenModel();
					GeraetAnlegenModel geraetAnlegenModel = new GeraetAnlegenModel();
					BuchungAnzeigeModel buchungAnzeigeModel = new BuchungAnzeigeModel();
					RechnungAnzeigenModel rechnungAnzeigeModel = new RechnungAnzeigenModel();
					WirtschaftlichkeitModel wModel = new WirtschaftlichkeitModel();
					PreislisteSucheModel preislisteSucheModel = new PreislisteSucheModel();
					PreislisteAendernModel preislisteAendernModel = new PreislisteAendernModel();

					// Controller erzeugen:
					KundeSucheStrg kundeSucheStrg = new KundeSucheStrg(kundeSucheModel);
					KundeAnlegenStrg kundeAnlegenStrg = new KundeAnlegenStrg(kundeAnlegenModel);
					BuchungKundeSucheStrg buchungKundeWaehlenStrg = new BuchungKundeSucheStrg(buchungKundeSucheModel);
					BuchungTypSucheStrg buchungTypSucheStrg = new BuchungTypSucheStrg(buchungTypSucheModel);
					BuchungModellSucheStrg buchungModellSucheStrg = new BuchungModellSucheStrg(buchungModellSucheModel);
					BuchungGeraetSucheStrg buchungGeraetSucheStrg = new BuchungGeraetSucheStrg(buchungGeraetSucheModel);
					ModellAnlegenStrg modellAnlegenStrg = new ModellAnlegenStrg(modellHinzufuegenModel);
					GeraetAnlegenStrg geraetAnlegenStrg = new GeraetAnlegenStrg(geraetAnlegenModel);
					BuchungBuchungAnzeigenStrg buchungBuchungAnzeigenStrg = new BuchungBuchungAnzeigenStrg(
							buchungAnzeigeModel);
					RechnungAnzeigeStrg rechnungAnzeigenStrg = new RechnungAnzeigeStrg(rechnungAnzeigeModel);
					WirtschaftlichkeitStrg wStrg = new WirtschaftlichkeitStrg(wModel);
					PreislisteSucheStrg preislisteSucheStrg = new PreislisteSucheStrg(preislisteSucheModel);
					PreislisteAendernStrg preislisteAendernStrg = new PreislisteAendernStrg(preislisteAendernModel);

					// Geräteverwaltung
					GeraeteVerwaltungGUI geraeteVerwaltungGUI = new GeraeteVerwaltungGUI();
					GeraeteModellVerwaltungGUI geraeteModellVerwaltungGUI = new GeraeteModellVerwaltungGUI(
							buchungModellSucheModel, buchungModellSucheStrg);
					GeraeteTypVerwaltungGUI geraeteTypVerwaltungGUI = new GeraeteTypVerwaltungGUI(buchungTypSucheModel,
							buchungTypSucheStrg);
					GeraetAnlegenGUI geraetAnlegenGUI = new GeraetAnlegenGUI(geraetAnlegenModel, geraetAnlegenStrg);
					GeraetAendernGUI geraetAendernGUI = new GeraetAendernGUI(geraetAnlegenModel, geraetAnlegenStrg);
					GeraeteStatusGUI geraeteStatusGUI = new GeraeteStatusGUI(geraetAnlegenModel, geraetAnlegenStrg);
					GeraeteReparaturGUI geraeteReparaturGUI = new GeraeteReparaturGUI(geraetAnlegenModel,
							geraetAnlegenStrg);
					ModellAendernGUI modellAnedernGUI = new ModellAendernGUI(modellHinzufuegenModel, modellAnlegenStrg);
					ModellAnlegenGUI modellAnlegenGUI = new ModellAnlegenGUI(modellHinzufuegenModel, modellAnlegenStrg);
					SportgeraeteVerwaltungGUI sportgeraeteGUI = new SportgeraeteVerwaltungGUI(buchungGeraetSucheModel,
							buchungGeraetSucheStrg);
					TypAendernGUI typAendernGUI = new TypAendernGUI();
					TypAnlegenGUI typAnlegenGUI = new TypAnlegenGUI();

					// BuchungsverwaltungGUI
					BuchungsverwaltungGUI buchungsverwaltungGUI = new BuchungsverwaltungGUI();
					BuchungKundeSucheGUI buchungKundeSucheGUI = new BuchungKundeSucheGUI(buchungKundeSucheModel,
							buchungKundeWaehlenStrg);
					BuchungTypSucheGUI buchungTypSucheGUI = new BuchungTypSucheGUI(buchungTypSucheModel,
							buchungTypSucheStrg);
					BuchungModellSucheGUI buchungModellSucheGUI = new BuchungModellSucheGUI(buchungModellSucheModel,
							buchungModellSucheStrg);
					BuchungGeraetSucheGUI buchungGeraetSucheGUI = new BuchungGeraetSucheGUI(buchungGeraetSucheModel,
							buchungGeraetSucheStrg);
					AktiveBuchungenGUI aktiveBuchungenGUI = new AktiveBuchungenGUI(buchungAnzeigeModel,
							buchungBuchungAnzeigenStrg);

					// Kundenverwaltung
					KundenverwaltungGUI kundenverwaltungGUI = new KundenverwaltungGUI();
					KundeAnlegenGUI kundeAnlegenGUI = new KundeAnlegenGUI(kundeAnlegenModel, kundeAnlegenStrg);
					KundeAendernGUI kundeAendernGUI = new KundeAendernGUI(kundeSucheModel, kundeSucheStrg);

					// Preislistenverwaltung
					PreislisteGUI preislisteGUI = new PreislisteGUI(preislisteSucheModel, preislisteSucheStrg);
					PreislisteAnlegenGUI preislisteAnlegenGUI = new PreislisteAnlegenGUI();
					PreislisteAendernGUI preislisteAendernGUI = new PreislisteAendernGUI(preislisteAendernModel,
							preislisteAendernStrg);

					// Rechnungsverwaltung
					RechungsSucheGUI rechnungSucheGUI = new RechungsSucheGUI(rechnungAnzeigeModel,
							rechnungAnzeigenStrg);

					// Wirtschaftlichkeitsrechnung
					WirtschaftlichkeitsverwaltungGUI wirtschaftlichkeitsverwaltungGUI = new WirtschaftlichkeitsverwaltungGUI(
							wModel, wStrg);

					// MainFrame erzeugen
					MainFrame mainframe = new MainFrame(geraeteVerwaltungGUI, geraeteModellVerwaltungGUI,
							geraeteTypVerwaltungGUI, geraetAnlegenGUI, geraetAendernGUI, geraeteStatusGUI,
							geraeteReparaturGUI, modellAnedernGUI, modellAnlegenGUI, sportgeraeteGUI, typAendernGUI,
							typAnlegenGUI, buchungsverwaltungGUI, buchungKundeSucheGUI, buchungTypSucheGUI,
							buchungModellSucheGUI, buchungGeraetSucheGUI, aktiveBuchungenGUI, kundenverwaltungGUI,
							kundeAnlegenGUI, kundeAendernGUI, preislisteGUI, preislisteAnlegenGUI, preislisteAendernGUI,
							rechnungSucheGUI, wirtschaftlichkeitsverwaltungGUI);

					frame.setMainFrame(mainframe);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
