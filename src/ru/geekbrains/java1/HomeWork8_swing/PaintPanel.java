package ru.geekbrains.java1.HomeWork8_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class PaintPanel extends JPanel{
    private BufferedImage bim = new BufferedImage(350, 325, BufferedImage.TYPE_INT_RGB);//создаём изображение - поле для рисования размером 200х200

    public PaintPanel() { //Конструктор нашего класса
        setBackground(Color.CYAN);//задаём начальный цвет фона

        //Прослушиватель для мыши:
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {//метод отслеживания движения нажатой мышкой
                Graphics g = bim.getGraphics(); //объект, которым будем рисовать на картинке "bim"
                g.setColor(Color.ORANGE);//устанавливаю цвет пера
                g.fillRect(e.getX() - 20, e.getY() - 20, 3, 3); //здесь выполняется запрос местоположения мыши и задаётся размер 5х5 пикс. - толлщина нашего пера
                repaint();//чтобы постоянно происходило обновление рисунка - чтобы отображалось рисуемое
            }

            @Override
            public void mouseMoved(MouseEvent e) {//метод отслеживания просто движения мышкой - остаётся пустым
            }
        });
    }

    //Метод, с помощью которого сможем рисовать на PaintPanel:
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//используем функционал метода из суперкласса JPanel
        g.drawImage(bim, 20, 20, this); //нарисовали изображение "bim" в начальной точке 0, 0. Объект здесь ссылается сам на себя (this)
        //g.setColor(Color.ORANGE);//задаём цвет "ручки" "g"
        //g.fillRect(20, 20, 100, 100);//рисуем прямоугольник
    }}
