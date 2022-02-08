/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Dao;

import controlador.grafo.GrafoEtiquetadoND;
import modelo.Escuela;

/**
 *
 * @author JavierSarango
 */
public class ServicioEscuela {
    
    private EscuelaDao escuelaDao = new EscuelaDao();
    
    public Escuela getEscuela(){
    return escuelaDao.getEscuela();
    }
    public void establecerCiudad(Escuela escuela){
    escuelaDao.setCiudad(escuela);    
    }
    public Boolean guardar(){
    return escuelaDao.guardar();
    }
    
    public GrafoEtiquetadoND<Escuela> getGrafo(){
    return escuelaDao.listarGrafo();
    }
    public GrafoEtiquetadoND<Escuela> getGrafoObjecto(){
    return escuelaDao.getGrafo();
    }
    public Boolean redibujarGrafo(GrafoEtiquetadoND<Escuela> grafo){
    return escuelaDao.actualizarGrafo(grafo);
    }
}
