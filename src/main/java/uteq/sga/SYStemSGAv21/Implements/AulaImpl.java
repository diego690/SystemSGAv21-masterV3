/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Aula;
import uteq.sga.SYStemSGAv21.Repositorys.IAulaRepository;
import uteq.sga.SYStemSGAv21.Services.IAulaServices;

/**
 *
 * @author capur
 */
@Service
public class AulaImpl implements IAulaServices{
    
    @Autowired
    private IAulaRepository aularepo;

    @Override
    public List<Aula> listarTodos() {
        return (List<Aula>) aularepo.findAll();
    }

    @Override
    public void guardar(Aula actividad) {
        aularepo.save(actividad);
    }

    @Override
    public Aula buscaById(Integer id) {
        return aularepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        aularepo.deleteById(id);
    }
    
}
