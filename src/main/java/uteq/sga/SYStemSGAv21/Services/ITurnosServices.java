/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Services;

import java.util.List;
import uteq.sga.SYStemSGAv21.Entity.Turnos;

/**
 *
 * @author capur
 */
public interface ITurnosServices {
    public List<Turnos> listarTodos();
    public void guardar(Turnos actividad);
    public Turnos buscaById(Integer id);
    public void eliminar(Integer id);
}
