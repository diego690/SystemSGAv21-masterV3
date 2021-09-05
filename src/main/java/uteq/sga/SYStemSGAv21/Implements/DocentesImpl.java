/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Docentes;

import uteq.sga.SYStemSGAv21.Repositorys.IDocentesRepository;
import uteq.sga.SYStemSGAv21.Services.IDocentesServices;


/**
 *
 * @author capur
 */
@Service
public class DocentesImpl implements IDocentesServices{
    
    @Autowired
    private IDocentesRepository doceRepo;

    @Override
    public List<Docentes> listarTodos() {
        return (List<Docentes>) doceRepo.findAll();
    }

    @Override
    public void guardar(Docentes actividad) {
        doceRepo.save(actividad);
    }

    @Override
    public Docentes buscaById(Integer id) {
        return doceRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
       doceRepo.deleteById(id);
    }

  
}
