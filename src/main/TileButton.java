package main;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.Action;
import javax.swing.JButton;

public class TileButton extends JButton {

	private Tile tile;
	private Boolean pressed;
	public static final Color WHITE = new Color(255,255,255,255);
	public static final Color NAVY = new Color(0,0,128,255);
	/**
	 * Create the panel.
	 */
	public TileButton(Tile newTile) {
		this.setTile(newTile);
		this.setPressed(false);
//		this.setSize(100, 100);
		Rectangle rect = new Rectangle();
		rect.height = 100;
		rect.width = 100;
		this.setBounds(rect);
		
		if (this.tile.getColour().equals(Tile.WHITE_TEXT)){
			this.setBackground(WHITE);			
		} else {
			this.setBackground(NAVY);
		}
		
		this.setSize(100, 100);
		
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public Boolean getPressed() {
		return pressed;
	}

	public void setPressed(Boolean pressed) {
		this.pressed = pressed;
	}
	
	public void swapTile(){
		this.getTile().swapTile();
		if(this.getTile().getColour().equals(Tile.WHITE_TEXT)){
			this.setBackground(WHITE);			
		} else {
			this.setBackground(NAVY);
		}
	}

}
