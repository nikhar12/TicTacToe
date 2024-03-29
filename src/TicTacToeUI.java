import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author NI289409
 */
public class TicTacToeUI extends javax.swing.JFrame{

    /**
     * Creates new form TicTacToeUI
     */
	   protected static final int PREF_W = 317;

	   protected static final int PREF_H = 317;
	
	Game game = new Game();
    public TicTacToeUI() {
    	game.initBoard();
    	
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
        	private void doDrawing(Graphics g) {

                Graphics2D g2d = (Graphics2D) g;

                g2d.drawLine(105, 0, 105, 317);
                g2d.drawLine(210, 0, 210, 317);
                g2d.drawLine(0, 105, 317, 105);
                g2d.drawLine(0, 210, 317, 210);
               
            }

            @Override
            public void paintComponent(Graphics g) {

                super.paintComponent(g);
                doDrawing(g);
            }
            
            public Dimension getPreferredSize() {
                if (isPreferredSizeSet()) {
                   return super.getPreferredSize();
                }
                return new Dimension(PREF_W, PREF_H);
             }
         

        };
        jPanel1.addMouseListener(new MouseListener(){
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		// TODO Auto-generated method stub
        		int x = arg0.getX();
        		int y = arg0.getY();
        		
        		//first row
        		if(x<105&&y<105)
        		{
        			game.userTurn(0, 0);
        			Graphics g = getGraphics();
        			g.setColor(new Color(77, 176, 230));
        			g.drawOval(10,40, 90, 90);
        			//jPanel1.validate();
        			//jPanel1.repaint();
        			
        		}
        		if((x<210&&x>105) && (y<105))
        		{
        			game.userTurn(0, 1);
        			Graphics g = getGraphics();
        			g.setColor(new Color(77, 176, 230));
        			g.drawOval(115,40, 90, 90);
        		}
        		if((x>210&&x<317)&& (y<105))
        		{
        			game.userTurn(0, 2);
        			Graphics g = getGraphics();
        			g.setColor(new Color(77, 176, 230));
        			g.drawOval(220,40, 90, 90);
        		}
        		
        		//second row
        		if(x<105&& (y<210&&y>105))
        		{
        			game.userTurn(1, 0);
        			Graphics g = getGraphics();
        			g.setColor(new Color(77, 176, 230));
        			g.drawOval(10,145, 90, 90);
        		}
        		if((x<210&&x>105)&& (y>105&&y<210))
        		{
        			game.userTurn(1, 1);
        			Graphics g = getGraphics();
        			g.setColor(new Color(77, 176, 230));
        			g.drawOval(115,145, 90, 90);
        		}
        		if((x>210&&x<317) && y<210&&y>105)
        		{
        			game.userTurn(1, 2);
        			Graphics g = getGraphics();
        			g.setColor(new Color(77, 176, 230));
        			g.drawOval(220,145, 90, 90);
        		}
        		
        		//third row
        		if(x<105 && (y<317&&y>210))
        		{
        			game.userTurn(2, 0);
        			Graphics g = getGraphics();
        			g.setColor(new Color(77, 176, 230));
        			g.drawOval(10,250, 90, 90);
        		}
        		if((x<210&&x<105) && (y<317&&y>210))
        		{
        			game.userTurn(2, 1);
        			Graphics g = getGraphics();
        			g.setColor(new Color(77, 176, 230));
        			g.drawOval(115,250, 90, 90);
        		}
        		if((x>210&&x<317) && (y<317&&y>210))
        		{
        			game.userTurn(2, 2);
        			Graphics g = getGraphics();
        			g.setColor(new Color(77, 176, 230));
        			g.drawOval(210,250, 90, 90);
        		}
        		
        		Map<Integer,Integer> map = game.compTurn();
        		Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
        		int row=entry.getKey();
        		int col = entry.getValue();
        		
        		//JOptionPane.showMessageDialog(null,row+" "+col);
        			Graphics g = getGraphics();
        			g.setColor(new Color(0, 204, 0));
        			g.drawLine(col*110,row*135, (col+1)*110, (row+1)*135);
        			g.drawLine(col*110, (row+1)*135,(col+1)*110,row*135);
        		game.printBoard();
        		
        		
        		
        	}

        	@Override
        	public void mouseEntered(MouseEvent arg0) {
        		// TODO Auto-generated method stub
        		
        	}

        	@Override
        	public void mouseExited(MouseEvent arg0) {
        		// TODO Auto-generated method stub
        		
        	}

        	@Override
        	public void mousePressed(MouseEvent arg0) {
        		// TODO Auto-generated method stub
        		
        	}

        	@Override
        	public void mouseReleased(MouseEvent arg0) {
        		// TODO Auto-generated method stub
        		
        	}
        });
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   


}


