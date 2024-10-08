/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package irrgarten.UI;
import irrgarten.GameState;
import irrgarten.Directions;
import java.awt.Font;

/**
 *
 * @author pablolinari
 */
public class JFrame extends javax.swing.JFrame implements UI {
    private Cursors cursor;
    /**
     * Creates new form JFrame
    **/
    public JFrame() {
        initComponents();
        this.cursor = new Cursors(this,true);
        this.cursor.setLocation(500, 500);
        setVisible(true);
        this.setLocationRelativeTo(null);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Labyrinth = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Players = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Monsters = new javax.swing.JTextArea();
        turn = new javax.swing.JTextField();
        winner = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Labyrinth.setColumns(20);
        Labyrinth.setRows(5);
        jScrollPane1.setViewportView(Labyrinth);

        Players.setColumns(20);
        Players.setRows(5);
        jScrollPane2.setViewportView(Players);

        Monsters.setColumns(20);
        Monsters.setRows(5);
        jScrollPane3.setViewportView(Monsters);

        turn.setText("jTextField1");

        winner.setText("jTextField2");

        log.setColumns(20);
        log.setRows(5);
        jScrollPane4.setViewportView(log);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(turn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(winner, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(turn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Labyrinth;
    private javax.swing.JTextArea Monsters;
    private javax.swing.JTextArea Players;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea log;
    private javax.swing.JTextField turn;
    private javax.swing.JTextField winner;
    // End of variables declaration//GEN-END:variables
        @Override
    public void showGame(GameState gameState){
        this.Labyrinth.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
       this.Labyrinth.setText(gameState.getLabyrinthv());
       this.Players.setText(gameState.getPlayers());
       this.Monsters.setText(gameState.getMonsters());
       this.log.setText(gameState.getLog());
       this.turn.setText("Turno de " + gameState.getCurrentPlayer());
       this.winner.setText("Ganador " + gameState.getWinner());
       this.repaint();
    }
    @Override
    public Directions nextMove(){
        Directions dir =cursor.getDirection();
        return dir;
    }

}
