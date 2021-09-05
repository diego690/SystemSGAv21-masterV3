/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author capur
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MultipartException.class)
    public String handleMultipart(MultipartException e,RedirectAttributes attributes){
        attributes.addFlashAttribute("message",e.getCause().getMessage());
        attributes.addFlashAttribute("nombre",e.getCause().getMessage());
        
        return "redirect:status";
    }
    
}
