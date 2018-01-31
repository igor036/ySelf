/*
Authors: Igor Joaquim dos Santos Lima
GitHub: https://github.com/igor036
*/
package br.com.ySelf.window;

import br.com.ySelf.Main;
import br.com.ySelf.modal.Layer;
import java.util.List;
import javax.swing.DefaultListModel;


public class Layers extends javax.swing.JFrame {
    
    private final DefaultListModel model = new DefaultListModel();
    
    public Layers() {
        initComponents();
        jListLayers.setModel(model);

    }
    
    public void setLayersList(List<Layer> layers) {
        
        while(!model.isEmpty())
            model.remove(0);
        
        for (int i = 0; i < layers.size(); i++) 
            model.addElement((i+1)+ " ° Camada ");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddLayer = new javax.swing.JButton();
        btnRemoveLayer = new javax.swing.JButton();
        list1 = new java.awt.List();
        list2 = new java.awt.List();
        list3 = new java.awt.List();
        choice1 = new java.awt.Choice();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListLayers = new javax.swing.JList<>();
        btnGoToLayer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Camadas");
        setResizable(false);

        btnAddLayer.setText("Adicionar");
        btnAddLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLayerActionPerformed(evt);
            }
        });

        btnRemoveLayer.setText("Remover");
        btnRemoveLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveLayerActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jListLayers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListLayers);

        btnGoToLayer.setText("Ir para Camada");
        btnGoToLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToLayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAddLayer)
                .addGap(18, 18, 18)
                .addComponent(btnGoToLayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnRemoveLayer))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveLayer)
                    .addComponent(btnAddLayer)
                    .addComponent(btnGoToLayer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLayerActionPerformed
        Main.addLayers();
        
    }//GEN-LAST:event_btnAddLayerActionPerformed

    private void btnRemoveLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveLayerActionPerformed
        Main.removeLayer(jListLayers.getSelectedIndex());
    }//GEN-LAST:event_btnRemoveLayerActionPerformed

    private void btnGoToLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToLayerActionPerformed
        Main.alterLayer(jListLayers.getSelectedIndex());
    }//GEN-LAST:event_btnGoToLayerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLayer;
    private javax.swing.JButton btnGoToLayer;
    private javax.swing.JButton btnRemoveLayer;
    private java.awt.Choice choice1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jListLayers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.List list1;
    private java.awt.List list2;
    private java.awt.List list3;
    // End of variables declaration//GEN-END:variables
}
