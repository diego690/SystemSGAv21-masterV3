/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Estudiantes;
import uteq.sga.SYStemSGAv21.Repositorys.IEstudiantesRepository;
import uteq.sga.SYStemSGAv21.Services.IEstudiantesServices;

/**
 *
 * @author capur
 */
@Service
public class EstudiantesImpl implements IEstudiantesServices{
    
    @Autowired
    private IEstudiantesRepository esturepo;

    @Override
    public List<Estudiantes> listarTodos() {
        return (List<Estudiantes>) esturepo.findAll();
    }

    @Override
    public void guardar(Estudiantes actividad) {
        esturepo.save(actividad);
    }

    @Override
    public Estudiantes buscaById(Integer id) {
        return esturepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        esturepo.deleteById(id);
    }
    
}
