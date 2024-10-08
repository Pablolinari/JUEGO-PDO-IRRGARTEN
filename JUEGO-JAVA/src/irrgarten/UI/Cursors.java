/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package irrgarten.UI;
import irrgarten.Directions;

/**
 *
 * @author pablolinari
 */
public class Cursors extends javax.swing.JDialog {
    private Directions move;
    /**
     * Creates new form Cursors
     */
    public Cursors(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upbutton = new javax.swing.JButton();
        downbutton = new javax.swing.JButton();
        rightbutton = new javax.swing.JButton();
        leftbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        upbutton.setText("UP");
        upbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upbuttonActionPerformed(evt);
            }
        });

        downbutton.setText("DOWN");
        downbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downbuttonActionPerformed(evt);
            }
        });

        rightbutton.setText("RIGHT");
        rightbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightbuttonActionPerformed(evt);
            }
        });

        leftbutton.setText("LEFT");
        leftbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(downbutton)
                    .addComponent(upbutton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(leftbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(rightbutton)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(upbutton)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightbutton)
                    .addComponent(leftbutton))
                .addGap(40, 40, 40)
                .addComponent(downbutton)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rightbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightbuttonActionPerformed
              // TODO add your handling code here:
        this.move = Directions.RIGHT;
        this.dispose();
    }//GEN-LAST:event_rightbuttonActionPerformed

    private void downbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downbuttonActionPerformed
        // TODO add your handling code here:
        this.move = Directions.DOWN;
        this.dispose();
    }//GEN-LAST:event_downbuttonActionPerformed

    private void upbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upbuttonActionPerformed
        // TODO add your handling code here:
        this.move = Directions.UP;
        this.dispose();
    }//GEN-LAST:event_upbuttonActionPerformed

    private void leftbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftbuttonActionPerformed
        // TODO add your handling code here:
        this.move = Directions.LEFT;
        this.dispose();
    }//GEN-LAST:event_leftbuttonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton downbutton;
    private javax.swing.JButton leftbutton;
    private javax.swing.JButton rightbutton;
    private javax.swing.JButton upbutton;
    // End of variables declaration//GEN-END:variables

    public Directions getDirection(){
        this.setVisible(true);
    
        return this.move;
    }

}
