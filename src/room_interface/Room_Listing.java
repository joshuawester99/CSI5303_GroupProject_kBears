
package room_interface;

import driver.Room;
import java.awt.List;
import java.util.ArrayList;
import loginandsignup.Login;
import javax.swing.table.DefaultTableModel;

public class Room_Listing extends javax.swing.JFrame {

    // to make editeable, just toggle
    
    private ArrayList<Room> rooms;
    private DefaultTableModel model;
    
    public Room_Listing() {
        initComponents();

        rooms = new ArrayList<>();
        rooms.add(new Room("A101", true, "King", 1, "executive"));
        rooms.add(new Room("A102", false, "Queen", 2, "comfort"));
        rooms.add(new Room("A103", false, "Full", 2, "business"));
        rooms.add(new Room("A104", false, "Twin", 2, "economy"));
        rooms.add(new Room("A105", false, "Twin", 2, "economy"));
        rooms.add(new Room("A105", false, "Twin", 2, "economy"));
        rooms.add(new Room("A105", false, "Twin", 2, "economy"));
        rooms.add(new Room("A105", false, "Twin", 2, "economy"));
        rooms.add(new Room("A105", false, "Twin", 2, "economy"));
        
        model = (DefaultTableModel)room_list.getModel();
        
        for (Room room : rooms) model.addRow(new Object[] {room.getRoomNumber(), room.getBedType(), room.getQuality()});
        
//        when this was a listing, it let me click on the object...
//        Room_Listing listing_reference = this;
//        
//        room_list.addListSelectionListener(new ListSelectionListener() {
//            
//            @Override
//            public void valueChanged(ListSelectionEvent arg0) {
//                if (!arg0.getValueIsAdjusting()) {
//                    Login LoginFrame = new Login();
//                    LoginFrame.setVisible(true);
//                    LoginFrame.pack();
//                    LoginFrame.setLocationRelativeTo(null); // center
//                    listing_reference.dispose();
//                }
//            }
//        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        number_beds = new javax.swing.JComboBox<>();
        smoking_option = new javax.swing.JComboBox<>();
        bed_size = new javax.swing.JComboBox<>();
        room_quality = new javax.swing.JComboBox<>();
        end_date = new com.toedter.calendar.JDateChooser();
        start_date = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        room_list = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 184, 28));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel3.setBackground(new java.awt.Color(21, 71, 52));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 3)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Agent Argon\\Documents\\NetBeansProjects\\CSI5303_GroupProject_kBears\\src\\Images\\logo_resized.png")); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setIconTextGap(0);
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));

        jSeparator1.setBackground(new java.awt.Color(255, 184, 28));
        jSeparator1.setForeground(new java.awt.Color(255, 184, 28));

        reservations_button.setBackground(new java.awt.Color(21, 71, 52));
        reservations_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reservation_icon.png"))); // NOI18N
        reservations_button.setBorder(null);
        reservations_button.setFocusPainted(false);
        reservations_button.setFocusable(false);

        profile_button.setBackground(new java.awt.Color(21, 71, 52));
        profile_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile_pic.png"))); // NOI18N
        profile_button.setBorder(null);
        profile_button.setFocusPainted(false);
        profile_button.setFocusable(false);
        profile_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        rooms_button.setBackground(new java.awt.Color(21, 71, 52));
        rooms_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bed.png"))); // NOI18N
        rooms_button.setBorder(null);
        rooms_button.setFocusPainted(false);
        rooms_button.setFocusable(false);

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
        jLabel2.setText("ROOMS");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);

        number_beds.setBackground(new java.awt.Color(255, 255, 255));
        number_beds.setForeground(new java.awt.Color(0, 0, 0));
        number_beds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bed Number", "1 Bed", "2 Beds" }));
        number_beds.setBorder(null);

        smoking_option.setBackground(new java.awt.Color(255, 255, 255));
        smoking_option.setForeground(new java.awt.Color(0, 0, 0));
        smoking_option.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smoking Pref.", "Smoking", "Non-Smoking" }));
        smoking_option.setBorder(null);
        smoking_option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smoking_optionActionPerformed(evt);
            }
        });

        bed_size.setBackground(new java.awt.Color(255, 255, 255));
        bed_size.setForeground(new java.awt.Color(0, 0, 0));
        bed_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bed Type", "Twin", "Full", "Queen", "King" }));
        bed_size.setBorder(null);

        room_quality.setBackground(new java.awt.Color(255, 255, 255));
        room_quality.setForeground(new java.awt.Color(0, 0, 0));
        room_quality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quality", "Economy", "Comfort", "Business", "Executive" }));
        room_quality.setBorder(null);
        room_quality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room_qualityActionPerformed(evt);
            }
        });

        end_date.setBackground(new java.awt.Color(21, 71, 52));
        end_date.setForeground(new java.awt.Color(255, 204, 51));
        end_date.setDateFormatString("MM, d, y");

        start_date.setBackground(new java.awt.Color(0, 0, 0));
        start_date.setForeground(new java.awt.Color(255, 204, 51));
        start_date.setDateFormatString("MM, d, y");
        start_date.setDoubleBuffered(false);
        start_date.setMinSelectableDate(new java.util.Date(-62135744317000L));
        start_date.setName("starting_date"); // NOI18N

        room_list.setBackground(new java.awt.Color(255, 255, 255));
        room_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        room_list.setToolTipText("");
        room_list.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        room_list.setRowHeight(60);
        room_list.setShowHorizontalLines(true);
        room_list.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(room_list);
        if (room_list.getColumnModel().getColumnCount() > 0) {
            room_list.getColumnModel().getColumn(0).setResizable(false);
            room_list.getColumnModel().getColumn(0).setPreferredWidth(50);
            room_list.getColumnModel().getColumn(1).setResizable(false);
            room_list.getColumnModel().getColumn(1).setPreferredWidth(280);
            room_list.getColumnModel().getColumn(2).setResizable(false);
            room_list.getColumnModel().getColumn(2).setPreferredWidth(280);
        }

        jButton2.setBackground(new java.awt.Color(255, 184, 28));
        jButton2.setForeground(new java.awt.Color(255, 184, 28));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Agent Argon\\Documents\\NetBeansProjects\\CSI5303_GroupProject_kBears\\src\\Images\\add_button.png")); // NOI18N
        jButton2.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(number_beds, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bed_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(room_quality, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(smoking_option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(331, 331, 331))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bed_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(smoking_option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(number_beds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(room_quality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(11, 11, 11))
        );

        start_date.getAccessibleContext().setAccessibleName("starting_date");

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
    }// </editor-fold>//GEN-END:initComponents
    
    
    private ArrayList<Room> update_list() {
        // whenever any action combo button is performed, do this.
        model.setRowCount(0); // clear the table
        String quality = (String) room_quality.getSelectedItem();
        String smoking_choice = (String) smoking_option.getSelectedItem();
        Boolean smoking = true;
        if (smoking_choice.equalsIgnoreCase("smoking")) smoking = true;
        else if (smoking_choice.equalsIgnoreCase("non-smoking")) smoking = false;
        String bed_type = (String) bed_size.getSelectedItem();
        String bed_count = (String) number_beds.getSelectedItem();
        int beds = (int) bed_count.charAt(0); 

        // if all the current attributes apply, display that option
        // if all defaults, display all
        
        // NOT WORKING YET
        
        ArrayList<Room> available_rooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getQuality().equalsIgnoreCase(quality) || quality.equalsIgnoreCase("quality")
                && (!(room.getBedNumber() == beds)) || bed_count.equalsIgnoreCase("bed number")
                && (!(room.getBedType().equalsIgnoreCase(bed_type))) || bed_type.equalsIgnoreCase("bed type")
                && (!(room.getSmoking()))) {
                available_rooms.add(room);
            }               
        }
        
        return available_rooms;
    }
    
    private void room_qualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_qualityActionPerformed
        ArrayList<Room> available_rooms = update_list();
        for (Room room : available_rooms) model.addRow(new Object[] {room.getRoomNumber(), room.getBedType(), room.getQuality()});
    }//GEN-LAST:event_room_qualityActionPerformed

    private void smoking_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smoking_optionActionPerformed
        ArrayList<Room> available_rooms = update_list();
        for (Room room : available_rooms) model.addRow(new Object[] {room.getRoomNumber(), room.getBedType(), room.getQuality()});
    }//GEN-LAST:event_smoking_optionActionPerformed

    private void sign_out_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_out_buttonActionPerformed
        Login LoginFrame = new Login(); 
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null); // center
        this.dispose();
    }//GEN-LAST:event_sign_out_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bed_size;
    private com.toedter.calendar.JDateChooser end_date;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> number_beds;
    private javax.swing.JButton profile_button;
    private javax.swing.JButton reservations_button;
    private javax.swing.JTable room_list;
    private javax.swing.JComboBox<String> room_quality;
    private javax.swing.JButton rooms_button;
    private javax.swing.JButton sign_out_button;
    private javax.swing.JComboBox<String> smoking_option;
    private com.toedter.calendar.JDateChooser start_date;
    // End of variables declaration//GEN-END:variables
}
