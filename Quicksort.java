import java.io.*;
import java.util.*;

public class Quicksort {
	static String cadena = "";
	static int x = 1;
	public static void main(String[] args) throws IOException, InterruptedException {

		for(;;) {

			System.out.println("Escoja un numero");
			System.out.println("1) Ingresar nuevo documento");
			System.out.println("2) Dar resultados");
			int entradaTeclado ;
			Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
	
	        entradaTeclado = entradaEscaner.nextInt ();
	        
	        if(entradaTeclado == 1 ) {
			
				switch(entradaTeclado)
				{
				   case 1 :
					   System.out.println("Ingresar direccion del documento");
					   Scanner a = new Scanner (System.in);
					   String cadena123 = a.nextLine ();
					   llamarDoc(cadena123);
				       break; 
				   default : 
				      break;
				}
			} else {
				
				resultados();
				break;
			}
		}
	}
        
		
			
		
		
		
			
	public static void resultados() {
		try {
            String ruta = "C:/Users/User/Desktop/filename.txt";
            String contenido = cadena;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void resultados(double a) throws IOException {  
		cadena +="Documento "+x+" = "+a+ " segundos\n";
		x++;
    }

	public static void llamarDoc(String a) throws IOException {
		
		double startTime=System.currentTimeMillis();
		
		int count = 0;
		
		String fileName = a;
        Scanner scan = new Scanner(new File(fileName));
		while(scan.hasNextLine()) {
            scan.nextLine();
            count++;
          }
        int intArray[] = new int[count];
        
        
        String fileName1 = a;
        Scanner sc = new Scanner(new File(fileName1));
        int i = 0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();        
            intArray[i] = Integer.parseInt(line);
            i++;
        }
        System.out.println();
        System.out.print("Inicio:\t\t");
        imprimir(intArray);
        quicksort(intArray,0,count-1);
        System.out.println();
        System.out.print("final:\t\t");
        imprimir(intArray);
        System.out.println();
        double estimatedTime = (System.currentTimeMillis() - startTime)/1000;
        System.out.println("segundos:\t"+estimatedTime);
        System.out.println();
        
        
        resultados(estimatedTime);
	}
	
	public static void imprimir(int A[]) {
		for(int j=0;j<A.length;j++)
        {
            System.out.print(A[j]+" ");
        }
	}
	
	public static void quicksort(int A[], int izq, int der) {

		  int pivote=A[izq]; // tomamos primer elemento como pivote
		  int i=izq;         // i realiza la búsqueda de izquierda a derecha
		  int j=der;         // j realiza la búsqueda de derecha a izquierda
		  int aux;
		 
		  while(i < j){                          // mientras no se crucen las búsquedas                                   
		     while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
		     while(A[j] > pivote) j--;           // busca elemento menor que pivote
		     if (i < j) {                        // si no se han cruzado                      
		         aux= A[i];                      // los intercambia
		         A[i]=A[j];
		         A[j]=aux;
		     }
		   }
		   
		   A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
		   A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
		   
		   if(izq < j-1)
		      quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
		   if(j+1 < der)
		      quicksort(A,j+1,der);          // ordenamos subarray derecho
		   
		}

}
