import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        char [][] tablero = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int f = 0; f < 10; f++) {
                tablero[i][f]='*';
            }
        }

        tablero[0][0] = 'R';
        tablero[9][9]= 'F';

        Random rn = new Random();
        int ranFil;
        int ranCol;

        for (int i = 0; i < 5; i++) {
            do {
                ranFil = rn.nextInt(10);
                ranCol = rn.nextInt(10);
            } while (tablero[ranFil][ranCol] != '*');
            tablero[ranFil][ranCol]='X';
        }

        for (int i = 0; i < 1; i++) {
            do {
                ranFil = rn.nextInt(10);
                ranCol = rn.nextInt(10);
            } while (tablero[ranFil][ranCol] != '*');
            tablero[ranFil][ranCol]='B';
        }

        for (int i = 0; i < 10; i++) {
            for (int f = 0; f < 10; f++) {
                System.out.print(tablero[i][f] + " ");
            }
            System.out.println();
        }

        int vidas = 10;
        char movimiento = ' ';
        int posY = 0;
        int posX = 0;


        Scanner sc = new Scanner(System.in);

        while (movimiento!='q'){
            System.out.println("Vidas: "+ vidas);
            System.out.println("Dime donde te quieres mover, W A S D , q para salir");
            movimiento = Character.toLowerCase(sc.next().charAt(0));
            int antY = posY;
            int antX = posX;
            switch (movimiento){
                case 'w':
                    posY = wasd.movWA(posY);
                    break;
                case 'a':
                    posX = wasd.movWA(posX);
                    break;
                case 's':
                    posY = wasd.movSD(posY);
                    break;
                case 'd':
                    posX = wasd.movSD(posX);
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Letra no valida");
            }

            if (posY != antY || posX != antX) {
                char destino = tablero[posY][posX];
                if (destino == 'X') {
                    System.out.println("Movimiento bloqueado");
                    vidas--;
                    posY = antY;
                    posX = antX;
                } else {
                    if (destino == 'B') {
                        vidas += 2;
                    }
                    if (destino == 'F') {
                        System.out.println("Rescate completado");
                    }
                    tablero[antY][antX] = '*';
                }
            }

            tablero[posY][posX]='R';
            for (int i = 0; i < 10; i++) {
                for (int f = 0; f < 10; f++) {
                    System.out.print(tablero[i][f] + " ");
                }
                System.out.println();
            }
        }
    }
    static class wasd {
        static int movWA(int num) {
            if (num != 0) {
                num--;
            }
            return num;
        }
        static int movSD(int num) {
            if (num != 9) {
                num++;
            }
            return num;
        }
    }
}

