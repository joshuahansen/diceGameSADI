package sadi.topic5.layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GridLayoutExample extends SimpleJFrame
{
	public GridLayoutExample()
	{
		// using a separate class for our JPanel this time
		Container buttonPanel = new CustomJPanelClass();
		// and we wrap it in another custom class to decorate it with a custom border!
		Container border = new TenPixelBorder(buttonPanel);
		// add the custom JPanel to the JFrame
		setLayout(new BorderLayout());
		add(border, BorderLayout.CENTER);
		// call super to show the frame
		super.showFrame();
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new GridLayoutExample();
			}
		});
	}
}

// we use a separate class for the JPnale this time (this is useful for encapsulation and reuse)
class CustomJPanelClass extends JPanel
{
	public CustomJPanelClass()
	{
		JButton one = new JButton("  1  ");
		JButton two = new JButton("  2  ");
		JButton three = new JButton("  3  ");
		JButton four = new JButton("  4  ");
		JButton five = new JButton("  5  ");
		JButton six = new JButton("  6  ");
		JButton seven = new JButton("  7  ");
		JButton eight = new JButton("  8  ");
		JButton nine = new JButton("  9  ");
		JButton ten = new JButton("this is a long label  ");

		setLayout(new GridLayout(3, 0, 10, 10));
		add(one);
		add(two);
		add(three);
		add(four);
		add(five);
		add(six);
		add(seven);
		add(eight);
		add(nine);
		add(ten);
	}
}
