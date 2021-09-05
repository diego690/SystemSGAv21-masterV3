/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Materias;
import uteq.sga.SYStemSGAv21.Services.IMateriasServices;

/**
 *
 * @author capur
 */
@Service
public class MateriasImpl implements IMateriasServices{

    @Override
    public List<Materias> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Materias actividad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Materias buscaById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
