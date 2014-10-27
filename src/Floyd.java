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


import java.util.Random;

public class Floyd {
    
    // Variable para tamaño
    private final int size = 9;
    // Crear matriz de incidencia
    private long [][] adyacencia = new long[size][size];
    // Crear matriz de conexiones
    String[][] conex = new String[size][size];
    // Random
    private Random rnd = new Random();
    
    public Floyd()
    {
        int i,j;
        for(i = 0; i < size; i++)
            for (j = 0; j < size; j++)
            {
                if (i == j)
                    adyacencia[i][j] = 0;
                // Si no hay conexión entre vertices se pone un valor "infinito" <99999999999>
                // Si hay conexión entre vertices se pone el "peso"
                else
                {
                    // Números entre 1 y 50
                    adyacencia[i][j] = (long)(rnd.nextInt(51));
                }
            }
        // Valores arbitrarios de no conexión
        int t1 = 0;
        int t2 = 0;        
        
        for (i = 0; i<10; i++)
        {
            t1 = rnd.nextInt(size);
            t2 = rnd.nextInt(size);
            while (t2 == t1)
                t2 = rnd.nextInt(size);
            adyacencia[t1][t2] = 10000;
        }
    }
    
    public String findEnlaces(int n, int m, String[][] Ms, String s)
    {
        if (Ms[n][m].equals("") == true)
            return "";
        else
        {
            s += findEnlaces(n,Integer.parseInt(Ms[n][m].toString()), Ms, s) + (Integer.parseInt(Ms[n][m].toString())+1) + " , ";
            return s;
        }
    }
    
    public void find()
    {        
        String eR = "";
        long M[][] = adyacencia;        
        String[][] o_conex = new String[size][size];
        
        // Limpiar matrices
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)      
            {
                conex[i][j] = "";
                o_conex[i][j] = "";
            }
        
        // Verificar el triangulo del tipo
        //           B 
        // A                     C
        // Si la distancia de A-B + B-C es mejor que A-C        
        for (int k = 0; k < size; k++)
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size;j++)
                {
                    float a = M[i][j];
                    float b = M[i][k];
                    float c = M[k][j];
                    float d = b+c;
                    float calc = Math.min(a, d);
                    if (a != d)
                        if (d == calc)
                        {
                            eR = "";
                            o_conex[i][j] = k+"";
                            conex[i][j] = findEnlaces(i, k, o_conex, eR)+(k+1);
                        }
                    M[i][j] = (long) calc;
                }     
    }
    
    public String caminos()
    {
        // Concatenar resultado
        String res = "La distancia mas corta entre nodos es: \n";
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)            
                if (j != i)
                    if (conex[i][j].equals("") == true)
                        res += "[ " + (i+1) + " - " + (j+1) + " ] = [ " + (i+1) + " , " + (j+1) + " ] \n";
                    else
                        res += "[ " + (i+1) + " - " + (j+1) + " ] = [ " + (i+1) + " , " + conex[i][j] + " , " + (j+1) + " ] \n"; 
        
        return res;
    }
    
    public String caminoIF(int inicio, int fin)
    {
        System.out.println(""+inicio+" "+fin);
        // Concatenar resultado
        String res = "";
        if (inicio == fin)
            res += "Ha seleccionado el mismo nodo como inicio y fin \n";
        else
        {
            res += "La distancia mas corta entre " + Integer.toString(inicio) + " y " + Integer.toString(fin) + " es: \n";
            if (conex[inicio-1][fin-1].equals(""))
                res += "[ " + inicio + " - " + fin + " ] = [ " + inicio + " , " + fin + " ] \n";
            else
                res += "[ " + inicio + " - " + fin + " ] = [ " + inicio + " , " + conex[inicio-1][fin-1] + " , " + fin + " ] \n"; 
        }
        
        return res;        
    }   
    
    public String toString()
    {
        String res = "    ";
        for (int i = 0; i < adyacencia.length; i++)
            if (i<9)
                res += Integer.toString(i+1) + " - ";
            else 
                res += Integer.toString(i+1);
        res += "\n";
        for (int i = 0; i < adyacencia.length; i++)
        {
            res += Integer.toString(i+1) + " | ";
            for (int j = 0; j < adyacencia.length; j++)
                res += Long.toString(adyacencia[i][j]) + " ";
            res += "\n";                        
        }
        return res;
    }    
}
