package Starhammer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ClickField {
	
	Color clickFieldColor = new Color( 0f, 1f, 1f, .2f );
	Color buildingGrid = new Color( 0.5f, 0.5f, 0.5f, .3f);
	private Menu menu;
	private int x,y;
	private int goalX, goalY;
	private int buildX, buildY;
	private boolean clicked;

	public ClickField( Menu menu ) {
		this.x = 0;
		this.y = 0;
		this.goalX = 0;
		this.goalY = 0;
		this.menu = menu;

	}


	public void render(Graphics g) {
		g.setColor( clickFieldColor );
		g.fillRect( x, y, goalX-x, goalY-y );
		
		if( menu.buildingNexus ) {
			g.setColor( buildingGrid );
			int mapX = (buildX/64)-1;
			int mapY = (buildY/64)-1;
			g.drawRect(mapX*64, mapY*64, 192, 192);
		}
		else if( menu.buildingBarracks ) {
			g.setColor( buildingGrid );
			int mapX = (buildX/64)-1;
			int mapY = (buildY/64)-1;
			g.drawRect(mapX*64, mapY*64, 128, 192);
		}
		
	}

	public Rectangle getBounds() { //niestety intersects nie dziala tak jak zalozylem wiec musialem pogmatwac tutaj ta funkcje
		if( goalX < x )
			if( goalY < y )
				return new Rectangle( goalX, goalY, x-goalX+1, y-goalY+1 ); //te jedynki sa po to zeby nie zachodzila sytuacja w ktorej width lub height = 0
			else
				return new Rectangle( goalX, y, x-goalX+1, goalY-y+1 );
		else
			if( goalY < y )
				return new Rectangle( x, goalY, goalX-x+1, y-goalY+1 );
			else
				return new Rectangle( x, y, goalX-x+1, goalY-y+1 );
	}
	

	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}


	public void setGoalX(int goalX) {
		this.goalX = goalX;
	}


	public void setGoalY(int goalY) {
		this.goalY = goalY;
	}


	public boolean isMouse1Pressed() {
		return clicked;
	}


	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}


	public void setBuildX(int buildX) {
		this.buildX = buildX;
	}


	public void setBuildY(int buildY) {
		this.buildY = buildY;
	}



}
