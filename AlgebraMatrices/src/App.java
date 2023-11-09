import java.util.Scanner;

public class App 
{
    //===============================================================================
    public static byte opc, TamañoFilas,TamañoColumnas, TamañoFilasB,TamañoColumnasB;
    public static double determinante;
    public static boolean similitud;  
    public static byte medidor = 3;
    //===============================================================================
    public static void main(String[] args) throws Exception 
    {
        Scanner local = new Scanner(System.in);

        System.out.println("¿Que tipo de operación desea hacer?");
        System.out.println("1) Igualdad de matrices"); 
        System.out.println("2) Suma de matrices"); 
        System.out.println("3) Matriz cero"); 
        System.out.println("4) Matriz inversa aditiva"); 
        System.out.println("5) Resta de matrices"); 
        System.out.println("6) Escalar de matriz"); 
        System.out.println("7) Multiplicacion de matrices"); 
        System.out.println("8) Crear matriz identidad");
        System.out.println("9) Obtener la inversa");
        System.out.println("10) Determinante de una matriz");
        //===============================================================================
        do 
        {
           opc = local.nextByte(); 
           if (opc < 1 || opc > 10) 
           {
                medidor--; 
                System.out.println("El valor ingresado no es una opcion. Intentos restantes: " + medidor);
           }
        } while (opc < 1 || opc > 10);

        if (medidor == 0) 
        { 
            System.out.println("Se han agotado los intentos, ejecute de nuevo");
            return;
        }
             
        if (opc == 9 || opc == 10)
        {
            System.out.println("Debido a la complejidad de este ejercicio, la matriz establecida es de 2x2");
           
        } else 
        {
            System.out.println("¿Cuantas filas tendra la matriz A?");

            do 
            {
                TamañoFilas = local.nextByte(); 
                if (TamañoFilas <= 0) 
                { 
                    medidor--; 
                    System.out.println("El valor debe ser mayor que cero. Intentos restantes: " + medidor);
                }
            } while (TamañoFilas <= 0 && medidor > 0);

            if (medidor == 0) 
            { 
                System.out.println("Se han agotado los intentos, ejecute de nuevo");
                return;
            }

                System.out.println("¿Cuantas columnas tendra la matriz A?");
                do
                {
                    TamañoColumnas = local.nextByte(); 
                    if (TamañoColumnas <= 0) 
                    {
                        medidor--;
                        System.out.println("El valor debe ser mayor que cero. Intentos restantes: " + medidor);
                    }
                } while (TamañoColumnas <= 0 && medidor > 0);

                if (medidor == 0) 
                {
                    System.out.println("Se han agotado los intentos, ejecute de nuevo");
                    return;
                }
                
                if (opc == 3 || opc == 4 || opc == 6 || opc == 8)
                {
                    System.out.println();
                } 

                else 
                {
                    System.out.println("¿Cuantas filas tendra la matriz B?");
                    do 
                    {
                        TamañoFilasB = local.nextByte(); 
                        if (TamañoFilasB <= 0) 
                        {
                           medidor--;
                           System.out.println("El valor debe ser mayor que cero. Intentos restantes: " + medidor);
                        }
                    } while (TamañoFilasB <= 0 && medidor > 0);

                    if (medidor == 0) 
                    {
                        System.out.println("Se han agotado los intentos, ejecute de nuevo");
                        return;
                    }

                    System.out.println("¿Cuantas columnas tendra la matriz B?");
                    do 
                    {
                        TamañoColumnasB = local.nextByte(); 
                        if (TamañoColumnasB <= 0) 
                        {
                            medidor--;
                            System.out.println("El valor debe ser mayor que cero. Intentos restantes: " + medidor);
                        }
                    } while (TamañoColumnasB <= 0 && medidor > 0);

                    if (medidor == 0) 
                    {
                        System.out.println("Se han agotado los intentos, ejecute de nuevo");
                        return;
                    }
                }         
        }

                int [][] matrizA = new int[TamañoFilas][TamañoColumnas];
                int [][] matrizB = new int[TamañoFilasB][TamañoColumnasB];
                int [][] resultado = new int[TamañoFilas][TamañoColumnas];

        switch (opc) 
        {
            case 1:
             System.out.println("===============================");
             System.out.println("IGUALDAD DE MATRICES");
             System.out.println("===============================");
                if (matrizA.length != matrizB.length) 
                {
                    similitud = false;
                } 
                
                else 
                {
                    System.out.println("Ingrese los elementos de la matriz A: ");
                    for (int i = 0; i < TamañoFilas; i++) 
                    {
                        for (int j = 0; j < TamañoColumnas; j++)
                        {
                            System.out.print("Matriz A [" + i + "," + j + "] = ");
                            matrizA[i][j] = local.nextInt();
                        }
                    }
                
                    System.out.println("Ingrese los elementos de la matriz B: ");
                    for (int i = 0; i < TamañoFilasB; i++) 
                    {
                        for (int j = 0; j < TamañoColumnasB; j++) 
                        {
                            System.out.print("Matriz B [" + i + "," + j + "] = ");
                            matrizB[i][j] = local.nextInt();
                        }
                    }
                    System.out.println("===============================");

                    for (int i = 0; i < TamañoFilas; i++) 
                    {
                        for (int j = 0; j < TamañoColumnas; j++) 
                        {
                            if (matrizA[i][j] != matrizB[i][j]) 
                            {
                                similitud = false; 
                                break;     
                            }
                        }
                        if (!similitud)
                        {
                            break;
                        }
                    }
                }
                
                if (similitud) 
                {
                    System.out.println("Las matrices son iguales");
                }
                
                else
                {
                    System.out.println("Las matrices no son iguales");
                }           
            break;

            case 2:
             System.out.println("===============================");
             System.out.println("SUMA DE MATRICES");
             System.out.println("===============================");
                
                if (TamañoFilas == TamañoFilasB && TamañoColumnas == TamañoColumnasB) 
                {
                    System.out.println("Ingrese los elementos de la matriz A: ");
                    for (int i = 0; i < TamañoFilas; i++) 
                    {
                        for (int j = 0; j < TamañoColumnas; j++) 
                        {
                            System.out.print("Matriz A [" + i + "," + j + "] = ");
                            matrizA[i][j] = local.nextInt();
                        }
                    }
                 
                    System.out.println("Ingrese los elementos de la matriz B: ");
                    for (int i = 0; i < TamañoFilasB; i++) 
                    {
                        for (int j = 0; j < TamañoColumnasB; j++)
                        {
                            System.out.print("Matriz B [" + i + "," + j + "] = ");
                            matrizB[i][j] = local.nextInt();
                        }
                    }
                
                    System.out.println(":::::::::::::::::::::::::::::::::");
                    System.out.println("La suma de A y B es: ");

                    for (int i = 0; i < TamañoFilas; i++)
                    {
                        for (int j = 0; j < TamañoColumnas; j++) 
                        {
                            resultado[i][j] = matrizA[i][j] + matrizB[i][j];
                            System.out.print(resultado[i][j] + "\t");
                        }
                        System.out.println();
                    }
                } 
                
                else 
                {
                    System.out.println("Para poder sumar las matrices deben tener las mismas dimensiones");
                }
            break;

            case 3:
             System.out.println("===============================");
             System.out.println("MATRIZ CERO");
             System.out.println("===============================");

                for (int i = 0; i < TamañoFilas; i++) 
                {
                    for (int j = 0; j < TamañoColumnas; j++) 
                    {
                        System.out.print(matrizA[i][j] + "\t");
                    }
                    System.out.println();
                }

            break;

            case 4:
             System.out.println("===============================");
             System.out.println("MATRIZ INVERSA ADITIVA");
             System.out.println("===============================");

                System.out.println("Ingrese los elementos de la matriz: ");
                for (int i = 0; i < TamañoFilas; i++) 
                {
                    for (int j = 0; j < TamañoColumnas; j++) 
                    {
                        System.out.print("Matriz A [" + i + "," + j + "] = ");
                        matrizA[i][j] = local.nextInt();
                    }
                }

                System.out.println("===============================");
                System.out.println("La inversa aditiva es: ");
                System.out.println("===============================");
                for (int i = 0; i < TamañoFilas; i++) 
                {
                    for (int j = 0; j < TamañoColumnas; j++) 
                    {
                        System.out.print(matrizA[i][j] * (-1) + "\t");
                    }
                    System.out.println();
                }

            break;

            case 5:
                System.out.println("===============================");
                System.out.println("RESTA DE MATRICES");
                System.out.println("===============================");
              
                if (TamañoFilas == TamañoFilasB && TamañoColumnas == TamañoColumnasB) 
                {
                    System.out.println("Ingrese los elementos de la matriz A: ");
                    for (int i = 0; i < TamañoFilas; i++) 
                    {
                        for (int j = 0; j < TamañoColumnas; j++) 
                        {
                            System.out.print("Matriz A [" + i + "," + j + "] = ");
                            matrizA[i][j] = local.nextInt();
                        }
                    }
                
                    System.out.println("Ingrese los elementos de la matriz B: ");
                    for (int i = 0; i < TamañoFilasB; i++) 
                    {
                        for (int j = 0; j < TamañoColumnasB; j++) 
                        {
                            System.out.print("Matriz B [" + i + "," + j + "] = ");
                            matrizB[i][j] = local.nextInt();
                        }
                    }
                    System.out.println(":::::::::::::::::::::::::::::::::");
                    System.out.println("La resta de A y B es: ");
                    for (int i = 0; i < TamañoFilas; i++) 
                    {
                        for (int j = 0; j < TamañoColumnas; j++) 
                        {
                            resultado[i][j] = matrizA[i][j] - matrizB[i][j];
                            System.out.print(resultado[i][j] + "\t");
                        }
                        System.out.println();
                    }
                } 

                else 
                {
                    System.out.println("Para poder restar las matrices deben tener las mismas dimensiones");
                }
            break;


            case 6: 
                System.out.println("===============================");
                System.out.println("ESCALAR POR LA MATRIZ");
                System.out.println("===============================");
                System.out.println("¿Cual es el escalar?");
                int escalar = local.nextInt();
                System.out.println("===============================");
                System.out.println("Ingrese los elementos de la matriz: ");

                for (int i = 0; i < TamañoFilas; i++) 
                {
                    for (int j = 0; j < TamañoColumnas; j++) 
                    {
                        System.out.print("Matriz A [" + i + "," + j + "] = ");
                        matrizA[i][j] = local.nextInt();
                    }
                }

                System.out.println("===============================");
                System.out.println("El resultado es: ");
                for (int i = 0; i < TamañoFilas; i++) 
                {
                    for (int j = 0; j < TamañoColumnas; j++) 
                    {
                       
                        System.out.print(matrizA[i][j] * escalar + "\t");
                    }
                    System.out.println();
                }  
            break;

            case 7:
                System.out.println("===============================");
                System.out.println("MULTIPLICACION DE MATRICES");
                System.out.println("===============================");

                if (TamañoColumnas != TamañoFilasB) 
                {
                    System.out.println("No se pueden multiplicar las matrices");
                } 
                
                else 
                {
                    System.out.println("Ingrese los elementos de la matriz A: ");
                    for (int i = 0; i < TamañoFilas; i++) 
                    {
                        for (int j = 0; j < TamañoColumnas; j++) 
                        {
                            System.out.print("Matriz A [" + i + "," + j + "] = ");
                            matrizA[i][j] = local.nextInt();
                        }
                    }
                
                    System.out.println("Ingrese los elementos de la matriz B: ");
                    for (int i = 0; i < TamañoFilasB; i++) 
                    {
                        for (int j = 0; j < TamañoColumnasB; j++) 
                        {
                            System.out.print("Matriz B [" + i + "," + j + "] = ");
                            matrizB[i][j] = local.nextInt();
                        }   
                    }

                    for (int i = 0; i < TamañoFilas; i++) 
                    {
                        for (int j = 0; j < TamañoColumnasB; j++) 
                        {
                            for (int k = 0; k < TamañoColumnas; k++) 
                            {
                                resultado[i][j] += matrizA[i][k] * matrizB[i][k];
                            }
                        }
                    }

                    System.out.println("===============================");
                    System.out.println("La multiplicacion de AB es: ");
                    System.out.println("===============================");

                    for (int i = 0; i < TamañoFilas; i++) 
                    {
                        for (int j = 0; j < TamañoColumnasB; j++) 
                        {
                            System.out.print(resultado[i][j] + "\t");
                        }
                        System.out.println();
                    }
                }
            break;

            case 8:
                System.out.println("===============================");
                System.out.println("CREAR MATRIZ IDENTIDAD");
                System.out.println("===============================");

                if (TamañoColumnas != TamañoFilas) 
                {
                System.out.println("Una matriz identidad debe ser cuadrada");             
                } 
                
                else 
                {
                    System.out.println("La matriz identidad es: ");
                
                    for (int i = 0; i < TamañoFilas; i++) 
                    {
                        for (int j = 0; j < TamañoColumnas; j++) 
                        {
                            if (i == j) 
                            {
                                matrizA[i][j] = 1;
                            } 
                      
                            else 
                            {
                                matrizA[i][j] = 0;
                            }
                            System.out.print(matrizA[i][j] + "\t");
                        }
                        System.out.println();
                    }
                } 
            break;

            case 9:
                System.out.println("===============================");
                System.out.println("OBTENER INVERSA");
                System.out.println("===============================");

                System.out.println("Ingrese los elementos de la matriz A: ");
                int matriz[][] = new int[2][2];
                for (int i = 0; i < 2; i++) 
                {
                    for (int j = 0; j < 2; j++) 
                    {
                        System.out.print("Matriz A [" + i + "," + j + "] = ");
                        matriz[i][j] = local.nextInt();
                    }
                }
                            
                double determinante = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
                            
                if (determinante == 0) 
                {
                    System.out.println("La matriz no tiene inversa porque su determinante es cero.");
                    return;
                }
                            
                           
                double[][] matrizAdjunta = {{matriz[1][1], -matriz[0][1]}, {-matriz[1][0], matriz[0][0]}};
                            
                        
                double[][] matrizInversa = new double[2][2];
                for (int i = 0; i < 2; i++) 
                {
                    for (int j = 0; j < 2; j++) 
                    {
                        matrizInversa[i][j] = matrizAdjunta[i][j] / determinante;
                    }
                }

                System.out.println("===============================");
                System.out.println("La Matriz Inversa es: ");
                System.out.println("===============================");

                for (int i = 0; i < 2; i++) 
                {
                    for (int j = 0; j < 2; j++) 
                    {
                        System.out.print(matrizInversa[i][j] + " ");
                    }
                    System.out.println();
                }    
            break;

            case 10:
                System.out.println("===============================");
                System.out.println("DETERMINANTE DE UNA MATRIZ");
                System.out.println("===============================");

                System.out.println("Ingrese los elementos de la matriz A: ");
                int matrizDet[][] = new int[2][2];
                for (int i = 0; i < 2; i++) 
                {
                    for (int j = 0; j < 2; j++) 
                    {
                        System.out.print("Matriz A [" + i + "," + j + "] = ");
                        matrizDet[i][j] = local.nextInt();
                    }
                }
                            
                determinante = matrizDet[0][0] * matrizDet[1][1] - matrizDet[0][1] * matrizDet[1][0];

                System.out.println("===============================");
                System.out.println("El determinante es: " + determinante);
                System.out.println("===============================");
            break;
        }                
    }          
}
