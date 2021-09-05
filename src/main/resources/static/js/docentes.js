/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        //docentes/findById(id)
        
        var href = $(this).attr('href');
        $.get(href, function(docente, status){
            $('#iddocenteEdit').val(docente.iddocente);
            $('#apellidosEdit').val(docente.apellidosdocente);
            $('#nombresEdit').val(docente.nombresdocente);
            $('#cedulaEdit').val(docente.ceduladocente);
            $('#emailEdit').val(docente.correodocente);
            $('#celularEdit').val(docente.celulardocente);
            $('#telefonoEdit').val(docente.telefonodocente);
            $('#direccionEdit').val(docente.direcciondocente);
        });
        
        
        
        $('#editModal').modal();
    });
    
    $('table #deleteButton').on('click',function(event){
        event.preventDefault();
         var href = $(this).attr('href');
         $('#confirmDeleteButton').attr('href',href);
        $('#deleteModal').modal();
    });
});

