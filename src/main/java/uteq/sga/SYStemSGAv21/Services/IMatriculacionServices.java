/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Services;

import java.util.List;
import uteq.sga.SYStemSGAv21.Entity.Matriculacion;

/**
 *
 * @author capur
 */
public interface IMatriculacionServices {
    public List<Matriculacion> listarTodos();
    public void guardar(Matriculacion actividad);
    public Matriculacion buscaById(Integer id);
    public void eliminar(Integer id);
}
