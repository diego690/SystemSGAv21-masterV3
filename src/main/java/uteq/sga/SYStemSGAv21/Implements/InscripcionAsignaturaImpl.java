/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.InscripcionesAsignaturas;
import uteq.sga.SYStemSGAv21.Repositorys.IInscripcionAsignaturaRepository;
import uteq.sga.SYStemSGAv21.Services.IInscripcionAsignaturasServices;

/**
 *
 * @author capur
 */
@Service
public class InscripcionAsignaturaImpl implements IInscripcionAsignaturasServices{
    
    @Autowired
    private IInscripcionAsignaturaRepository inscripServ;

    @Override
    public List<InscripcionesAsignaturas> listarTodos() {
        return (List<InscripcionesAsignaturas>) inscripServ.findAll();
    }

    @Override
    public void guardar(InscripcionesAsignaturas actividad) {
        inscripServ.save(actividad);
    }

    @Override
    public InscripcionesAsignaturas buscaById(Integer id) {
        return inscripServ.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        inscripServ.deleteById(id);
    }
    
}
