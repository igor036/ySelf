package br.com.ySelf.window;

import br.com.ySelf.util.EColor;
import br.com.ySelf.util.MatUtil;
import java.util.Stack;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.opencv.core.Mat;


public class MainWindow extends javax.swing.JFrame {

    private Mat img;
    private Stack<Mat> previous;
    private Stack<Mat> next;
    private int waveLength;
    private EColor color; 
    
    public MainWindow() {
        
        this.setLocationRelativeTo(null); 
        previous = new Stack<>();
        next = new Stack<>();
        
        initComponents();
        
        GlitchWave.setLocationRelativeTo(null);
        GlitchWave.setSize(400, 200);
  
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GlitchWave = new javax.swing.JDialog();
        blue = new javax.swing.JRadioButton();
        Red = new javax.swing.JRadioButton();
        yellow = new javax.swing.JRadioButton();
        okButton = new javax.swing.JButton();
        txtxLength = new javax.swing.JTextField();
        lb = new javax.swing.JLabel();
        lPhoto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        photoSelection = new javax.swing.JMenu();
        options = new javax.swing.JMenu();
        ctrlZ = new javax.swing.JMenuItem();
        ctrlY = new javax.swing.JMenuItem();
        btMasks = new javax.swing.JMenu();
        dogMask = new javax.swing.JMenuItem();
        glasses1Mask = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        filter = new javax.swing.JMenu();
        gray = new javax.swing.JMenuItem();
        blur = new javax.swing.JMenuItem();
        inversor = new javax.swing.JMenuItem();
        glitchButton = new javax.swing.JMenu();
        glitchWave = new javax.swing.JMenuItem();

        blue.setText("Blue");

        Red.setText("Red");

        yellow.setText("Yellow");

        okButton.setText("Okay");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        lb.setText("Tamanho:");

        javax.swing.GroupLayout GlitchWaveLayout = new javax.swing.GroupLayout(GlitchWave.getContentPane());
        GlitchWave.getContentPane().setLayout(GlitchWaveLayout);
        GlitchWaveLayout.setHorizontalGroup(
            GlitchWaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GlitchWaveLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(GlitchWaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GlitchWaveLayout.createSequentialGroup()
                        .addComponent(yellow)
                        .addGap(35, 35, 35)
                        .addComponent(blue)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GlitchWaveLayout.createSequentialGroup()
                        .addComponent(lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtxLength, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(GlitchWaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Red)
                    .addComponent(okButton))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        GlitchWaveLayout.setVerticalGroup(
            GlitchWaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GlitchWaveLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(GlitchWaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yellow)
                    .addComponent(blue)
                    .addComponent(Red))
                .addGap(18, 18, 18)
                .addGroup(GlitchWaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtxLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton)
                    .addComponent(lb))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lPhoto.setText(" ");

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

        glasses1Mask.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        glasses1Mask.setIcon(new javax.swing.ImageIcon("C:\\Users\\igor.lima\\Documents\\NetBeansProjects\\ySelf\\img\\icon\\glasses_1.png")); // NOI18N
        glasses1Mask.setText("Óculos 1");
        glasses1Mask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glasses1MaskActionPerformed(evt);
            }
        });
        btMasks.add(glasses1Mask);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\igor.lima\\Documents\\NetBeansProjects\\ySelf\\img\\icon\\glasses_2.png")); // NOI18N
        jMenuItem1.setText("Óculos 2");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        btMasks.add(jMenuItem1);

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

        glitchButton.setText("Glitch");

        glitchWave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK));
        glitchWave.setText("Wave");
        glitchWave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glitchWaveActionPerformed(evt);
            }
        });
        glitchButton.add(glitchWave);

        jMenuBar1.add(glitchButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lPhoto)
                .addGap(0, 559, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lPhoto)
                .addGap(0, 376, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void photoSelectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_photoSelectionMouseClicked
        
        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            
            String photoPath = fileChooser.getSelectedFile().getAbsolutePath();
            img = MatUtil.readImg(photoPath);
            
            MatUtil.show(img, lPhoto);
            
            previous.clear();
            next.clear();
            
            lPhoto.setText("");
        }
    }//GEN-LAST:event_photoSelectionMouseClicked

    private void dogMaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dogMaskActionPerformed
        
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.dog(newImg, MatUtil.DOG_PNG);
        MatUtil.show(newImg, lPhoto);
        
        previous.push(img);
        img = newImg;
    }//GEN-LAST:event_dogMaskActionPerformed

    private void ctrlZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlZActionPerformed
        if(!previous.isEmpty()){
            next.push(img);
            img = previous.pop();
            MatUtil.show(img, lPhoto);
        } else 
            JOptionPane.showMessageDialog(null, "Não há mais oque desfazer!");
    }//GEN-LAST:event_ctrlZActionPerformed

    private void ctrlYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlYActionPerformed
        if (!next.isEmpty()){
            previous.push(img);
            img = next.pop();
            MatUtil.show(img, lPhoto);
        } else
            JOptionPane.showMessageDialog(null, "Não há mais oque refazer!");
    }//GEN-LAST:event_ctrlYActionPerformed

    private void grayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayActionPerformed
        
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.grayScale(newImg);
        MatUtil.show(newImg, lPhoto);
        
        previous.push(img);
        img = newImg;
    }//GEN-LAST:event_grayActionPerformed

    private void blurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blurActionPerformed
        
        int blurLevel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nível de desfoque",JOptionPane.WARNING_MESSAGE));
        
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.blur(newImg,blurLevel);
        MatUtil.show(newImg, lPhoto);
        
        previous.push(img);
        img = newImg;
        
    }//GEN-LAST:event_blurActionPerformed

    private void inversorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inversorActionPerformed
       
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.inversor(newImg);
        MatUtil.show(newImg, lPhoto);
        
        previous.push(img);
        img = newImg;
        
    }//GEN-LAST:event_inversorActionPerformed

    private void glasses1MaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glasses1MaskActionPerformed
        
        try{
            
            Mat newImg = MatUtil.copy(img);
        
            MatUtil.glasses(newImg, MatUtil.GLASSES_1);
            MatUtil.show(newImg, lPhoto);

            previous.push(img);
            img = newImg;
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Combinação de efeitos inválida!");
        }
    }//GEN-LAST:event_glasses1MaskActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        try {
            
            Mat newImg = MatUtil.copy(img);
        
            MatUtil.glasses(newImg, MatUtil.GLASSES_2);
            MatUtil.show(newImg, lPhoto);

            previous.push(img);
            img = newImg;
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Combinação de efeitos inválida!");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void glitchWaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glitchWaveActionPerformed
        
        
        GlitchWave.setModal(true);
        GlitchWave.setVisible(true);
        
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.glitchWave(newImg, waveLength, color);
        MatUtil.show(newImg, lPhoto);

        previous.push(img);
        img = newImg;
        
    }//GEN-LAST:event_glitchWaveActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        try {

            waveLength = Integer.parseInt(txtxLength.getText());

            if (yellow.isValid())
                color = EColor.YELLOW;
            else if (blue.isValid())
                color = EColor.BLUE;
            else
                color = EColor.RED;
            
            
            GlitchWave.dispose();

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro no preenchimento!");
        }
    }//GEN-LAST:event_okButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog GlitchWave;
    private javax.swing.JRadioButton Red;
    private javax.swing.JRadioButton blue;
    private javax.swing.JMenuItem blur;
    private javax.swing.JMenu btMasks;
    private javax.swing.JMenuItem ctrlY;
    private javax.swing.JMenuItem ctrlZ;
    private javax.swing.JMenuItem dogMask;
    private javax.swing.JMenu filter;
    private javax.swing.JMenuItem glasses1Mask;
    private javax.swing.JMenu glitchButton;
    private javax.swing.JMenuItem glitchWave;
    private javax.swing.JMenuItem gray;
    private javax.swing.JMenuItem inversor;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lPhoto;
    private javax.swing.JLabel lb;
    private javax.swing.JButton okButton;
    private javax.swing.JMenu options;
    private javax.swing.JMenu photoSelection;
    private javax.swing.JTextField txtxLength;
    private javax.swing.JRadioButton yellow;
    // End of variables declaration//GEN-END:variables
}
