package com.hit.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CacheUnitView{
	
	private PropertyChangeSupport changes;
	private JFrame mainFrame;
    private CacheUnitPanel mainPanel;
    
	//*******Variables*******//
    JPanel buttonsPanel = new JPanel(new BorderLayout());
    JPanel successPanel = new JPanel();
    JPanel textPanel = new JPanel();
    JPanel namesPanel = new JPanel();
    
    JLabel CapacityLbl = new JLabel("");
    JLabel AlgorithmLbl = new JLabel("");
    JLabel TotalRequestsLbl = new JLabel("");
    JLabel TotalDataModelsGDULbl = new JLabel("");
    JLabel TotalSwapsLbl = new JLabel("");
    JLabel namesLbl = new JLabel("\u00A9 Dima Tepliakov & Mike Roz 2018");
    JLabel successLbl = new JLabel("");
    JLabel buttonsLbl = new JLabel();

    JButton loadBtn = new JButton("Load a Request");
    JButton statisticsBtn = new JButton("Show Statistics");

    ImageIcon loadIcon = new ImageIcon("images/load.png");
    ImageIcon statisticsIcon = new ImageIcon("images/statistics.png");
    ImageIcon checkIcon = new ImageIcon("images/check.png");
    ImageIcon xmarkIcon = new ImageIcon("images/xmark.png");
    ImageIcon notFoundIcon = new ImageIcon("images/notfound.png");
    ImageIcon wallpaperIcon = new ImageIcon("images/wallpaper.png");

    Image img = wallpaperIcon.getImage();
    Image temp = img.getScaledInstance(580, 400, Image.SCALE_SMOOTH);
    
    public CacheUnitView() {
    	mainFrame = new JFrame("Memory Management Unit Controller Project 2018");
    	mainPanel = new CacheUnitPanel();
		changes = new PropertyChangeSupport(this);
	}
    
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		changes.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		changes.removePropertyChangeListener(pcl);
	}
	
	public void start() {
	       mainPanel.start();
    }
	
	public class CacheUnitPanel extends JPanel implements ActionListener{

		public void start() {
		 textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));

	        textPanel.setSize(500, 100);
	        textPanel.setLocation(20, 170);
	        textPanel.setBackground(new Color(0,0,0,0));

	        successPanel.setSize(300, 55);
	        successPanel.setLocation(100, 100);
	        successPanel.setBackground(new Color(0,0,0,0));

	        wallpaperIcon = new ImageIcon(temp);

	        namesPanel.setSize(250, 50);
	        namesPanel.setLocation(150, 330);
	        namesPanel.setBackground(new Color(0,0,0,0));

	      //*******Load A Request Button*******//
	        loadBtn.setBounds(30, 20, 220, 55);
	        loadBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        loadBtn.setIcon(loadIcon);
	        loadBtn.addActionListener(this);
	        loadBtn.setBackground(new Color(20,152,216));

	      //*******Show Statistics Button*******//
	        statisticsBtn.setBounds(260, 20, 220, 55);
	        statisticsBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        statisticsBtn.setIcon(statisticsIcon);
	        statisticsBtn.addActionListener(this);
	        statisticsBtn.setBackground(new Color(92,20,216));

	        //*******Font and Color*******//
	        CapacityLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
	        AlgorithmLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
	        TotalRequestsLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
	        TotalDataModelsGDULbl.setFont(new Font("Tahoma", Font.BOLD, 16));
	        TotalSwapsLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
	        successLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        namesLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

	        CapacityLbl.setForeground(Color.BLACK);
	        AlgorithmLbl.setForeground(Color.BLACK);
	        TotalRequestsLbl.setForeground(Color.BLACK);
	        TotalDataModelsGDULbl.setForeground(Color.BLACK);
	        TotalSwapsLbl.setForeground(Color.BLACK);
	        successLbl.setForeground(Color.WHITE);

	        loadBtn.setForeground(Color.WHITE);
	        statisticsBtn.setForeground(Color.WHITE);
	        namesLbl.setForeground(Color.WHITE);

	      //*******Add Text To Panels*******//
	        textPanel.setVisible(true);
	        textPanel.add(CapacityLbl);
	        textPanel.add(AlgorithmLbl);
	        textPanel.add(TotalRequestsLbl);
	        textPanel.add(TotalDataModelsGDULbl);
	        textPanel.add(TotalSwapsLbl);
	        buttonsLbl.add(loadBtn);
	        buttonsLbl.add(statisticsBtn);
	        successPanel.add(successLbl);
	        namesPanel.add(namesLbl);
	        buttonsPanel.add(buttonsLbl);

	        //*******Add panels to main frame*******//
	        mainFrame.setLayout(new BorderLayout());
	        mainFrame.setContentPane(new JLabel(wallpaperIcon));
	        mainFrame.setLayout(null);
	        mainFrame.add(loadBtn);
	        mainFrame.add(statisticsBtn);
	        mainFrame.add(textPanel);
	        mainFrame.add(namesPanel);
	        mainFrame.setPreferredSize(new Dimension(570, 400));
	        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        mainFrame.pack();
	        mainFrame.setLocationRelativeTo(null);//location of the frame Relative to screen.
	        mainFrame.setVisible(true);//show GUI
		}
	        
		@Override
		public void actionPerformed(ActionEvent evt) {

	        if ("Load a Request".equals(evt.getActionCommand())) {
	            mainFrame.add(successPanel).setVisible(false);
	            JFileChooser openFileChooser = new JFileChooser();
	            openFileChooser.setCurrentDirectory(new File("src/main/resources"));
	            openFileChooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);

	            int returnValue = openFileChooser.showOpenDialog(loadBtn);
	            if (returnValue == JFileChooser.APPROVE_OPTION) {
	                File file = new File(openFileChooser.getSelectedFile().getPath());
	                Scanner scanner = null;
	                StringBuilder req = new StringBuilder();
	                try {
	                	scanner = new Scanner(file);

	                    while (scanner.hasNext()) {
	                        req.append(scanner.next());
	                    }
	                } catch (FileNotFoundException fnfe) {
	                	fnfe.printStackTrace();
	                }
	                
	                CacheUnitView.this.changes.firePropertyChange("Load a Request", null, req.toString());

	            } else {
	                successLbl.setText("File Not Selected!");
	                successLbl.setFont(new Font("Tahoma", Font.BOLD, 16));;
	                successLbl.setIcon(notFoundIcon);
	                successPanel.setLocation(100, 100);
	            }
	            mainFrame.add(successPanel).setVisible(true);
	            mainFrame.add(textPanel).setVisible(false);
	        } else {
	        	CacheUnitView.this.changes.firePropertyChange("Show Stats", null, "{ \"headers\":{\"action\":\"SHOWSTATS\"},\"body\":[]}");
	        }
		}
	}
	
	public <T> void updateUIData(T t) {
        String[] response = ((String) t).split(",");
        if (response.length == 1) {
            successLbl.setText(response[0]);
            if(response[0].equals("Succeeded"))
            	successLbl.setIcon(checkIcon);
            else
            	successLbl.setIcon(xmarkIcon);
        } else {
        	textPanel.setVisible(true);
			successLbl.setVisible(true);
			AlgorithmLbl.setVisible(true);
            AlgorithmLbl.setText("Algorithm: " + response[0]);
            CapacityLbl.setText("Capacity: " + response[1]);
            TotalSwapsLbl.setText("Total Number Of DataModel Swaps: " + response[2]);
            TotalRequestsLbl.setText("Total Number Of Requests: " + response[3]);
            TotalDataModelsGDULbl.setText("Total Number Of DataModels: " + response[4]);
        }
    }
	
}


