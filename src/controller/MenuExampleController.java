package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import view.MenuExampleView;

public class MenuExampleController implements ActionListener {
		private MenuExampleView exampleView;
		
		public MenuExampleController(MenuExampleView mView) {
			this.exampleView = mView;
		}

		
		@Override
		public void actionPerformed(ActionEvent e) {
			String src = e.getActionCommand();
			if(src.equals("Exit")) {
				this.exampleView.change("Exit");
				System.exit(0);
			}
			else {
				this.exampleView.change(src);
			}
			
		}
}
