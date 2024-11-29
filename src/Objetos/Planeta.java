package Objetos;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


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
public class SistemaPlanetas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<Planeta> misplanetas = todosLosplanetas();
        Planeta planetaSeleccionado = null;
        boolean opcionValida = false;

        do {
            System.out.println("Selecciona un planeta:");
            for (int i = 0; i < misplanetas.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, misplanetas.get(i).getNombre());
            }

            try {
                System.out.print("Introduce el número de tu elección: ");
                int opcion = entrada.nextInt();

                if (opcion >= 1 && opcion <= misplanetas.size()) {
                    planetaSeleccionado = misplanetas.get(opcion - 1);
                    opcionValida = true; 
                    System.out.println("Has seleccionado: " + planetaSeleccionado.getNombre());
                } else {
                    System.out.println("Opción incorrecta. Por favor, selecciona un número entre 1 y " + misplanetas.size());
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido.");
                entrada.next(); 
            }
        } while (!opcionValida);

        entrada.close();
    }
    

}
}