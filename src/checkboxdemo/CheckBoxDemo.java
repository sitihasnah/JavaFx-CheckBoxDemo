
package checkboxdemo;

/**
 *
 * @author Siti Hasnah
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*; 


public class CheckBoxDemo implements ActionListener {
    JTextField nameTF;
    JTextField matrixTF;
    JLabel nameLab;
    JLabel matrixLab;
    JLabel codeLab;
    JComboBox<String> codeCB;
    JLabel outputLab;
    JLabel ratingLab;
    JLabel outcomeLab;
    JCheckBox c1, c2;
    JScrollPane jsp;
    
    //global variable  
   String output="";
   String code_selection="";
   String rb_selection="";
   String cb_selection="";
    
    CheckBoxDemo(){
        //1. create a new JFrame container
        JFrame myFrame = new JFrame("Evaluation");
        
        //2. Specify FlowLayout for the layout manager
        myFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //3. Give the frame an inital size
        myFrame.setSize(350, 500);
        
        //4. Terminate the programe when we close the apps
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //5. Create a label & text field instance
        nameLab =  new JLabel("Name :");
        nameLab.setPreferredSize(new Dimension(150, 20));
        matrixLab =  new JLabel("Matrix :");
        matrixLab.setPreferredSize(new Dimension(150, 20));
        
        nameTF =new JTextField(20);
        matrixTF = new JTextField(20);
        
        //add combo box
        String [] courses= {"[Select]", "KP14603 OOPC", "KP34403 Parallel"};
        codeLab = new JLabel("Course Code : ");
        codeCB = new JComboBox<String>(courses);
        codeLab.setPreferredSize(new Dimension(100, 20));
        
        //Radio Button
        ratingLab = new JLabel("Rating"); 
        ratingLab.setPreferredSize(new Dimension(100, 20));
        
        JRadioButton b1 = new JRadioButton("1");
        JRadioButton b2 = new JRadioButton("2");
        JRadioButton b3 = new JRadioButton("3");
              
        
        //Define a button group
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        
        //CheckBox
        outcomeLab =  new JLabel("Outcome:");
        outcomeLab.setPreferredSize(new Dimension(110, 10));
        
        c1 = new JCheckBox ("Basic Knowledge");
        c2 = new JCheckBox ("Advance Knowledge");
        
        //add output box
        outputLab =  new JLabel("Output:");
        //outputLab.setVerticalAlignment(JLabel.TOP);
        outputLab.setPreferredSize(new Dimension(100, 20));
        
        //Submit button
        JButton submitBttn = new JButton ("Submit");
        submitBttn.setPreferredSize(new Dimension(250, 20));
        
        
        //add output label to scrollpane
        jsp = new JScrollPane(outputLab);
        jsp.setPreferredSize(new Dimension(420,90));
        
        //6. Add action listener
        nameTF.addActionListener(this);
        matrixTF.addActionListener(this);
        codeCB.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        c1.addActionListener(this);
        c2.addActionListener(this);
        submitBttn.addActionListener(this);
        
      //JComboBox action listener
      codeCB.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            //get selected item
            code_selection = (String) codeCB.getSelectedItem();
         }
      });    
        
        //handle button submit action listener
      submitBttn.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){
            //call method
            printOutput();  
            cb_selection="";    
         }  
      });
      
      
        //7. Add all elements to content pane
        myFrame.add(nameLab);
        myFrame.add(nameTF);
        myFrame.add(matrixLab);
        myFrame.add(matrixTF);
        myFrame.add(codeLab);
        myFrame.add(codeCB);
        //myFrame.add(outputLab);
        myFrame.add(ratingLab);
        myFrame.add(b1);
        myFrame.add(b2);
        myFrame.add(b3);
        myFrame.add(outcomeLab);
        myFrame.add(c1);
        myFrame.add(c2);
        myFrame.add(submitBttn);
        myFrame.add(jsp);
        
        
      
        //10. Display the frame
        myFrame.setVisible(true);
        
    }
    
    //Handle the button
    /*public void actionPerformed(ActionEvent ae) {
       
        //obtain the current text and display it in a label
        /*outputLab.setText(nameTF.getText() +  
                        matrixTF.getText() +  
                        codeCB.getSelectedItem()
        + ae.getActionCommand());
        if(ae.getActionCommand().equals("Submit"));
        printOutput();
        //matrixLab.setText("Current contents: " + matrixTF.getText());
        
    }*/

    //handle radio button selection
   public void actionPerformed(ActionEvent ae) {
      
       rb_selection = ae.getActionCommand();    	   
   }
   
   //handle item listener for checkbox
   public void itemStateChanged(ItemEvent ie) {  
      cb_selection="";
      if(c1.isSelected()) cb_selection += c1.getText() + " ";
        if(c2.isSelected()) cb_selection += c2.getText() + " ";
         
   }
  public void printOutput(){
      output = "<html>";
      output += "Thank you for your evaluation<br><br>"; 
      output += "Name: " + nameLab.getText() + "<br>";
      output += "Matric: " + matrixLab.getText() + "<br>";
      output += "Course: " + code_selection + "<br>";
      output += "Rating: " + rb_selection + "<br>";
      output += "Outcome: " + cb_selection + "<br>";
      output += "</html>";          
      outputLab.setText(output);
      jsp.getViewport().revalidate(); //refresh scrollpane
   }
    


    public static void main(String[] args) {
       //create the frame on the event dispatching thread
       SwingUtilities.invokeLater(new Runnable () {
           public void run() {
               new CheckBoxDemo();
           }
       });
    }
    
}