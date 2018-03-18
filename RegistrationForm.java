package CarSales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.awt.GridLayout;
@SuppressWarnings("serial")


public class RegistrationForm extends JFrame implements ActionListener{  
	
JLabel title, idLabel, nameLabel, genderLabel, addressLabel, contactLabel; 

JTextField idField, nameField, genderField, addressField, contactField;

JButton registerButton, exitButton, loginButton;

JRadioButton male, female;  

ButtonGroup bg;    

JPanel panel;    

List<User> list = new ArrayList<User>();   

JTable table;      

String gender = "";  

// Returns a column class of Object               
DefaultTableModel model;               
JScrollPane scrollpane;               
Object[][] data;      

// Defining Constructor               
RegistrationForm() {                               
setSize(700, 360);                               
setLayout(null); 

  //Defining Labels                               
title = new JLabel("Registration Form");                                
title.setBounds(60, 7, 200, 30);
  idLabel = new JLabel("ID");
 idLabel.setBounds(30, 50, 60, 30);                                
nameLabel = new JLabel("Name");                                
nameLabel.setBounds(30, 85, 60, 30);
  genderLabel =new JLabel("Gender");                               
genderLabel.setBounds(30, 120, 60, 30);                                
addressLabel = new JLabel("Address");                                
addressLabel.setBounds(30, 155, 60, 30);                                
contactLabel = new JLabel("Contact");                               
contactLabel.setBounds(30, 190, 60, 30); 

// Defining ID field                                
idField = new JTextField();                                
idField.setBounds(95, 50, 100, 30);                               
idField.addKeyListener(new KeyAdapter() {                                                
public void keyTyped(KeyEvent e) {                                                                 
char c = e.getKeyChar();                                                              
if(!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) ||                                                             
(c == KeyEvent.VK_DELETE))) {                                                                               
e.consume();                                                               

}                                               
}                               

});     


// Defining Name field                                
nameField = new JTextField();                                
nameField.setBounds(95, 85, 100, 30);

  // Defining Gender Buttons
 male = new JRadioButton("Male");                          
male.setBounds(95, 120, 60, 30);                             
male.addActionListener(new ActionListener() {

  public void actionPerformed(ActionEvent e) {
     gender= "Male";
  }

   });

    female = new  JRadioButton("Female");
 female.setBounds(155,120, 70, 30);                       

female.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
      gender ="Female";
            }

         });
 bg = new ButtonGroup();
       bg.add(male);
      bg.add(female);
     addressField = new JTextField();
    addressField.setBounds(95, 155, 100, 30);
 contactField = new JTextField();  
contactField.setBounds(95, 190, 100, 30);         
contactField.addKeyListener(new KeyAdapter() {
     public void keyTyped(KeyEvent e) {
   char c = e.getKeyChar();                          
if(!((c >= '0') && (c <= '9') || (c ==KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                                          
e.consume();

         }

       }

             });

    //Defining Exit Button
     exitButton = new JButton("Exit");                          
exitButton.setBounds(25, 230, 80, 30);                         
exitButton.addActionListener(this);

    //Defining Register Button
   registerButton = new JButton("Register");      
registerButton.setBounds(110, 230, 100, 30);                      
registerButton.addActionListener(this);

	//Defining Login Button
		loginButton = new JButton("Login");
		loginButton.setBounds(65, 275, 100, 30);
		loginButton.addActionListener(this);
		
    // fixing all Label,TextField,Button 
       add(title);
       add(idLabel);
      add(nameLabel);
     add(genderLabel);
     add(addressLabel);
      add(contactLabel);
       add(idField);
       add(nameField);
        add(male);
        add(female);
       add(addressField);
      add(contactField);
     add(exitButton);
    add(registerButton);
    add(loginButton);
    
      //Defining Panel
     panel =new JPanel();
     panel.setLayout(new GridLayout());
     panel.setBounds(250,10, 400, 300);                         
panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
    add(panel);
    
     // Defining Model for table 
      model = new DefaultTableModel();
        table = new JTable(model);                          
       table.setEnabled(false);
       
   // Defining Column Names on model 
         model.addColumn("ID");                         
        model.addColumn("Name");                         
        model.addColumn("Gender");                        
        model.addColumn("Address");
         model.addColumn("Contact"); 
         
    // Enable Scrolling on table
      scrollpane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,                                                       

JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);panel.add(scrollpane);                       
panel.setEnabled(false);                         
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       setResizable(false); 
       setVisible(true);

            }

    public void actionPerformed(ActionEvent ae) {

    if(ae.getSource() == exitButton) {
   System.exit(0); 

            }
    if(ae.getSource() == loginButton){
    	Log log =new Log();
    	log.setVisible(true);
    }

    if(ae.getSource() ==registerButton) {                        

if(idField.getText().equals("") || nameField.getText().equals("") ||                           
addressField.getText().equals("")|| contactField.getText().equals("")||                              
gender.equals(""))JOptionPane.showMessageDialog(idField,  "Fields will not be blank"); 

         else{
        	 
     //Storing records in List 
      list.add(new User(idField.getText(), nameField.getText(), gender,                                                   
addressField.getText(), contactField.getText())); 
       addRows();
       
       //Open Welcome panel
       WelcomePanel wp = new WelcomePanel();
   	wp.setVisible(true);
       
       // using for DialogBox
        JOptionPane.showMessageDialog(this,"Successfully Registered");                                    
       idField.setText("");                                     
      nameField.setText("");
       gender ="";                            
bg.clearSelection();                                 
addressField.setText("");                                    
contactField.setText("");

      } 

           } 
        }
    
    //Adding records in List

      public void addRows() { 
         Object[] row =null;
     User str = list.get(list.size()- 1); 
      String string =str.uid + "," + str.uname + "," + str.gender +"," + str.uaddress + "," +                                                  
str.ucontact;

             row =string.split(",");
             
       //Adding records in table model                           
model.addRow(row);                             
panel.revalidate(); 

       }

        public static void main(String[] args) { 
           new RegistrationForm(); 

      }
}

