package browser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class WebBrowser {

		private JFrame frame;
		private JPanel panel;
		private JEditorPane editor;
		private JScrollPane scroll;
		private JTextField field;
		private JButton button;
		private URL url;
		
		public WebBrowser(String title) {
			initComponents();
			frame.setTitle(title);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800,600);
			frame.add(BorderLayout.NORTH, panel);
			frame.setResizable(false);
			panel.add(field);
			panel.add(button);
			frame.add(BorderLayout.CENTER, scroll);
			frame.setVisible(true);}
			private void initComponents() {
				frame = new JFrame();
				panel=new JPanel();
				try {
					//pre determina a url ao abrir
					url = new URL("https://www.google.com");
				} catch (MalformedURLException mue) {
					JOptionPane.showMessageDialog(null, mue);
				}
				try {
					editor = new JEditorPane(url);
					editor.setEditable(false);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e);
					
				}
				scroll = new JScrollPane(editor, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				field = new JTextField(65);
				field.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
				SwingUtilities.invokeLater(new Runnable() {
				
					public void run() {
						field.setText(url.toString());
					}
				
				});
				button = new JButton(">>>");
				button.setBackground(Color.GRAY);
				button.setForeground(Color.white);
				
				button.addMouseListener(new java.awt.event.MouseAdapter() {
				
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
						button.setBackground(Color.DARK_GRAY);
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
						button.setBackground(Color.DARK_GRAY);
				    }
				});
			    
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {editor.setPage(field.getText());
						
						}catch(IOException e1){
							JOptionPane.showMessageDialog(null, e1);
						}						
						
					}
				});
					
				
			}
			
			public static void main(String args[]) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						new WebBrowser("WebBrowser");
					}
				
				});
				
			}
			
		}
