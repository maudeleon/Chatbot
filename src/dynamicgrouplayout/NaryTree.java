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
    
    public void containsNode(Node current, String instruccion, DynamicGroupLayout dgl, int actionFlag, int subActionFlag, int omeActionFlag) {
        
        switch (actionFlag) {
            
            case 0:
                
                if(Stream.of(current.palabra_clave).allMatch(instruccion::contains)){
                    dgl.sendBotMessage(current.instruccion);
                }else if(Stream.of(current.operacion1.palabra_clave).allMatch(instruccion::contains)){
                    dgl.sendBotMessage(current.operacion1.operacion1.instruccion);
                    dgl.setActionFlag(1);
                }else if(Stream.of(current.operacion2.palabra_clave).allMatch(instruccion::contains)){
                    dgl.sendBotMessage(current.operacion2.operacion1.instruccion);
                    dgl.setActionFlag(2);
                }else if(Stream.of(current.operacion3.palabra_clave).allMatch(instruccion::contains)){
                    dgl.sendBotMessage(current.operacion3.operacion1.instruccion);
                }else if(Stream.of(current.operacion4.palabra_clave).allMatch(instruccion::contains)){
                    dgl.sendBotMessage(current.operacion4.operacion1.instruccion);
                }else if(Stream.of(current.operacion5.palabra_clave).allMatch(instruccion::contains)){
                    dgl.sendBotMessage(current.operacion5.operacion1.instruccion);
                }else{
                    dgl.sendBotMessage(current.salida.instruccion);
                    dgl.setActionFlag(0);
                    dgl.setSubActionFlag(0);
                    dgl.setOmeActionFlag(0);
                    dgl.sendBotMessage(current.instruccion);
                }
                break;
                
            case 1:
                
                if(subActionFlag != 0){
                    
                    String confirmacion = instruccion;
                    
                    if(Stream.of("si").allMatch(confirmacion::contains)){
                        
                        if("0".equals(dgl.data.arr_estado.get(subActionFlag))){
                            
                            dgl.sendBotMessage("Tu tarjeta ya se encuentra bloqueada. No se realizo ninguna acción.");
                            dgl.setActionFlag(0);
                            dgl.setSubActionFlag(0);
                            dgl.sendBotMessage(current.instruccion);
                            
                        }else{
                            
                            dgl.data.arr_estado.set(subActionFlag, "0");
                            dgl.sendBotMessage("Tu tarjeta ha sido bloqueada exitosamente.");
                            dgl.setActionFlag(0);
                            dgl.setSubActionFlag(0);
                            dgl.sendBotMessage(current.instruccion);
                            
                        }
                        
                    }else if(Stream.of("no").allMatch(confirmacion::contains)){
                        
                        dgl.sendBotMessage("No se ha realizado ninguna acción en base a tu petición.");
                        dgl.setActionFlag(0);
                        dgl.setSubActionFlag(0);
                        dgl.sendBotMessage(current.instruccion);
                        
                    }else{
                        dgl.sendBotMessage("No puedo interpretar esa respuesta.  Intenta colocando un 'Si' o un 'No'.");
                    }
                    
                }else{
                    
                    String dpi = instruccion;
                    
                    if(dgl.data.arr_dpi.contains(dpi)){
                        
                        int posicion = dgl.data.arr_dpi.indexOf(dpi);
                        dgl.sendBotMessage("He encontrado tu DPI.  Deseas bloquear la tarjeta con la numeracion: " + dgl.data.arr_tarjeta.get(posicion) + "?");
                        dgl.setSubActionFlag(posicion);
                        
                    }else{
                        dgl.sendBotMessage(current.operacion1.salida.instruccion);
                        dgl.setActionFlag(0);
                        dgl.setSubActionFlag(0);
                        dgl.sendBotMessage(current.instruccion);
                    }
                    
                }
                break;
                
            case 2:
                
                if(subActionFlag != 0){
                
                }else{
                    
                }
                
                break;
            default:
                break;
        }
        
    }
    
}
