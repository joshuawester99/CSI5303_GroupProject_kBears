package driver;

import javax.swing.JButton;

import loginandsignup.Login;
import loginandsignup.Profile_Page;
import loginandsignup.SignUp;
import reservations_interface.Reservation_Listing;
import room_interface.Room_Listing;

public class Frame extends javax.swing.JFrame {

    protected javax.swing.JButton profile_button;
    protected javax.swing.JButton rooms_button;
    protected javax.swing.JButton reservations_button;
    protected javax.swing.JButton sign_out_button;
    
    public Frame() {
    	initializeComponents();
    }
    
    private void initializeComponents() {
    	reservations_button = new javax.swing.JButton();
    	profile_button = new javax.swing.JButton();
    	rooms_button = new javax.swing.JButton();
    	sign_out_button = new javax.swing.JButton();
    	
    	reservations_button.setBackground(new java.awt.Color(21, 71, 52));
        reservations_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reservation_icon.png"))); // NOI18N
        reservations_button.setBorder(null);
        reservations_button.setFocusPainted(false);
        reservations_button.setFocusable(false);
        reservations_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservations_buttonActionPerformed(evt);
            }
        });

        profile_button.setBackground(new java.awt.Color(21, 71, 52));
        profile_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile_pic.png"))); // NOI18N
        profile_button.setBorder(null);
        profile_button.setFocusPainted(false);
        profile_button.setFocusable(false);
        profile_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profile_button.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		profile_button_buttonActionPerformed(evt);
        	}
        });

        rooms_button.setBackground(new java.awt.Color(21, 71, 52));
        rooms_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bed.png"))); // NOI18N
        rooms_button.setBorder(null);
        rooms_button.setFocusPainted(false);
        rooms_button.setFocusable(false);
        rooms_button.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		rooms_button_buttonActionPerformed(evt);
        	}
        });

        sign_out_button.setBackground(new java.awt.Color(21, 71, 52));
        sign_out_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sign_out.png"))); // NOI18N
        sign_out_button.setBorder(null);
        sign_out_button.setFocusPainted(false);
        sign_out_button.setFocusable(false);
        sign_out_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_out_buttonActionPerformed(evt);
            }
        });
    }

    private void sign_out_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_out_buttonActionPerformed
        new Login();
        this.dispose();
    }

    private void rooms_button_buttonActionPerformed(java.awt.event.ActionEvent evt) {
    	new Room_Listing();
    	this.dispose();
    }
    
    private void reservations_buttonActionPerformed(java.awt.event.ActionEvent evt){
        new Reservation_Listing(Main.masterController.getCurrentUser());
        this.dispose();
    }
    
    private void profile_button_buttonActionPerformed(java.awt.event.ActionEvent evt) {
    	new Profile_Page(new Guest());
    	this.dispose();
    }
}