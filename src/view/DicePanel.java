package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Random;
//www.ja v  a  2s  .  co m
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class DicePanel extends JPanel {
	  private static final int SIDE = 32;
	  private static final Random r = new Random();
	  private Color color = Color.black;
	  private int value = getValue();
	  private final Timer t = new Timer(500, null);
	  DicePanel() {
	    value = getValue();
	    t.addActionListener(e-> {
	        value = getValue();
	        repaint();
	    });
	    t.start();
	  }
	  @Override
	  public Dimension getPreferredSize() {
	    return new Dimension(SIDE * 7, SIDE * 7);
	  }
	  private int getValue() {
	    return r.nextInt(6) + 1;
	  }
	  @Override
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(color);
	    switch (value) {
	    case 1:
	      g.fillRect(3 * SIDE, 3 * SIDE, SIDE, SIDE);
	      break;
	    case 2:
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      break;
	    case 3:
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(3 * SIDE, 3 * SIDE, SIDE, SIDE);
	      break;
	    case 4:
	      g.fillRect(SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      break;
	    case 5:
	      g.fillRect(SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(3 * SIDE, 3 * SIDE, SIDE, SIDE);
	      break;
	    case 6:
	      g.fillRect(SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
	      g.fillRect(SIDE, 3 * SIDE, SIDE, SIDE);
	      g.fillRect(5 * SIDE, 3 * SIDE, SIDE, SIDE);
	      break;
	    }
	  }
	}
