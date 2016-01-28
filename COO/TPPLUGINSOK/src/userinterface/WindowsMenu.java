package userinterface;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.ActionListener;
import main.PluginFinder;

@SuppressWarnings("serial")
public class WindowsMenu extends JFrame implements ActionListener {
	
	protected JTextArea areaText;
	protected JMenu fileButton;
	protected JMenu toolsButton;
	protected JMenu helpButton;
	protected JScrollPane jsp;
	protected JMenuItem addPlug;
		
	/**
	 * WindowsMenu allows to display the windows with the menu
	 */
	public WindowsMenu(){
		super("Extendable Editor");
		
		this.initialiseParam();
		this.createToolBar();
		this.createTextArea();
		this.createScroll();
		this.createMenuItem();
		
		this.setVisible(true);		
	}
	
	/**
	 * initialiseParam allows to intialize the parameters of the windows
	 */
	public void initialiseParam(){
		this.areaText = new JTextArea();
		this.fileButton = new JMenu("File");
		this.toolsButton = new JMenu("Tools");
		this.helpButton = new JMenu("Help");
				
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	/**
	 * createToomBar allows to create the tool bar in the windows
	 */
	public void createToolBar(){
		JMenuBar toolbar = new JMenuBar();
		
		toolbar.add(this.fileButton);
		toolbar.add(this.toolsButton);
		toolbar.add(this.helpButton);
	    
		this.setJMenuBar(toolbar);
	}
	
	/**
	 * createTextArea allows to create the text area in the windows
	 */
	public void createTextArea(){
		areaText.requestFocusInWindow();
		this.add(areaText);		
	}
	
	/**
	 * createScroll allows to create the two scroll bar in the windows
	 */
	public void createScroll(){
		jsp = new JScrollPane(this.areaText);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(jsp);
	}
	
	/**
	 * createMenuItem allows to fill the menu
	 */
	public void createMenuItem(){
		File pluginsDirectory = new File("./classes/plugins");
		PluginFinder plugin = new PluginFinder(pluginsDirectory);
		
		for (File plug :  plugin.getCurrentFiles()){
			addPlug = new JMenuItem(plug.getName());
			toolsButton.add(addPlug);
		}
		helpButton.add(new JMenuItem("?"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
}
