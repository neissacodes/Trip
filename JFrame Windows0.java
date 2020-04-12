//ComboBox and JList Window
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class Trip extends JFrame {
      //Variables
      private JPanel continents0; //done
      private JPanel months0; //done
      private JPanel results; //done
      private JPanel message0; //done
      private JLabel message; //done
      private JLabel selected; //done
      private JComboBox box; //done
      private JScrollPane pane; //done
      private JList list; //done
      private JTextField contchose; //done
      private JTextField monthchose; //done
      private final int WINDOWS_WIDTH = 500; //done
      private final int WINDOWS_HEIGHT = 500; //done
      
      //Arrays
      String [] continents = {"South America", "North America", "West Indies", "Africa", "Europe", "Asia"};
      String [] months = {"January", "February", "March", "April", "May", "June", "July", "August","September", "October", "November", "December"};
      
      //Constructor
      //create the window
      //put the panels in it
      //close button
      //pack and set it visible
      
      public Trip () {
         //Set the title
         setTitle("2020 Trip");
         
         //Set the label
         message = new JLabel("Get ready for your trip: choose a continent and the month of departure");
         
         //Set size
         setSize( WINDOWS_WIDTH,WINDOWS_HEIGHT);
         
         //Set layout manager
         setLayout(new BorderLayout());
         
         //Buildpanels
         Buildcontinents();
         Buildmonths();
         Buildselected();
         message0 = new JPanel();
         message0.add(message);
         
         //Add the panels to the layout manager
         add(message0, BorderLayout.NORTH);
         add(continents0, BorderLayout.WEST);
         add(months0, BorderLayout.EAST);
         add(results, BorderLayout.SOUTH);
                  
         //Set the closing button
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         //Pack and set visible
         pack();
         setVisible(true);
      }

     //BuildContinents panel
     private void Buildcontinents ()
      {  
         //Create a panel to add the combo box
         continents0 = new JPanel();
         //Add the continents to JComboBox
         box = new JComboBox(continents);
         
         //Register an actionListener
         box.addActionListener(new ComboBoxListener());
         
         //Add the box to the panel
         continents0.add(box); 
      }
      
      //buildMonths panel
      private void Buildmonths(){
            //Create a panel to add the list
            months0 = new JPanel();
            
            //Add the months to the list
            list = new JList(months);
            list.setVisibleRowCount(5);
            
            //Set the selection mode
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
            //Register the listener
            list.addListSelectionListener(new ListenerList());
           
            //Create a ScrollPane
            pane = new JScrollPane(list);
            
            //Add the scroll pane to the panel
            months0.add(pane);
          }
          
         //Buildselected
         private void Buildselected(){
                 results = new JPanel();
                 
                 //Create a label
                 selected = new JLabel("You selected ");
                 
                 //Create two textfields
                 contchose = new JTextField(10);
                 monthchose = new JTextField(10);
                 
                 //Make the text fields uneditable
                 contchose.setEditable(false);
                 monthchose.setEditable(false);
                 
                 //Add labels and text fields to the panel
                 results.add(selected);
                 results.add(contchose);
                 results.add(monthchose);
            }
            
            //LISTENERS
            
            //ComboboxListener
            private class ComboBoxListener implements ActionListener
               {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//get the selected continent
                    String selectedCont = (String) box.getSelectedItem();
                    //Display the selected item in te textfield
                    contchose.setText(selectedCont);  
				}
               }
               
           //ListListener
           private  class ListenerList implements ListSelectionListener
            {

			@Override
			public void valueChanged(ListSelectionEvent e)
				{
				// TODO Auto-generated method stub
				 //Get the selected month
                String selectedMonth = (String) list.getSelectedValue();
                
                //Put the selected month in the text field
                monthchose.setText(selectedMonth);
                
				}
            }
            
            //Main
            public static void main(String [] args) {
               new Trip();
            }
   }
