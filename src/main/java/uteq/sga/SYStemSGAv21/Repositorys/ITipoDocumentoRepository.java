/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uteq.sga.SYStemSGAv21.Entity.Tipodocumento;

/**
 *
 * @author capur
 */
@Repository
public interface ITipoDocumentoRepository extends CrudRepository<Tipodocumento, Integer>{
    
}
