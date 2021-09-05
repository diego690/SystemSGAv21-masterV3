/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Time;
import uteq.sga.SYStemSGAv21.Repositorys.ITimeRepository;
import uteq.sga.SYStemSGAv21.Services.ITimeServices;

/**
 *
 * @author capur
 */
@Service
public class TimeImpl implements ITimeServices{
    
    @Autowired
    private ITimeRepository timeRepo;

    @Override
    public List<Time> listarTodos() {
        return (List<Time>) timeRepo.findAll();
    }

    @Override
    public void guardar(Time actividad) {
        timeRepo.save(actividad);
    }

    @Override
    public Time buscaById(Integer id) {
        return timeRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
