/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Horarios;
import uteq.sga.SYStemSGAv21.Repositorys.IHorariosRepository;
import uteq.sga.SYStemSGAv21.Services.IHorariosServices;

/**
 *
 * @author capur
 */
@Service
public class HorarioImpl implements IHorariosServices{
    @Autowired 
    private IHorariosRepository horaRepo;

    @Override
    public List<Horarios> listarTodos() {
        return (List<Horarios>) horaRepo.findAll();
    }

    @Override
    public void guardar(Horarios actividad) {
        horaRepo.save(actividad);
    }

    @Override
    public Horarios buscaById(Integer id) {
        return horaRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        horaRepo.deleteById(id);
    }
    
}
