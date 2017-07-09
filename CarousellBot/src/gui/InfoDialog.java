package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InfoDialog extends JDialog {
	private JTextField itemField;
	private JComboBox<String> itemCategory;
	private JTextField priceField;
	private JRadioButton newBtn;
	private JRadioButton usedBtn;
	private TextPanel descText;
	private JRadioButton meetupBtn;
	private JRadioButton deliveryBtn;
	private ButtonGroup conditionGroup;
	private ButtonGroup deliveryGroup;
	private JButton okBtn;
	private JButton cancelBtn;
	private JButton imgBtn;
	private JFileChooser fileChooser;
	private Controller controller;
	private String itemName;
	private String itemCat;
	private String itemCond;
	private String itemText;
	private double itemPrice;
	private String itemDelivery;
	private String path;
	public InfoDialog(JFrame parent) {
		super(parent,"Sales Input",null);
		itemField = new JTextField(20);
		itemCategory = new JComboBox<String>();
		priceField = new JTextField(20);
		newBtn = new JRadioButton("new");
		newBtn.setActionCommand("new");
		usedBtn = new JRadioButton("used");
		usedBtn.setActionCommand("used");
		descText = new TextPanel();
		meetupBtn = new JRadioButton("Meetups");
		meetupBtn.setActionCommand("meetup");
		deliveryBtn = new JRadioButton("Delivery");
		deliveryBtn.setActionCommand("delivery");
		okBtn = new JButton("OK");
		cancelBtn = new JButton("Cancel");
		imgBtn = new JButton("Image");
		controller = new Controller();
		fileChooser = new JFileChooser();
		
		
		
		DefaultComboBoxModel<String> saleType = new DefaultComboBoxModel<String>();
		saleType.addElement("Cars");
		saleType.addElement("Everything Else");
		itemCategory.setModel(saleType);
		
		conditionGroup = new ButtonGroup();
		conditionGroup.add(newBtn);
		conditionGroup.add(usedBtn);
		
		deliveryGroup = new ButtonGroup();
		deliveryGroup.add(deliveryBtn);
		deliveryGroup.add(meetupBtn);
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemName = itemField.getText();
				setItemName(itemName);
				String itemCat = (String) itemCategory.getSelectedItem();
				setItemCat(itemCat);
				double price = Double.parseDouble(priceField.getText());
				setItemPrice(price);
				String cond = conditionGroup.getSelection().getActionCommand();
				setItemCond(cond);
				String description = descText.getText();
				setItemText(description);
				String deliveryoption = deliveryGroup.getSelection().getActionCommand();
				setItemDelivery(deliveryoption);
				String path = controller.getPath();
				setPath(path);
				setVisible(false);
				
			}

		});
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
			
		});
		imgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(InfoDialog.this) == JFileChooser.APPROVE_OPTION ) {
					String path = fileChooser.getSelectedFile().getAbsolutePath();
					controller.loadImage(path);
					
				}
			}
			
		});
		layoutComponents();
		setMinimumSize(new Dimension(400,400));
		setSize(400,400);
		
		
	}
	
	public void setPath(String path) {
		this.path=path;
	}
	public String getPath() {
		return path;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemCat() {
		return itemCat;
	}

	public String getItemCond() {
		return itemCond;
	}

	public String getItemText() {
		return itemText;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public String getItemDelivery() {
		return itemDelivery;
	}
	
	public JTextField getItemField() {
		return itemField;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}


	public void setItemCond(String itemCond) {
		this.itemCond = itemCond;
	}


	public void setItemText(String itemText) {
		this.itemText = itemText;
	}


	public void setItemPrice(double price) {
		this.itemPrice = price;
	}


	public void setItemDelivery(String itemDelivery) {
		this.itemDelivery = itemDelivery;
	}


	private void layoutComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		JPanel buttonPanel1 = new JPanel();
		JPanel buttonPanel2 = new JPanel();
		
		buttonPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonPanel1.add(newBtn);
		buttonPanel1.add(usedBtn);
		
		buttonPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonPanel2.add(meetupBtn);
		buttonPanel2.add(deliveryBtn);
		
		//setting up the areas//
		//row1//
		gc.gridx=1;
		gc.gridy=1;
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(5,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Item Name: "),gc);
		
		gc.gridx++;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(itemField,gc);
		//row2//
		gc.gridx=1;
		gc.gridy++;
		gc.insets = new Insets(5,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill= GridBagConstraints.NONE;
		add(new JLabel("Item Category: "),gc);
		
		gc.gridx++;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(itemCategory,gc);
		
		//row 3//
		gc.gridx=1;
		gc.gridy++;gc.insets = new Insets(5,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill= GridBagConstraints.NONE;
		add(new JLabel("Price:"),gc);
		
		gc.gridx++;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(priceField,gc);
		
		//row 4//
		gc.gridx=1;
		gc.gridy++;
		gc.insets = new Insets(5,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill= GridBagConstraints.NONE;
		add(new JLabel("Condition:"),gc);
		
		gc.gridx++;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		add(buttonPanel1,gc);
		
		//row5//
		gc.gridx=1;
		gc.gridy++;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(7,0,0,5);
		add(new JLabel("Description: "),gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(0,0,0,5);
		add(descText,gc);
		
		//row 6//
		gc.gridx=1;
		gc.gridy++;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(7,0,0,5);
		gc.fill = GridBagConstraints.NONE;
		add(new JLabel("Meetup/Delivery: "),gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(buttonPanel2,gc);
		
		//row7//
		gc.gridx=1;
		gc.gridy++;
		gc.fill=GridBagConstraints.BOTH;
		add(okBtn,gc);
		
		gc.gridx++;
		add(cancelBtn,gc);
		
		gc.gridx++;
		add(imgBtn,gc);
		
		
	}
}
