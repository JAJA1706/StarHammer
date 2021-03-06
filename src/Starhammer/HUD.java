package Starhammer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class HUD {
	
	private Font myFont = new Font( "arial", 0, 15 );
	private Color myColor = new Color( 0.9f, 0.9f, 0.7f, .1f);
	private Menu menu;
	
	public HUD( Menu menu ) {
		this.menu = menu;
	}
	
	public void tick() {
		
	}
	
	
	public void render( Graphics g) {
		String str = String.valueOf( menu.player[0].getMinerals() );
		g.setColor(Color.BLUE);
		g.fillRoundRect(1150, 3, 20, 20, 20, 20);
		g.setColor(Color.YELLOW);
		g.fillRoundRect(1150, 28, 20, 20, 20, 20);
		g.fillRect(1170, 53, 20, 20);
		g.setColor(Color.WHITE);
		g.setFont( myFont );
		g.drawString(str, 1180, 17);
		str = String.valueOf( menu.player[0].getGold() );
		g.drawString(str, 1180, 43);
		str = String.valueOf( menu.player[0].getSupply() );
		str += "/200";
		g.drawString(str, 1200, 68);
		
		if( menu.buildMode ) {
			g.setColor( myColor );
			g.fillRect(1086, 580, 176, 100);
			g.setColor( Color.WHITE );
			g.drawRect(1086, 580, 88, 50);
			g.drawRect(1174, 580, 88, 50);
			g.drawRect(1086, 630, 88, 50);
			g.drawRect(1174, 630, 88, 50);
			g.drawString("Q:Nexus", 1100, 610);
			g.drawString("W:Barracks", 1180, 610);
			
		}
		

	}
	
}
