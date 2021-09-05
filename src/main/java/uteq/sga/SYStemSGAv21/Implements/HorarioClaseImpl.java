/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Horarioclase;
import uteq.sga.SYStemSGAv21.Repositorys.IHorarioClaseRepository;
import uteq.sga.SYStemSGAv21.Services.IHorarioClaseServices;

/**
 *
 * @author capur
 */
@Service
public class HorarioClaseImpl implements IHorarioClaseServices{
    
    @Autowired
    private IHorarioClaseRepository horarioRepo;

    @Override
    public List<Horarioclase> listarTodos() {
        return (List<Horarioclase>) horarioRepo.findAll();
    }

    @Override
    public void guardar(Horarioclase actividad) {
       horarioRepo.save(actividad);
    }

    @Override
    public Horarioclase buscaById(Integer id) {
       return horarioRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
       horarioRepo.deleteById(id);
    }
    
}
