/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.PlanificacionTareas;
import uteq.sga.SYStemSGAv21.Repositorys.IPlanificacionTareasRepository;
import uteq.sga.SYStemSGAv21.Services.IPlanificacionTareasServices;

/**
 *
 * @author capur
 */
@Service
public class PlanificacionTareasImpl implements IPlanificacionTareasServices{
    
    @Autowired
    private IPlanificacionTareasRepository planRepo;

    @Override
    public List<PlanificacionTareas> listarTodos() {
        return (List<PlanificacionTareas>) planRepo.findAll();
    }

    @Override
    public void guardar(PlanificacionTareas actividad) {
        planRepo.save(actividad);
    }

    @Override
    public PlanificacionTareas buscaById(Integer id) {
       return planRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        planRepo.deleteById(id);
    }
    
}
