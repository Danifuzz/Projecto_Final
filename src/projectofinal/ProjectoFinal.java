/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectofinal;

import java.util.Scanner;

/**
 *
 * @author nunez
 */
public class ProjectoFinal {
    public static int fila = 4;
    public static int columna = 4;
    public static final String ANSI_RESET = "\u001B[0m"; //colores, inspirado en el laboratorio.
    public static final  String ANSI_BLUE = "\u001B[34m";
    public static final   String ANSI_RED = "\u001B[31m";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    char[][] tabla = new char[8][8];
    int ganador = 0;
    int perder = 0;
    char puntero = tabla[4][4];
    for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
            tabla[i][j]= ' '; 
            }
    }
    while (ganador<45) { //45 siendo la cantidad de espacios disponibles en la matriz
        ImprimirTabla(tabla);
        System.out.println("Ingrese a donde quiere moverse:");
        System.out.println("W = Arriba \n" // formato de movimiento WASD, tambien puedes usar un string como comando
                + "S = Abajo \n"
                + "A = Izquierda \n"
                + "D = Derecha");
        String comando = entrada.next();
        for (int i = 0; i < comando.length(); i++) {
            
        
        if (comando.charAt(i) == 'W' || comando.charAt(i) == 'w') {
            if (fila > 0) {
                tabla[fila][columna] = 'O';
                if (tabla[fila-1][columna]==' ') { // asi sabre si coloreas un espacio ya vacio
                    ganador++;
                } else if (tabla[fila-1][columna]=='X') {
                    System.out.println("Entro en un obstaculo");
                    perder++;
                    break;
                }
                fila--;
            
            } else {
                System.out.println("Perdiste carita sorprendida, cuidado con los bordes!");
            }
        } else if (comando.charAt(i) == 'S'|| comando.charAt(i) == 's') {
            if (fila < 7) {
                tabla[fila][columna]='O';
                if (tabla[fila+1][columna]==' ') {
                    ganador++;
                } else if (tabla[fila+1][columna]=='X') {
                    System.out.println("Entro en un obstaculo");
                    perder++;
                    break;
                }
                fila ++;
                
            } else {
                System.out.println("Lo que el dijo");
            }
        } else if (comando.charAt(i) == 'A'|| comando.charAt(i) == 'a') {
            if (columna > 0) {
                tabla[fila][columna]='O';
                if (tabla[fila][columna-1]==' ') {
                    ganador++;
                } else if (tabla[fila][columna-1]=='X') {
                    System.out.println("Entro en un obstaculo");
                    perder++;
                    break;
                }
                columna--;
            } else {
                System.out.println("Lo que el volvio a decir");
            }
        } else if (comando.charAt(i) == 'D' || comando.charAt(i) == 'd') {
            tabla[fila][columna]='O';
            if (columna < 7) {
                if (tabla[fila][columna+1]==' ') {
                    ganador++;
                } else if (tabla[fila][columna+1]=='X') {
                    System.out.println("Entro en un obstaculo");
                    perder++;
                    break;
                }
                columna++;
            } else {
                System.out.println("Lo que volvio a decir otra vez");
            }
        } else {
            System.out.println("Ingrese un comando valido.");
        }
        tabla[fila][columna] = 'A';
        }
       if (perder >0) {
        System.out.println("Perdio el juego, no hay nada mas que hacer");
        break;
    } 
    }
    if (ganador > 44) {
        System.out.println("Felicidades, relleno toda la matriz!");
    }
    
    ImprimirTabla(tabla);
    
    }
    public static void ImprimirTabla(char[][] tabla) {
        
        tabla[fila][columna]='A';
        tabla[0][0]='X';
        tabla[0][5]='X';
        tabla[5][5]='X';
        tabla[0][3]='X';
        tabla[1][0]='X';
        tabla[3][3]='X';
        tabla[2][4]='X';
        tabla[5][0]='X';
        tabla[4][2]='X';
        tabla[7][7]='X';
        tabla[7][6]='X';
        tabla[6][7]='X';
        tabla[7][0]='X';
        tabla[6][2]='X';
        tabla[3][6]='X';
        tabla[3][7]='X';
        tabla[6][4]='X';
        tabla[7][4]='X';

        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                    if (tabla[i][j]=='O') {
                        System.out.print("["+ ANSI_BLUE + tabla[i][j]+ ANSI_RESET +"]");   
                    } else if (tabla[i][j]=='X') {
                        System.out.print("{" + ANSI_RED + tabla[i][j] + ANSI_RESET + "]");   
                    }else{
                    System.out.print("["+tabla[i][j]+"]");   
                    }
            }
            System.out.println("");
        }
    }
}
