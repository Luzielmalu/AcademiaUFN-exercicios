package br.las.mavenproject;

import org.apache.commons.math3.util.FastMath;
public class MathOperations 
{
    public static void main( String[] args )
    {
    	double numero = 145.0;
        double raizQuadrada = FastMath.sqrt(numero);
        System.out.println("A raiz quadrada de " + numero + " é " + raizQuadrada);
    
    }
    
}
