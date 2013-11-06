package main;

public class Tile {
	
	private Boolean colour;
	private Boolean swapped;
	public static final String WHITE_TEXT = "WHITE";
	public static final String NAVY_TEXT = "NAVY";
	public static final Boolean WHITE = false;
	public static final Boolean NAVY = true;
	
	public Tile(){
		colour = WHITE;
		setSwapped(false);
	}
	
	public void setColourToWhite(){
		colour = WHITE;
	}
	
	public void setColourToNavy(){
		colour = NAVY;
	}
	
	public String getColour(){
		if (colour == WHITE){
			return WHITE_TEXT;
		} else {
			return NAVY_TEXT;
		}
	}
	
	public void swapTile(){
		
		if(colour.equals(WHITE)){
			colour = NAVY;
		} else {
			colour = WHITE;
		}
		
		setSwapped(true);
	}

	public Boolean getSwapped() {
		return swapped;
	}

	public void setSwapped(Boolean swapped) {
		this.swapped = swapped;
	}
	
}
