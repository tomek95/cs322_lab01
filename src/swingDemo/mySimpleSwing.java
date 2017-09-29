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
	    	//Create and set up the window.
	    	JFrame frame = new JFrame();
	    	frame.setTitle("JoeSynthExampleGUI");
	        frame.setSize(600, 200);
	        frame.setLocation(50,50);
	    	//frame.setResizable(false);
	        
	        Container contentPane = frame.getContentPane();
	        frame.getContentPane().setLayout(new GridBagLayout());
	        GridBagConstraints c = new GridBagConstraints();

	        //Vol
	    	final JTextField VolumeText;
	    	JSlider OutputVolume;
	    	
	    	OutputVolume = new JSlider(JSlider.VERTICAL, 1, 100, 2);
	        int vText=10;
	        String vTextS=Integer.toString(vText);
            VolumeText= new JTextField("Volume "+vTextS+"%");
            VolumeText.setEditable(false);
            
            Dimension minSize = new Dimension(0, 20);
	        Dimension prefSize = new Dimension(0, 20);
	        Dimension maxSize = new Dimension(Short.MAX_VALUE, 20);
	        
	        Box VolumeBox = new Box(BoxLayout.Y_AXIS);
	        VolumeBox.add(OutputVolume);
	        VolumeBox.add(new Box.Filler(minSize, prefSize, maxSize));
	        VolumeBox.add(VolumeText);
	        VolumeBox.setBorder(BorderFactory.createTitledBorder("Volume"));

	        c.fill = GridBagConstraints.BOTH;
	        c.weightx = 0.01;
	        c.weighty = 1;
	        c.gridx = 0;
	        c.gridy = 0;
	        c.gridheight=0;
	        frame.getContentPane().add(VolumeBox,c);
	        
	        OutputVolume.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	    	        Object o = e.getSource();
	    	        JSlider s = (JSlider)o;
	    	        System.out.println(s.getValue());
	    	        VolumeText.setText("Volume " + s.getValue()+"%");
	    	                    }
		        });
	        
	        //Osci
	    	JRadioButton OscSaw;
	    	JRadioButton OscPulse;
	    	
	    	OscSaw = new JRadioButton("Saw", true);
	        OscPulse = new JRadioButton("Pulse", true);
	        ButtonGroup Osc1Group = new ButtonGroup();
	        Osc1Group.add(OscSaw);
	        Osc1Group.add(OscPulse);
	        
	        Box Osc1box = new Box(BoxLayout.Y_AXIS);
	        Osc1box.add(Box.createVerticalStrut(15));
	        Osc1box.add(OscSaw);
	        Osc1box.add(OscPulse);
	        Osc1box.setBorder(BorderFactory.createTitledBorder("Osc"));
	        
	        c.fill = GridBagConstraints.BOTH;
	        c.weightx = 0.01;
	        c.weighty = 0;
	        c.gridx = 1;
	        c.gridy = 0;
	        c.gridheight=0;
	        frame.getContentPane().add(Osc1box,c);
	    	
	        // Envelope
	        
	        RotaryKnob ModMix = new RotaryKnob();
	        RotaryKnob DecayMix = new RotaryKnob();
	        
	        JTextField ModMixText = new JTextField("0");
	        JTextField DecayMixText = new JTextField("0");
	        
	        ModMixText.setEditable(false);
	        DecayMixText.setEditable(false);
	        
	        
	        Box Envelope = new Box(BoxLayout.Y_AXIS);
	        Envelope.add(ModMix);
	        Envelope.add(ModMixText);
	        Envelope.add(DecayMix);
	        Envelope.add(DecayMixText);
	        Envelope.setBorder(BorderFactory.createTitledBorder("Envelope"));
          
	        c.fill = GridBagConstraints.BOTH;
	        c.weightx = 0.0005;
	        c.weighty = 0.0005;
	        c.gridx = 2;
	        c.gridy = 0;
	        c.gridheight=0;
	        frame.getContentPane().add(Envelope,c);
	        
	        ModMix.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
//	    	        Object o = e.getSource();
//	    	        RotaryKnob s = (RotaryKnob)o;
//	    	        System.out.println(s.getValue());
//	    	        Osc2OctaveText.setText("Octave " + s.getValue());
	            	RotaryKnob t = (RotaryKnob) e.getSource();
	            	ModMixText.setText("Mod: " + ((int)(10 * t.getValue())));
	    	                    }
		        });
	        
	        DecayMix.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
//	    	        Object o = e.getSource();
//	    	        RotaryKnob s = (RotaryKnob)o;
//	    	        System.out.println(s.getValue());
//	    	        Osc2OctaveText.setText("Octave " + s.getValue());
	            	RotaryKnob t = (RotaryKnob) e.getSource();
	            	DecayMixText.setText("Decay: " + ((int)(10 * t.getValue())));
	    	                    }
		        });
	        
	        
	        // Filter
	        
	        RotaryKnob CutoffMix = new RotaryKnob();
	        RotaryKnob ResoMix = new RotaryKnob();
	        
	        JTextField CutoffMixText = new JTextField("0");
	        JTextField ResoMixText = new JTextField("0");
	        
	        CutoffMixText.setEditable(false);
	        ResoMixText.setEditable(false);
	        
	        Box Filter = new Box(BoxLayout.Y_AXIS);
	        Filter.add(CutoffMix);
	        Filter.add(CutoffMixText);
	        Filter.add(ResoMix);
	        Filter.add(ResoMixText);
	        Filter.setBorder(BorderFactory.createTitledBorder("Filter"));
          
	        c.fill = GridBagConstraints.BOTH;
	        c.weightx = 0.0005;
	        c.weighty = 0.0005;
	        c.gridx = 3;
	        c.gridy = 0;
	        c.gridheight=0;
	        frame.getContentPane().add(Filter,c);
	        
	        CutoffMix.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
//	    	        Object o = e.getSource();
//	    	        RotaryKnob s = (RotaryKnob)o;
//	    	        System.out.println(s.getValue());
//	    	        Osc2OctaveText.setText("Octave " + s.getValue());
	            	RotaryKnob t = (RotaryKnob) e.getSource();
	            	CutoffMixText.setText("Cutoff: " + ((int)(10 * t.getValue())));
	    	                    }
		        });
	        
	        ResoMix.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
//	    	        Object o = e.getSource();
//	    	        RotaryKnob s = (RotaryKnob)o;
//	    	        System.out.println(s.getValue());
//	    	        Osc2OctaveText.setText("Octave " + s.getValue());
	            	RotaryKnob t = (RotaryKnob) e.getSource();
	            	ResoMixText.setText("Reso: " + ((int)(10 * t.getValue())));
	    	                    }
		        });
	        
	        // Accent
	        
	        RotaryKnob AccentMix = new RotaryKnob();
	        RotaryKnob GlideMix = new RotaryKnob();
	        
	        JTextField AccentMixText = new JTextField("0");
	        JTextField GlideMixText = new JTextField("0");
	        
	        AccentMixText.setEditable(false);
	        GlideMixText.setEditable(false);
	        
	        Box Accent = new Box(BoxLayout.Y_AXIS);
	        Accent.add(AccentMix);
	        Accent.add(AccentMixText);
	        Accent.add(GlideMix);
	        Accent.add(GlideMixText);
	        Accent.setBorder(BorderFactory.createTitledBorder("Accent"));
          
	        c.fill = GridBagConstraints.BOTH;
	        c.weightx = 0.0005;
	        c.weighty = 0.0005;
	        c.gridx = 4;
	        c.gridy = 0;
	        c.gridheight=0;
	        frame.getContentPane().add(Accent,c);
	        
	        
	        AccentMix.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
//	    	        Object o = e.getSource();
//	    	        RotaryKnob s = (RotaryKnob)o;
//	    	        System.out.println(s.getValue());
//	    	        Osc2OctaveText.setText("Octave " + s.getValue());
	            	RotaryKnob t = (RotaryKnob) e.getSource();
	            	AccentMixText.setText("Accent: " + ((int)(10 * t.getValue())));
	    	                    }
		        });
	        
	        GlideMix.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
//	    	        Object o = e.getSource();
//	    	        RotaryKnob s = (RotaryKnob)o;
//	    	        System.out.println(s.getValue());
//	    	        Osc2OctaveText.setText("Octave " + s.getValue());
	            	RotaryKnob t = (RotaryKnob) e.getSource();
	            	GlideMixText.setText("Glide: " + ((int)(10 * t.getValue())));
	    	                    }
		        });
	       
	        
	        
            
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



