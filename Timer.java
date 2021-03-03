import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Timer extends JFrame implements ActionListener{
    
    // declare JPanel
    JPanel panel;
     
    // declare lable and textfield for display time (in seconds)
    JLabel counterLabel;
    static JTextField counterText;
    
    // declare two buttons
    JButton startTimer, stopTimer;
    
    // This class work as Thread which implements Runnable interface
    CounterThread myRun;
    
    public Timer(){
        
        // create panel which contains components
        panel = new JPanel();
        
        // set JPanel Layout null
        panel.setLayout(null);
        
        // create label
        counterLabel = new JLabel("Time (in seconds)");
        
        // set location of JLabel
        counterLabel.setBounds(20, -25, 110, 100);
        
        
        // create JTextfield
        counterText = new JTextField("0");
        
        // set Editable false
        counterText.setEditable(false);
        
        // set location of JTextfield
        counterText.setBounds(128, 17, 130, 18);
        
        
        // create JButtons
        startTimer = new JButton("Start Timer");
        stopTimer = new JButton("Stop Timer");
        
        // set location of JBUttons
        startTimer.setBounds(30, 50, 100, 20);
        stopTimer.setBounds(142, 50, 100, 20);
        
        
        // set ActionListener for the JButtons
        startTimer.addActionListener(this);
        stopTimer.addActionListener(this);
        
        // now add component to the JPanel
        panel.add(counterLabel);
        panel.add(counterText);
        panel.add(startTimer);
        panel.add(stopTimer);
        
        // add panel to the JFrame
        add(panel);
        
    }

	private void add(JPanel panel2) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public void actionPerformed(ActionEvent ae) {
        
        // create object CounterThread class
        myRun = new CounterThread();
        
        // create an object of Thread  to call run() method which will increment the counter
        Thread myThread = new Thread(myRun);
        
        if(ae.getSource().equals(startTimer)){
            
            System.out.println("Start Timer Button is clicked by the user");
            
            // set the variable false which is used to stop the Thread
            CounterThread.stopThread = true;
            
            // call the run() method using start() method of Thread class
            myThread.start();
            
        }else{
            
            System.out.println("Stop Timer Button is clicked by the user");
            
            // stop the thread using CounterThread object which call the stop()
            myRun.stop();
            
        }
    }
    /*
        This method called when user close the JFrame
    */
    public void windowClosing(WindowEvent e){
       
        // here thread will automatically stopped when user close the JFrame
    }
    
    public static void main(String[] args) {
        

        Timer obj = new Timer();
         

        obj.setSize(300,120);
        
        // set Title for the JFrame
        obj.setTitle("Timer");
        
        // visible the Jframe
        obj.setVisible(true);
        
        // set default operation 
        obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}}
