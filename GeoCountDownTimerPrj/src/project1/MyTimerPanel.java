package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**********************************************************************
GUI "MYTIMERPANEL" implements GeoCountDownTimer program
 
@author Luke Vasilion
@version September 13,2016
*********************************************************************/

public class MyTimerPanel extends JPanel {

    private GeoCountDownTimer geoCountDownTimer;
    private Timer javaTimer;
    private TimerListener timer;
    private JButton start;
    private JButton stop;  
    private JButton reset;
    private JButton compare;
    private JLabel currentDate;
    private JLabel futureDate;
    private JLabel result;
    private JTextField curDate;
    private JTextField futDate;
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel bottomPanel;
    private GeoCountDownTimer current;
    private GeoCountDownTimer future;
    
    
    
   

    public MyTimerPanel() {
    	
        timer = new TimerListener();

// This calls timer object 10 times per second 
        javaTimer = new Timer(100, timer);   

// There is a problem here, your demonstration of your program could take years.  So, you can
// assume that every time the timer object is called equals one day.  So, in about 3 seconds would be
// a month.   That is how you can speed up time.
       
        // Create buttons and color them, create textfields
        start = new JButton("Start");
    	start.setBackground(Color.green);
    	stop = new JButton("Stop");
    	stop.setBackground(Color.green);
    	reset = new JButton("Reset");
    	reset.setBackground(Color.green);
    	curDate = new JTextField();
    	futDate = new JTextField();
    	
    	//Create listeners for buttons
    	start.addActionListener(new TimerListener());
    	stop.addActionListener(new TimerListener());
    	reset.addActionListener(new TimerListener());
    	
    	
    	//Labels each text field
    	currentDate = new JLabel("Current Date         ");
    	futureDate = new JLabel("   Future Date");
    	result = new JLabel("RESULTS HERE");
    	
    	// assign locations for all objects
    	upperPanel = new JPanel();
    	upperPanel.add(currentDate);
    	upperPanel.add(futureDate);
    	
    	centerPanel = new JPanel();
    	centerPanel.add(curDate);
    	centerPanel.add(futDate);
    	centerPanel.add(result);
    	
    	
    	bottomPanel = new JPanel();
    	bottomPanel.add(start);
    	bottomPanel.add(stop);
    	bottomPanel.add(reset);
    	
    	//set sizes
    	curDate.setPreferredSize(new Dimension(100, 25));
    	futDate.setPreferredSize(new Dimension(100, 25));
    	
    	setLayout(new BorderLayout());
    	
    	//locations
    	add(upperPanel, BorderLayout.NORTH);
    	add(centerPanel, BorderLayout.CENTER);
    	add(bottomPanel, BorderLayout.SOUTH);
    	
    	
    }
    

    private class TimerListener implements ActionListener {

        	public void actionPerformed(ActionEvent e) {
			      	

        		
        		
        		//functionality for start button
				if(e.getSource() == start){
					javaTimer.stop();
					current = new GeoCountDownTimer(curDate.getText());
					future = new GeoCountDownTimer(futDate.getText());

					
					javaTimer.start();
					result.setText("Time Elapsed" + current.daysToGo(futDate.getText()));
				}
				
        		if(javaTimer.isRunning()){
						result.setText("Time Elsapsed: " + current.daysToGo(futDate.getText()));
						current.inc();
        		}
        		//functionality for stop button
        		if(e.getSource() == stop){
        			javaTimer.stop();
        		}
        		//functionality for reset button
        		if(e.getSource()== reset){
        			javaTimer.stop();
        			futDate.setText("");
        			curDate.setText("");
        			result.setText("");
        			
        			
        		}
        	}
        }
    /******************************************************************
    Main method of the GUI
    @param args
    *****************************************************************/
    public static void main(String[] args){
    
    	JFrame frame = new JFrame("MyTimerPanel");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().add(new MyTimerPanel());
    	frame.setSize(300,200);
    	frame.setVisible(true);
    }

}


	

	


