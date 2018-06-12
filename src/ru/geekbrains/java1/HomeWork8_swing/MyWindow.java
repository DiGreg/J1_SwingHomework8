package ru.geekbrains.java1.HomeWork8_swing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame{
    public MyWindow(){
        setTitle("Java");
        setBounds(400, 200, 800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setResizable(false);//чтобы фиксировать размер окна (чтобы его нельзя было растягивать)

        setLayout(new GridLayout(1,2));//задаём для MyWindow сетку из 2-х элементов
        JPanel jpLeft = new JPanel();//создаём левую панель (1-й элемент окна)
        add(jpLeft);//добавляю лев. панель на Окно
        jpLeft.setBackground(Color.GRAY);//устанавливаю цвет фона лев. панели
        jpLeft.setBorder(new LineBorder(Color.DARK_GRAY, 2)); //делаем рамку вокруг лев. панели тощиной 2 пикселя
        jpLeft.setLayout(new BoxLayout(jpLeft, BoxLayout.Y_AXIS)); //задаём компоновщик для левой панели
        //Кнопки для левой панели:
        JButton jbl1 = new JButton("Кнопка 1");
        jbl1.setAlignmentX(CENTER_ALIGNMENT);//выпавниваю кнопку посередине панели
        jpLeft.add(jbl1);//добавляю кнопку 1 на лев. панель
        JButton jbl2 = new JButton("Кнопка 2");
        jbl2.setAlignmentX(CENTER_ALIGNMENT);
        jpLeft.add(jbl2);
        JButton jbl3 = new JButton("Кнопка 3");
        jbl3.setAlignmentX(CENTER_ALIGNMENT);
        jpLeft.add(jbl3);

        JPanel jpRight = new JPanel();//создаём правую панель
        add(jpRight);
        jpRight.setLayout(new CardLayout());//задаём CardLayout для правой панели (поэтому потом можем добавить несколько разных панелек)

        PaintPanel jpRed = new PaintPanel();//создаём панель для 1-й кнопки

        ImagePanel jpGreen = new ImagePanel();//создаём панель для 2-й кнопки

        JPanel jpBlue = new JPanel();//создаём панель для 3-й кнопки
        jpBlue.setBackground(Color.BLUE);
        jpBlue.setLayout(new FlowLayout());//устанавливаю компоновщик для панели
        JTextField jtf = new JTextField(20);//создаю текстовую строку
        jpBlue.add(jtf);//добавляю на панель
        JButton jbSend = new JButton("Отправить");//кнопка для отправки сообщения
        jpBlue.add(jbSend);
        JTextArea jta = new JTextArea(20, 20);//создаю текстовую область
        jta.setLineWrap(true);//устанавливаем автомат.перенос на след.строку
        JScrollPane jsp = new JScrollPane(jta);//помещаем текст.обл. внутрь полос прокрутки
        jpBlue.add(jsp);//добавляю полосы прокрутки на панель

        jbSend.addActionListener(new ActionListener() { //Прослушка для кнопки "Отправить"
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");//берём текст из строки "jtf" и присоединяем к текстовой области "jta"
                jtf.setText("");//очищаем строку после отправки
                jtf.grabFocus();//фокусировка курсора на строке после нажатия кнопки
            }
        });
        jtf.addActionListener(new ActionListener() { //Прослушка на [Enter]
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
            }
        });

        //Добавляем в правую панель разные панели. Здесь "RED" используется для обращения к панели по имени
        jpRight.add(jpRed, "RED");
        jpRight.add(jpGreen, "GREEN");
        jpRight.add(jpBlue, "BLUE");
        ((CardLayout)jpRight.getLayout()).show(jpRight, "RED"); //по умолчанию показываем(show) панельку "RED"

        jbl1.addActionListener(new ActionListener() { //устанавливаем Прослушиватель события на Кнопку 1
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Кнопка 1 нажата"); //для примера действия
                ((CardLayout)jpRight.getLayout()).show(jpRight, "RED");
            }
        });

        jbl2.addActionListener(new ActionListener() { //для 2-й кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "GREEN");
            }
        });

        jbl3.addActionListener(new ActionListener() { //для 3-й кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "BLUE");
            }
        });

        setVisible(true);//всегда пишется в самом конце
    }
}
