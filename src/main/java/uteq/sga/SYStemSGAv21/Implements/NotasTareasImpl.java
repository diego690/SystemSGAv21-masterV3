/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Notastareas;
import uteq.sga.SYStemSGAv21.Repositorys.INotasTareasRepository;
import uteq.sga.SYStemSGAv21.Services.INotasTareasServices;

/**
 *
 * @author capur
 */
@Service
public class NotasTareasImpl implements INotasTareasServices{
    
    @Autowired
    private INotasTareasRepository notarepo;

    @Override
    public List<Notastareas> listarTodos() {
        return (List<Notastareas>) notarepo.findAll();
    }

    @Override
    public void guardar(Notastareas actividad) {
        notarepo.save(actividad);
    }

    @Override
    public Notastareas buscaById(Integer id) {
        return notarepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        notarepo.deleteById(id);
    }
    
}
