package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StandortGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblPasswort;
	private JPasswordField passwordField;
	private JLabel icon;
	private boolean correctData;




	/**
	 * Create the frame.
	 */
	public StandortGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{353, 0, 256, 0, 0, 0, 0, 0, 0, 343, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{58, 116, 52, 41, 52, 52, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel StandortLabel = new JLabel("Willkommen im Surf- & Segelcenter!");
		StandortLabel.setForeground(Color.WHITE);
		StandortLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		StandortLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_StandortLabel = new GridBagConstraints();
		gbc_StandortLabel.anchor = GridBagConstraints.NORTH;
		gbc_StandortLabel.insets = new Insets(0, 0, 5, 0);
		gbc_StandortLabel.gridwidth = 13;
		gbc_StandortLabel.gridx = 0;
		gbc_StandortLabel.gridy = 0;
		contentPane.add(StandortLabel, gbc_StandortLabel);
		
		JLabel lblStandort = new JLabel("Standort:");
		lblStandort.setForeground(Color.WHITE);
		lblStandort.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblStandort = new GridBagConstraints();
		gbc_lblStandort.gridwidth = 4;
		gbc_lblStandort.anchor = GridBagConstraints.EAST;
		gbc_lblStandort.fill = GridBagConstraints.VERTICAL;
		gbc_lblStandort.insets = new Insets(0, 0, 5, 5);
		gbc_lblStandort.gridx = 2;
		gbc_lblStandort.gridy = 2;
		contentPane.add(lblStandort, gbc_lblStandort);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		
		icon = new JLabel("Hier w\u00E4re ein icon ganz cool");
		icon.setForeground(Color.WHITE);
		icon.setBackground(Color.BLACK);
		GridBagConstraints gbc_icon = new GridBagConstraints();
		gbc_icon.gridheight = 3;
		gbc_icon.insets = new Insets(0, 0, 5, 5);
		gbc_icon.gridx = 9;
		gbc_icon.gridy = 2;
		
		contentPane.add(icon, gbc_icon);
		
		
		lblPasswort = new JLabel("Passwort:");
		lblPasswort.setForeground(Color.WHITE);
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.gridwidth = 6;
		gbc_lblPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblPasswort.fill = GridBagConstraints.VERTICAL;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 0;
		gbc_lblPasswort.gridy = 4;
		contentPane.add(lblPasswort, gbc_lblPasswort);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 7;
		gbc_passwordField.gridy = 4;
		contentPane.add(passwordField, gbc_passwordField);
		
		JButton okButton = new JButton("Best\u00E4tigen");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		
		JButton regButton = new JButton("Registrieren");
		regButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		regButton.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_regButton = new GridBagConstraints();
		gbc_regButton.anchor = GridBagConstraints.EAST;
		gbc_regButton.fill = GridBagConstraints.VERTICAL;
		gbc_regButton.insets = new Insets(0, 0, 0, 5);
		gbc_regButton.gridx = 7;
		gbc_regButton.gridy = 5;
		contentPane.add(regButton, gbc_regButton);
		okButton.setBackground(new Color(255, 140, 0));
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.insets = new Insets(0, 0, 0, 5);
		gbc_okButton.anchor = GridBagConstraints.WEST;
		gbc_okButton.fill = GridBagConstraints.VERTICAL;
		gbc_okButton.gridx = 8;
		gbc_okButton.gridy = 5;
		contentPane.add(okButton, gbc_okButton);
	}
}
