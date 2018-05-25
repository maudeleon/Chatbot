package dynamicgrouplayout;

public class Conversation {
  
    NaryTree tree;
    
    public Conversation(){
        
        Node raiz;
        Node op1, op2, op3, op4, op5, exit;
        tree = new NaryTree();
        
        raiz = tree.root = new Node("Hola! Soy chatbot. ¿Cómo puedo ayudarte?");
        raiz.palabra_clave[0] = "hola";
        raiz.palabra_clave[1] = "buen";
        raiz.palabra_clave[2] = "dia";
        
        op1 = raiz.operacion1 = new Node("bloquear tarjeta");
        op1.palabra_clave[0] = "bloquear";
        op1.palabra_clave[1] = "mi";
        op1.palabra_clave[2] = "tarjeta";
        op1.operacion1 = new Node("Con gusto te puedo ayudar a bloquear tu tarjeta ¿Me puedes indicar tu número de DPI?");
        op1.salida = new Node("Lo siento no me aparece ninguna tarjeta de crédito asociada con ese DPI, por favor visita alguna de nuestras agencias y un asesor te estará apoyando con tu solicitud.");
        
        op2 = raiz.operacion2 = new Node("saldo disponible tarjeta");
        op2.palabra_clave[0] = "saldo";
        op2.palabra_clave[1] = "disponible";
        op2.palabra_clave[2] = "tarjeta";
        op2.operacion1 = new Node("Con gusto te puedo brindar el saldo disponible de tu tarjeta ¿Me puedes indicar tu número de DPI?");
        op2.salida = new Node("Lo siento no me aparece ninguna tarjeta de crédito asociada con ese DPI, por favor visita alguna de nuestras agencias y un asesor te estará apoyando con tu solicitud.");
        
        op3 = raiz.operacion3 = new Node("fecha de corte tarjeta");
        op3.palabra_clave[0] = "fecha";
        op3.palabra_clave[1] = "corte";
        op3.palabra_clave[2] = "tarjeta";
        op3.operacion1 = new Node("Con gusto te puedo brindar la fecha de corte de tu tarjeta ¿Me puedes indicar tu número de DPI?");
        op3.salida = new Node("Lo siento no me aparece ninguna tarjeta de crédito asociada con ese DPI, por favor visita alguna de nuestras agencias y un asesor te estará apoyando con tu solicitud.");
        
        op4 = raiz.operacion4 = new Node("fecha de pago tarjeta");
        op4.palabra_clave[0] = "fecha";
        op4.palabra_clave[1] = "pago";
        op4.palabra_clave[2] = "tarjeta";
        op4.operacion1 = new Node("Con gusto te puedo brindar la fecha de pago de tu tarjeta ¿Me puedes indicar tu número de DPI?");
        op4.salida = new Node("Lo siento no me aparece ninguna tarjeta de crédito asociada con ese DPI, por favor visita alguna de nuestras agencias y un asesor te estará apoyando con tu solicitud.");
        
        op5 = raiz.operacion5 = new Node("informacion de tarjeta");
        op5.palabra_clave[0] = "informacion";
        op5.palabra_clave[1] = "de";
        op5.palabra_clave[2] = "tarjeta";
        op5.operacion1 = new Node("Con gusto te puedo brindar información acerca de las tarjetas de crédito. ¿Me puedes indicar tu nombre?");
        op5.salida = new Node("Lo siento no me aparece ninguna tarjeta de crédito asociada con ese DPI, por favor visita alguna de nuestras agencias y un asesor te estará apoyando con tu solicitud.");
        
        exit = raiz.salida = new Node("No tengo esa petición entre mis registros.  Intenta de nuevo con un tema relacionado a las tarjetas de credito.");
        
    }
    
    public NaryTree getMyTree(){
        return tree;
    }
    
}
