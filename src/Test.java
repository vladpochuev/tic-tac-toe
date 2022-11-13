import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] array = new double[9];

        fillRandomNum(array);

        printArray(array);

        for(boolean gameStatus = true; gameStatus;){
            while(true){    ///////////////////////////// Player's Turn
                System.out.println("Ввести комірку");
                int i = sc.nextInt();

                if(array[i-1]==0||array[i-1]==1){
                    System.out.println("Комірка зайнята");
                } else {
                    array[i-1] = 1;
                    printArray(array);
                    break;  ////////////////////////////// Check Status 1
                }
            }
            if(checkStatus(array)!=0){
                gameStatus = false;
                continue;
            }               ////////////////////////////// Computer's Turn
            int compTurn = analyzeCompTurn(array);

            array[compTurn] = 0;

            printArray(array);    //////////////////////// Check Status 2
            if(checkStatus(array)!=0){
                gameStatus = false;
            }
        }
    }
    public static void fillRandomNum(double[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (Math.random()*10)+2;
            }
        }
    public static int analyzeCompTurn(double[] array){
        double[] newArray = Arrays.copyOf(array,array.length);
        Arrays.sort(newArray);
            int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(newArray[array.length - 1] - array[i]) < 0.000000001) {
                result = i;
            }
        }
        return result;
    }
    public static char checkStatus(double[] array) {
        char k = 0;
        for (int i = 0; i < array.length; i = i + 3) {         ///////////// Strings
            if (array[i] == array[1 + i] && array[1 + i] == array[2 + i]) {
                k = endGame(array[i]);
            }
        }
        for (int i = 0; i < Math.pow(array.length,0.5); i++) {  //////////// Column
            if(array[i]==array[3+i]&array[3+i]==array[6+i]){
                k = endGame(array[i]);
            }
        }

        if(array[0]==array[4]&&array[4]==array[8]){
            k = endGame(array[4]);
        }
        if(array[2]==array[4]&&array[4]==array[6]){
            k = endGame(array[4]);
        }

        return k;
    }
    public static char endGame(double v){
        if(v==1){
            System.out.println("x перем");
        return 'x';
        }else {
            System.out.println("o перем");
            return 'o';
        }
    }
    public static void printArray(double[] array){
        for (int i = 0; i < array.length;i = i + 3) {
            System.out.print((array[i] == 0 ? "o": array[i] == 1 ? "x": " ")+ "|");
            System.out.print((array[i+1] == 0 ? "o": array[i+1] == 1 ? "x": " ")+ "|");
            System.out.print((array[i+2] == 0 ? "o": array[i+2] == 1 ? "x": " "));
            System.out.println();
        }
    }
}

