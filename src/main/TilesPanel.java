package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TilesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private TileButton[][] buttons; 
	private Integer dimension;
	private Boolean swapMade;
	private Boolean guessMade;
	private Integer guessCount;
	private JPanel buttonPanel;
	private JPanel gridPanel;
	private Grid tileGrid;
	private ActionListener aL;
	
	public TilesPanel(Integer dimension) {
	
		this.dimension = dimension;
		this.swapMade = false;
		this.guessMade = false;
		this.guessCount = 0;
		this.setLayout(new GridLayout(0, 1));

		aL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource().getClass().equals(TileButton.class)) {
					
					if (!swapMade) {
						TileButton pressedTile = (TileButton) e.getSource();
						pressedTile.swapTile();
						for(int i = 0 ; i < buttons.length; i++) {
							for (int j = 0 ; j < buttons[i].length; j++) {
								if(buttons[i][j] != null){
									buttons[i][j].removeActionListener(aL);	
									buttons[i][j].setPreferredSize(new Dimension(40, 40));
								}
							}
						}
						
						buttonPanel.removeAll();
						JButton guessButton = new JButton();
						guessButton.setText("Ready to guess");
						guessButton.addActionListener(aL);
						buttonPanel.add(guessButton);
						swapMade = true;
					} else if (swapMade && !guessMade){
						TileButton pressedTile = (TileButton) e.getSource();
						for(int i = 0 ; i < buttons.length; i++) {
							for (int j = 0 ; j < buttons[i].length; j++) {
								if(buttons[i][j] != null){
									buttons[i][j].removeActionListener(aL);	
									buttons[i][j].setPreferredSize(new Dimension(40, 40));
								}
							}
						}
						
						JLabel label;
						if (pressedTile.getPressed()){
							label = new JLabel("Congratulations, you are correct!");
						} else {
							label = new JLabel("Incorrect, sorry.");
						}
						guessMade = true;
						guessCount ++;
						
						buttonPanel.removeAll();
						buttonPanel.add(label);
						JButton randomButton = new JButton();
						randomButton.setText("Play Again");
						randomButton.addActionListener(aL);
						buttonPanel.add(randomButton);
					}
					
				} else if (e.getSource().getClass().equals(JButton.class)){
					
					JButton pressedButton = (JButton) e.getSource();
					if (pressedButton.getText().equals("Randomize") || pressedButton.getText().equals("Play Again") ) {
						swapMade = false;
						guessMade = false;
						
						tileGrid.randomizeTiles();
						buttons = new TileButton[tileGrid.getDimension()][tileGrid.getDimension()];
						gridPanel.removeAll();
						
						for (int i = 0; i < tileGrid.getDimension()-1; i++){
							JPanel rowPanel = new JPanel();
							for(int j = 0; j < tileGrid.getDimension()-1; j++){
								buttons[i][j] = new TileButton(tileGrid.getTileGrid()[i][j]);
								buttons[i][j].addActionListener(aL);
								buttons[i][j].setPreferredSize(new Dimension(40, 40));
								rowPanel.add(buttons[i][j]);
							}
							gridPanel.add(rowPanel);
								
						}
						
						buttonPanel.removeAll();
						JButton randomButton = new JButton();
						randomButton.setText("Randomize");
						randomButton.addActionListener(aL);
						buttonPanel.add(randomButton);
						if (guessCount > 5){
							JButton evenBufferButton = new JButton();
							evenBufferButton.setText("Difficulty Increase");
							evenBufferButton.addActionListener(aL);
							buttonPanel.add(evenBufferButton);
						}
						
					} else if (pressedButton.getText().equals("Difficulty Increase")) {
						tileGrid.fillOuterTiles();
						gridPanel.removeAll();
						
						for (int i = 0; i < tileGrid.getDimension(); i++){
							JPanel rowPanel = new JPanel();
							for(int j = 0; j < tileGrid.getDimension(); j++){
								buttons[i][j] = new TileButton(tileGrid.getTileGrid()[i][j]);
								buttons[i][j].addActionListener(aL);
								buttons[i][j].setPreferredSize(new Dimension(40, 40));
								rowPanel.add(buttons[i][j]);
							}
							gridPanel.add(rowPanel);
						}
						
						buttonPanel.removeAll();
						JButton randomButton = new JButton();
						randomButton.setText("Randomize");
						randomButton.addActionListener(aL);
						buttonPanel.add(randomButton);
						
					} else if (pressedButton.getText().equals("Ready to guess")) {
						
						for(int i = 0 ; i < buttons.length; i++) {
							for (int j = 0 ; j < buttons[i].length; j++) {
								if(buttons[i][j] != null){
									buttons[i][j].addActionListener(aL);
									buttons[i][j].setPreferredSize(new Dimension(40, 40));
								}
							}
						}
						
						buttonPanel.removeAll();
						
					}
				}
				
				gridPanel.revalidate();
				gridPanel.repaint();
				buttonPanel.revalidate();
				buttonPanel.repaint();
								
			}
		};
		
		tileGrid = new Grid(dimension);
		tileGrid.randomizeTiles();
		
		buttons = new TileButton[tileGrid.getDimension()][tileGrid.getDimension()];
		gridPanel = new JPanel(new GridLayout(0, 1));
		
		for (int i = 0; i < tileGrid.getDimension()-1; i++){
			JPanel rowPanel = new JPanel();
			for(int j = 0; j < tileGrid.getDimension()-1; j++){
				buttons[i][j] = new TileButton(tileGrid.getTileGrid()[i][j]);
				buttons[i][j].addActionListener(aL);
				buttons[i][j].setPreferredSize(new Dimension(40, 40));
				rowPanel.add(buttons[i][j]);
			}
			gridPanel.add(rowPanel);
				
			this.add(gridPanel);
		}
		
		buttonPanel = new JPanel();
		JButton randomButton = new JButton();
		randomButton.setText("Randomize");
		randomButton.addActionListener(aL);
		buttonPanel.add(randomButton);
		this.add(buttonPanel);
		
		return;
	}

	public Boolean getSwapMade() {
		return swapMade;
	}

	public void setSwapMade(Boolean swapMade) {
		this.swapMade = swapMade;
	}

	public Boolean getGuessMade() {
		return guessMade;
	}

	public void setGuessMade(Boolean guessMade) {
		this.guessMade = guessMade;
	}

	public Integer getGuessCount() {
		return guessCount;
	}

	public void setGuessCount(Integer guessCount) {
		this.guessCount = guessCount;
	}
	
}
