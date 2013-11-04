package main;

public class Grid {

	private Tile[][] tileGrid;
	private Integer dimension;
	
	public Grid(Integer dimensions){
		this.dimension = dimensions;
		tileGrid = new Tile[dimensions][dimensions];
		for (int i = 0; i < tileGrid.length; i ++){
			for (int j = 0; j < tileGrid[i].length; j++){
				tileGrid[i][j] = null;
			}
		}
	}

	public Tile[][] getTileGrid() {
		return tileGrid;
	}

	public void setTileGrid(Tile[][] tileGrid) {
		this.tileGrid = tileGrid;
	}
	
	public Integer getDimension() {
		return dimension;
	}

	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}

	public void randomizeTiles(){
		for (int i = 0; i < tileGrid.length - 1; i++){
			for (int j = 0; j < tileGrid[i].length - 1; j++){

				tileGrid[i][j] = new Tile();
				
				if (Math.random() >= 0.5){
					tileGrid[i][j].setColourToWhite();
				} else {
					tileGrid[i][j].setColourToNavy();
				}
				
			}
		}
	}
	
	public void fillOuterTiles(){
		for (int i = 0; i < tileGrid.length - 1; i++){
			
			Integer whiteCount = 0;

			for (int j = 0; j < tileGrid[i].length - 1; j++){
				if (tileGrid[i][j].getColour().equals(Tile.WHITE_TEXT)){
					whiteCount++;
				}
			}
			
			tileGrid[i][tileGrid[i].length - 1] = new Tile();

			if(whiteCount%2 == 0){
				tileGrid[i][tileGrid[i].length - 1].setColourToNavy();
			} else {
				tileGrid[i][tileGrid[i].length - 1].setColourToWhite();
			}
			
		}
		
		for (int i = 0; i < tileGrid.length; i++){
			
			Integer whiteCount = 0; 
			
			for (int j = 0; j < tileGrid[j].length - 1; j++){
				if (tileGrid[j][i].getColour().equals(Tile.WHITE_TEXT)){
					whiteCount++;
				}
			}
			
			tileGrid[tileGrid[i].length -1][i] = new Tile();
			
			if(whiteCount%2 == 0){
				tileGrid[tileGrid[i].length - 1][i].setColourToNavy();
			} else {
				tileGrid[tileGrid[i].length - 1][i].setColourToWhite();
			}
			
		}
	}
	
}
