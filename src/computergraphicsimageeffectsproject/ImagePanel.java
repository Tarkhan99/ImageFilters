/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package computergraphicsimageeffectsproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author tarkhan
 */
public class ImagePanel extends javax.swing.JPanel {
    
    private BufferedImage image;
    private File file;

    public ImagePanel() {
        initComponents();
    }

    public void setImage(File file){
        this.file = file;
        try {                
            image = ImageIO.read(file);
            repaint();
            System.out.println(file.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public BufferedImage getImage(){
        return image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null){
            Image scaledImage = image.getScaledInstance(getWidth(), getHeight(),  Image.SCALE_SMOOTH);
            g.drawImage(scaledImage, 0, 0, this);
        }
    }
    
    public void setGray(){
        Color myWhite = new Color(0, 0, 0, 0);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int p = image.getRGB(x, y);
                
                int a = (p >>24)&0xff;
                int r = (p >>16)&0xff;
                int g = (p >>8)&0xff;
                int b = p&0xff;
                
                int tr = (int) (0.393*r + 0.769*g + 0.189*b);
                int tg = (int) (0.349*r + 0.686*g + 0.168*b);
                int tb = (int) (0.272*r + 0.534*g + 0.131*b);
                
                r = (tr>255) ? 255 : tr;
                g = (tg>255) ? 255 : tg;
                b = (tb>255) ? 255 : tb;
                
                p = (a<<24) | (r<<16) | (g<<8) | b;
                image.setRGB(x, y, p);
            }
        }
        repaint();
    }
    
    public void setGreen(){
        Color myWhite = new Color(0, 0, 0, 0);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int p = image.getRGB(x, y);
                
                int a = (p >>24)&0xff;
                int r = (p >>16)&0xff;
                int g = (p >>8)&0xff;
                int b = p&0xff;
                
                int tr = (int) (0.123*r + 0.169*g + 0.589*b);
                int tg = (int) (0.149*r + 0.686*g + 0.168*b);
                int tb = (int) (0.272*r + 0.234*g + 0.131*b);
                
                r = (tr>255) ? 255 : tr;
                g = (tg>255) ? 255 : tg;
                b = (tb>255) ? 255 : tb;
                
                p = (a<<24) | (r<<16) | (g<<8) | b;
                image.setRGB(x, y, p);
            }
        }
        repaint();
    }
    
    public void setPurple(){
        Color myWhite = new Color(0, 0, 0, 0);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int p = image.getRGB(x, y);
                
                int a = (p >>24)&0xff;
                int r = (p >>16)&0xff;
                int g = (p >>8)&0xff;
                int b = p&0xff;
                
                int tr = (int) (0.193*r + 0.469*g + 0.389*b);
                int tg = (int) (0.149*r + 0.286*g + 0.368*b);
                int tb = (int) (0.272*r + 0.534*g + 0.131*b);
                
                r = (tr>255) ? 255 : tr;
                g = (tg>255) ? 255 : tg;
                b = (tb>255) ? 255 : tb;
                
                p = (a<<24) | (r<<16) | (g<<8) | b;
                image.setRGB(x, y, p);
            }
        }
        repaint();
    }
    
    public void setGrayScale(){
        Color myWhite = new Color(0, 0, 0, 0);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int p = image.getRGB(x, y);
                
                int a = (p >>24)&0xff;
                int r = (p >>16)&0xff;
                int g = (p >>8)&0xff;
                int b = p&0xff;
                
                int average = (r+g+b)/3;
                
                p = (a<<24) | (average<<16) | (average<<8) | average;
                image.setRGB(x, y, p);
            }
        }
        repaint();
    }
    
    public void saveImage(){
       try{
           ImageIO.write(image,"PNG",new File("filteredImage.png"));
           System.out.println("Must save");
       }catch(IOException e){
           e.printStackTrace();
       }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
