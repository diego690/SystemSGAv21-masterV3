/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Services;

import java.util.List;
import uteq.sga.SYStemSGAv21.Entity.Asignaciones;

/**
 *
 * @author capur
 */
public interface IAsignacionesServices {
    public List<Asignaciones> listarTodos();
    public void guardar(Asignaciones actividad);
    public Asignaciones buscaById(Integer id);
    public void eliminar(Integer id);
}
