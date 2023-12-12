/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.outliner.MODEL;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class Section {
    
    private String id;
    private String title;
    private int priority;
    private LocalDate targetDate; 
    private String userId;
    private boolean completed;
    private List<Subsection> subSections = new ArrayList();

   
     public Section() {
    }
    
    public String getId() {
        return id;
    }

   
    public void setId(String id) {
        this.id = id;
    }
  
    public boolean isCompleted() {
        return completed;
    }

 
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


   
    public String getUserId() {
        return userId;
    }

  
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Subsection> getSubSections() {
        return subSections;
    }

    public void setSubSections(List <Subsection> subSections) {
        this. subSections = subSections;
    }

    /**
     * Get the value of targetDate
     * Gets targetDate of the task LocalDate format 
     * @return the value of targetDate
     */
    public LocalDate getTargetDate() {
        return targetDate;
    }

  
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
    
  
    public void setTargetDate(String dateStr) throws DateTimeParseException {
        this.targetDate = LocalDate.parse(dateStr);
    }

 
    public int getPriority() {
        return priority;
    }

   
    public void setPriority(int priority) {
        this.priority = priority;
    }

   
    public String getTitle() {
        return title;
    }

 
    public void setTitle(String title) {
        this.title = title;
    }
    
     
    public Section(String csvLine) {
        String[] attributes = csvLine.split(",");
        this.id = attributes[0];
        this.userId = attributes[1];
        this.title = attributes[2];
        this.priority = Integer.parseInt(attributes[3]);
        this.targetDate = LocalDate.parse(attributes[4]);
        this.completed = Boolean.parseBoolean(attributes[5]);
        
    }

   
    @Override
    public String toString() {
         String indent = "\t";
        return indent + id + "," + userId + "," + title + "," + priority + "," + targetDate.toString() + "," + completed;
    }
}
    
  