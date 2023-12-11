/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.outliner.MODEL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class User {
   
    private String name;

    private List<Section> sections = new ArrayList();

    private String id;

   
    public User(){
        
    }
    
    
    public User(String csvLine) {
        String[] attributes = csvLine.split(",");
        this.id = attributes[0];
        this.name = attributes[1];
      
    }

 
    public boolean addSection(Section section){
        return sections.add(section);
    }

  
     
    public String getId() {
        return id;
    }

  
    public void setId(String id) {
        this.id = id;
    }

   
    public List<Section> getSection() {
        return sections;
    }

 
    public void setSection(List<Section> sections) {
        this.sections = sections;
    }

   
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }
    
   
    public Section getSection(String id){
         Section section = null;
         for (Section s : sections){
             if (s.getId().equals(id)) section = s;
         }
         return section;
     }
    
   
    @Override
    public String toString() {
        return id + "," + name;
    }
 
}
    

