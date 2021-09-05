/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.Secciones;
import uteq.sga.SYStemSGAv21.Repositorys.ISeccionesRepository;
import uteq.sga.SYStemSGAv21.Services.ISeccionesServices;

/**
 *
 * @author capur
 */
@Service
public class SeccionesImpl implements ISeccionesServices{
    
    @Autowired
    private ISeccionesRepository secrepo;

    @Override
    public List<Secciones> listarTodos() {
        return (List<Secciones>) secrepo.findAll();
    }

    @Override
    public void guardar(Secciones actividad) {
        secrepo.save(actividad);
    }

    @Override
    public Secciones buscaById(Integer id) {
        return secrepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        secrepo.deleteById(id);
    }
    
}
