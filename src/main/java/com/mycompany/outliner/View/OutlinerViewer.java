
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.outliner.View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import com.mycompany.outliner.Control.BTactionControl;

/**
 *
 * @author Alexis
 */
public class OutlinerViewer extends JFrame {
    
     private JButton AddSection = new JButton("New Section");
     private JButton AddSubsection = new JButton("New Sub-Section");
     private JButton Editsection = new JButton("Edit section");
     private JButton EditSubsection = new JButton("Edit Subsection");
     private JButton DelSection = new JButton("Delete Section");
     private JButton DelSubsection = new JButton("Delete Subsection");

    public JButton getAddSection() {
        return AddSection;
    }

    public void setAddSection(JButton AddSection) {
        this.AddSection = AddSection;
    }

    public JButton getAddSubsection() {
        return AddSubsection;
    }

    public void setAddSubsection(JButton AddSubsection) {
        this.AddSubsection = AddSubsection;
    }

    public JButton getEditsection() {
        return Editsection;
    }

    public void setEditsection(JButton Editsection) {
        this.Editsection = Editsection;
    }

    public JButton getEditSubsection() {
        return EditSubsection;
    }

    public void setEditSubsection(JButton EditSubsection) {
        this.EditSubsection = EditSubsection;
    }

    public JButton getDelSection() {
        return DelSection;
    }

    public void setDelSection(JButton DelSection) {
        this.DelSection = DelSection;
    }

    public JButton getDelSubsection() {
        return DelSubsection;
    }

    public void setDelSubsection(JButton DelSubsection) {
        this.DelSubsection = DelSubsection;
    }
  
    
    public static OutlinerViewer instance;
   

   
    public static OutlinerViewer  getInstance(){
        if (instance == null){
            instance = new OutlinerViewer ();
        }
        return instance;
    }
    
   
  
    private OutlinerViewer (){
        this.setSize(400, 500);
        this.setLayout(new BorderLayout());
        var buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(AddSection);
        buttonPanel.add(AddSubsection);
        buttonPanel.add(Editsection);
        buttonPanel.add(EditSubsection);
        buttonPanel.add(DelSection);
        buttonPanel.add(DelSubsection);
        this.add(new JScrollPane(AddSection),BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
