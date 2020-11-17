package Praktika5;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.prefs.Preferences;

public class Launch {

    public static void main(String[] args) {
        
        Preferences node = Preferences.userRoot().node("praktika5");
        System.out.println("Вариант 12. Задание:");
        System.out.println("Задание:Найти максимальный элемент второй строки таблицы и заменить его на ноль");

        final int r = 4;
        final int c = 5;
        int m[][] = new int[r][c];
        int k, A, B, C, D, E;
        System.out.println("Матрица");
        Random random = new Random();
        // Создаем случайные данные для xml
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //k = (int) Math.round(Math.random() * 9);
                k = random.nextInt(10);
                m[i][j] = k;
                System.out.print(k + " ");
            }
            System.out.println("");
        }

        // Реализация алгоритма по варианту задания
        boolean end = false;
            int count0f0ne = 0, max = m[0][0], maxr = 0, maxc = 0;

            // поиск макс. элемента
            max = m[1][0];
            for (int j = 0; j < c; j++) {

                k = m[1][j];
                if (k > max) {
                    max = k;
                    maxr = 1;
                    maxc = j;
                }
            }

            System.out.println("Максимальный элемент второй строки:" + max);
            
            
            
            //замена максимального элемента новым значением
        m[maxr][maxc] = 0; {
       
        }

        for (int i = 0; i < r ; i++) {
            
            node.putInt("A" + i, m[i][0]);
            node.putInt("B" + i, m[i][1]);
            node.putInt("C" + i, m[i][2]);
            node.putInt("D" + i, m[i][3]);
            node.putInt("E" + i, m[i][4]);
        }
        System.out.println("Новая матрица:");
        for (int i = 0; i < r; i++) {
                A = node.getInt("A"+i, 0);
                B = node.getInt("B" + i, 0);
                C = node.getInt("C" + i, 0);
                D = node.getInt("D" + i, 0);
                E = node.getInt("E" + i, 0);
                System.out.println(A + " "+B + " "+C + " "+D + " "+E);
            }
        try {
            node.exportSubtree(new FileOutputStream("myPreferences.xml"));
        }
        catch(Exception e) {
      
        
       
        }
    }
}
    
    