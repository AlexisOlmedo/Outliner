/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.outliner.MODEL;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.in;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mycompany.outlinernb.View.OutlinerViewer;

/**
 *
 * @author Alexis
 */
public class Outliner1 {
    
   private static final String CSVHEADERUSERS = "user_id,name";
   private static final String CSVHEADERTASKS = "task_id,user_id,title,priority,targetDate,completed";
   private static final String CSVHEADERSUBTASKS = "sequence,task_id,title,completed";
   
    private List<Section> sections = new ArrayList();
    private List<Section> selected;
    private List<User> users = new ArrayList();
     private List<Subsection> subSections = new ArrayList();
    

    public List<Subsection> getSubsection() {
        return subSections;
    }

    public void setSubsection(List<Subsection> subSections) {
        this.subSections = subSections;
    }
  
    
  
    public static Outliner1 instance;
    private  Outliner1(){
     
    }  
    public static Outliner1 getInstance(){
        if (instance == null){
            instance = new Outliner1();
        }
        return instance;
    }
    

    public String displayTextModel(){
        StringBuilder sb = new StringBuilder();
        for (User u : this.getUsers()){
            sb.append(u.toString());
            sb.append(System.lineSeparator());
            for (Section s : u.getSection()){
                    sb.append(s.toString());
                    sb.append(System.lineSeparator());
                    for (Subsection Ss : s.getSubSections()){
                        sb.append(Ss.toString());
                        sb.append(System.lineSeparator());
                    }
                    
                }
        }
        return sb.toString();
    
    } 
  
    public void assignStoredSections(){
  
        for(Section s : sections){
            User u = this.getUser(s.getUserId());
            u.addSection(s);
        }
        
    }
  
    public void assignStoredSubsection(){
     
        for(Subsection Ss: subSections){
            Section s = this.getSection(Ss. getSectionID());
            s.addSubsection(Ss);
        }
        
    }
 
    public List<User> getUsers() {
        return users;
    }

  
    public void setUsers(List<User> users) {
        this.users = users;
    }

  
    public List<Section> getSections() {
        return sections;
    }

   
    public void setSection(List<Section> sections) {
        this.sections = sections;
    }
    
  
    public boolean addSection(Section section){
        return sections.add(section);
    }

   
    public boolean addUser(User user){
         return users.add(user);
    }
 
    public boolean addSubsection(Subsection subSection){
         return subSections.add(subSection);
    }
    
  
    public Section getSection(String id){
         Section section = null;
         for (Section s : sections){
             if (s.getId().equals(id)) section = s;
         }
         return section;
     }

   
    public User getUser(String id){
           User user = null;
         for (User u : users){
             if (u.getId().equals(id)) user = u;
         }
         return user;
       }
       

    public Subsection getSubsection(String id, int sequence){
           Subsection subSection = null;
         for (Subsection Ss : subSections){
             if (Ss.getSectionID().equals(id) && Ss.getSequence()==sequence) subSection = Ss;
         }
         return subSection;
       }
       
   
    
    public boolean removeSection(Section section){
           return sections.remove(section);
       }
       
   
    public boolean removeUser(User user){
          return users.remove(user);
      }
    
  
    public boolean removeSubsection(Subsection subSection){
          return subSections.remove(subSection);
      }
      
  
    public String getValue(User user, String property){
          String value=null;
         
          switch(property){
              case "name" -> value = user.getName();
              
              case "id" -> value = user.getId();
                  
                  
          }
          return value;
      }
      
  
    public String getValue(Section section, String property){
          String value=null;
     
          switch(property){
              case "title" -> value = section.getTitle();
               case "priority" -> value = Integer.toString(section.getPriority());
                case "targetDate" -> value = section.getTargetDate().toString();
              case "id" -> value = section.getId();
               case "completed" -> value= Boolean.toString(section.isCompleted());
                      
                  
          }
          return value;
      }
      
 
    public String getValue(Subsection subSection, String property){
          String value=null;
     
          switch(property){
              case "title":
                  value = subSection.getTitle();
                  break;
               case "sequence":
                  value = Integer.toString(subSection.getSequence());
                  break;
              case "taskid":
                  value = subSection.getSectionID();
                  break;
               case "completed":
                  value= Boolean.toString(subSection.isCompleted());
                  break;
                      
                  
          }
          return value;
      }
      
  
    public String setValue(Section section, String property, String value){
          boolean result=false;
          switch(property){
              case "title":
                  section.setTitle(value);
                  result = true;
                  break;
               case "priority":
                  section.setPriority(Integer.parseInt(value));
                  result = true;
                  break;
                case "targetDate":
                  section.setTargetDate(LocalDate.parse(value));
                  result = true;
                  break;    
              case "id":
                  section.setId(value);
                  result = true;
                  break;
              case "completed":
                  section.setCompleted(Boolean.parseBoolean(value));
                  result = true;
                  break;
                  
                  
          }
          return value;
      }
      
   
    public String setValue(Subsection subSection, String property, String value){
          boolean result=false;
    
          switch(property){
              case "title":
                  subSection.setTitle(value);
                  result=true;
                  break;
               case "sequence":
                  subSection.setSequence(Integer.parseInt(value));
                  result=true;
                  break;
              case "taskid":
                  subSection.setSectionId(value);
                  result=true;
                  break;
               case "completed":
                  subSection.setCompleted(Boolean.parseBoolean(value));
                  result=true;
                  break;  
          }
          return value;
      }
       
  
    public boolean setValue(User user, String property,String value) {
             boolean result=false;
       
          switch(property){
              case "name":
                  user.setName(value);
                  result = true;
                  break;
                  
              case "id":
                  user.setId(value);
                  result = true;
                  break;
                  
                  
          }
          return result;
         }
         
    public void readUsersFromCsvFile(String filename){
      try (Scanner in = new Scanner(new File(filename))){
       
          in.nextLine();
          while(in.hasNextLine()){
              String csvLine = in.nextLine();
              User user = new User(csvLine);
              this.addUser(user);
          }
          
          in.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
         
   }
   
 
    
    public void readTasksFromCsvFile(String filename){
      try (BufferedReader in = new BufferedReader(new FileReader(filename))){
       
          in.readLine();
          while(in.ready()){
              String csvLine = in.readLine();
              Section section = new Section(csvLine);
              this.addSection(section);
          }
          
          in.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }
    
 
    public void readSubTasksFromCsvFile(String filename){
      try (BufferedReader in = new BufferedReader(new FileReader(filename))){
        
          in.readLine();
          while(in.ready()){
              String csvLine = in.readLine();
              Subsection subSection = new Subsection(csvLine);
              this.addSubSections(SubSection);
          }
          
          in.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }
    
  
    public void writeTasksToCsvFile(String filename){
      try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
       
          out.write(CSVHEADERTASKS);
          out.newLine();
          for(Section s: sections){
              out.write(s.toString().substring(1)); 
              out.newLine();
              
          }
          
          out.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }
 
    public void writeUsersToCsvFile(String filename){
        
      try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
       
          out.write(CSVHEADERUSERS);
          out.newLine();
          for(User u: users){
              out.write(u.toString());
              out.newLine();
              
          }
          
          out.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }
    
 
    public void writeSubTasksToCsvFile(String filename){
        
      try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
          out.write(CSVHEADERSUBTASKS);
          out.newLine();
          for(Subsection Ss: subSections){
              out.write(Ss.toString().substring(2)); 
              out.newLine();
              
          }
          
          out.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (User u : this.getUsers()){
            sb.append(u.toString());
            sb.append(System.lineSeparator());
            for (Section s : u.getSection()){
                    sb.append(s.toString());
                    sb.append(System.lineSeparator());
                    for (Subsection Ss : s.getSubSections()){
                        sb.append(Ss.toString());
                        sb.append(System.lineSeparator());
                    }
                    
                } 
        }
        return sb.toString();
    }

    
}
