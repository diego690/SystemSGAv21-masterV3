/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.MaterialDidactico;
import uteq.sga.SYStemSGAv21.Repositorys.IMaterialDidacticoRepository;
import uteq.sga.SYStemSGAv21.Services.IMaterialDidacticoServices;

/**
 *
 * @author capur
 */
@Service
public class MaterialDidacticoImpl implements IMaterialDidacticoServices{
    
    @Autowired
    private IMaterialDidacticoRepository matRepo;

    @Override
    public List<MaterialDidactico> listarTodos() {
        return (List<MaterialDidactico>) matRepo.findAll();
    }

    @Override
    public void guardar(MaterialDidactico actividad) {
        matRepo.save(actividad);
    }

    @Override
    public MaterialDidactico buscaById(Integer id) {
        return matRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        matRepo.deleteById(id);
    }
    
}
