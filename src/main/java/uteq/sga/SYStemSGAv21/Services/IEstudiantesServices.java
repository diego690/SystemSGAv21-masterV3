/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Services;

import java.util.List;
import uteq.sga.SYStemSGAv21.Entity.Estudiantes;

/**
 *
 * @author capur
 */
public interface IEstudiantesServices {
    public List<Estudiantes> listarTodos();
    public void guardar(Estudiantes actividad);
    public Estudiantes buscaById(Integer id);
    public void eliminar(Integer id);
}
