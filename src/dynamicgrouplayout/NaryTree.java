package dynamicgrouplayout;

import java.util.stream.Stream;

public class NaryTree {
    
    Node root;
    
    NaryTree(String instruccion){
        root = new Node(instruccion);
    }
    
    NaryTree(){
        root = null;
    }
    
    public String containsNode(Node current, String instruccion) {
        
        if(Stream.of(current.palabra_clave).allMatch(instruccion::contains)){
            return current.instruccion;
        }else if(Stream.of(current.operacion1.palabra_clave).allMatch(instruccion::contains)){
            return current.operacion1.operacion1.instruccion;
        }else if(Stream.of(current.operacion2.palabra_clave).allMatch(instruccion::contains)){
            return current.operacion2.operacion1.instruccion;
        }else if(Stream.of(current.operacion3.palabra_clave).allMatch(instruccion::contains)){
            return current.operacion3.operacion1.instruccion;
        }else if(Stream.of(current.operacion4.palabra_clave).allMatch(instruccion::contains)){
            return current.operacion4.operacion1.instruccion;
        }else if(Stream.of(current.operacion5.palabra_clave).allMatch(instruccion::contains)){
            return current.operacion5.operacion1.instruccion;
        }else{
            return current.salida.instruccion;
        }
        
    }
    
}
