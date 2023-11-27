package reservations_interface;

import driver.Booking;
import driver.Frame;
import driver.Main;
import loginandsignup.Login;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

public class Reservation_Display extends Frame {

    String smoking;
    String beds;
    String bedType;
    String quality;
    boolean modificationAvailable = false;
    String modificationTooltip = "";
    Booking booking;
    Date bookingEndDate;
    Date bookingStartDate;

    public Reservation_Display(Booking booking) {

        this.booking = booking;

        bookingEndDate = Date.from(booking.getEndDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        bookingStartDate = Date.from(booking.getStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant());


        if (booking.getRoom().getSmoking()){
            smoking = "Smoking";
        } else {
            smoking = "Non-Smkoking";
        }

        if (booking.getRoom().getBedNumber() == 1){
            beds = "1 Bed";
        } else if (booking.getRoom().getBedNumber() == 2){
            beds = "2 Beds";
        } else if (booking.getRoom().getBedNumber() == 3){
            beds = "3 Beds";
        } else {
            beds = "None";
        }

        bedType = booking.getRoom().getBedType();
        quality = booking.getRoom().getQuality();

        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Style">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
//        reservations_button = new javax.swing.JButton();
//        profile_button = new javax.swing.JButton();
//        rooms_button = new javax.swing.JButton();
//        sign_out_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        cancel_reservation = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        modify_reservation = new javax.swing.JButton();
        end_date = new com.toedter.calendar.JDateChooser();
        start_date = new com.toedter.calendar.JDateChooser();
        errorMessageLabel = new JLabel(" ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        end_date.setDate(bookingEndDate);
        end_date.setBackground(new java.awt.Color(21, 71, 52));
        end_date.setForeground(new java.awt.Color(255, 204, 51));
        end_date.setDateFormatString("MM, d, y");
        end_date.setBounds(270, 210, 100, 20);
        end_date.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                dateActionPerformed(evt);
            }
        });



        start_date.setDate(bookingStartDate);
        start_date.setBackground(new java.awt.Color(0, 0, 0));
        start_date.setForeground(new java.awt.Color(255, 204, 51));
        start_date.setDateFormatString("MM, d, y");
        start_date.setDoubleBuffered(false);
        start_date.setMinSelectableDate(new java.util.Date(-62135744317000L));
        start_date.setName("starting_date"); // NOI18N
        start_date.setBounds(157, 210, 100, 20);
        start_date.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                dateActionPerformed(evt);
            }
        });

        start_date.getAccessibleContext().setAccessibleName("starting_date");
        end_date.getAccessibleContext().setAccessibleName("ending_date");

        jPanel1.add(start_date);
        jPanel1.setComponentZOrder(start_date, 0);

        jPanel1.add(end_date);
        jPanel1.setComponentZOrder(end_date, 0);



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
        jLabel2.setText("RESERVATION INFORMATION");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(21, 71, 52));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Agent Argon\\Documents\\NetBeansProjects\\CSI5303_GroupProject_kBears\\src\\Images\\resized_room.jpg")); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 71, 52)));
        jLabel3.setPreferredSize(new java.awt.Dimension(600, 500));

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(21, 71, 52));
        jTextArea1.setRows(5);
        jTextArea1.setText("ROOM OPTIONS\nFully refundable before\nGET DATE\n\nRate\nAny Discounts\nTotal\n");
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 71, 52)));
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(21, 71, 52));
        jTextArea2.setRows(1);
        jTextArea2.setText(smoking + ", " + quality + ", " + beds + ", " + bedType);
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(21, 71, 52)));
        jScrollPane2.setViewportView(jTextArea2);

        cancel_reservation.setBackground(new java.awt.Color(21, 71, 52));
        cancel_reservation.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancel_reservation.setForeground(new java.awt.Color(255, 184, 28));
        cancel_reservation.setText("Cancel Reservation");
        cancel_reservation.setToolTipText("");
        cancel_reservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cancel_reservationActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        back_button.setBackground(new java.awt.Color(21, 71, 52));
        back_button.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        back_button.setForeground(new java.awt.Color(255, 184, 28));
        back_button.setText("Back");
        back_button.setToolTipText("");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        modify_reservation.setBackground(new java.awt.Color(21, 71, 52));
        modify_reservation.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modify_reservation.setForeground(new java.awt.Color(255, 184, 28));
        modify_reservation.setText("Modify Reservation");
        modify_reservation.setToolTipText(modificationTooltip);
        modify_reservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    modify_reservationActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(back_button, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cancel_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modify_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(66, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_reservation)
                    .addComponent(modify_reservation))
                .addGap(46, 46, 46))
        );

        Font customFont = new Font("Arial", Font.PLAIN, 18);

        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setFont(customFont);
        errorMessageLabel.setBounds(550, 460, 285, 30);
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
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_reservationActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_cancel_reservationActionPerformed
        Main.masterController.deleteBooking(booking);
        new Reservation_Listing(Main.masterController.getCurrentUser());
        this.dispose();
    }//GEN-LAST:event_cancel_reservationActionPerformed
    
    
    private void dateActionPerformed(PropertyChangeEvent evt){
        errorMessageLabel.setVisible(false);
        LocalDate newStartDate = convertToLocalDate(start_date.getDate());
        LocalDate newEndDate = convertToLocalDate(end_date.getDate());
        modificationAvailable = Main.masterController.checkNewAvailability(booking, newStartDate, newEndDate);
        System.out.println(modificationAvailable);
        if (modificationAvailable){
            modificationTooltip = "";
        } else {
            modificationTooltip = "";
        }

    }

    private LocalDate convertToLocalDate(Date date) {
        if (date != null) {
            Instant instant = date.toInstant();
            return instant.atZone(ZoneId.systemDefault()).toLocalDate();
        }
        return null;
    }

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_buttonActionPerformed

    private void modify_reservationActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_modify_reservationActionPerformed
        LocalDate newStartDate = convertToLocalDate(start_date.getDate());
        LocalDate newEndDate = convertToLocalDate(end_date.getDate());
        if (modificationAvailable){
            booking = Main.masterController.adjustBooking(booking, newStartDate, newEndDate);
            new Reservation_Listing(Main.masterController.getCurrentUser());
            this.dispose();
        } else {
            errorMessageLabel.setText("Dates Unavailable!");
            errorMessageLabel.setVisible(true);
        }
    }//GEN-LAST:event_modify_reservationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JButton cancel_reservation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton modify_reservation;
    private JLabel errorMessageLabel;
    private com.toedter.calendar.JDateChooser start_date;
    private com.toedter.calendar.JDateChooser end_date;
    // End of variables declaration//GEN-END:variables
}
