package chatbot;

public class Node {
    
    String instruccion;
    String[] palabra_clave;
    Node operacion1;
    Node operacion2;
    Node operacion3;
    Node operacion4;
    Node operacion5;
    Node operacion6;
    Node salida;
 
    Node(String instruccion) {
        this.instruccion = instruccion;
        this.palabra_clave = new String[3];
        this.operacion1 = null;
        this.operacion2 = null;
        this.operacion3 = null;
        this.operacion4 = null;
        this.operacion5 = null;
        this.operacion6 = null;
        this.salida = null;
    }
    
}
