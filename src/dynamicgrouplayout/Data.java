package dynamicgrouplayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    
    ArrayList<String> id;
    ArrayList<String> nombre;
    ArrayList<String> apellido;
    ArrayList<String> sexo;
    ArrayList<String> pais;
    ArrayList<String> fecha;
    ArrayList<String> telefono;
    ArrayList<String> tarjeta;
    ArrayList<String> tipo;
    ArrayList<String> fecha_tarjeta;
    ArrayList<String> ccv;
    ArrayList<String> dpi;
    
    public Data(){
        
        id = new ArrayList<>();
        nombre = new ArrayList<>();
        apellido = new ArrayList<>();
        sexo = new ArrayList<>();
        pais = new ArrayList<>();
        fecha = new ArrayList<>();
        telefono = new ArrayList<>();
        tarjeta = new ArrayList<>();
        tipo = new ArrayList<>();
        fecha_tarjeta = new ArrayList<>();
        ccv = new ArrayList<>();
        dpi = new ArrayList<>();
        
        loadData();
        
    }
    
    public final void loadData(){
        
        String filename = "datos_tarjeta.csv";
        File file = new File(filename);
        
        Scanner inputStream;
        
        try {
            
            inputStream = new Scanner(file);
            
            while(inputStream.hasNext()){
                String line = inputStream.next();
                String[] values = line.split(";");
                // this adds the currently parsed line to the 2-dimensional string array
                //lines.add(Arrays.asList(values));
                for (String value : values) {
                    System.out.println(value);
                }
            }
            
            System.out.println("Terminbo");
            
            inputStream.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de carga!");
        }
        
    }
    
}
