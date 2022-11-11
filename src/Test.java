import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] array = new double[9];

        fillRandomNum(array);

        for(boolean gameStatus = true; gameStatus;){
            while(true){    ///////////////////////////// Player's Turn
                System.out.println("Ввести комірку");
                int i = sc.nextInt();

                if(array[i]==1||array[i]==0){
                    System.out.println("Комірка зайнята");
                } else {
                    array[i] = 1;
                    break;  //////////////////////////////
                }
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
        System.out.println(newArray[array.length-1]);
            int result = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (Math.abs(newArray[array.length - 1] - array[i]) < 0.000001) {
                result = i;
            }
        }
        return result+1;
    }
}

