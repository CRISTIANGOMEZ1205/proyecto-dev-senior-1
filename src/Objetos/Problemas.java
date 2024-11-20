package Objetos;

import java.util.List;

public class Problemas{
    public String nombre;
    public double daño_nave;
    public double daño_distancia;

   public void setNombre(String nombre){
       this.nombre = nombre;

   }
   public void setDaño_nave(double daño_nave){
       this.daño_nave = daño_nave;

   }
   public void setDaño_distancia(double daño_distancia){
       this.daño_distancia = daño_distancia;

   }

   public Problemas(String nombre, double daño_nave, double daño_distancia){
       this.nombre = nombre;
       this.daño_nave = daño_nave;
       this.daño_distancia = daño_distancia;

}
public static void todosLosProblemas(List<Problemas> lista){
   lista.add(new Problemas("Asteroide Gigante", 50, 120));
   lista.add(new Problemas("Agujero negro", 95, 0));
   lista.add(new Problemas("Ovnies", 15, 20));
   lista.add(new Problemas("Meteoritos", 25, 5));
}

@Override
public String toString(){
   return nombre;

}
}
