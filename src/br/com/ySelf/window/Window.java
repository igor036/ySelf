/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
 */
package br.com.ySelf.window;

import br.com.ySelf.modal.EColor;
import br.com.ySelf.util.MatUtil;
import br.com.ySelf.util.Text;
import java.awt.Color;
import java.awt.Component;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MouseInputAdapter;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;

public class Window extends javax.swing.JFrame {

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
    private final JLabel REGION;       //select region
    private int rx,ry;
    private Mat copyRegion;           //copy region
    private Mat paintImg;            //image paint
    private Mat nexLayerImg;           //image use to paint
    private Mat matZoomOut;
    private Mat matZoomOutNexLayerImg;
    private JLabel  selectedWidget;
    private int lastSaturation;
   
    private JPanel zoomRegion;
    private Text text;
    
    //control variables of listeners
    private boolean selectRegion = false;
    private boolean copying = false;
    
   
    
    public Window(Mat img, String title){
        this(title);
        this.img = img;
        MatUtil.show(img, lPhoto);
        lPhoto.setSize(img.width(), img.height());
        this.setSize(img.width(), img.height());
    }
    
    public Window(String title) {

        initComponents();
        addMouseListeners();
        
        setResizable(false);
        
        GlitchWave.setLocationRelativeTo(null);
        GlitchVHS.setLocationRelativeTo(null);
        GlitchLilac.setLocationRelativeTo(null);
        Propertys.setLocationRelativeTo(null);
        
        GlitchWave.setSize(400, 200);
        GlitchVHS.setSize(500, 200);
        GlitchLilac.setSize(300, 100);
        Propertys.setSize(400, 400);
        Text.setSize(400, 400);

        WIDGET_EXTENSION = new ArrayList<>();
        WIDGETS = new ArrayList<>();
        REGION = new JLabel();
        previous = new Stack<>();
        next = new Stack<>();

        WIDGET_EXTENSION.add("JPG");
        WIDGET_EXTENSION.add("JPEG");
        WIDGET_EXTENSION.add("PNG");
        this.setTitle(title);
        
        penSize.setValue(10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GlitchWave = new javax.swing.JDialog();
        blue = new javax.swing.JRadioButton();
        Red = new javax.swing.JRadioButton();
        green = new javax.swing.JRadioButton();
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
        contrastLabel = new javax.swing.JLabel();
        brightnessLabel = new javax.swing.JLabel();
        noiseBar = new javax.swing.JScrollBar();
        lightenLabel1 = new javax.swing.JLabel();
        penSizeLabel = new javax.swing.JLabel();
        penSize = new javax.swing.JSpinner();
        penColorLabel = new javax.swing.JLabel();
        penColor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbSize = new javax.swing.JLabel();
        txtWidth = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btResize = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contrastSlide = new javax.swing.JSlider();
        brightnessSlider = new javax.swing.JSlider();
        saturationLabel = new javax.swing.JLabel();
        saturationSlider = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        goutTypePen = new javax.swing.ButtonGroup();
        GlitchLilac = new javax.swing.JDialog();
        rbtGreen = new javax.swing.JCheckBox();
        rbtBlue = new javax.swing.JCheckBox();
        rbtRed = new javax.swing.JCheckBox();
        Text = new javax.swing.JDialog();
        lbText = new javax.swing.JLabel();
        txtText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlTextColor = new javax.swing.JPanel();
        textScale = new javax.swing.JSpinner();
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
        save = new javax.swing.JMenuItem();
        zoomIn = new javax.swing.JMenuItem();
        zoomOut = new javax.swing.JMenuItem();
        writeText = new javax.swing.JMenuItem();
        focus = new javax.swing.JMenuItem();
        btMasks = new javax.swing.JMenu();
        dogMask = new javax.swing.JMenuItem();
        glasses1Mask = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        filter = new javax.swing.JMenu();
        gray = new javax.swing.JMenuItem();
        blur = new javax.swing.JMenuItem();
        inversor = new javax.swing.JMenuItem();
        morphology = new javax.swing.JMenuItem();
        cartoon = new javax.swing.JMenuItem();
        sepia = new javax.swing.JMenuItem();
        glitchButton = new javax.swing.JMenu();
        glitchWave = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        lilac = new javax.swing.JMenuItem();
        colorDetection = new javax.swing.JMenu();
        select = new javax.swing.JMenuItem();
        pen = new javax.swing.JCheckBoxMenuItem();
        eraser = new javax.swing.JCheckBoxMenuItem();
        propertys = new javax.swing.JMenu();

        GlitchWave.setTitle("Glitch Wave");

        colors.add(blue);
        blue.setText("Azul");

        colors.add(Red);
        Red.setText("Vermelho");

        colors.add(green);
        green.setText("Verde");

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
                        .addComponent(green)
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
                .addContainerGap(29, Short.MAX_VALUE))
        );
        GlitchWaveLayout.setVerticalGroup(
            GlitchWaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GlitchWaveLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(GlitchWaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(green)
                    .addComponent(blue)
                    .addComponent(Red))
                .addGap(18, 18, 18)
                .addGroup(GlitchWaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtxLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton)
                    .addComponent(lb))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GlitchVHS.setTitle("Glitch VHS");
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

        Propertys.setTitle("Propriedades");

        contrastLabel.setText("Contraste:");

        brightnessLabel.setText("Brilho:");

        noiseBar.setMaximum(255);
        noiseBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        noiseBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                noiseBarMouseReleased(evt);
            }
        });
        noiseBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                noiseBarAdjustmentValueChanged(evt);
            }
        });

        lightenLabel1.setText("Ruído:");

        penSizeLabel.setText("Tamanho do pincel:");

        penColorLabel.setText("Cor do pincel:");

        penColor.setBackground(new java.awt.Color(0, 0, 0));
        penColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout penColorLayout = new javax.swing.GroupLayout(penColor);
        penColor.setLayout(penColorLayout);
        penColorLayout.setHorizontalGroup(
            penColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        penColorLayout.setVerticalGroup(
            penColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel2.setText("Pincel");

        jLabel3.setText("Contraste");

        lbSize.setText("Tamannho(LxA): ");

        jLabel4.setText("Largura:");

        jLabel5.setText("Altura:");

        btResize.setText("Redimensionar");
        btResize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResizeActionPerformed(evt);
            }
        });

        jLabel6.setText("Ruído:");

        jLabel7.setText("Tamanho:");

        contrastSlide.setMinimum(-100);
        contrastSlide.setToolTipText("");
        contrastSlide.setValue(0);
        contrastSlide.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                contrastSlideStateChanged(evt);
            }
        });

        brightnessSlider.setMinimum(1);
        brightnessSlider.setToolTipText("");
        brightnessSlider.setValue(1);
        brightnessSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brightnessSliderStateChanged(evt);
            }
        });

        saturationLabel.setText("Saturação:");

        saturationSlider.setMinimum(-100);
        saturationSlider.setToolTipText("");
        saturationSlider.setValue(1);
        saturationSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                saturationSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PropertysLayout = new javax.swing.GroupLayout(Propertys.getContentPane());
        Propertys.getContentPane().setLayout(PropertysLayout);
        PropertysLayout.setHorizontalGroup(
            PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropertysLayout.createSequentialGroup()
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PropertysLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel3))
                    .addGroup(PropertysLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PropertysLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PropertysLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(PropertysLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(2, 2, 2)
                                                .addComponent(txtWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel5))
                                            .addComponent(lbSize))
                                        .addGap(5, 5, 5)
                                        .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PropertysLayout.createSequentialGroup()
                                        .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(penSizeLabel)
                                            .addComponent(penColorLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(penSize, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(penColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PropertysLayout.createSequentialGroup()
                                .addComponent(lightenLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(noiseBar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PropertysLayout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel2))))
                    .addGroup(PropertysLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btResize))
                    .addGroup(PropertysLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PropertysLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel6))
                    .addGroup(PropertysLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel7))
                    .addGroup(PropertysLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contrastLabel)
                            .addComponent(brightnessLabel)
                            .addComponent(saturationLabel))
                        .addGap(28, 28, 28)
                        .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saturationSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brightnessSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contrastSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        PropertysLayout.setVerticalGroup(
            PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropertysLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PropertysLayout.createSequentialGroup()
                        .addComponent(contrastSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brightnessSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PropertysLayout.createSequentialGroup()
                        .addComponent(contrastLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brightnessLabel)))
                .addGap(18, 18, 18)
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saturationSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saturationLabel))
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noiseBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lightenLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(penSizeLabel)
                    .addComponent(penSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(penColorLabel)
                    .addComponent(penColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbSize)
                .addGap(24, 24, 24)
                .addGroup(PropertysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(btResize)
                .addGap(42, 42, 42))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        GlitchLilac.setTitle("Glitch Lilás");

        rbtGreen.setText("Verde");

        rbtBlue.setText("Azul");

        rbtRed.setText("Vermelho");

        javax.swing.GroupLayout GlitchLilacLayout = new javax.swing.GroupLayout(GlitchLilac.getContentPane());
        GlitchLilac.getContentPane().setLayout(GlitchLilacLayout);
        GlitchLilacLayout.setHorizontalGroup(
            GlitchLilacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GlitchLilacLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(rbtGreen)
                .addGap(18, 18, 18)
                .addComponent(rbtBlue)
                .addGap(34, 34, 34)
                .addComponent(rbtRed)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        GlitchLilacLayout.setVerticalGroup(
            GlitchLilacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GlitchLilacLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(GlitchLilacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtGreen)
                    .addComponent(rbtBlue)
                    .addComponent(rbtRed))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lbText.setText("Texto:");

        jLabel1.setText("Tamanho:");

        jLabel8.setText("Cor:");

        pnlTextColor.setBackground(new java.awt.Color(0, 0, 0));
        pnlTextColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTextColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlTextColorLayout = new javax.swing.GroupLayout(pnlTextColor);
        pnlTextColor.setLayout(pnlTextColorLayout);
        pnlTextColorLayout.setHorizontalGroup(
            pnlTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        pnlTextColorLayout.setVerticalGroup(
            pnlTextColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        textScale.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                textScaleStateChanged(evt);
            }
        });

        javax.swing.GroupLayout TextLayout = new javax.swing.GroupLayout(Text.getContentPane());
        Text.getContentPane().setLayout(TextLayout);
        TextLayout.setHorizontalGroup(
            TextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TextLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbText)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textScale, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        TextLayout.setVerticalGroup(
            TextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(TextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbText)
                    .addComponent(txtText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(TextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(pnlTextColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addGap(0, 307, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lPhoto)
                .addContainerGap(306, Short.MAX_VALUE))
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

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Salvar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        options.add(save);

        zoomIn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_EQUALS, java.awt.event.InputEvent.SHIFT_MASK));
        zoomIn.setText("Zoom +");
        zoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInActionPerformed(evt);
            }
        });
        options.add(zoomIn);

        zoomOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_MINUS, java.awt.event.InputEvent.SHIFT_MASK));
        zoomOut.setText("Zoom -");
        zoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutActionPerformed(evt);
            }
        });
        options.add(zoomOut);

        writeText.setText("Texto");
        writeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeTextActionPerformed(evt);
            }
        });
        options.add(writeText);

        focus.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        focus.setText("Focar");
        focus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                focusActionPerformed(evt);
            }
        });
        options.add(focus);

        menuBar.add(options);

        btMasks.setText("Mascaras");

        dogMask.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.CTRL_MASK));
        dogMask.setText("Cachorro");
        dogMask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dogMaskActionPerformed(evt);
            }
        });
        btMasks.add(dogMask);

        glasses1Mask.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        glasses1Mask.setText("Óculos 1");
        glasses1Mask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glasses1MaskActionPerformed(evt);
            }
        });
        btMasks.add(glasses1Mask);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
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

        cartoon.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        cartoon.setText("Desenho");
        cartoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartoonActionPerformed(evt);
            }
        });
        filter.add(cartoon);

        sepia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        sepia.setText("Sépia");
        sepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepiaActionPerformed(evt);
            }
        });
        filter.add(sepia);

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

        lilac.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        lilac.setText("Lilás");
        lilac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lilacActionPerformed(evt);
            }
        });
        glitchButton.add(lilac);

        menuBar.add(glitchButton);

        colorDetection.setText("Ferramentas");

        select.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        select.setText("Selecionar");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        colorDetection.add(select);

        pen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        pen.setText("Pincel");
        colorDetection.add(pen);

        eraser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.SHIFT_MASK));
        eraser.setText("Borracha");
        colorDetection.add(eraser);

        menuBar.add(colorDetection);

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

            lPhoto.setSize(img.width(), img.height());
            previous.clear();
            next.clear();

            lPhoto.setText("");
            
            updatePropertys();
        }
    }//GEN-LAST:event_photoSelectionMouseClicked

    private void dogMaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dogMaskActionPerformed

        Mat newImg = MatUtil.copy(img);

        MatUtil.dog(newImg);
        MatUtil.show(newImg, lPhoto);

        previous.push(img);
        img = newImg;
        removeRegion();
    }//GEN-LAST:event_dogMaskActionPerformed

    private void grayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayActionPerformed

        Mat newImg = MatUtil.copy(img);

        if (selectRegion) {

            MatUtil.grayScale(newImg, MatUtil.getRect(REGION));
            removeRegion();

        } else {
            MatUtil.grayScale(newImg);
        }

        MatUtil.show(newImg, lPhoto);

        previous.push(img);
        img = newImg;
    }//GEN-LAST:event_grayActionPerformed

    private void blurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blurActionPerformed

        int blurLevel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nível de desfoque", JOptionPane.WARNING_MESSAGE));

        Mat newImg = MatUtil.copy(img);

        if (selectRegion) {

            MatUtil.blur(newImg, blurLevel, MatUtil.getRect(REGION));
            removeRegion();

        } else {
            MatUtil.blur(newImg, blurLevel);
        }

        MatUtil.show(newImg, lPhoto);

        previous.push(img);
        img = newImg;

    }//GEN-LAST:event_blurActionPerformed

    private void inversorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inversorActionPerformed

        Mat newImg = MatUtil.copy(img);

        if (selectRegion) {
            MatUtil.inversor(newImg, MatUtil.getRect(REGION));
            removeRegion();
        }else 
            MatUtil.inversor(newImg);
        
        MatUtil.show(newImg, lPhoto);

        previous.push(img);
        img = newImg;

    }//GEN-LAST:event_inversorActionPerformed

    private void glasses1MaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glasses1MaskActionPerformed

        try {

            Mat newImg = MatUtil.copy(img);

            MatUtil.glasses(newImg, MatUtil.GLASSES_1);
            MatUtil.show(newImg, lPhoto);

            previous.push(img);
            img = newImg;

        } catch (Exception ex) {
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

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Combinação de efeitos inválida!");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void glitchWaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glitchWaveActionPerformed

        
        GlitchWave.setModal(true);
        GlitchWave.setVisible(true);

        Mat newImg = MatUtil.copy(img);

        if (selectRegion) {
            MatUtil.glitchWave(newImg, waveLength, color, MatUtil.getRect(REGION));
            removeRegion();
        } else {
            MatUtil.glitchWave(newImg, waveLength, color);
        }

        MatUtil.show(newImg, lPhoto);

        previous.push(img);
        img = newImg;

    }//GEN-LAST:event_glitchWaveActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
        if (!lb.isVisible() && !txtxLength.isVisible())
            GlitchWave.dispose();
        
        else {
            
            try {

                waveLength = Integer.parseInt(txtxLength.getText());

                /* !! ALERT: improve, make dynamic verification */
                if (green.isSelected()) {
                    color = EColor.GREEN;
                } else if (blue.isSelected()) {
                    color = EColor.BLUE;
                } else {
                    color = EColor.RED;
                }

                GlitchWave.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro no preenchimento!");
            }
            
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void morphologyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_morphologyActionPerformed

        try {

            int morph_size = Integer.parseInt(JOptionPane.showInputDialog(null, "Tamanho"));

            Mat newImg = MatUtil.copy(img);

            if (selectRegion) {
                MatUtil.morphology(newImg, morph_size, MatUtil.getRect(REGION));
                removeRegion();
            } else {
                MatUtil.morphology(newImg, morph_size);
            }
            MatUtil.show(newImg, lPhoto);

            previous.push(img);
            img = newImg;

        } catch (Exception ex) {
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
            if (vhs_1.isSelected()) {
                MatUtil.vhs(newImg, MatUtil.VHS_1);
            } else if (vhs_2.isSelected()) {
                MatUtil.vhs(newImg, MatUtil.VHS_2);
            } else if (vhs_3.isSelected()) {
                MatUtil.vhs(newImg, MatUtil.VHS_3);
            } else if (vhs_4.isSelected()) {
                MatUtil.vhs(newImg, MatUtil.VHS_4);
            } else if (vhs_date_1.isSelected()) {
                MatUtil.vhs(newImg, MatUtil.VHS_DATE_1);
            } else {
                MatUtil.vhs(newImg, MatUtil.VHS_DATE_2);
            }

            MatUtil.show(newImg, lPhoto);

            previous.push(img);
            img = newImg;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Tente novamente!");
            System.out.println("ERRO: " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            Mat newImg = MatUtil.copy(img);
            MatUtil.overlay(newImg,MatUtil.readImg(fileChooser.getSelectedFile().getAbsolutePath()) );
            MatUtil.show(newImg, lPhoto);

            previous.push(img);
            img = newImg;

        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            
            if (selectRegion) {
                removeRegion();
            } else if (selectedWidget != null){
                removeWidget();
            } else if (copying) {
                disablePasteMode();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F12){
            MatUtil.show(nexLayerImg, "");
        }
    }//GEN-LAST:event_formKeyPressed

    private void propertysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertysMouseClicked
        temp = MatUtil.copy(img);
        Propertys.setModal(true);
        Propertys.setVisible(true);
        previous.push(img);
        img = temp;
        removeRegion();
        restartPorpertyComponentsValues();
    }//GEN-LAST:event_propertysMouseClicked

    private void cartoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartoonActionPerformed

        Mat newImg = MatUtil.copy(img);
        
        if (selectRegion) {
            MatUtil.cartoon(newImg, MatUtil.getRect(REGION));
            removeRegion();
        }   else
            MatUtil.cartoon(newImg);
        
        MatUtil.show(newImg, lPhoto);

        previous.push(img);
        img = newImg;

    }//GEN-LAST:event_cartoonActionPerformed

    private void noiseBarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noiseBarMouseReleased
        applyNoise(noiseBar.getValue(),true);
    }//GEN-LAST:event_noiseBarMouseReleased

    private void noiseBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_noiseBarAdjustmentValueChanged
       applyNoise(noiseBar.getValue(),false);
    }//GEN-LAST:event_noiseBarAdjustmentValueChanged

    private void penColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penColorMouseClicked
        
        Color color = JColorChooser.showDialog(null, "Selecione a cor!",Color.BLACK);
        penColor.setBackground(color);
       
    }//GEN-LAST:event_penColorMouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        if (img != null) {

            try {

                JFileChooser fileChooser = new JFileChooser();

                if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

                    Mat newImg = MatUtil.copy(img);

                    for (JLabel widget : WIDGETS) {
                        MatUtil.widget(newImg, MatUtil.readImg(widget.getIcon().toString()), widget.getX(), widget.getY());
                        panel.remove(widget);
                    }

                    MatUtil.show(newImg, lPhoto);

                    previous.push(img);
                    img = newImg;

                    MatUtil.save(fileChooser.getSelectedFile().getAbsolutePath(), img);
                    JOptionPane.showMessageDialog(null, "Salvo!");

                    WIDGETS.clear();

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar, tente colocar o caminho com o nome do arquivo!");
                System.out.println(ex.getMessage());
            }

        }
    }//GEN-LAST:event_saveActionPerformed

    private void cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutActionPerformed

        if (!selectRegion) {
            JOptionPane.showMessageDialog(null, "Selecione uma área primeiro!");
        } else {

            Mat newImg = MatUtil.cut(img, MatUtil.getRect(REGION));
            MatUtil.show(newImg, lPhoto);

            previous.push(img);
            img = newImg;

            removeRegion();
        }
    }//GEN-LAST:event_cutActionPerformed

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

    private void widgetBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widgetBtActionPerformed

        disableListeners();

        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            widgetPath = fileChooser.getSelectedFile().getAbsolutePath();

            if (WIDGET_EXTENSION.contains(widgetPath.substring(widgetPath.lastIndexOf(".") + 1).toUpperCase())) {

                Mat widget = MatUtil.readImg(widgetPath);
                JLabel widgetLabel = new JLabel(new ImageIcon(widgetPath));
                addWidgetListener(widgetLabel);
                widgetLabel.setBounds(this.getX() / 2, this.getY() / 2, widget.cols(), widget.rows());

                panel.setLayout(null);
                panel.add(widgetLabel);
                panel.setComponentZOrder(widgetLabel, 0);

                for (int i = 1; i < WIDGETS.size(); i++) 
                    panel.setComponentZOrder(WIDGETS.get(i), i);

                panel.setComponentZOrder(lPhoto, WIDGETS.size() + 1);
                panel.repaint();
                panel.revalidate();

                WIDGETS.add(widgetLabel);


            } else {
                JOptionPane.showMessageDialog(null, "O arquivo selecionado não é válido!");
            }
        }
    }//GEN-LAST:event_widgetBtActionPerformed

    private void ctrlYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlYActionPerformed

        if (!next.isEmpty()) {

            if (!selectRegion) {
                
                previous.push(img);
                img = next.pop();
            
            } else {

                Rect roi = MatUtil.getRect(REGION);
                Mat newImg = MatUtil.copy(img);

                next.peek().submat(roi).copyTo(newImg.submat(roi));
                previous.push(img);
                img = newImg;

            }
            MatUtil.show(img, lPhoto);

        } else {
            JOptionPane.showMessageDialog(null, "Não há mais oque refazer!");
        }
    }//GEN-LAST:event_ctrlYActionPerformed

    private void ctrlZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlZActionPerformed

        if (!previous.isEmpty()) {

            if (!selectRegion) {

                next.push(img);
                img = previous.pop();

            } else {

                Rect roi = MatUtil.getRect(REGION);
                Mat newImg = MatUtil.copy(img);

                previous.peek().submat(roi).copyTo(newImg.submat(roi));
                previous.push(img);
                img = newImg;
                removeRegion();
            }

            MatUtil.show(img, lPhoto);

        } else {
            JOptionPane.showMessageDialog(null, "Não há mais oque desfazer!");
        }
    }//GEN-LAST:event_ctrlZActionPerformed

    private void zoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomInActionPerformed
        
        if (selectRegion) {
            
            zoomIn.setEnabled(false);
            zoomRegion = new JPanel();
            zoomRegion.setBounds(REGION.getX(), REGION.getY(), REGION.getWidth(), REGION.getHeight());
            matZoomOut = MatUtil.copy(img);
            
            img = img.submat(MatUtil.getRect(zoomRegion));
            
            //pen image - 2nd layer
            if (nexLayerImg != null) {
                
                matZoomOutNexLayerImg = MatUtil.copy(nexLayerImg);
                nexLayerImg = nexLayerImg.submat(MatUtil.getRect(zoomRegion));
                MatUtil.resize(nexLayerImg, matZoomOut.size());
            }
            
            MatUtil.resize(img, matZoomOut.size());
            MatUtil.show(img, lPhoto);
            removeRegion();
            
        } else
            JOptionPane.showMessageDialog(null, "Selecione a região do zoom");
        
    }//GEN-LAST:event_zoomInActionPerformed

    private void zoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomOutActionPerformed
        
        zoomIn.setEnabled(true);
        
        MatUtil.resize(img, new Size(zoomRegion.getWidth(), zoomRegion.getHeight()));
              
        img.copyTo(matZoomOut.submat(MatUtil.getRect(zoomRegion)));
        img = matZoomOut;
        
        MatUtil.show(img, lPhoto);
        nexLayerImg = matZoomOutNexLayerImg;
        
    }//GEN-LAST:event_zoomOutActionPerformed

    private void btResizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResizeActionPerformed
        
        try { 
            
            double width = Double.parseDouble(txtWidth.getText());
            double height = Double.parseDouble(txtHeight.getText());
            
            Mat newImg = MatUtil.copy(temp);
            MatUtil.resize(newImg, new Size(width, height));

            previous.push(img);
            img = temp = newImg;
            
            MatUtil.show(temp, lPhoto);
            
            updatePropertys();
                    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Pre-encha corretamente os dados!");
        }
        
    }//GEN-LAST:event_btResizeActionPerformed

    private void sepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepiaActionPerformed
        
        Mat newImg = MatUtil.copy(img);
        
        if (selectRegion) {
        
            MatUtil.sepia(newImg, MatUtil.getRect(REGION));
            removeRegion();
            
        }else
            MatUtil.sepia(newImg);
        
        
        previous.push(img);
        img = newImg;
        MatUtil.show(img, lPhoto);
        
    }//GEN-LAST:event_sepiaActionPerformed

    private void lilacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lilacActionPerformed
                
        GlitchLilac.setModal(true);
        GlitchLilac.setVisible(true);
        
        if (rbtBlue.isSelected() || rbtGreen.isSelected() || rbtRed.isSelected()) {
            Mat newImg = MatUtil.copy(img);
            previous.push(newImg);
            img = temp;
        }
    }//GEN-LAST:event_lilacActionPerformed

    private void contrastSlideStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_contrastSlideStateChanged
        contrastAndBrightness();
    }//GEN-LAST:event_contrastSlideStateChanged

    private void brightnessSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brightnessSliderStateChanged
        contrastAndBrightness();
    }//GEN-LAST:event_brightnessSliderStateChanged

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        disableListeners();
        selectRegion = true;
    }//GEN-LAST:event_selectActionPerformed

    private void pnlTextColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTextColorMouseClicked
        
        Color color = JColorChooser.showDialog(null, "Selecione a cor!",Color.BLACK);
        text.setColor(new Scalar(color.getBlue(), color.getGreen(), color.getRed()));
        
        writeText();
        
    }//GEN-LAST:event_pnlTextColorMouseClicked

    private void writeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeTextActionPerformed
        
        if (selectRegion) {
            
            text = new Text();
        
            Text.setModal(true);
            Text.setVisible(true);
        
            previous.push(img);
            img = temp;
            
            removeRegion();
        } else 
            JOptionPane.showMessageDialog(null, "Selecione a área do texto!");
  
    }//GEN-LAST:event_writeTextActionPerformed

    private void textScaleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_textScaleStateChanged

        text.setScale((int)textScale.getValue());
        writeText();
    }//GEN-LAST:event_textScaleStateChanged

    private void focusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_focusActionPerformed
        
        if (selectRegion) {
        
            Mat newImg = MatUtil.copy(img);
            MatUtil.focus(newImg, MatUtil.getRect(REGION));
            MatUtil.show(newImg, lPhoto);

            previous.push(img);
            img = newImg;

            removeRegion();
            
        } else
            JOptionPane.showMessageDialog(null, "Selecione a área que deseja focar!");
    }//GEN-LAST:event_focusActionPerformed

    private void saturationSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_saturationSliderStateChanged
        
        temp = MatUtil.copy(img);
        
        int saturation = saturationSlider.getValue();
        lastSaturation = saturationSlider.getValue();
        
        if (selectRegion) {
            MatUtil.saturation(temp, saturation, MatUtil.getRect(REGION));
        } else {
            MatUtil.saturation(temp, saturation);
        }
        
        MatUtil.show(temp, lPhoto);
        
    }//GEN-LAST:event_saturationSliderStateChanged

    //util's method's
    private void addMouseListeners() {

        panel.addMouseMotionListener(new MouseAdapter() {
            
            @Override
            public void mouseDragged(MouseEvent e) {
                
                if (selectRegion)
                    setRegionSize(e.getX(), e.getY());
                else if (pen.isSelected() || eraser.isSelected())
                    paint(e.getX(), e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (copying) {
                    REGION.setLocation(e.getPoint());
                    REGION.repaint();
                }
            }
        });

        panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                removeWidgetSelection();
                if (selectRegion) 
                    addRegion(e.getPoint());
                else if (copying) 
                    paste();
            }
            
            
            @Override
            public void mouseReleased(MouseEvent e){
                
                
                if (pen.isSelected() || eraser.isSelected() ){
                    
                    previous.add(img);
                    img = MatUtil.copy(paintImg);
                    paintImg = null;
                }
            }
        });
        
        ActionListener cbx = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                boolean[] colors = {
                    rbtBlue.isSelected(),
                    rbtGreen.isSelected(),
                    rbtRed.isSelected()
                };
                
                temp = MatUtil.copy(img);
                
                MatUtil.lilac(temp, colors);
                MatUtil.show(temp, lPhoto);
            }
        };
        
        txtText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                text.setStr(txtText.getText());
                writeText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text.setStr(txtText.getText());
                writeText();
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text.setStr(txtText.getText());
                writeText();

            }
        });
        
        
        rbtBlue.addActionListener(cbx);
        rbtGreen.addActionListener(cbx);
        rbtRed.addActionListener(cbx);
    }

    
    private void writeText() {
        temp = MatUtil.copy(img);
        MatUtil.writeText(text,temp, MatUtil.getRect(REGION));
        MatUtil.show(temp, lPhoto);
    }
    
    private void paint(int x, int y){
        
        x = x < 0 ? 0 : x;
        y = y < 0 ? 0 : y;
        
        if (paintImg == null)
            paintImg = MatUtil.copy(img);
        
        int size = (Integer)penSize.getValue();
        int width  = x + size > paintImg.cols()? (x + size) - paintImg.cols(): size;
        int heigth = y + size > paintImg.rows()? (y + size) - paintImg.rows(): size;
        
        
        if ( pen.isSelected()) {
            
            int[] color = {
                penColor.getBackground().getBlue(),
                penColor.getBackground().getGreen(),
                penColor.getBackground().getRed()
            };
            
            MatUtil.paint(color,width,heigth, x, y, paintImg);
        
        } else {
            
            Mat img1 = paintImg.submat(new Rect(x, y, width, heigth));
            Mat img2 = null;
            
            if (!zoomOut.isEnabled())
                img2 = nexLayerImg.submat(MatUtil.getRect(zoomRegion)).submat(new Rect(x, y,width, heigth));
            else
                img2 = nexLayerImg.submat(new Rect(x, y, width, heigth));
            
            MatUtil.overlay(img1,img2);
        }
        
        MatUtil.show(paintImg, lPhoto);
        
    }
    
    private void paste() {

        Mat newImg = MatUtil.copy(img);
        MatUtil.copyToRegion(newImg, copyRegion, MatUtil.getRect(REGION));
        MatUtil.show(newImg, lPhoto);

        previous.push(img);
        img = newImg;
    }

    private void addRegion(Point p) {
        
        REGION.setLocation(p);
        REGION.setSize(20, 20);
        REGION.setBorder(BorderFactory.createLineBorder(Color.cyan));

        panel.setLayout(null);
        panel.add(REGION);
        panel.setComponentZOrder(REGION, 0);

        for (int i = 1; i < WIDGETS.size(); i++) {
            panel.setComponentZOrder(WIDGETS.get(i), i);
        }

        panel.setComponentZOrder(lPhoto, WIDGETS.size() + 1);
        panel.repaint();
        panel.revalidate();
        
        rx = REGION.getX();
        ry = REGION.getY();

    }

    private void setRegionSize(int w, int h) {
        
        int x = 0,y = 0;
        int width = 0, heigth = 0;
        
        if (w < rx) {
            
            x = w;
            width = rx - w;
        
        } else {
        
            x = rx;
            width = w-rx;
        }
        
        
        if (h < ry) {
            
            y = h;
            heigth = ry - h;
        
        } else {
        
            y = ry;
            heigth = h-ry;
        }
        
        
        REGION.setBounds(x,y,width,heigth);
       
    }

    private void removeRegion() {

        panel.setLayout(null);
        panel.remove(REGION);
        panel.repaint();
        panel.revalidate();
        selectRegion = false;
    }

    private void removeWidget() {
        WIDGETS.remove(selectedWidget);
        panel.setLayout(null);
        panel.remove(selectedWidget);
        panel.repaint();
        panel.revalidate();
    }
    
    private void contrastAndBrightness(){
        
        temp = MatUtil.copy(img);
        
        if (selectRegion)
            MatUtil.contrastAndBrightness(temp, brightnessSlider.getValue(), -contrastSlide.getValue(), MatUtil.getRect(REGION));
        else
            MatUtil.contrastAndBrightness(temp, brightnessSlider.getValue(), -contrastSlide.getValue());
        
        
        MatUtil.show(temp, lPhoto);
    }
    
    private void applyNoise(int level, boolean replace) {

        Mat copy = MatUtil.copy(temp);

        if (selectRegion) {
            MatUtil.noise(copy, level, MatUtil.getRect(REGION));
        } else {
            MatUtil.noise(copy, level);
        }

        MatUtil.show(copy, lPhoto);

        if (replace) {
            temp = copy;
        }

    }

    private void restartPorpertyComponentsValues() {
        Component[] components = Propertys.getContentPane().getComponents();
        for (Component c : components) {
            if (c instanceof JScrollBar) {
                ((JScrollBar) c).setValue(0);
            }
        }
    }

    private void disablePasteMode() {
        removeRegion();
        REGION.removeAll();
        copyRegion = null;
    }

    private void disableListeners() {
        selectRegion = copying  = false;
    }

    public Mat getImg(){
        return img;
    }
    
    public void setNextLayerMat(Mat img){
        this.nexLayerImg = img;      
    }
    
    private void updatePropertys(){
        
        txtWidth.setText(img.width()+"");
        txtHeight.setText(img.height()+"");
        lbSize.setText("Tamanho (LxA): "+img.width() + "x" + img.height());
        
        int width = img.width() >= 200 ? img.width() : 200;
        int height = img.height() >= 200 ? img.height() : 200;
        
        
        this.setSize(width,height);
        
    }
    
    
    private void addWidgetListener(JLabel widget){
        Window win = this;
        MouseInputAdapter mia = new MouseInputAdapter () { 
            int x;
            int y; 
            public void mousePressed (MouseEvent me) { 
                x = me.getX (); 
                y = me.getY ();
                win.selectedWidget = widget;
                widget.setBorder(BorderFactory.createLineBorder(Color.CYAN));
            } 
            public void mouseDragged (MouseEvent e) { 
                widget.setLocation (widget.getX () + e.getX () - x, widget.getY () + e.getY () - y); 
            } 
        }; 
        
        widget.addMouseListener (mia); 
        widget.addMouseMotionListener (mia); 
        
    }
    
    public void removeWidgetSelection(){
        
        if (selectedWidget != null){
            selectedWidget.setBorder(null);
            selectedWidget = null;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog GlitchLilac;
    private javax.swing.JDialog GlitchVHS;
    private javax.swing.JDialog GlitchWave;
    private javax.swing.JDialog Propertys;
    private javax.swing.JRadioButton Red;
    private javax.swing.JDialog Text;
    private javax.swing.JRadioButton blue;
    private javax.swing.JMenuItem blur;
    private javax.swing.JLabel brightnessLabel;
    private javax.swing.JSlider brightnessSlider;
    private javax.swing.JMenu btMasks;
    private javax.swing.JButton btResize;
    private javax.swing.JButton btnVhs;
    private javax.swing.JMenuItem cartoon;
    private javax.swing.JMenu colorDetection;
    private javax.swing.ButtonGroup colors;
    private javax.swing.JLabel contrastLabel;
    private javax.swing.JSlider contrastSlide;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem ctrlY;
    private javax.swing.JMenuItem ctrlZ;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem dogMask;
    private javax.swing.JCheckBoxMenuItem eraser;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenu filter;
    private javax.swing.JMenuItem focus;
    private javax.swing.JMenuItem glasses1Mask;
    private javax.swing.JMenu glitchButton;
    private javax.swing.JMenuItem glitchWave;
    private javax.swing.ButtonGroup goutTypePen;
    private javax.swing.JMenuItem gray;
    private javax.swing.JRadioButton green;
    private javax.swing.JMenuItem inversor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lPhoto;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lightenLabel1;
    private javax.swing.JMenuItem lilac;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem morphology;
    private javax.swing.JScrollBar noiseBar;
    private javax.swing.JButton okButton;
    private javax.swing.JMenu options;
    private javax.swing.JPanel panel;
    private javax.swing.JCheckBoxMenuItem pen;
    private javax.swing.JPanel penColor;
    private javax.swing.JLabel penColorLabel;
    private javax.swing.JSpinner penSize;
    private javax.swing.JLabel penSizeLabel;
    private javax.swing.JMenu photoSelection;
    private javax.swing.JPanel pnlTextColor;
    private javax.swing.JMenu propertys;
    private javax.swing.JCheckBox rbtBlue;
    private javax.swing.JCheckBox rbtGreen;
    private javax.swing.JCheckBox rbtRed;
    private javax.swing.JLabel saturationLabel;
    private javax.swing.JSlider saturationSlider;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem select;
    private javax.swing.JMenuItem sepia;
    private javax.swing.JSpinner textScale;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtText;
    private javax.swing.JTextField txtWidth;
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
    private javax.swing.JMenuItem writeText;
    private javax.swing.JMenuItem zoomIn;
    private javax.swing.JMenuItem zoomOut;
    // End of variables declaration//GEN-END:variables
}
