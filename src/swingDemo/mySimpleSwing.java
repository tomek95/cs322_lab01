package swingDemo;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;






public class mySimpleSwing {
        
//private JTextField VolumeText;
//private JTextField Osc1DetuneText;
//private JTextField Osc2DetuneText;
//private JTextField Osc2OctaveText;
//private JTextField OscMixText;

	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    public static void createAndShowGUI() {
	    	
	    	JRadioButton OscSaw;
	    	JRadioButton OscPulse;
	    	
	    	final JTextField VolumeText;
	    		    	
	    	final JTextField OscText;
	    	final JTextField EnvalopeText;
	    	final JTextField FilterText;
	    	final JTextField AccentText;
	    	final JTextField DecayText;
	    	final JTextField GlideText;
	    	
	    	
	    	JSlider OutputVolume;
	    	
	    	
	    	//JComponent DKnob;
	    	//JComponent RotaryKnobPlusText;
	    	//Create and set up the window.
	    	JFrame frame = new JFrame();
	    	frame.setTitle("JoeSynthExampleGUI");
	        frame.setSize(800, 400);
	        frame.setLocation(50,50);
	    	//frame.setResizable(false);
	        
	        OutputVolume = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        int vText=10;
	        String vTextS=Integer.toString(vText);
            VolumeText= new JTextField("Volume "+vTextS+"%");
            VolumeText.setEditable(false);
	        
            
            Dimension minSize = new Dimension(0, 200);
	        Dimension prefSize = new Dimension(0, 200);
	        Dimension maxSize = new Dimension(Short.MAX_VALUE, 200);
	        
	        
            Box VolumeBox = new Box(BoxLayout.Y_AXIS);
	        VolumeBox.add(OutputVolume);
	        VolumeBox.add(new Box.Filler(minSize, prefSize, maxSize));
	        VolumeBox.add(VolumeText);
	        VolumeBox.setBorder(BorderFactory.createTitledBorder("Volume"));
	        
            
	        frame.setVisible(true);
	    	
	    }
	    
	    public static void main(String[] args) {
	    
	    	
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
	}



