package application_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

	int window_width;
	int window_height;
	Color baylor_green = new Color(21, 71, 52);
	Color baylor_gold = new Color(255, 184, 28);
	
	JButton button;
	
	public Frame() {

		button = new JButton();
		button.setBounds(50, 100, 10, 10);
		button.addActionListener(this);
		button.setText("ENTER");
		button.setFocusable(false);
		button.setBackground(baylor_gold);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.CENTER);
		button.setFont(new Font("Goudy Old Style", Font.BOLD, 80));
		button.setBorder(BorderFactory.createEtchedBorder());
		this.add(button, BorderLayout.CENTER);
		
		setWindowIcon();
		getWindowDimensions();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setTitle("kBears Hotel");
	    this.setSize(window_width, window_height);
	    this.setLocationRelativeTo(null); // center the window
	    this.setVisible(true);
	    this.getContentPane().setBackground(baylor_green);
	    
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			System.out.println("yo");
		}
	}

	private void getWindowDimensions() {

		// Set relative window size
        double percent_screen_width = 0.6;
        double percent_screen_height = 0.6;

        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Convert to relative size to actual width and height
        window_width = (int) (screenSize.width * percent_screen_width);
        window_height = (int) (screenSize.height * percent_screen_height);
	}

	private void setWindowIcon() {
	    ClassLoader cldr = this.getClass().getClassLoader();
	    java.net.URL imageURL = cldr.getResource("application_GUI/images/logo.png");
	    ImageIcon image = new ImageIcon(imageURL);
	    this.setIconImage(image.getImage());  
	}
}
