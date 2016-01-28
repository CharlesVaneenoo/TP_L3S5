package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Timer;

public class TimerMain  {
	
    static class MyActionListener implements ActionListener {
       	
    	public void actionPerformed(ActionEvent evt) {
        	Calendar hour = Calendar.getInstance();
    		System.out.println(hour.getTime());
        }
    }
	
        public static void main (String[]args){
        	ActionListener actionListener = new MyActionListener();
        	int delay = 1000; // millisecondes
        	
        	Timer timer = new Timer(delay,actionListener);
         	timer.start();  
         	while(true);
        }
}
