import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[][] arr = new double[4][4];
        double[] b = new double[4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {   //заполнение матрицы в консоль
            for (int g = 0; g < 3; g++) {
                System.out.println("Введите элемент матрицы");
                arr[i][g] = scanner.nextDouble();
            }
            System.out.println("Введите решение матрицы");
            b[i] = scanner.nextDouble();
        }

        for (int i = 0; i < 3; i++) { // вывод матрицы в консоль
            for (int g = 0; g < 3; g++) {
                System.out.print(arr[i][g] + " ");
            }
            System.out.println(b[i]);
        }

        double pum = 0; // переменная запоминающая максимальное число

        for (int i = 0; i < 3; i++) {   //поиск максимального числа
            for (int g = 0; g < 3; g++) {
                if (Math.abs(arr[i][g]) > Math.abs(arr[i][g + 1])) {
                    if(pum > arr[i][g]){
                        continue;
                    }else {
                        pum = arr[i][g];
                    }
                } else {
                    if(pum > arr[i][g]){
                        continue;
                    }else {
                        pum = arr[i][g + 1];
                    }

                }
            }
        }

        int i_1 = 0;// переменные запоминающие позиции максимального числа
        int g_1 = 0;

        System.out.println("Максимальный элемент =" + pum);

        for (int i = 0; i < 3; i++) {
            for (int g = 0; g < 3; g++) {
                if (arr[i][g] == pum) {
                    i_1 = i;
                    g_1 = g;
                }
            }
        }

        System.out.println("Ряд номер = " + i_1 + " " + "Строка номер = " + g_1);

        double[] arr_1 = new double[4];
        double pum_1 = 0;

        for (int i = 0; i < 3; i++) { //перестановка рядов
            if (i_1 != 0) {
                arr_1[i] = arr[0][i];
                arr[0][i] = arr[i_1][i];
                arr[i_1][i] = arr_1[i];
            }
        }

        pum_1 = b[0];
        b[0] = b[i_1];
        b[i_1] = pum_1;

        for (int i = 0; i < 3; i++) {// перестановка строк
            arr_1[i] = arr[i][0];
            arr[i][0] = arr[i][g_1];
            arr[i][g_1] = arr_1[i];
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {//вывод матрицы
            for (int g = 0; g < 3; g++) {
                System.out.print(arr[i][g] + " ");
            }
            System.out.println(b[i]);
        }

        System.out.println("Преобразование");

        for (int i = 0; i < 3; i++) { // деление всей матрицы на максимальное число
            for (int g = 0; g < 3; g++) {
                arr[i][g] /= pum;
                System.out.print(arr[i][g] + " ");
            }
            b[i] /= pum;
            System.out.println(b[i]);
        }

        System.out.println();

        pum_1 = arr[1][0];

        for (int i = 0; i < 3; i++) {//арифметические действия над матрицей
            arr[1][i] -= arr[0][i] * pum_1;
            if (i == 0) {
                b[1] -= b[0] * pum_1;
            }
        }

        pum_1 = arr[2][0];

        for (int i = 0; i < 3; i++) {
            arr[2][i] -= arr[0][i] * pum_1;
            if (i == 0) {
                b[2] -= b[0] * pum_1;
            }
        }

        pum_1 = 4;

        for (int i = 0; i < 3; i++) {
            arr[i][1] -= arr[i][2] * pum_1;
        }


        for (int i = 0; i < 3; i++) {//вывод полученной матрицы
            for (int g = 0; g < 3; g++) {
                System.out.print(arr[i][g] + " ");
            }
            System.out.println(b[i]);
        }

        System.out.println();

        double x, y, z;

        z = b[2] / arr[2][2];// нахождение коэффициентов
        System.out.println("z = " + z);
        y = (b[1] - arr[1][2] * z) / arr[1][1];
        System.out.println("y = " + y);
        x = (b[0] - arr[0][2] * z - arr[0][1] * y) / arr[0][0];
        System.out.println("x = " + x);

        System.out.println();

        double znach_1, znach_2, znach_3;

        znach_1 = arr[0][0] * x + arr[0][1] * y + arr[0][2] * z;//проверка конечного ответа
        System.out.println("znach_1 = " + znach_1);
        znach_2 = arr[1][0] * x + arr[1][1] * y + arr[1][2] * z;
        System.out.println("znach_2 = " + znach_2);
        znach_3 = arr[2][0] * x + arr[2][1] * y + arr[2][2] * z;
        System.out.println("znach_3 = " + znach_3);
    }
}