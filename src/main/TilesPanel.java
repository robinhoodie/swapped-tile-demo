package main;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TilesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private TileButton[][] buttons; 
	private Integer dimension;
	
	public TilesPanel(Integer dimension) {
	
		this.dimension = dimension;
		Grid tileGrid = new Grid(dimension);
		tileGrid.randomizeTiles();
		tileGrid.fillOuterTiles();
		buttons = new TileButton[tileGrid.getDimension()][tileGrid.getDimension()];
		
		for (int i = 0; i < tileGrid.getDimension(); i++){
			JPanel rowPanel = new JPanel();
			for(int j = 0; j < tileGrid.getDimension(); j++){
				buttons[i][j] = new TileButton(tileGrid.getTileGrid()[i][j]);
				rowPanel.add(buttons[i][j]);
			}
			this.add(rowPanel);
				
		}
		
		JPanel buttonPanel = new JPanel();
		JButton randomButton = new JButton();
		randomButton.setText("Randomize");
//		JButton difficultyButton = new JButton();
//		difficultyButton.setText("Difficulty Increase");
		buttonPanel.add(randomButton);
//		buttonPanel.add(difficultyButton);
		this.add(buttonPanel);
		return;
	}

}
