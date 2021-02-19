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

/* -=== Опредиление клиентской ширины экрана ===- */



    public Main() {
        setTitle("Пятнашки"); //Заголовок окна



        setSize (300, 300); // Задаем размеры окна приложения
        setLocationRelativeTo(null); // Окно приложения центрируется относительно экрана

        setResizable(true); // задаем возможность растягивать окно
        createMenu(); //инициализируем меню
        setJMenuBar(menu); // добавляем панель меню к окну
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрываем программу при закрытии окна

        //Класс container — прямой подкласс класса component, и наследует все его методы.
        //Каждый компонент перед выводом на экран помещается в контейнер (container). Контейнер "знает", как разместить компоненты на экране.
        /*Создав компонент — объект класса Component или его расширения, следует добавить его к предварительно созданному объекту класса container
        или его расширения одним из методов add (). */

        Container container = getContentPane();
        init();
        panel.setDoubleBuffered(true);
        panel.setBackground(Color.white); // устанавливаем цвет фона
        container.add(panel); // добавление компонентов в контейнер
        repaintField();
        JLabel();

    }
    public void init() { // описание метода init
        int[] invariants = new int[16]; // инициализируем массив с именем invariants из 16 элементов - лт 0 до 15

        for (int i = 0; i < 4; i++) { // перебираем элементы i от 0 до 3
            for (int j = 0; j < 4; j++) { // перебираем элементы j от 0 до 3
                numbers[i][j] = 0; // указываем что перебор в цикле начинается с нулевого элемента
                invariants[i*4 + j] = 0; // определяем какой из 16 элементов будет = 0
            }
        }

        for (int i = 1; i < 16; i++) { // перебираем елементы i от 1 до 15
            int k; //обьявляем переменную k типа int
            int l; //обьявляем переменную l типа int
            do { // цикл с послеусловием
                k = generator.nextInt(100) % 4; // переменной k присваиваем произвольное число от 0 до 100 деленное по модулю на 4
                l = generator.nextInt(100) % 4; // переменной l присваиваем произвольное число от 0 до 100 деленное по модулю на 4
            }
            while (numbers[k][l] != 0); // до тех пор пока двумерный массив numbers не равен 0
            numbers[k][l] = i; // присваиваем двумерному массиву numbers значение i в цикле от 1 до 15
            invariants[k*4+l] = i; // определяем позиции всех елементов кроме 0 на сетке
        }

        boolean change = true; // в булевую переменную change заносим значение true
        int counter = 1; // инициализируем переменную counter типа int и присваиваем ей 1
        while (change) {
            change = false;
            for (int i = 0; i < 16; i++) {
                if (invariants[i] != i) {
                    for (int j = 0; j < 16; j++) {
                        if (invariants[j] == i) {
                            int temp = invariants[i];
                            invariants[i] = invariants[j];
                            invariants[j] = temp;
                            change = true;
                            counter++;
                            break;
                        }
                    }
                    break;
                }
            }
        }

   if (counter % 2 != 0) {
            int temp = numbers[0][0];
            numbers[0][0] = numbers[3][3];
            numbers[3][3] = temp;
        }
    }
}
