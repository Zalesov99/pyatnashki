import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame { // класс Main в данной работе называют прямым наследником класса JFrame

    /*При построении интерфейсов нужны компоненты-контерйнеры, которые будут содержать другие компоненты
    пользовательского интерфейса. В Swing одним из таких компонентов-контейнеров является JPanel.
    Класс GridLayout позволяет размещать компоненты в контейнере в виде таблицы. В каждой ячейке таблицы может быть размещен только один компонент.
    Количество строк и столбцов таблицы определяется или в конструкторе, или вызовом методов setColumns и setRows.*/

    private JPanel panel = new JPanel(new GridLayout(4, 4, 2, 2));

    /*Главное меню JMenuBar - компонент графического интерфейса Java Swing*/

    private JMenuBar menu = null;
    private final String fileItems[] = new String [] {"Новая", "Статистика", "Выход"};
    private static Random generator = new Random(); // генератор случайных чисел
    private int[][] numbers = new int[4][4];

   
}