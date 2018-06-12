package ru.geekbrains.java1.HomeWork8_swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel{
    private BufferedImage bimFromFile; //переменная под загрузку изображения

    public ImagePanel(){//Конструктор
        setBackground(Color.MAGENTA);//задаём начальный цвет фона

        try {
            bimFromFile = ImageIO.read(new File("forJava.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bimFromFile, 40, 25, this); //"рисуем" наше изображение на ImagePanel
    }
}
