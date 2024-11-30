package Objetos;

public class miNave{
    public String nombre_nave;
    public long combustible;
    public double distancia_inicial;
    public double distancia_actual;
    private double distancia_final;
    public double vida_nave;
    
      

    public miNave(String nombre_nave, long combustible, double vida_nave){
        this.nombre_nave = nombre_nave;
        this.combustible = combustible;
        this.vida_nave = vida_nave;
    }
    public void setDistancia_final(double distancia_final){
        this.distancia_final = distancia_final;
    }
    public double getDistancia_final(){
        return distancia_final;
    }

    public void movimiento(){
        combustible --;
        distancia_actual += 0.5 ;
    }
    public void destino(double plantena_destinada){
        distancia_final = plantena_destinada;

    }

    public void despegar( String nombre_planeta){
        System.out.println(nombre_nave+" esta por despegar hacia "+ nombre_planeta);
        distancia_inicial = 0;
        distancia_actual = 0;

    }
    public double aterrizar(String nombre_planeta){
        System.out.println(nombre_nave +" acaba de aterrizar en " +nombre_planeta +" y esta es su distancia total recorrida: "+ distancia_actual + " Km");
        return distancia_actual;

    }

}
