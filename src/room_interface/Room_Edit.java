package room_interface;

import driver.Main;
import driver.Room;
import loginandsignup.Login;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Room_Edit extends javax.swing.JFrame {

    Room currentRoom = new Room();

    String smoking;
    String beds;
    String bedType;
    String quality;

    public Room_Edit(Room room) {
        this.currentRoom = room;

        if (room.getSmoking()){
            smoking = "Smoking";
        } else {
            smoking = "Non-Smoking";
        }

        if (room.getBedNumber() == 1){
            beds = "1 Bed";
        } else if (room.getBedNumber() == 2){
            beds = "2 Beds";
        } else if (room.getBedNumber() == 3){
            beds = "3 Beds";
        } else {
            beds = "None";
        }

        bedType = room.getBedType();
        quality = room.getQuality();
        initComponents();
        
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        reservations_button = new javax.swing.JButton();
        profile_button = new javax.swing.JButton();
        rooms_button = new javax.swing.JButton();
        sign_out_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        submit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        bedField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        qualityField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        smokingField = new javax.swing.JTextField();
        bedNumberField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userInfoLabel = new javax.swing.JLabel();
        instructionLabel = new javax.swing.JLabel();
        errorMessageLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 184, 28));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel3.setBackground(new java.awt.Color(21, 71, 52));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 3));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Agent Argon\\Documents\\NetBeansProjects\\CSI5303_GroupProject_kBears\\src\\Images\\logo_resized.png"));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setIconTextGap(0);
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));

        userInfoLabel.setFont(new java.awt.Font("Segoe UI", 0, 20));
        userInfoLabel.setForeground(new java.awt.Color(21, 71, 52));
        userInfoLabel.setText("CURRENT ROOM: " + currentRoom.getRoomNumber() + "  " + smoking + ", " + quality + ", " + beds + ", " + bedType);

        jPanel1.add(userInfoLabel);
        userInfoLabel.setBounds(200, 80, 600, 30);

        instructionLabel.setFont(new java.awt.Font("Segoe UI", 0, 16));
        instructionLabel.setForeground(new java.awt.Color(21, 71, 52));
        instructionLabel.setText("Please Enter Your Updated Information Below");

        jPanel1.add(instructionLabel);
        instructionLabel.setBounds(257, 120, 400, 30);

        jSeparator1.setBackground(new java.awt.Color(255, 184, 28));
        jSeparator1.setForeground(new java.awt.Color(255, 184, 28));

        reservations_button.setBackground(new java.awt.Color(21, 71, 52));
        reservations_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reservation_icon.png")));
        reservations_button.setBorder(null);
        reservations_button.setFocusPainted(false);
        reservations_button.setFocusable(false);

        profile_button.setBackground(new java.awt.Color(21, 71, 52));
        profile_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile_pic.png")));
        profile_button.setBorder(null);
        profile_button.setFocusPainted(false);
        profile_button.setFocusable(false);
        profile_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        rooms_button.setBackground(new java.awt.Color(21, 71, 52));
        rooms_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bed.png")));
        rooms_button.setBorder(null);
        rooms_button.setFocusPainted(false);
        rooms_button.setFocusable(false);

        sign_out_button.setBackground(new java.awt.Color(21, 71, 52));
        sign_out_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sign_out.png")));
        sign_out_button.setBorder(null);
        sign_out_button.setFocusPainted(false);
        sign_out_button.setFocusable(false);
        sign_out_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_out_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(reservations_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rooms_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profile_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sign_out_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profile_button, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rooms_button)
                .addGap(18, 18, 18)
                .addComponent(reservations_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(sign_out_button)
                .addGap(17, 17, 17))
        );

        jLabel2.setBackground(new java.awt.Color(21, 71, 52));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 184, 28));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ROOM INFO");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);

        submit_button.setBackground(new java.awt.Color(21, 71, 52));
        submit_button.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submit_button.setForeground(new java.awt.Color(255, 184, 28));
        submit_button.setText("Submit");
        submit_button.setToolTipText("");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    submit_buttonActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        back_button.setBackground(new java.awt.Color(21, 71, 52));
        back_button.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        back_button.setForeground(new java.awt.Color(255, 184, 28));
        back_button.setText("Back");
        back_button.setToolTipText("Back to Previous Page");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(21, 71, 52));
        jLabel3.setText("Enter Bed Type Update (King, Queen, Full, or Twin)");

        qualityField.setPreferredSize(new java.awt.Dimension(64, 28));
        qualityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualityFieldActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(21, 71, 52));
        jLabel4.setText("Enter Quality Update (Executive, Business, Comfort, or Economy)");

        smokingField.setPreferredSize(new java.awt.Dimension(64, 28));
        smokingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokingFieldActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(21, 71, 52));
        jLabel5.setText("Enter Smoking Update (Smoking or Non-Smoking)");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(21, 71, 52));
        jLabel6.setText("Enter Bed Number Update (1, 2, or 3)");

        bedNumberField.setPreferredSize(new java.awt.Dimension(64, 28));
        bedNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedNumberFieldActionPerformed(evt);
            }
        });



        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(440, 440, 440)
                                .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(back_button)))
                        .addContainerGap(66, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(257, 257, 257)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(smokingField, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bedField)
                            .addComponent(qualityField, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bedNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(258, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back_button)
                .addGap(313, 313, 313)
                .addComponent(submit_button)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(smokingField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(qualityField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bedField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(bedNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );

        Font customFont = new Font("Arial", Font.PLAIN, 18);

        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setFont(customFont);
        errorMessageLabel.setBounds(300, 55, 285, 30);
        errorMessageLabel.setText("Invalid Selection!");
        errorMessageLabel.setVisible(false);

        jPanel1.add(errorMessageLabel);
        jPanel1.setComponentZOrder(errorMessageLabel, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void sign_out_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new Login();
        this.dispose();
    }

    // Check if edit parameters are allowed and submit if so
    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        String newSmoking = smokingField.getText();
        String newQuality = qualityField.getText();
        String newBedType = bedField.getText();
        String newBedNumber = bedNumberField.getText();

        if (!newSmoking.equals("") && !newSmoking.equals("Smoking") && !newSmoking.equals("Non-Smoking")){
            errorMessageLabel.setText("Smoking Field Invalid");
            errorMessageLabel.setVisible(true);
            return;
        }

        if (!newQuality.equals("") && !newQuality.equals("Executive") && !newQuality.equals("Comfort") && !newQuality.equals("Business") && !newQuality.equals("Economy")){
            errorMessageLabel.setText("Quality Field Invalid");
            errorMessageLabel.setVisible(true);
            return;
        }

        if (!newBedType.equals("") && !newBedType.equals("King") && !newBedType.equals("Queen") && !newBedType.equals("Full") && !newBedType.equals("Twin")){
            errorMessageLabel.setText("Bed Type Field Invalid");
            errorMessageLabel.setVisible(true);
            return;
        }

        if (!newBedNumber.equals("") && !newBedNumber.equals("1") && !newBedNumber.equals("2") && !newBedNumber.equals("3")){
            errorMessageLabel.setText("Bed Number Field Invalid");
            errorMessageLabel.setVisible(true);
            return;
        }

        Main.masterController.modifyRoom(currentRoom, newSmoking, newQuality, newBedType, newBedNumber);
        new Room_Listing();
        this.dispose();


    }

    // Go back
    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new Room_Listing();
        this.dispose();
    }

    private void qualityFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void smokingFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void bedNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private javax.swing.JButton back_button;
    private javax.swing.JTextField qualityField;
    private javax.swing.JTextField smokingField;
    private javax.swing.JTextField bedNumberField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField bedField;
    private javax.swing.JButton profile_button;
    private javax.swing.JButton reservations_button;
    private javax.swing.JButton rooms_button;
    private javax.swing.JButton sign_out_button;
    private javax.swing.JButton submit_button;
    private javax.swing.JLabel userInfoLabel;
    private javax.swing.JLabel instructionLabel;
    private JLabel errorMessageLabel;

}
