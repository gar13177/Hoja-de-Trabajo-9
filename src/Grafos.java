/*
 * Universidad del Valle de Guatemala 2014
 * Algoritmos y Estructuras de Datos
 * Seccion No. 10
 * 
 * Hoja de Trabajo No. 9
 * 
 * Implementacion de mapeo
 * 
 * Integrantes:
 * 13023 Vidal Villegaz Zabala
 * 13077 Luis Eduardo Avila Cruz
 * 13177 Kevin Estuardo Garcia Guerra
 */
/**
 *
 * @author Kevin
 */

import java.util.Scanner;

public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in  = new Scanner(System.in);
                
        // Crear objeto
        Floyd floyd = new Floyd();       
             
        // Mostrar conexión entre nodos
        System.out.println("La matriz de adyacencia generada aleatoriamente de 15x15");
        System.out.println(floyd.toString());
        
        System.out.println("\n1.Caminos mas cortos\n2.Distancia mas corta entre 2 nodos\n3.Salir");
        
        int opcion = 0;
        // Encontrar caminos mas cortos
        floyd.find();
        
        while (opcion != 3){
            opcion = in.nextInt();
            if (opcion == 1){
                System.out.println("Caminos mas cortos:");
                
                // Mostar camino mas corto entre nodos
                System.out.println(floyd.caminos());
            }else if (opcion == 2){
                System.out.println("Ingrese dos numeros entre 1 y 9 inclusive");
                int num1 = in.nextInt();
                int num2 = in.nextInt();
                System.out.println(floyd.caminoIF(num1, num2));
            }else if (opcion ==3) System.out.println("Salida--");
        }
    }
    
}