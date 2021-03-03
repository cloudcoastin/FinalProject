import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class CounterThread implements Runnable{
    
    public static boolean stopThread; 
    
    public void run(){
        
        while(stopThread){
            
            int counter = Integer.parseInt(Timer.counterText.getText());

            
            counter++;

            Timer.counterText.setText(String.valueOf(counter));

            System.out.println("counter="+counter);
            
            try {
                
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
       
    }
    
    public void stop(){
        
        stopThread = false;
    }
    
}
