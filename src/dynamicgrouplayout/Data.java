package dynamicgrouplayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {
    
    ArrayList<String> arr_id;
    ArrayList<String> arr_nombre;
    ArrayList<String> arr_apellido;
    ArrayList<String> arr_sexo;
    ArrayList<String> arr_pais;
    ArrayList<String> arr_fecha;
    ArrayList<String> arr_telefono;
    ArrayList<String> arr_tarjeta;
    ArrayList<String> arr_tipo;
    ArrayList<String> arr_fecha_tarjeta;
    ArrayList<String> arr_ccv;
    ArrayList<String> arr_dpi;
    ArrayList<String> arr_estado;
    ArrayList<String> arr_saldo;
    
    public Data(){
        
        arr_id = new ArrayList<>();
        arr_nombre = new ArrayList<>();
        arr_apellido = new ArrayList<>();
        arr_sexo = new ArrayList<>();
        arr_pais = new ArrayList<>();
        arr_fecha = new ArrayList<>();
        arr_telefono = new ArrayList<>();
        arr_tarjeta = new ArrayList<>();
        arr_tipo = new ArrayList<>();
        arr_fecha_tarjeta = new ArrayList<>();
        arr_ccv = new ArrayList<>();
        arr_dpi = new ArrayList<>();
        arr_estado = new ArrayList<>();
        arr_saldo = new ArrayList<>();
        
        loadData();
        
    }
    
    public final void loadData(){
        
        String filename = "datos_tarjeta.csv";
        BufferedReader br;
        String line;
        String splitter = ";";
        
        try {
            
            br = new BufferedReader(new FileReader(filename));
            
            while ((line = br.readLine()) != null) {
                String[] info = line.split(splitter);
                arr_id.add(info[0]);
                arr_nombre.add(info[1]);
                arr_apellido.add(info[2]);
                arr_sexo.add(info[3]);
                arr_pais.add(info[4]);
                arr_fecha.add(info[5]);
                arr_telefono.add(info[6]);
                arr_tarjeta.add(info[7]);
                arr_tipo.add(info[8]);
                arr_fecha_tarjeta.add(info[9]);
                arr_ccv.add(info[10]);
                arr_dpi.add(info[11]);
                arr_estado.add(info[12]);
                arr_saldo.add(info[13]);
            }
            
            System.out.println("Finaliza la carga de información.");
            
            for (int i = 0; i < arr_id.size(); i++) {
                
                String row = arr_id.get(i) +
                    " *** " +
                    arr_nombre.get(i) + 
                    " *** " +
                    arr_apellido.get(i) + 
                    " *** " +
                    arr_sexo.get(i) + 
                    " *** " +
                    arr_pais.get(i) + 
                    " *** " +
                    arr_fecha.get(i) + 
                    " *** " +
                    arr_telefono.get(i) + 
                    " *** " +
                    arr_tarjeta.get(i) + 
                    " *** " +
                    arr_tipo.get(i) + 
                    " *** " +
                    arr_fecha_tarjeta.get(i) + 
                    " *** " +
                    arr_ccv.get(i) + 
                    " *** " +
                    arr_dpi.get(i) + 
                    " *** " +
                    arr_estado.get(i) +
                    " *** " +
                    arr_saldo.get(i);
                
                //System.out.println(row);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
