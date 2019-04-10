package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Lesson_4 {

    static final int SIZE_X = 5;
    static final int SIZE_Y = 5;
    static final int winStrick = 4;
    static char[][] field = new char[SIZE_X][SIZE_Y];

    static char PLAYER_DOT = 'x';
    static char AI_DOT = '0';
    static char Empty_dot = '.';


    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void FullField() {
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = Empty_dot;
            }
    }

    public static void PrintField() {
        System.out.println("-------");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    public static void main() {

    }

    public static boolean checkWin(char sym) {
        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                if (field[y][x] == sym) {
                    if (y <= SIZE_Y - winStrick + 1 && checkVertical(x, y))
                        return true;
                    if (x <= SIZE_X - winStrick + 1 && checkHorizontal(x, y))
                        return true;
                    if (y <= SIZE_Y - winStrick + 1 && x < SIZE_X - winStrick + 1 && checkDiagonalDOWN(x, y))
                        return true;
                    if (y >= SIZE_Y - winStrick + 1 && x < SIZE_X - winStrick + 1 && checkDiagonalUP(x, y))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean checkVertical(int x, int y) {
        int strick = 0;
        for (int i = y; strick < winStrick; i++) {
            if (field[i][x] == field[y][x]) {
                strick++;
            } else
                return false;
        }
        return true;

    }

    public static boolean checkHorizontal(int x, int y) {
        int strick = 0;
        for (int i = x; strick < winStrick; i++) {
            if (field[y][i] == field[y][x]) {
                strick++;
            } else
                return false;
        }
        return true;
    }

    public static boolean checkDiagonalUP(int x, int y) {
        int strick = 0;
        for (int i = y, j = x; strick < winStrick; i--, j++) {
            if (field[i][j] == field[y][x]) {
                strick++;
            } else
                return false;
        }
        return true;
    }

    public static boolean checkDiagonalDOWN(int x, int y) {
        int strick = 0;
        for (int i = y, j = x; strick < winStrick; i++, j++) {
            if (field[i][j] == field[y][x]) {
                strick++;
            } else
                return false;
        }
        return true;

    }


    public static boolean isCellvailed(int x, int y) { //проверка возможности хода вданную яч.
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y)
            return false;
        return field[x][y] == Empty_dot;
    }

    public static void SetSymbol(int x, int y, char sym) {
        field[x][y] = sym;
    }

    public static boolean isFieldFull() {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++)
                if (field[i][j] == Empty_dot)
                    return false;
        }
        return true;

    }

    public static void Playerstep() {
        int x, y;
        System.out.println("Введите координаты");
        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellvailed(x, y));
        SetSymbol(x, y, PLAYER_DOT);
    }

    public static void Aistep() {
        int x, y;
        do {
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isCellvailed(x, y));
        SetSymbol(x, y, AI_DOT);
    }

    public static void main(String[] args) {
        FullField();
        PrintField();

        while (true) {
            Playerstep();
            PrintField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("You win!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW!");
                break;
            }

            Aistep();
            PrintField();
            if (checkWin(AI_DOT)) {
                System.out.println("You lost!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW!");
                break;
            }

        }
    }
}
