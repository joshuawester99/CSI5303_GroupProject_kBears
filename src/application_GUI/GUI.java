package application_GUI;

import javax.swing.*;
import java.awt.*;


public class GUI {
		
	Color baylor_gold = new Color(255, 184, 28);
	Color baylor_green = new Color(21, 71, 52);
	
	public GUI() {
		Frame frame = new Frame();

		ImageIcon image = getImage("waco.png");

		JLabel label = new JLabel();
		label.setText("kBEARS HOTEL");
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setForeground(baylor_gold);
		label.setFont(new Font("Goudy Old Style", Font.BOLD, 80));
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.add(label, BorderLayout.WEST);
		
	}
	// TODO make a transition between GUI states for login to main screen.
	
	// TODO make this a static method... resolve the "this" issue.
	public ImageIcon getImage(String PNG_file) {
		
		String file_path = "application_GUI/images/" + PNG_file;
		ClassLoader cldr = this.getClass().getClassLoader();
	    java.net.URL imageURL = cldr.getResource(file_path);
		ImageIcon image = new ImageIcon(imageURL);
		return image;
	}
}