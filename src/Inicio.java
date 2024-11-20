import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Objetos.Planeta;
import Objetos.Problemas;
import Objetos.miNave;

public class Inicio {
    String[] nombres_nave = new String[] { "NASA", "IBV", "OC", "Club Colombia", "Vianca", "Nombre personalizado" };
    List<Planeta> misplaneta = Planeta.todosLosplanetas();
    List<Planeta> planetas_visitados = new ArrayList<>();
    List<Problemas> problemas = new ArrayList<>();
    boolean terminar_programa = false;
    String opcion_seleccionar = "\n1 = Si\n2 = No";

    public Inicio() {
        Scanner entrada = new Scanner(System.in);
        Problemas.todosLosProblemas(problemas);
        
        miNave miNave = crearNave(entrada);
        do{
        System.out.println("A que planeta gustas dirigirte: ");
        for (int i = 0; i < misplaneta.size(); i++) {
            System.out.println(i + 1 + " " + misplaneta.get(i).getNombre());
        }
        int planeta_seleccionado = entrada.nextInt() - 1;
        Planeta miplaneta = misplaneta.get(planeta_seleccionado);
        miNave.despegar(miplaneta.getNombre());
        int seleccion_problemas = new Random().nextInt(0, 4);
        Problemas problemaEncontrado = problemas.get(seleccion_problemas);
        int valor_medio = (int) miplaneta.getDistancia() / 2;
        int valor_cuarto = (int) miplaneta.getDistancia() / 4;
        int opcion_decidida = 0;
        for (int i = 0; i < miplaneta.getDistancia(); i++) {
            if(i == valor_medio){
                System.out.println(problemaEncontrado);
                System.out.println(String.format("Deseas evitarlo? %s",opcion_seleccionar));
                opcion_decidida = entrada.nextInt();
                switch (opcion_decidida) {
                    case 1:
                    System.out.println("Has evitado " + problemaEncontrado);
                        break;
                    case 2:
                    System.out.println("Daño de nave afectado: "+ problemaEncontrado.daño_nave);
                    miNave.vida_nave -= problemaEncontrado.daño_nave;
                    miNave.distancia_actual += problemaEncontrado.daño_distancia;
                        break;
                    default:
                    System.out.println("Opcion incorrecta");
                        break;
                }
                seleccion_problemas = new Random().nextInt(0, 4);
                problemaEncontrado = problemas.get(seleccion_problemas);
            }
            if(i == valor_cuarto){
                System.out.println(problemaEncontrado);
                System.out.println(String.format("Deseas evitarlo? %s",opcion_seleccionar));
                opcion_decidida = entrada.nextInt();
                switch (opcion_decidida) {
                    case 1:
                        System.out.println("Has evitado " + problemaEncontrado);   
                        break;
                    case 2:
                    System.out.println("Daño de nave afectado: "+ problemaEncontrado.daño_nave);
                    miNave.vida_nave -= problemaEncontrado.daño_nave;
                    miNave.distancia_actual += problemaEncontrado.daño_distancia;
                        break;
                    default:
                    System.out.println("Opcion incorrecta");
                        break;
                }
            }
            miNave.movimiento();
        }
        double destino_llegada = miNave.aterrizar(miplaneta.getNombre());
        planetas_visitados.add(miplaneta);
        miNave.setDistancia_final(destino_llegada);
        System.out.println(miNave.nombre_nave + " llego a su destino final: " + miNave.getDistancia_final());
        System.out.println("Y llego con " + miNave.combustible + " Combustible");
        System.out.println(miNave.nombre_nave + " llego con " + miNave.vida_nave + "% de vida");
        mostrarPlanetasrecorridos();
        System.out.println(String.format("Quieres dirigirte a otro planeta? %s",opcion_seleccionar));
        int salida = entrada.nextInt();
        if(salida == 2){
            terminar_programa = true;
        }
        
    }while(!terminar_programa);
    entrada.close();
    System.exit(0);
    }

    private void mostrarPlanetasrecorridos(){
        System.out.println("Planetas recorridos: ");
        for(Planeta miplaneta : planetas_visitados){
            System.out.println("* "+ miplaneta.getNombre() );
        }

    }
    private miNave crearNave(Scanner entrada){
        System.out.println("Bienvenido al proyecto espacial!");
        System.out.println("Para iniciar, por favor ingresa el nombre de tú nave: ");
        for (int i = 0; i < nombres_nave.length; i++) {
            System.out.println(i + 1 + " " + nombres_nave[i]);
        }
        System.out.println("Ingresa la opcion que gustas: ");
        int opcion_escogida = entrada.nextInt() - 1;
        entrada.nextLine();

        String nombre_seleccionado;

        if (opcion_escogida == nombres_nave.length - 1) {
            System.out.println("Ingresa el nombre que deseas: ");

            nombre_seleccionado = entrada.nextLine();

        } else {
            nombre_seleccionado = nombres_nave[opcion_escogida];

        }
        return new miNave(nombre_seleccionado, 10000000000L, 100);

    }
}
