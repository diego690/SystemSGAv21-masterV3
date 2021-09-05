/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Services;

import java.util.List;
import uteq.sga.SYStemSGAv21.Entity.Usuarios;

/**
 *
 * @author capur
 */
public interface IUsuariosServices {
    public List<Usuarios> listarTodos();
    public void guardar(Usuarios actividad);
    public Usuarios buscaById(Integer id);
    public void eliminar(Integer id);
 
}
