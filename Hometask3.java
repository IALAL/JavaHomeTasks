package Hometask3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        boolean session = true;
        String game;
        do {
            System.out.println("Что бы сыграть в игру \"Угадай число\", напиши цифру 1. Игра \"Угадай слово\" - цифра 2. Не хотите играть более - цифра 0");
            game = sc.next();
            switch (game.charAt(0)) {
                case '1':
                    GuessNum();
                    break;
                case '2':
                    GuessWord();
                    break;
                case '0':
                    session = false;
                    break;
                default:
                    System.out.println("Выберите один из предложенных вариантов!");
            }
        }while (session);
    }

    public static int GetRandNum(int bound1,int bound2){
        Random random = new Random();
        if(bound1<0 && bound2<0) {
            bound1 = -bound1-1;
            bound2 = -bound2;
            return -(random.nextInt(bound1-bound2)+bound2);
        }
            bound2++;
            return random.nextInt(bound2-bound1)+bound1;

    }

    public static void GuessNum(){
        int Num = GetRandNum(0,9),answer,attemps=0;
        System.out.println("У вас есть 3 попытки");
        do{
            answer = sc.nextInt();
            if(answer==Num) {
                attemps = 3;
            }
            attemps++;
        }while (attemps<3);
        if(answer != Num)
            System.out.println("Вы проиграли");
        else
            System.out.println("Вы выиграли");

    }

    public static void GuessWord(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String answer;
        StringBuilder output = new StringBuilder("###############");
        boolean end = true;
        int WordNum = 1;
        int i=0;
        System.out.println("Чтоб было проще отгадывать вот список всех возможных слов: apple orange lemon banana apricot avocado broccoli carrot cherry garlic grape melon leak kiwi mango mushroom nut olive pea peanut pear pepper pineapple pumpkin potato" );        do{
            answer = sc.next();
            if (answer.charAt(0)== '0')
                end = false;
            if(words[WordNum].equals(answer)){
                System.out.println("Вы выиграли");
                end=false;
            }
            else {
                    while (i<words[WordNum].length()) {
                        if(answer.length()-1<i)
                            break;
                        else if(answer.charAt(i) == words[WordNum].charAt(i))
                        output.insert(i, words[WordNum].charAt(i));
                        i++;
                }
                System.out.println(output);
            }

        }while (end);
    };

}
