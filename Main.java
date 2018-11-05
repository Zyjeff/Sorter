package com.company;

import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;


public class Main extends JFrame {

    private Image offScreenImageDrawed = null;
    private Graphics offScreenGraphicsDrawed = null;


    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        this.setTitle("Frame");
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void paint(Graphics g) {
        final Dimension d = getSize();

        if (offScreenImageDrawed == null) {
            offScreenImageDrawed = createImage(d.width, d.height);
        }

        offScreenGraphicsDrawed = offScreenImageDrawed.getGraphics();
        offScreenGraphicsDrawed.setColor(Color.white);
        offScreenGraphicsDrawed.fillRect(0, 0, d.width, d.height);
        //Make Array
        int line[] = new int[400];
        for (int i = 0; i < 400; i++) {
            line[i] = (int) (Math.random() * 400) + 1;
        }
        //Print array
        for (int i = 0; i < line.length; i++) {
            offScreenGraphicsDrawed.drawLine(i, 400, i, line[i]);
            offScreenImageDrawed.getGraphics();

            g.drawImage(offScreenImageDrawed, 0, 0, null);
        }

        //Print sort
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length - 2 - i; j++) {
                if (line[j + 1] > line[j]) {
                    int temp = line[j];
                    line[j] = line[j + 1];
                    line[j + 1] = temp;
                }
                offScreenGraphicsDrawed.setColor(Color.WHITE);
                offScreenGraphicsDrawed.drawLine(j, 0, j, line[j]);
                offScreenGraphicsDrawed.setColor(Color.BLACK);
                offScreenGraphicsDrawed.drawLine(j, 400, j, line[j]);
                offScreenGraphicsDrawed.setColor(Color.WHITE);
                offScreenGraphicsDrawed.drawLine(j + 1, 0, j + 1, line[j + 1]);
                offScreenGraphicsDrawed.setColor(Color.BLACK);
                offScreenGraphicsDrawed.drawLine(j + 1, 400, j + 1, line[j + 1]);
                if (j % 2 == 0) {
                    offScreenImageDrawed.getGraphics();
                    g.drawImage(offScreenImageDrawed, 0, 0, null);
                }
            }
        }
    }
}



