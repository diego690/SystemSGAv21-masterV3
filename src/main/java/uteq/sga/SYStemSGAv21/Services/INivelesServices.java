/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Services;

import java.util.List;
import uteq.sga.SYStemSGAv21.Entity.Niveles;

/**
 *
 * @author capur
 */
public interface INivelesServices {
    public List<Niveles> listarTodos();
    public void guardar(Niveles actividad);
    public Niveles buscaById(Integer id);
    public void eliminar(Integer id);
    public int total();
}
