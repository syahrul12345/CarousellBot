package Model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField keywordField;
	private JButton okBtn;
	private JButton cancelBtn;
	private Controller controller;
	public MainFrame() {
		super("Carousell Bot");
		userField = new JTextField(10);
		passwordField = new JPasswordField(10);
		keywordField = new JTextField(10);
		okBtn= new JButton("OK");
		cancelBtn = new JButton("Close");
		controller = new Controller();
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
			
		});
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userField.getText();
				String password = new String(passwordField.getPassword());
				String keyword = keywordField.getText();
				controller.write(username,password,keyword);
				controller.execute();
			}
			
		});
		setLayout();
		setMinimumSize(new Dimension(300,140));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void setLayout() {
		JPanel fieldPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//gc set up//
		fieldPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.weightx=1;
		gc.weighty=1;
		gc.insets = new Insets(0,0,0,5);
		fieldPanel.add(new JLabel("Username: "), gc);
		
		gc.gridx++;
		fieldPanel.add(userField,gc);
		//next row//
		gc.gridx=0;
		gc.gridy++;
		fieldPanel.add(new JLabel("Password: "),gc);
		
		gc.gridx++;
		fieldPanel.add(passwordField,gc);
		//next row//
		gc.gridx=0;
		gc.gridy++;
		fieldPanel.add(new JLabel("Keyword: "), gc);
		
		gc.gridx++;
		fieldPanel.add(keywordField,gc);
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(okBtn);
		buttonPanel.add(cancelBtn);
		
		this.setLayout(new BorderLayout());
		add(fieldPanel,BorderLayout.NORTH);
		add(buttonPanel,BorderLayout.SOUTH);
		
		
	}
}
