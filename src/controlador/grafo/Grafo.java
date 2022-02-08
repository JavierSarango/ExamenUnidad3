package controlador.grafo;

import controlador.exception.AdyacenciaExepcion;
import java.io.Serializable;
import lista.controlador.Lista;


/**
 *
 * @author usuario
 */
public abstract class Grafo implements Serializable {

    /**
     * Es el numero de vertices del grafo
     *
     * @return Integer numero de vertices
     */
    public abstract Integer numVertices();

    /**
     * Es el numero de aristas del grafo
     *
     * @return Integer numero de aristas
     */
    public abstract Integer numAristas();

    /**
     * Permite ver si entre dos nodos hay conexion (arista)
     *
     * @param i Nodo incial
     * @param j Nodo final
     * @return true si estan conectados
     * @throws Exception Excepcion
     */
    public abstract Boolean existeArista(Integer i, Integer j) throws Exception;

    /**
     * Retorna el peso que hay entre dos vertices
     *
     * @param i Nodo incial
     * @param j Nodo final
     * @return Double peso de la arista
     */
    public abstract Double pesoArista(Integer i, Integer j);

    /**
     * Permite insertar arista sin peso
     *
     * @param i Nodo incial
     * @param j Nodo final
     */
    public abstract void insertarArista(Integer i, Integer j);

    /**
     * Permite insertar arista con peso
     *
     * @param i Nodo incial
     * @param j Nodo final
     * @param peso peso de la arista
     */
    public abstract void insertarArista(Integer i, Integer j, Double peso);

    /**
     * Listado de adycencias de un nodo
     *
     * @param i Nodo a listar sus adyacencias
     * @return Lista
     */
    public abstract Lista<Adyacencia> adyacentes(Integer i);

    @Override
    public String toString() {
        String grafo = "";
        for (int i = 1; i <= numVertices(); i++) {
            grafo += "Vertice " + i;
            Lista<Adyacencia> lista = adyacentes(i);
            for (int j = 0; j < lista.tamanio(); j++) {
                Adyacencia aux = lista.consultarDatoPosicion(j);

                if (aux.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                    grafo += " --Vertice destino " + aux.getDestino() + "-- SP ";
                } else {
                    grafo += " --Vertice destino " + aux.getDestino() + "-- Peso " + aux.getPeso() + "--";
                }

            }
            grafo += "\n";
        }
        return grafo;
    }

    public Lista caminoMinimo(Integer verticeI, Integer verticeF) throws AdyacenciaExepcion {
        Lista<Integer> caminos = new Lista<>();

        Lista<Double> listarPesos = new Lista<>();
        Integer inicial = verticeI;
        caminos.insertarNodo(inicial);
        Boolean finalizar = false;
        while (!finalizar) {
            Lista<Adyacencia> adyacencias = adyacentes(inicial);
            if (adyacencias == null) {
                throw new AdyacenciaExepcion("No existe adyacencias");
            }

            Double peso = 100000000.0;
            Integer T = -1;//aux Destino
            for (int i = 0; i < adyacencias.tamanio(); i++) {
                Adyacencia ad = adyacencias.consultarDatoPosicion(i);

                if (!estaEnCamino(caminos, ad.getDestino())) {
                    Double pesoArista = ad.getPeso();
                    if (verticeF.intValue() == ad.getDestino().intValue()) {
                        T = ad.getDestino();
                        peso = pesoArista;
                        break;
                    } else if (pesoArista < peso) {
                        T = ad.getDestino();
                        peso = pesoArista;
                    }
                }

            }

            listarPesos.insertarNodo(peso);
            caminos.insertarNodo(T);
            inicial = T;

            if (verticeF.intValue() == inicial.intValue()) {
                finalizar = true;
            }
        }

        return caminos;
    }

    public boolean estaEnCamino(Lista<Integer> lista, Integer vertice) {
        Boolean band = false;
        for (int i = 0; i < lista.tamanio(); i++) {
            if (lista.consultarDatoPosicion(i).intValue() == vertice.intValue()) {
                band = true;
                break;
            }
        }
        return band;
    }
    
       public String Floyd(){
       
       return "";
       }
            
//    public void algoritmoFloyd(Integer vI, Integer vF){
//    Double minimo = 0.0;
//    Lista<Adyacencia> adyacentes = new Lista<>();
//    
//        for (int k = 0; k < 10; k++) {
//            for (int i = 0; i < 10; i++) {
//                for (int j = 0; j < 10; j++) {
//                    if (i != j && k != i && k!=j) {
//                        vF = adyacentes.consultarDatoPosicion(i).getDestino();
//                    } else {
//                    }
//                }
//            }
//        }
//    
//    
//    }
}
