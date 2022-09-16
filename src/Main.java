import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[][] arr = new double[3][3];
        double[] b = new double[3];
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
                if(g == 2){
                    break;
                }
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
        double[][] arr_2 = new double[3][1];
        double[][] arr_3 = new double[3][1];

        z = b[2] / arr[2][2];// нахождение коэффициентов
        System.out.println("z = " + z);
        y = (b[1] - arr[1][2] * z) / arr[1][1];
        System.out.println("y = " + y);
        x = (b[0] - arr[0][2] * z - arr[0][1] * y) / arr[0][0];
        System.out.println("x = " + x);
        arr_2[0][0] = z;
        arr_2[1][0] = y;
        arr_2[2][0] = x;
        System.out.println(arr_2[0][0]);
        System.out.println(arr_2[1][0]);
        System.out.println(arr_2[2][0]);

        System.out.println();
        System.out.println(Arrays.toString(arr_2));

        double znach_1, znach_2, znach_3;


        int p_i = 0;
        int p_g = 0;
        int p = 0;
        while (p_i < arr.length) {
            if(arr[0].length != arr_2.length){
                break;
            }
            for (int i = 0; i < arr.length; i++) {
                for (int g = 0; g < arr[i].length; g++) {
                    arr_3[p_i][p_g] += arr[p][g] * arr_2[g][0];
                }
                p_g++;
                if (p_g == arr_3[i].length) {
                    p_g = 0;
                }
            }
            p_i++;
            p++;
            if(p == arr.length){
                p = 0;
            }
        }

        for (int i = 0; i < arr_3.length; i++) {
            for (int g = 0; g < arr_3[i].length; g++) {
                System.out.print(arr_3[i][g] + " ");
            }
            System.out.println();
        }

        double[] F = new double[3];

        System.out.println(Arrays.toString(b));

        for(int i = 0; i < F.length; i++){
            F[i] =arr_3[i][0] - b[i];
        }
        System.out.println(Arrays.toString(F));
        System.out.println();
        double x1,y1,z1;

        for (int i = 0; i < arr.length; i++) {
            for (int g = 0; g < arr[i].length; g++) {
                System.out.print(arr[i][g] + " ");
            }
            System.out.println(F[i]);
        }

        z1 = F[2] / arr[2][2];// нахождение коэффициентов
        System.out.println("z1 = " + z1);
        y1 = (F[1] - arr[1][2] * z1) / arr[1][1];
        System.out.println("y1 = " + y1);
        x1 = (F[0] - arr[0][2] * z1 - arr[0][1] * y1) / arr[0][0];
        System.out.println("x1 = " + x1);

        double maxX = arr_2[0][0];

        for (int i = 0; i < arr_2.length; i++) {
            for (int g = 0; g < arr_2[i].length; g++) {
                if(maxX < arr_2[i][g]){
                    maxX = arr_2[i][g];
                }
            }
        }
        System.out.println(maxX);
        System.out.println(Arrays.toString(F));
        for(int i = 0; i < arr_2.length; i++){
            for(int g = 0; g < arr_2[i].length; g++){
                System.out.print(arr_2[i][g]);
            }
            System.out.println();
        }

        F[0] -= arr_2[0][0];
        F[1] -= arr_2[1][0];
        F[2] -= arr_2[2][0];

        System.out.println(Arrays.toString(F));
        double maxF = F[0];
        for(int i = 0; i < F.length; i++){
            if(maxF < F[i]){
                maxF = F[i];
            }
        }
        System.out.println(maxX);
        System.out.println(maxF);
        double pog = maxF/maxX;
        System.out.println(pog);
    }

}