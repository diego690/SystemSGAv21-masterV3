/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Matriculacion;
import uteq.sga.SYStemSGAv21.Repositorys.IMatriculacionRepository;
import uteq.sga.SYStemSGAv21.Services.IMatriculacionServices;

/**
 *
 * @author capur
 */
@Service
public class MatriculacionImpl implements IMatriculacionServices{
    
    @Autowired
    private IMatriculacionRepository matrirepo;

    @Override
    public List<Matriculacion> listarTodos() {
       return (List<Matriculacion>) matrirepo.findAll();
    }

    @Override
    public void guardar(Matriculacion actividad) {
        matrirepo.save(actividad);
    }

    @Override
    public Matriculacion buscaById(Integer id) {
        return matrirepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        matrirepo.deleteById(id);
    }
    
}
