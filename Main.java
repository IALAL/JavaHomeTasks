package Java_home_task2;

import com.sun.org.apache.bcel.internal.generic.CASTORE;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] task_1 = {0,1,0,1,1,0};
	    int[] task_2 = new int[8];
	    int[] task_3 = {2,7,2,7,2,7,2,7};
	    int[][] task_4 = new int[5][5];
	    int[] task_5 = {5,5,5,-60,5,5,100,5};

	    int[] task_6 = {-1,-2,-3,-4,-5,-6,-7,8,10,10};
	    /*task_4= {
                {00000},
                {00000},
                {00000},
                {00000},
                {00000}
        };*/
        System.out.println("1."+Arrays.toString(task_1));
        System.out.println("  "+Arrays.toString(invertmass(task_1)));
        System.out.println("2."+Arrays.toString(pullmass(task_2)));
        System.out.println("3."+Arrays.toString(task3(task_3)));
        //task4
        for(int i=0,j=task_4[i].length-1; i<task_4.length; i++,j--){
            task_4[i][i]=1;
            task_4[i][j]=1;
        }

        for(int i = 0; i < task_4.length; i++){
            for(int j =0;j<task_4[i].length; j++)
                System.out.print(" "+task_4[i][j]);
            System.out.println();
        }
        //task5
        int greater=task_5[0],lower=task_5[0];
        for(int i=1;i<task_5.length;i++){
            if(task_5[i]>=greater){
                greater=task_5[i];
            }
            if(task_5[i]<=lower) {
                lower=task_5[i];
            }
        }
        if (lower==greater)
            System.out.println("5. в массиве одинаковые цифры: " + greater);
        else
            System.out.println("5. большее "+ greater +" меньшее "+ lower);

        System.out.println("6."+checkBalance(task_6));
    }
    //task1
    public static int[] invertmass(int[] mass){
        for(int i=0; i<mass.length; i++) {
            switch (mass[i]){
                case 0:
                    mass[i]=1;
                    break;
                case 1:
                    mass[i]=0;
                    break;
                default:
                    System.out.println("Участник массива не 1 и не 0");
            }
        }
        return mass;
    }
    //task2
    public static int[] pullmass(int[] mass){
        for(int i=0,j=0; i<mass.length; i++,j+=3) {
            mass[i] = j;
        }
        return mass;
    }
    //task3
    public static int[] task3(int[] mass){
        for(int i=0; i<mass.length;i++) {
            if (mass[i] < 6)
                mass[i] *= 2;
        }
        return mass;
    }
    //task6
    public static boolean checkBalance(int[] mass){

        int summL=0,summR=0;

        for(int i=0;i<mass.length-1;i++){
            summL+=mass[i];
            summR=0;
            for(int j=mass.length-1; j>i; j--){
                summR+=mass[j];
            }
            if (summL==summR) {
               return true;
            }
        }
        return false;
    }


}
