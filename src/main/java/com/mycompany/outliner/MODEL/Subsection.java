/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.outliner.MODEL;

/**
 *
 * @author Alexis
 */
public class Subsection {
    
    private String title;

    private int sequence;
    
    private boolean completed;
       
    private String SectionID;
    
   public Subsection() {
    }
    

   
    public String getSectionID() {
        return SectionID;
    }

  
    public void setSectionId(String sectionID) {
        this.SectionID = sectionID;
    }

   
    public boolean isCompleted() {
        return completed;
    }

    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


  
    public int getSequence() {
        return sequence;
    }

   
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    
      public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


  
    public Subsection(String csvLine) {
         String[] attributes = csvLine.split(",");
       // update to reflect ID
       this.sequence = Integer.parseInt(attributes[0]);
       this.SectionID=attributes[1];
       this.title = attributes[2];
       this.completed = Boolean.parseBoolean(attributes[3]);
      
    }

    @Override
    public String toString() {
        String indent = "\t";
        return indent + indent + sequence + "," + SectionID + "," + title + "," +  completed;
    }
}
