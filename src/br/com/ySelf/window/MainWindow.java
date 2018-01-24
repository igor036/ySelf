/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
*/


package br.com.ySelf.window;

import br.com.ySelf.util.EColor;
import br.com.ySelf.util.MatUtil;
import java.awt.Color;
import java.awt.Component;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import org.opencv.core.Mat;


public class MainWindow extends javax.swing.JFrame {

    //control of photo
    private Mat img;              //actually
    private Mat temp;             //temp
    private Stack<Mat> previous; //ctrl+z 
    private Stack<Mat> next;     //ctrl+y
    
    //glitch wave
    private int waveLength;
    private EColor color;
   
    //widget
    private String widgetPath;
    private final List<String> WIDGET_EXTENSION;
    private final List<JLabel> WIDGETS;
    
    //outer's
    private final JLabel REGION; //select region
    private Mat copyRegion;           //copy region
    
    //control variables of listeners
    private boolean addingWidget = false;
    private boolean selectRegion = false;
    private boolean copying      = false;
    
    public MainWindow() {
        
        initComponents();
        addMouseListeners();
        
        setResizable(false);
        GlitchWave.setLocationRelativeTo(null);
        GlitchWave.setSize(400, 200);
        GlitchVHS.setSize(500, 200);
        Propertys.setSize(400,200);
        
        WIDGET_EXTENSION = new ArrayList<>();
        WIDGETS = new ArrayList<>();
        previous = new Stack<>();
        next = new Stack<>();
        REGION = new JLabel();
        
        WIDGET_EXTENSION.add("JPG");
        WIDGET_EXTENSION.add("JPEG");
        WIDGET_EXTENSION.add("PNG");
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
        colors = new javax.swing.ButtonGroup();
        GlitchVHS = new javax.swing.JDialog();
        vhs_1 = new javax.swing.JRadioButton();
        vhs_2 = new javax.swing.JRadioButton();
        vhs_3 = new javax.swing.JRadioButton();
        vhs_4 = new javax.swing.JRadioButton();
        vhs_date_1 = new javax.swing.JRadioButton();
        vhs_date_2 = new javax.swing.JRadioButton();
        vhs_1_icon = new javax.swing.JLabel();
        vhs_2_icon = new javax.swing.JLabel();
        vhs_3_icon = new javax.swing.JLabel();
        vhs_4_icon = new javax.swing.JLabel();
        vhs_1_icon4 = new javax.swing.JLabel();
        vhs_1_icon5 = new javax.swing.JLabel();
        btnVhs = new javax.swing.JButton();
        vhs = new javax.swing.ButtonGroup();
        Propertys = new javax.swing.JDialog();
        darkenLabel = new javax.swing.JLabel();
        darkenBar = new javax.swing.JScrollBar();
        lightenLabel = new javax.swing.JLabel();
        lightenBar = new javax.swing.JScrollBar();
        panel = new javax.swing.JPanel();
        lPhoto = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        menuBar = new javax.swing.JMenuBar();
        photoSelection = new javax.swing.JMenu();
        options = new javax.swing.JMenu();
        ctrlZ = new javax.swing.JMenuItem();
        ctrlY = new javax.swing.JMenuItem();
        widgetBt = new javax.swing.JMenuItem();
        copy = new javax.swing.JMenuItem();
        cut = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        btMasks = new javax.swing.JMenu();
        dogMask = new javax.swing.JMenuItem();
        glasses1Mask = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        filter = new javax.swing.JMenu();
        gray = new javax.swing.JMenuItem();
        blur = new javax.swing.JMenuItem();
        inversor = new javax.swing.JMenuItem();
        morphology = new javax.swing.JMenuItem();
        glitchButton = new javax.swing.JMenu();
        glitchWave = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        tools = new javax.swing.JMenu();
        select = new javax.swing.JMenuItem();
        propertys = new javax.swing.JMenu();

        colors.add(blue);
        blue.setText("Blue");

        colors.add(Red);
        Red.setText("Red");

        colors.add(yellow);
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

        GlitchVHS.setResizable(false);

        vhs.add(vhs_1);
        vhs_1.setText("VHS_1");

        vhs.add(vhs_2);
        vhs_2.setText("VHS_2");

        vhs.add(vhs_3);
        vhs_3.setText("VHS_3");

        vhs.add(vhs_4);
        vhs_4.setText("VHS_4");

        vhs.add(vhs_date_1);
        vhs_date_1.setText("VHS_DATE_1");

        vhs.add(vhs_date_2);
        vhs_date_2.setText("VHS_DATE_2");

        vhs_1_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\igor.lima\\Documents\\NetBeansProjects\\ySelf\\img\\icon\\vhs\\1.jpg")); // NOI18N

        vhs_2_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\igor.lima\\Documents\\NetBeansProjects\\ySelf\\img\\icon\\vhs\\2.jpg")); // NOI18N

        vhs_3_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\igor.lima\\Documents\\NetBeansProjects\\ySelf\\img\\icon\\vhs\\3.jpg")); // NOI18N

        vhs_4_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\igor.lima\\Documents\\NetBeansProjects\\ySelf\\img\\icon\\vhs\\4.jpg")); // NOI18N

        vhs_1_icon4.setIcon(new javax.swing.ImageIcon("C:\\Users\\igor.lima\\Documents\\NetBeansProjects\\ySelf\\img\\icon\\vhs\\vhs_date1.png")); // NOI18N

        vhs_1_icon5.setIcon(new javax.swing.ImageIcon("C:\\Users\\igor.lima\\Documents\\NetBeansProjects\\ySelf\\img\\icon\\vhs\\vhs_date2.jpg")); // NOI18N

        btnVhs.setText("Aplicar");
        btnVhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVhsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GlitchVHSLayout = new javax.swing.GroupLayout(GlitchVHS.getContentPane());
        GlitchVHS.getContentPane().setLayout(GlitchVHSLayout);
        GlitchVHSLayout.setHorizontalGroup(
            GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GlitchVHSLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GlitchVHSLayout.createSequentialGroup()
                        .addComponent(vhs_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vhs_1_icon))
                    .addGroup(GlitchVHSLayout.createSequentialGroup()
                        .addComponent(vhs_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vhs_2_icon)))
                .addGap(32, 32, 32)
                .addGroup(GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(GlitchVHSLayout.createSequentialGroup()
                        .addComponent(vhs_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vhs_3_icon)
                        .addGap(30, 30, 30)
                        .addComponent(vhs_date_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vhs_1_icon5))
                    .addGroup(GlitchVHSLayout.createSequentialGroup()
                        .addGroup(GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVhs)
                            .addGroup(GlitchVHSLayout.createSequentialGroup()
                                .addComponent(vhs_4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vhs_4_icon)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vhs_date_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vhs_1_icon4)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        GlitchVHSLayout.setVerticalGroup(
            GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GlitchVHSLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GlitchVHSLayout.createSequentialGroup()
                        .addGroup(GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vhs_1)
                            .addComponent(vhs_1_icon))
                        .addGap(18, 18, 18)
                        .addGroup(GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vhs_2)
                            .addComponent(vhs_2_icon)))
                    .addGroup(GlitchVHSLayout.createSequentialGroup()
                        .addGroup(GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(vhs_3)
                                .addComponent(vhs_3_icon))
                            .addComponent(vhs_date_2)
                            .addComponent(vhs_1_icon5))
                        .addGap(15, 15, 15)
                        .addGroup(GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vhs_4)
                            .addComponent(vhs_4_icon)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GlitchVHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(vhs_date_1)
                                .addComponent(vhs_1_icon4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnVhs)
                .addContainerGap())
        );

        darkenLabel.setText("Escurecer:");

        darkenBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        darkenBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                darkenBarMouseReleased(evt);
            }
        });
        darkenBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                darkenBarAdjustmentValueChanged(evt);
            }
        });

        lightenLabel.setText("Clarear:");

        lightenBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        lightenBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lightenBarMouseReleased(evt);
            }
        });
        lightenBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                lightenBarAdjustmentValueChanged(evt);
            }
        });

        javax.swing.GroupLayout PropertysLayout = new javax.swing.GroupLayout(Propertys.getContentPane());
        Propertys.getContentPane().setLayout(PropertysLayout);
        PropertysLayout.setHorizontalGroup(
            PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropertysLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(darkenLabel)
                    .addComponent(lightenLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lightenBar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(darkenBar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        PropertysLayout.setVerticalGroup(
            PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropertysLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(darkenBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(darkenLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lightenBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lightenLabel))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lPhoto.setText("Selecione uma imagem  ...");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lPhoto)
                .addGap(0, 438, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lPhoto)
                .addGap(0, 376, Short.MAX_VALUE))
        );

        photoSelection.setText("Selecionar Foto");
        photoSelection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoSelectionMouseClicked(evt);
            }
        });
        menuBar.add(photoSelection);

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

        widgetBt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        widgetBt.setText("Widget");
        widgetBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widgetBtActionPerformed(evt);
            }
        });
        options.add(widgetBt);

        copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copy.setText("Copiar");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        options.add(copy);

        cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        cut.setText("Cortar");
        cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });
        options.add(cut);

        delete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        delete.setText("Deletar");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        options.add(delete);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Salvar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        options.add(save);

        menuBar.add(options);

        btMasks.setText("Mascaras");

        dogMask.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.CTRL_MASK));
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

        menuBar.add(btMasks);

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

        morphology.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        morphology.setText("Morfologia");
        morphology.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                morphologyActionPerformed(evt);
            }
        });
        filter.add(morphology);

        menuBar.add(filter);

        glitchButton.setText("Glitch");

        glitchWave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK));
        glitchWave.setText("Wave");
        glitchWave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glitchWaveActionPerformed(evt);
            }
        });
        glitchButton.add(glitchWave);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("VHS");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        glitchButton.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Somar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        glitchButton.add(jMenuItem3);

        menuBar.add(glitchButton);

        tools.setText("Ferramentas");

        select.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        select.setText("Selecionar");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        tools.add(select);

        menuBar.add(tools);

        propertys.setText("Propriedades");
        propertys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                propertysMouseClicked(evt);
            }
        });
        menuBar.add(propertys);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            
            this.setSize(img.width(), img.height());
        }
    }//GEN-LAST:event_photoSelectionMouseClicked

    private void dogMaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dogMaskActionPerformed
        
        Mat newImg = MatUtil.copy(img);
        
        MatUtil.dog(newImg);
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
        
        if (!next.isEmpty()) {
            
            previous.push(img);
            img = next.pop();
            MatUtil.show(img, lPhoto);
        
        } else
            JOptionPane.showMessageDialog(null, "Não há mais oque refazer!");
    }//GEN-LAST:event_ctrlYActionPerformed

    private void grayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayActionPerformed
        
        Mat newImg = MatUtil.copy(img);
        
        if (selectRegion) {
            
            MatUtil.grayScale(newImg,MatUtil.getRect(REGION));
            removeRegion();
       
        } else
            MatUtil.grayScale(newImg);
        
        MatUtil.show(newImg, lPhoto);
        
        previous.push(img);
        img = newImg;
    }//GEN-LAST:event_grayActionPerformed

    private void blurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blurActionPerformed
        
        int blurLevel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nível de desfoque",JOptionPane.WARNING_MESSAGE));
        
        Mat newImg = MatUtil.copy(img);
        
        if (selectRegion) {
            
            MatUtil.blur(newImg,blurLevel,MatUtil.getRect(REGION));
            removeRegion();
            
        } else
            MatUtil.blur(newImg,blurLevel);
        
        MatUtil.show(newImg, lPhoto);
        
        previous.push(img);
        img = newImg;
        
    }//GEN-LAST:event_blurActionPerformed

    private void inversorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inversorActionPerformed
       
        Mat newImg = MatUtil.copy(img);
        
        if (selectRegion) {
            MatUtil.inversor(newImg,MatUtil.getRect(REGION));
            removeRegion();
        } else
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
        
        if (selectRegion){
            MatUtil.glitchWave(newImg, waveLength, color,MatUtil.getRect(REGION));
            removeRegion();
        } else
            MatUtil.glitchWave(newImg, waveLength, color);
        
        MatUtil.show(newImg, lPhoto);

        previous.push(img);
        img = newImg;
        
    }//GEN-LAST:event_glitchWaveActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        try {

            waveLength = Integer.parseInt(txtxLength.getText());

            /* !! ALERT: improve, make dynamic verification */
            if (yellow.isSelected())
                color = EColor.YELLOW;
            else if (blue.isSelected())
                color = EColor.BLUE;
            else
                color = EColor.RED;
            
            
            GlitchWave.dispose();

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro no preenchimento!");
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void morphologyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_morphologyActionPerformed
        
        try{
            
            int morph_size = Integer.parseInt(JOptionPane.showInputDialog(null, "Tamanho"));
            
            Mat newImg = MatUtil.copy(img);
        
            if (selectRegion){
                MatUtil.morphology(newImg, morph_size,MatUtil.getRect(REGION));
                removeRegion();
            } else
                MatUtil.morphology(newImg, morph_size);
            MatUtil.show(newImg, lPhoto);

            previous.push(img);
            img = newImg;
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Tente novamente!");
        }
        
    }//GEN-LAST:event_morphologyActionPerformed

    private void btnVhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVhsActionPerformed
      GlitchVHS.dispose();  
    }//GEN-LAST:event_btnVhsActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
           
        try {
        
            GlitchVHS.setModal(true);
            GlitchVHS.setVisible(true);
        
            Mat newImg = MatUtil.copy(img);
        
            /* !! ALERT: improve, make dynamic verification */
            if(vhs_1.isSelected())
                MatUtil.vhs(newImg, MatUtil.VHS_1);
            else if(vhs_2.isSelected())
                MatUtil.vhs(newImg, MatUtil.VHS_2);
            else if(vhs_3.isSelected())
                MatUtil.vhs(newImg, MatUtil.VHS_3);
            else if(vhs_4.isSelected())
                MatUtil.vhs(newImg, MatUtil.VHS_4);
            else if(vhs_date_1.isSelected())
                MatUtil.vhs(newImg, MatUtil.VHS_DATE_1);
            else 
                MatUtil.vhs(newImg, MatUtil.VHS_DATE_2);
            
            MatUtil.show(newImg, lPhoto);
            
            previous.push(img);
            img = newImg;
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Tente novamente!");
            System.out.println("ERRO: "+ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void widgetBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widgetBtActionPerformed
        
        disableListeners();
        
        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            
            widgetPath = fileChooser.getSelectedFile().getAbsolutePath();

            if (WIDGET_EXTENSION.contains(widgetPath.substring(widgetPath.lastIndexOf(".")+1).toUpperCase())) {    
                
                
                Mat widget = MatUtil.readImg(widgetPath);
                JLabel widgetLabel = new JLabel(new ImageIcon(widgetPath));
                widgetLabel.setBounds(this.getX()/2, this.getY()/2, widget.cols(), widget.rows());

                panel.setLayout(null);
                panel.add(widgetLabel);
                panel.setComponentZOrder(widgetLabel, 0);
                
                for (int i = 1; i < WIDGETS.size(); i++)
                    panel.setComponentZOrder(WIDGETS.get(i), i);
                
                panel.setComponentZOrder(lPhoto, WIDGETS.size()+1);
                panel.repaint();
                panel.revalidate();
                
                WIDGETS.add(widgetLabel);
                
                addingWidget = true;
                
            } else 
                JOptionPane.showMessageDialog(null, "O arquivo selecionado não é válido!");
        }
        
    }//GEN-LAST:event_widgetBtActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        
        if (img != null) {
            
            try {
                
                JFileChooser fileChooser = new JFileChooser();

                if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    
                    Mat newImg = MatUtil.copy(img);
                    
                    for (JLabel widget : WIDGETS) {
                        MatUtil.widget(newImg, MatUtil.readImg(widget.getIcon().toString()), widget.getX() ,widget.getY());
                        panel.remove(widget);
                    }
                    
                    MatUtil.show(newImg, lPhoto);

                    previous.push(img);
                    img = newImg;
                    
                    MatUtil.save(fileChooser.getSelectedFile().getAbsolutePath(), img);
                    JOptionPane.showMessageDialog(null, "Salvo!");
                    
                    WIDGETS.clear();
                    
                    addingWidget = false;
                }
                
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar, tente colocar o caminho com o nome do arquivo!");
                System.out.println(ex.getMessage());
            }
            
        }
    }//GEN-LAST:event_saveActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        
        JFileChooser fileChooser = new JFileChooser();
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            
             Mat newImg = MatUtil.copy(img);
             
             MatUtil.sumMat(newImg, MatUtil.readImg(fileChooser.getSelectedFile().getAbsolutePath()));
             MatUtil.show(newImg, lPhoto);
             
             previous.push(img);
             img = newImg;
                    
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        disableListeners();
        selectRegion = true;
    }//GEN-LAST:event_selectActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            
            if (selectRegion)
                removeRegion();
            else if (addingWidget)
                removeWidget();
            else if (copying) 
                disablePasteMode();
        }
    }//GEN-LAST:event_formKeyPressed

    private void cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutActionPerformed
        
        if (!selectRegion)
            JOptionPane.showMessageDialog(null, "Selecione uma área primeiro!");
        else {

            Mat newImg =MatUtil.cut(img, MatUtil.getRect(REGION));
            MatUtil.show(newImg, lPhoto);
            
            previous.push(img);
            img = newImg;
            
            removeRegion();
        }
    }//GEN-LAST:event_cutActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        if (!selectRegion)
            JOptionPane.showMessageDialog(null, "Selecione uma área primeiro!");
        else {

            Mat newImg = MatUtil.copy(img);
            MatUtil.delete(newImg, MatUtil.getRect(REGION));
            MatUtil.show(newImg, lPhoto);
            
            previous.push(img);
            img = newImg;
            
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        
        disableListeners();
        
        copying = true;
        copyRegion = img.submat(MatUtil.getRect(REGION));
        
        JLabel lbRegion = new JLabel();
        MatUtil.show(copyRegion, lbRegion);
        
        REGION.setLayout(null);
        REGION.add(lbRegion);
        REGION.repaint();
        REGION.revalidate();
        
    }//GEN-LAST:event_copyActionPerformed

    private void darkenBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_darkenBarAdjustmentValueChanged
        applyDarken(darkenBar.getValue(), false);
    }//GEN-LAST:event_darkenBarAdjustmentValueChanged

    private void propertysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertysMouseClicked
        temp = MatUtil.copy(img);
        Propertys.setModal(true);
        Propertys.setVisible(true);
        previous.push(img);
        img = temp;
        restartPorpertyComponentsValues();
    }//GEN-LAST:event_propertysMouseClicked

    private void lightenBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_lightenBarAdjustmentValueChanged
        applyLighten(lightenBar.getValue(), false);
    }//GEN-LAST:event_lightenBarAdjustmentValueChanged

    private void darkenBarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_darkenBarMouseReleased
        applyDarken(darkenBar.getValue(), true);
    }//GEN-LAST:event_darkenBarMouseReleased

    private void lightenBarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lightenBarMouseReleased
        applyLighten(lightenBar.getValue(), true);
    }//GEN-LAST:event_lightenBarMouseReleased
    
    
    
    //util's method's
    
    private void addMouseListeners() {
        
        panel.addMouseMotionListener(new MouseAdapter() {
            
            @Override
            public void mouseDragged(MouseEvent e) {
                if (addingWidget)
                    updateWidgetLocation(e.getPoint());
                else if (selectRegion)
                    setRegionSize(e.getX(), e.getY());
            }
            
            @Override
            public void mouseMoved(MouseEvent e) {
                if (copying){
                    REGION.setLocation(e.getPoint());
                    REGION.repaint();
                }
            }
        });
        
        panel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (addingWidget)
                    updateWidgetLocation(e.getPoint());
                else if (selectRegion)
                    addRegion(e.getPoint());
                else if (copying)
                    paste();
            }
        });
    }
    
    private void paste() {
        
        Mat newImg = MatUtil.copy(img);
        MatUtil.copyToRegion(newImg, copyRegion, MatUtil.getRect(REGION));
        MatUtil.show(newImg, lPhoto);
        
        previous.push(img);
        img = newImg;
    }
    
    private void updateWidgetLocation(Point p) {
        
        if (!WIDGETS.isEmpty()) {
            
            p.setLocation(p.x+2, p.y-47);
            
            JLabel widgetLabel = WIDGETS.get(WIDGETS.size()-1);
            widgetLabel.setLocation(p);
            widgetLabel.repaint();
        }
    }
    
    private void addRegion(Point p){
        
        REGION.setLocation(p);
        REGION.setSize(20, 20);
        REGION.setBorder(BorderFactory.createLineBorder(Color.cyan));
        
        panel.setLayout(null);
        panel.add(REGION);
        panel.setComponentZOrder(REGION, 0);
        
        for (int i = 1; i < WIDGETS.size(); i++)
            panel.setComponentZOrder(WIDGETS.get(i), i);

        panel.setComponentZOrder(lPhoto, WIDGETS.size()+1);
        panel.repaint();
        panel.revalidate();
        
    }
    
    private void setRegionSize(int width, int height) {
        
        width  -= REGION.getX() *2;
        height -= REGION.getY() *2;
        
        REGION.setBounds(REGION.getX(), REGION.getY(), REGION.getX() + width, REGION.getX() + height);
    }
    
    private void removeRegion(){
        
        panel.setLayout(null);
        panel.remove(REGION);
        panel.repaint();
        panel.revalidate();
        selectRegion = false;
    }
    
    private void removeWidget(){
        
        if(!WIDGETS.isEmpty()) {
        
            JLabel widget = WIDGETS.get(WIDGETS.size()-1);
            WIDGETS.remove(WIDGETS.size()-1);
            
            panel.setLayout(null);
            panel.remove(widget);
            panel.repaint();
            panel.revalidate();
        }
        
    }
    
    private void applyLighten(int level, boolean replace){
        
        Mat copy = MatUtil.copy(temp);
        
        if (selectRegion)
            MatUtil.lighten(copy, level, MatUtil.getRect(REGION));
        else
            MatUtil.lighten(copy, level);
        
        MatUtil.show(copy, lPhoto);
        
        if (replace)
            temp = copy;
        
    }
    
    private void applyDarken(int level, boolean replace){
        
        Mat copy = MatUtil.copy(temp);
        
        if (selectRegion)
            MatUtil.darken(copy, level, MatUtil.getRect(REGION));
        else
            MatUtil.darken(copy, level);
        
        MatUtil.show(copy, lPhoto);
        
        if (replace)
            temp = copy;
        
    }
    
    private void restartPorpertyComponentsValues(){
        Component[] components = Propertys.getContentPane().getComponents();
        for (Component c : components)
            if ( c instanceof  JScrollBar )
                ((JScrollBar)c).setValue(0);
    }
    
    private void disablePasteMode(){
        removeRegion();
        REGION.removeAll();
        copyRegion = null;
    }
    
    private void disableListeners(){
        selectRegion = copying = addingWidget = false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog GlitchVHS;
    private javax.swing.JDialog GlitchWave;
    private javax.swing.JDialog Propertys;
    private javax.swing.JRadioButton Red;
    private javax.swing.JRadioButton blue;
    private javax.swing.JMenuItem blur;
    private javax.swing.JMenu btMasks;
    private javax.swing.JButton btnVhs;
    private javax.swing.ButtonGroup colors;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem ctrlY;
    private javax.swing.JMenuItem ctrlZ;
    private javax.swing.JMenuItem cut;
    private javax.swing.JScrollBar darkenBar;
    private javax.swing.JLabel darkenLabel;
    private javax.swing.JMenuItem delete;
    private javax.swing.JMenuItem dogMask;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenu filter;
    private javax.swing.JMenuItem glasses1Mask;
    private javax.swing.JMenu glitchButton;
    private javax.swing.JMenuItem glitchWave;
    private javax.swing.JMenuItem gray;
    private javax.swing.JMenuItem inversor;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lPhoto;
    private javax.swing.JLabel lb;
    private javax.swing.JScrollBar lightenBar;
    private javax.swing.JLabel lightenLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem morphology;
    private javax.swing.JButton okButton;
    private javax.swing.JMenu options;
    private javax.swing.JPanel panel;
    private javax.swing.JMenu photoSelection;
    private javax.swing.JMenu propertys;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem select;
    private javax.swing.JMenu tools;
    private javax.swing.JTextField txtxLength;
    private javax.swing.ButtonGroup vhs;
    private javax.swing.JRadioButton vhs_1;
    private javax.swing.JLabel vhs_1_icon;
    private javax.swing.JLabel vhs_1_icon4;
    private javax.swing.JLabel vhs_1_icon5;
    private javax.swing.JRadioButton vhs_2;
    private javax.swing.JLabel vhs_2_icon;
    private javax.swing.JRadioButton vhs_3;
    private javax.swing.JLabel vhs_3_icon;
    private javax.swing.JRadioButton vhs_4;
    private javax.swing.JLabel vhs_4_icon;
    private javax.swing.JRadioButton vhs_date_1;
    private javax.swing.JRadioButton vhs_date_2;
    private javax.swing.JMenuItem widgetBt;
    private javax.swing.JRadioButton yellow;
    // End of variables declaration//GEN-END:variables
}
