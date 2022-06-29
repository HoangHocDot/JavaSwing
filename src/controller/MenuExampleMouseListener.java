package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.MenuExampleView;

public class MenuExampleMouseListener implements MouseMotionListener, MouseListener {
	private MenuExampleView menuExampleViewl;
	public MenuExampleMouseListener (MenuExampleView mView) {
		this.menuExampleViewl = mView;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(e.isPopupTrigger()) {
			this.menuExampleViewl.jPopupMenu.show(e.getComponent(), e.getX(),e.getY() );
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
