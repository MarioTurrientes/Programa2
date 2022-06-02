
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Examen_Ordinaria {
    
    //funcion para saber cual es la intervencion maxima y minima que guardamos en el arraylist:
    public static void IntervencionMaxMin(ArrayList listaIntervenciones) {
        //ordenamos la lista:
        Collections.sort(listaIntervenciones);
        
        //la ultima posicion correspondrá al de mayor numero:
        String maximo = (String) listaIntervenciones.get(listaIntervenciones.size() - 1);
        //la primera posicion la 0 del arraylist correspondrá con el minimo:
        String minimo = (String) listaIntervenciones.get(0);
        //escribimos el resultado:
        System.out.println("La intervencion maxima es: "+maximo+" y la minima"+minimo);
     }
    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        try{
            //declaramos las variables:
            double IntervencionMedia = 0;
            ArrayList<String> SalidasMax = new ArrayList<String>();
            ArrayList<String> SalidasMin = new ArrayList<String>();
            
            //probamos primero con un solo fichero:
            //ruta para introducir ejemplo -->  C:\Users\DAW\Documents\NetBeansProjects\Examen_Ordinaria\Bomberos\2017.csv
            System.out.println("Introduce la ruta del fichero");
            String ruta = leer.nextLine();
        
            File archivo = new File(ruta);
            Scanner leer2 = new Scanner(archivo);
             
            //recorremos el fichero linea por linea:
            do{
               String fila = leer2.nextLine();
               //ahora dividimos cada parte o en columnas por el ";" dado que en el fichero se separa asi:
               String parte[] = fila.split(";");
               
               //almacenamos el total de las salidas max y minimas en dos arraylist:
               //la columna 11 porque es la del total en ambas
               SalidasMax.add(parte[11]);
               SalidasMin.add(parte[11]);
               
            }while (leer2.hasNextLine());
            leer2.close();
            
            //mostramos ahora por pantalla la informacion pedida:
            System.out.println("Intervencion con más salidas:");
            IntervencionMaxMin(SalidasMax);
            System.out.println("--------------------------------------");
            System.out.println("Intervencion con menos salidas:");
            IntervencionMaxMin(SalidasMin);
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
