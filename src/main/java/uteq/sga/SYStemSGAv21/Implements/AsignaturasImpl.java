/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Asignaturas;
import uteq.sga.SYStemSGAv21.Repositorys.IAsiganaturasRepository;
import uteq.sga.SYStemSGAv21.Services.IAsignaturaServices;

/**
 *
 * @author capur
 */
@Service
public class AsignaturasImpl implements IAsignaturaServices{
    
    @Autowired
    private IAsiganaturasRepository asiRepo;

    @Override
    public List<Asignaturas> listarTodos() {
        return (List<Asignaturas>) asiRepo.findAll();
    }

    @Override
    public void guardar(Asignaturas actividad) {
        asiRepo.save(actividad);
    }

    @Override
    public Asignaturas buscaById(Integer id) {
        return asiRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        asiRepo.deleteById(id);
    }
    
}
