package Objetos;
import java.util.LinkedList;
import java.util.List;


public class Planeta {
    private String nombre;
    private long distancia;
    private double oxigeno_necesario;
    private boolean tieneVida;

    
    public String getNombre() {
        return nombre;
    }
    public long getDistancia() {
        return distancia;
    }
    public double getOxigeno_necesario() {
        return oxigeno_necesario;
    }
    public boolean isTieneVida() {
        return tieneVida;
    }

    
    public Planeta(String nombre, long distancia, double oxigeno_necesario, boolean tieneVida) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.oxigeno_necesario = oxigeno_necesario;
        this.tieneVida = tieneVida;
    }

    public static List<Planeta> todosLosplanetas() {

        List<Planeta> misplanetas = new LinkedList<>();
        misplanetas.add(new Planeta("Mercurio",910000L, 25, false));
        misplanetas.add(new Planeta("Venus",410000L, 25, false));
        misplanetas.add(new Planeta("Marte",780000L, 25, false));
        misplanetas.add(new Planeta("Jupiter",6280000L, 25, false));
        misplanetas.add(new Planeta("Saturno",12750000L, 25, false));
        misplanetas.add(new Planeta("Urano",27240000L, 25, false));
        misplanetas.add(new Planeta("Neptuno",435110000L, 25, false));
        
        return misplanetas;
        
        
    

        
    }

}
