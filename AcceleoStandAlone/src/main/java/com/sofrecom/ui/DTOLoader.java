/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.ui;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author z.benrhouma
 */
public class DTOLoader extends javax.swing.JInternalFrame {

    /**
     * Creates new form DTOLoader
     */
    public DTOLoader() {
        initComponents();
        this.loadUIConfiguration();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choice = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        tableNamelabel1 = new javax.swing.JLabel();
        outpathTextField = new javax.swing.JTextField();
        cutomizeOutPathButton = new javax.swing.JButton();
        tableNamelabel2 = new javax.swing.JLabel();
        defaultDtoInputtext = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        generateViewModelBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 250, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("You Shoul Generate DTO .classe files before you can load View Model the source file.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);

        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 1));
        getContentPane().add(jSeparator1);

        tableNamelabel1.setText("Class Directory Path");

        outpathTextField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                outpathTextFieldCaretUpdate(evt);
            }
        });

        cutomizeOutPathButton.setText("...");
        cutomizeOutPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutomizeOutPathButtonActionPerformed(evt);
            }
        });

        tableNamelabel2.setText("DTO full name");

        defaultDtoInputtext.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                defaultDtoInputtextCaretUpdate(evt);
            }
        });

        choice.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("DTO");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        choice.add(jRadioButton2);
        jRadioButton2.setText("Custom");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tableNamelabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tableNamelabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(outpathTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                                    .addComponent(defaultDtoInputtext, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cutomizeOutPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(128, 128, 128))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outpathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cutomizeOutPathButton)
                    .addComponent(tableNamelabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tableNamelabel2)
                    .addComponent(defaultDtoInputtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        getContentPane().add(jPanel2);

        jSeparator2.setPreferredSize(new java.awt.Dimension(1, 1));
        getContentPane().add(jSeparator2);

        jPanel3.setPreferredSize(new java.awt.Dimension(0, 50));

        generateViewModelBtn.setText("Ok");
        generateViewModelBtn.setEnabled(false);
        generateViewModelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateViewModelBtnActionPerformed(evt);
            }
        });

        jButton2.setText("Annuler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(450, Short.MAX_VALUE)
                .addComponent(generateViewModelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(generateViewModelBtn))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cutomizeOutPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutomizeOutPathButtonActionPerformed

        final File directoryChoice = this.getDirectoryChoice(this, Configuration.getProperty(Configuration.LastUsedOutputpath), "Choose output directory");
        if (directoryChoice != null) {
            this.outpathTextField.setText(directoryChoice.getAbsolutePath());
        }
    }//GEN-LAST:event_cutomizeOutPathButtonActionPerformed

    private void generateViewModelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateViewModelBtnActionPerformed
        Configuration.setProperty(Configuration.LastUsedClassPath, outpathTextField.getText());
        Configuration.saveConfiguration();
        
        final String str = this.defaultDtoInputtext.getText();
        XmiFormatter xmiFormatter = new XmiFormatter(getEntityName(str), getBasePackage(str), this.outpathTextField.getText());
        xmiFormatter.buildAndSaveViewModel();
        JOptionPane.showMessageDialog(rootPane, "File generated successfully");
        
    }//GEN-LAST:event_generateViewModelBtnActionPerformed
    private String getBasePackage(String str) {
        final Pattern pattern = Pattern.compile("(.*)\\.");
        final Matcher matcher = pattern.matcher(str);
        matcher.find();
        return matcher.group(1);
    }

    private String getEntityName(String str) {
        final Pattern pattern = Pattern.compile("(\\.[^..]*)$");
        final Matcher matcher = pattern.matcher(str);
        if( matcher.find())
            return matcher.group(1).substring(1);
        return str;
    }
    private void outpathTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_outpathTextFieldCaretUpdate
        // TODO add your handling code here:
        checkConfiguration();
    }//GEN-LAST:event_outpathTextFieldCaretUpdate
    private void checkConfiguration() {
        if (verifyDtoExistance()) {
            this.generateViewModelBtn.setEnabled(true);
        } else {
            this.generateViewModelBtn.setEnabled(false);
        }
    }

    /**
     *
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void defaultDtoInputtextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_defaultDtoInputtextCaretUpdate
        // TODO add your handling code here:
        this.checkConfiguration();
    }//GEN-LAST:event_defaultDtoInputtextCaretUpdate

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Please specify the full qualified class name <packagename>.<className>");
        this.defaultDtoInputtext.setText("");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        this.loadUIConfiguration();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    public File getDirectoryChoice(Component owner, String defaultDirectory, String title) {
        final SecurityManager sm = System.getSecurityManager();
        final JFileChooser chooser = new JFileChooser();
        File choiceFile = null;

        System.setSecurityManager(null);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        final File defaultDir = new File(defaultDirectory);
        if (defaultDir.exists() && defaultDir.isDirectory()) {
            chooser.setCurrentDirectory(defaultDir);
            chooser.setSelectedFile(defaultDir);
        }
        chooser.setDialogTitle(title);
        chooser.setApproveButtonText("OK");
        final int choice = chooser.showOpenDialog(owner);
        owner.requestFocus();
        switch (choice) {
            case JFileChooser.APPROVE_OPTION:
                if (chooser.getSelectedFile() != null) {
                    if (chooser.getSelectedFile().exists()) {
                        choiceFile = chooser.getSelectedFile();
                        Configuration.setProperty(Configuration.LastUsedClassPath, choiceFile.getAbsolutePath());
                    } else {
                        File parentFile = new File(chooser.getSelectedFile().getParent());
                        choiceFile = parentFile;
                    }
                }
                break;
            case JFileChooser.CANCEL_OPTION:
            case JFileChooser.ERROR_OPTION:
        }
        chooser.removeAll();
        System.setSecurityManager(sm);

        return choiceFile;
    }

    private void loadUIConfiguration() {
        Configuration.loadConfiguration();
        this.outpathTextField.setText(Configuration.getProperty(Configuration.LastUsedClassPath));
        loadDtoConfiguration();
        this.verifyDtoExistance();

    }

    void loadDtoConfiguration() {
        String lastUsedTablename = Configuration.getProperty(Configuration.LastUsedTableName);
        // if the first character is a lower case 
        this.defaultDtoInputtext.setText(Configuration.getProperty(Configuration.JavaModelTargetPathField) + "." + CommonUtils.upperFirstLetterAfterUnderscore(lastUsedTablename));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup choice;
    private javax.swing.JButton cutomizeOutPathButton;
    private javax.swing.JTextField defaultDtoInputtext;
    private javax.swing.JButton generateViewModelBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField outpathTextField;
    private javax.swing.JLabel tableNamelabel1;
    private javax.swing.JLabel tableNamelabel2;
    // End of variables declaration//GEN-END:variables

    /**
     * detect if the given directory in the output path is a classes directory
     */
    private boolean verifyClassesDireectory() {

        this.outpathTextField.setBackground(new Color(255, 204, 204));
        final File classDirectory = new File(this.outpathTextField.getText());
        if (classDirectory.exists() && classDirectory.getAbsolutePath().endsWith("classes")) {
            // detect if the applicationConfig file is present to qualify the directory as a play application directoy or not
            final File configFile = new File(this.outpathTextField.getText() + "/application.conf");
            if (configFile.exists()) {
                this.outpathTextField.setBackground(new Color(153, 255, 153));
                return true;
            } else {
                JOptionPane.showMessageDialog(rootPane, "This directory doesen't seem to be a valid playframework application");
                this.outpathTextField.setBackground(new Color(255, 204, 204));
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean verifyDtoExistance() {
        this.defaultDtoInputtext.setBackground(new Color(255, 204, 204));
        if (!verifyClassesDireectory()) {
            return false;
        }
        String filename = String.format("%s/%s.class", this.outpathTextField.getText(), this.defaultDtoInputtext.getText().replaceAll("\\.", "/"));
        System.out.println(filename);
        final File dtoFile = new File(filename);
        if (dtoFile.exists()) {
            System.out.println("---true");
            this.defaultDtoInputtext.setBackground(new Color(153, 255, 153));
            return true;
        } else {
            System.out.println("---false");
            this.defaultDtoInputtext.setBackground(new Color(255, 204, 204));
            return false;
        }

    }

}