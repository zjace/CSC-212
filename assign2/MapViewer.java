import java.awt.*;
import javax.swing.*;
import java.lang.reflect.Field;

/**
 *  Allows the MapGrid to be viewed.
 *  
 *  @author  Zach Arthurs and Maneka Puligandla 
 *  @version Wednesday, February 6, 2013
 */

public class MapViewer extends JComponent {  // CHANGE THE CLASS NAME TO SOMETHING APPROPRIATE
    
	/** Stores MapGrid to be displayed. */
	public MapGrid grid;
	
	/** How big the width of the viewer area will be */
	public int viewerWidth;
	
	/** How big the height of the viewer area will be */
	public int viewerHeight;
	
	/** How big the map will be */
	private int scale;
	
	/** Location of the upper left hand corner of the map. */
	private Point offset;

	/** Constructs MapView with defualt location and scale. */
	public MapViewer(MapGrid grid) {
		this.grid = grid;
		offset = new Point(0,0);
		scale = 10;
		viewerWidth = scale*grid.returnWidth();
		viewerHeight = scale*grid.returnHeight();
	} 
	
	/** Accessor for grid */
	public MapGrid getGrid() {
		return grid;
	}
	
	/** Accessor for viewerWidth */
	public int getViewerWidth() {
		return viewerWidth;
	}
	
	/** Accessor for viewerHeight */
	public int getViewerHeight() {
		return viewerHeight;
	}
	
	/** Accessor for scale */
	public int getScale() {
		return scale;
	}
	
	/** Accessor for offset */
	public Point getOffset() {
		return offset;
	}
	
	/** Manipulator for viewerWidth */
	public void changeViewerWidth(int newWidth) {
		viewerWidth = newWidth;
	}
	
	/** Manipulator for viewerHeight */
	public void changeViewerHeight(int newHeight) {
		viewerHeight = newHeight;
	}
	
	/** Manipulator for scale */
	public void changeScale(int newscale) {
		scale = newscale;
	}
	
	/** Manipulator for offset */
	public void changeOffset(Point newoffset) {
		offset.setLocation(newoffset);
	}
	
	/** Returns size of the displayed area */
	public Dimension getMininmunSize() {
		Dimension d = new Dimension(viewerWidth, viewerHeight);
		return d;
	}
	
	/** Returns size of the displayed area */
	public Dimension getPreferredSize() {
		Dimension d = new Dimension(viewerWidth, viewerHeight);
		return d;
	}
	
	/**
	 * Draws the map.
	 *
	 * @params scale, offset, grid
	 *
	 */
	public void paintComponent(Graphics g) {
		for (int i = 0; i< grid.returnWidth(); i++){
			for (int j = 0; j< grid.returnHeight(); j++){
				Color squarecolor = grid.getColor(i, j);
				g.setColor(squarecolor);
				g.fillRect((int)offset.getX() + i*scale, (int)offset.getY() + j*scale, scale, scale);
			}
		}
	}

}