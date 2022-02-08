
package controlador.Dao;

import java.io.Serializable;
import modelo.Escuela;

/**
 *
 * @author JavierSarango
 */
public class EscuelaDao extends AdaptadorDao<Escuela> implements Serializable{
    private Escuela escuela = new Escuela();
    
    public EscuelaDao(){
    super(Escuela.class);
    listarGrafo();
    }

    public Escuela getEscuela() {
        if (escuela == null) {
            escuela = new Escuela();
        }
        return escuela;
    }

    public void setCiudad(Escuela escuela) {
        this.escuela = escuela;
    }
      public  Boolean guardar(){
        Integer aux = (getGrafo() !=null) ? getGrafo().numVertices()+1 : 1;
        escuela.setId(new Long(String.valueOf(aux)));
        return guardar(escuela);
    }
    
    public Boolean modificar(){
        return  modificar(escuela);
    }
    
}
