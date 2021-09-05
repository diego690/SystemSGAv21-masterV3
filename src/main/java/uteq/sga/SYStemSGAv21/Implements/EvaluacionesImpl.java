/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Evaluaciones;
import uteq.sga.SYStemSGAv21.Repositorys.IEvaluacionesRepository;
import uteq.sga.SYStemSGAv21.Services.IEvaluacionesServices;

/**
 *
 * @author capur
 */
@Service
public class EvaluacionesImpl implements IEvaluacionesServices{
    
    @Autowired
    private IEvaluacionesRepository evalRepo;

    @Override
    public List<Evaluaciones> listarTodos() {
        return (List<Evaluaciones>) evalRepo.findAll();
    }

    @Override
    public void guardar(Evaluaciones actividad) {
        evalRepo.save(actividad);
    }

    @Override
    public Evaluaciones buscaById(Integer id) {
        return evalRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        evalRepo.deleteById(id);
    }
    
}
