/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Asignaciones;
import uteq.sga.SYStemSGAv21.Repositorys.IAsignacionesRepository;
import uteq.sga.SYStemSGAv21.Services.IAsignacionesServices;

/**
 *
 * @author capur
 */
@Service
public class AsignacionesImpl implements IAsignacionesServices{
    
    @Autowired
    private IAsignacionesRepository asigRepo;

    @Override
    public List<Asignaciones> listarTodos() {
        return (List<Asignaciones>) asigRepo.findAll();
    }

    @Override
    public void guardar(Asignaciones actividad) {
        asigRepo.save(actividad);
    }

    @Override
    public Asignaciones buscaById(Integer id) {
        return asigRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        asigRepo.deleteById(id);
    }
    
}
