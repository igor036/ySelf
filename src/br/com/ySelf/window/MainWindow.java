package br.com.ySelf.window;

import br.com.ySelf.util.MatUtil;
import java.util.Stack;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.opencv.core.Mat;


public class MainWindow extends javax.swing.JFrame {

    private Mat img;
    private Stack<Mat> previous;
    private Stack<Mat> next;
    
    public MainWindow() {
        this.setLocationRelativeTo(null); 
        previous = new Stack<>();
        next = new Stack<>();
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbPhoto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        photoSelection = new javax.swing.JMenu();
        options = new javax.swing.JMenu();
        ctrlZ = new javax.swing.JMenuItem();
        ctrlY = new javax.swing.JMenuItem();
        btMasks = new javax.swing.JMenu();
        dogMask = new javax.swing.JMenuItem();
        filter = new javax.swing.JMenu();
        gray = new javax.swing.JMenuItem();
        blur = new javax.swing.JMenuItem();
        inversor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        photoSelection.setText("Selecionar Foto");
        photoSelection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoSelectionMouseClicked(evt);
            }
        });
        jMenuBar1.add(photoSelection);

        options.setText("Opções");

        ctrlZ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        ctrlZ.setText("Desfazer");
        ctrlZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlZActionPerformed(evt);
            }
        });
        options.add(ctrlZ);

        ctrlY.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        ctrlY.setText("Refazer");
        ctrlY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlYActionPerformed(evt);
            }
        });
        options.add(ctrlY);

        jMenuBar1.add(options);

        btMasks.setText("Mascaras");

        dogMask.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        dogMask.setIcon(new javax.swing.ImageIcon("C:\\Users\\igor.lima\\Documents\\NetBeansProjects\\ySelf\\img\\icon\\dog-icon.png")); // NOI18N
        dogMask.setText("Cachorro");
        dogMask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dogMaskActionPerformed(evt);
            }
        });
        btMasks.add(dogMask);

        jMenuBar1.add(btMasks);

        filter.setText("Filtros");

        gray.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        gray.setText("Escala de Cinza");
        gray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grayActionPerformed(evt);
            }
        });
        filter.add(gray);

        blur.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        blur.setText("Desfocar");
        blur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blurActionPerformed(evt);
            }
        });
        filter.add(blur);

        inversor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        inversor.setText("Inverter");
        inversor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inversorActionPerformed(evt);
            }
        });
        filter.add(inversor);

        jMenuBar1.add(filter);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPhoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void photoSelectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_photoSelectionMouseClicked
        
        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            
            String photoPath = fileChooser.getSelectedFile().getAbsolutePath();
            img = MatUtil.readImg(photoPath);
                     
            MatUtil.show(img, lbPhoto);
            
            previous.clear();
            next.clear();
            
            lbPhoto.setText("");
        }
    }//GEN-LAST:event_photoSelectionMouseClicked

    private void dogMaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dogMaskActionPerformed
        
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.merge(newImg, MatUtil.DOG_PNG);
        MatUtil.show(newImg, lbPhoto);
        
        previous.push(img);
        img = newImg;
    }//GEN-LAST:event_dogMaskActionPerformed

    private void ctrlZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlZActionPerformed
        if(!previous.isEmpty()){
            next.push(img);
            img = previous.pop();
            MatUtil.show(img, lbPhoto);
        } else 
            JOptionPane.showMessageDialog(null, "Não há mais oque desfazer!");
    }//GEN-LAST:event_ctrlZActionPerformed

    private void ctrlYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlYActionPerformed
        if (!next.isEmpty()){
            previous.push(img);
            img = next.pop();
            MatUtil.show(img, lbPhoto);
        } else
            JOptionPane.showConfirmDialog(null, "Não há mais oque refazer!");
    }//GEN-LAST:event_ctrlYActionPerformed

    private void grayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayActionPerformed
        
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.grayScale(newImg);
        MatUtil.show(newImg, lbPhoto);
        
        previous.push(img);
        img = newImg;
    }//GEN-LAST:event_grayActionPerformed

    private void blurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blurActionPerformed
        
        int blurLevel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nível de desfoque",JOptionPane.WARNING_MESSAGE));
        
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.blur(newImg,blurLevel);
        MatUtil.show(newImg, lbPhoto);
        
        previous.push(img);
        img = newImg;
        
    }//GEN-LAST:event_blurActionPerformed

    private void inversorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inversorActionPerformed
       
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.inversor(newImg);
        MatUtil.show(newImg, lbPhoto);
        
        previous.push(img);
        img = newImg;
        
    }//GEN-LAST:event_inversorActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem blur;
    private javax.swing.JMenu btMasks;
    private javax.swing.JMenuItem ctrlY;
    private javax.swing.JMenuItem ctrlZ;
    private javax.swing.JMenuItem dogMask;
    private javax.swing.JMenu filter;
    private javax.swing.JMenuItem gray;
    private javax.swing.JMenuItem inversor;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbPhoto;
    private javax.swing.JMenu options;
    private javax.swing.JMenu photoSelection;
    // End of variables declaration//GEN-END:variables
}
