import java.util.Stack;

public class Pila {

    private Stack <String>historial;
    public Pila(){

        historial = new Stack<String>();
    }

    public void apilar(String datosIngrasados ){
        historial.push(datosIngrasados);
    }

    public  boolean estaVacia(){
        return historial.empty();
    }

    public String desapilar() throws Exception{
        if (estaVacia()){
            throw new Exception("NO HAY ELEMENTOS EN EL HISTORIAL");

        }
        return historial.pop();
    }

    public boolean buscarUrl(String url){
        return historial.contains(url);
    }
    @Override
    public String toString(){
        String mensaje = "";
        for (int i=historial.size()-1;i>=0;i--){
            mensaje+=historial.get(i)+"\n";
        }
        return mensaje;
    }




}
