/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Implements;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.sga.SYStemSGAv21.Entity.YearsAcademicos;
import uteq.sga.SYStemSGAv21.Repositorys.IYearsAcademicosRepository;
import uteq.sga.SYStemSGAv21.Services.IYearsAcademicosServices;

/**
 *
 * @author capur
 */
@Service
public class YearsAcademicosImpl implements IYearsAcademicosServices{
    
    @Autowired
    private IYearsAcademicosRepository yarepo;

    @Override
    public List<YearsAcademicos> listarTodos() {
        return (List<YearsAcademicos>) yarepo.findAll();
    }

    @Override
    public void guardar(YearsAcademicos actividad) {
        yarepo.save(actividad);
    }

    @Override
    public YearsAcademicos buscaById(Integer id) {
        return yarepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        yarepo.deleteById(id);
    }
    
}
