/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.PlanEstudio;
import uteq.sga.SYStemSGAv21.Repositorys.IPlanEstudioRepository;
import uteq.sga.SYStemSGAv21.Services.IPlanEstudioServices;

/**
 *
 * @author capur
 */
@Service
public class PlanEstudioImpl implements IPlanEstudioServices{
    
    @Autowired
    private IPlanEstudioRepository planRepo;

    @Override
    public List<PlanEstudio> listarTodos() {
        return (List<PlanEstudio>) planRepo.findAll();
    }

    @Override
    public void guardar(PlanEstudio actividad) {
        planRepo.save(actividad);
    }

    @Override
    public PlanEstudio buscaById(Integer id) {
       return planRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
       planRepo.deleteById(id);
    }
    
}
