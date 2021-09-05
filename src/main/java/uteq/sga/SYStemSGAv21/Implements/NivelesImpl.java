/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Niveles;
import uteq.sga.SYStemSGAv21.Repositorys.INivelesRepository;
import uteq.sga.SYStemSGAv21.Services.INivelesServices;

/**
 *
 * @author capur
 */
@Service
public class NivelesImpl implements INivelesServices{
    
    @Autowired
    private INivelesRepository nivelRepo;

    @Override
    public List<Niveles> listarTodos() {
        return (List<Niveles>) nivelRepo.findAll();
    }

    @Override
    public void guardar(Niveles actividad) {
        nivelRepo.save(actividad);
    }

    @Override
    public Niveles buscaById(Integer id) {
        return nivelRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
       nivelRepo.deleteById(id);
    }

    @Override
    public int total() {
        
        return (int) nivelRepo.count();
    }
    
}
