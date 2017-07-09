package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	private JTextArea textArea;
	
	public TextPanel() {
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		setSize(300,600);
		add(new JScrollPane(textArea),BorderLayout.CENTER);
	}
	public String getText() {
		return textArea.getText();
	}
}
