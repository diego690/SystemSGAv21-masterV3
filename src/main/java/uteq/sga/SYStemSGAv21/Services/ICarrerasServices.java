/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Services;

import java.util.List;
import uteq.sga.SYStemSGAv21.Entity.Carreras;

/**
 *
 * @author capur
 */
public interface ICarrerasServices {
    public List<Carreras> listarTodos();
    public void guardar(Carreras actividad);
    public Carreras buscaById(Integer id);
    public void eliminar(Integer id);
}
