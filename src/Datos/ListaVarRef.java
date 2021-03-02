
package Datos;
/**
 * 
 * @author Jorge-Pc
 */
class nodoVref{
    int id;
    String contexto;
    String nombreVref;
    int frecuencia;
    int freEsperada;
    nodoVref siguiente;
    
    public nodoVref(String contexto,String nombreVref,int frecuencia, int freEsperada,int id) {
        this.contexto=contexto;
        this.nombreVref=nombreVref;
        this.frecuencia=frecuencia;
        this.freEsperada=freEsperada;
        this.id=id;
    }
    
}

public class ListaVarRef {
    private nodoVref cabeza;
   private nodoVref cola;
   int id;
   
   
   public void insertarVarRef(String contexto,String nombreVref,int frecuencia, int freEsperada){
       
       if(cabeza==null){
            cabeza= new nodoVref(contexto,nombreVref,frecuencia,freEsperada,id);
            id++;
            cola=cabeza;
        }else{
            cola.siguiente=new nodoVref(contexto,nombreVref,frecuencia,freEsperada,id); 
            id++;
            cola=cola.siguiente;
        }
    }
   
   public boolean existeVar(String nombreVref,String Contexto){
        if(cabeza==null){
        return false;
        }else{
           nodoVref tmp=cabeza;
           
            while(tmp!=null){
                if(tmp.nombreVref.equals(nombreVref) && tmp.contexto.equals(Contexto)){
                    return true;
                }
                tmp=tmp.siguiente;
            }
            return false;
        } 
    }
    
}
