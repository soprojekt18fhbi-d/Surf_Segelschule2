/**
 * @author Ben S.
 */

package GUIRechnungsverwaltung;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.GroupLayout;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.GroupLayout.Alignment;
	import javax.swing.border.EmptyBorder;

import GUI.Hauptmenue;

import javax.swing.JScrollPane;
	import javax.swing.JList;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.GridBagLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.GridBagConstraints;

public class RechungsverwaltungGUI extends JFrame {

	

		private JPanel contentPane;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						RechungsverwaltungGUI frame = new RechungsverwaltungGUI();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public RechungsverwaltungGUI() {
			setTitle("Rechnung auswählen");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1000, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			//Basic Panel
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.NORTH);
			
			//Back Button
			JButton btnZurck = new JButton("Zur\u00FCck");
			btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(824, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(6)
						.addComponent(btnZurck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
			
			//Center Panel
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1, BorderLayout.CENTER);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			panel_1.add(scrollPane, gbc_scrollPane);
			
			//JList Init
			JList list = new JList();
			scrollPane.setViewportView(list);
			
			//South Panel
			JPanel panel_2 = new JPanel();
			contentPane.add(panel_2, BorderLayout.SOUTH);
			
			JButton btnAuswhlen = new JButton("Ausw\u00E4hlen");
			btnAuswhlen.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap(824, Short.MAX_VALUE)
						.addComponent(btnAuswhlen, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
						.addGap(6)
						.addComponent(btnAuswhlen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel_2.setLayout(gl_panel_2);
			
			
			//Action Listener Buttons
			btnZurck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Hauptmenue frame = new Hauptmenue();
					dispose();
				}
			});
			
			btnAuswhlen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					SportGeräteGUI frame = new SportGeräteGUI();
					setVisible(false);
				}
			});
			
			setVisible(true);
		}


}
