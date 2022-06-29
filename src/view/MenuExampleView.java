package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import controller.MenuExampleController;
import controller.MenuExampleMouseListener;

public class MenuExampleView extends JFrame {
	private JLabel jLabel;
	public JPopupMenu jPopupMenu;
	public MenuExampleView() {
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Example Menu");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		ActionListener ac = new MenuExampleController(this);

		JMenuBar jMenuBar = new JMenuBar();

		JMenu jMenu_file = new JMenu("File");
		JMenuItem jMenuItem_open = new JMenuItem("Open", KeyEvent.VK_O);
		jMenuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jMenuItem_save = new JMenuItem("Save");
		jMenuItem_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jMenu_file.add(jMenuItem_open);
		jMenu_file.addSeparator();
		jMenu_file.add(jMenuItem_save);
		jMenuItem_open.addActionListener(ac);
		jMenuItem_save.addActionListener(ac);
		jMenu_file.setMnemonic(KeyEvent.VK_L);

		JMenu jMenu_Edit = new JMenu("Edit");
		JMenuItem jMenuItem_exit = new JMenuItem("Exit");
		jMenuItem_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		jMenu_Edit.add(jMenuItem_exit);
		jMenuItem_exit.addActionListener(ac);

		JMenu Convert = new JMenu("Convert");
		JMenuItem jMenuItem_1 = new JMenuItem("1");
		JMenuItem jMenuItem_2 = new JMenuItem("2");
		Convert.add(jMenuItem_1);
		Convert.add(jMenuItem_2);
		jMenu_file.add(Convert);

		jMenuBar.add(jMenu_file);
		jMenuBar.add(jMenu_Edit);
		this.setJMenuBar(jMenuBar);

		
		// tạo toolbar(thanh công cụ)
		JToolBar jToolBar = new JToolBar();

		JButton jButton_undo = new JButton("Undo");
		jButton_undo.setToolTipText("Undo");
		JButton jButton_redo = new JButton("Redo");
		jButton_redo.setToolTipText("nhấn vào em đi anh zai");
		JButton jButton_copy = new JButton("Copy");
		JButton jButton_cut = new JButton("Cut");
		JButton jButton_paste = new JButton("paste");

		jButton_undo.addActionListener(ac);
		jButton_redo.addActionListener(ac);
		jButton_copy.addActionListener(ac);
		jButton_cut.addActionListener(ac);
		jButton_paste.addActionListener(ac);

		jToolBar.add(jButton_undo);
		jToolBar.add(jButton_redo);
		jToolBar.add(jButton_copy);
		jToolBar.add(jButton_cut);
		jToolBar.add(jButton_paste);
		
		this.add(jToolBar, BorderLayout.NORTH);
		
		
		//tạo menu chuột phải
		
		jPopupMenu = new JPopupMenu();
		JMenu jMenu_rightMouse = new JMenu("Font");
		JMenuItem jMenuItem_size = new JMenuItem("Size");
		JMenuItem jMenuItem_type = new JMenuItem("Type");
		jMenu_rightMouse.add(jMenuItem_size);
		jMenu_rightMouse.add(jMenuItem_type);
		
		jPopupMenu.add(jMenu_rightMouse);
		jPopupMenu.addSeparator();
		jPopupMenu.add(jMenuItem_1);
		jPopupMenu.addSeparator();
		jPopupMenu.add(jMenuItem_2);
		jPopupMenu.addSeparator();
		jPopupMenu.add(jMenuItem_save);
	
		this.add(jPopupMenu);
		// add mouse listener
		MenuExampleMouseListener mouseListener = new MenuExampleMouseListener(this);
		// thêm sự kiện cho phải chuột
		
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
		
		
		// tao label
		jLabel = new JLabel("...", JLabel.CENTER);
		Font font = new Font("Monaco", Font.BOLD, 24);
		jLabel.setFont(font);	
		this.add(jLabel, BorderLayout.CENTER);
	}

	public void change(String jmenuItem) {
		jLabel.setText(jmenuItem);
	}
}
