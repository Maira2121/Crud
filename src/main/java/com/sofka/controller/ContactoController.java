package com.sofka.controller;

import com.sofka.domain.Contacto;
import com.sofka.service.ContactoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.List;

@Slf4j
@RestController
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

   @RequestMapping(value = "api/contactos")
    public List<Contacto> listaContactos(){
        List<Contacto> response = null;
        try {
            response = contactoService.list();
        }catch (Exception exc){
            log.info(String.valueOf(exc));
        }
        return response;
    }

    @RequestMapping(path = "api/contacto/{id}")
    public Optional<Contacto> getById(@PathVariable("id") Long id){
        return this.contactoService.getById(id);
    }

    @PostMapping(value = "api/contacto")
    public Contacto save(@RequestBody Contacto contacto){
        return this.contactoService.save(contacto);
    }

    @DeleteMapping(path = "api/contacto/{id}")
    public ResponseEntity<Contacto> borrar(Contacto contacto){
        log.info("Contacto a borrar: {}",contacto);
        contactoService.delete(contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    @PutMapping(path = "api/contacto/{id}")
    public ResponseEntity<Contacto> actualizar(Contacto contacto, @PathVariable("id") Long id){
        log.info("Contacto a modificar: {}", contacto);
        contactoService.update(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    @PatchMapping(path = "/contacto/nombre_completo/{id}")
    public ResponseEntity<Contacto> actualizarNombreCompleto(Contacto contacto, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contacto);
        contactoService.updateNombreCompleto(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    @PatchMapping(path = "/contacto/email/{id}")
    public ResponseEntity<Contacto> actualizarEmail(Contacto contacto, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contacto);
        contactoService.updateEmail(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    @PatchMapping(path = "/contacto/telefono/{id}")
    public ResponseEntity<Contacto> actualizarTelefono(Contacto contacto, @PathVariable("id") Long id){
        log.info("Contacto a modificar: {}", contacto);
        contactoService.updateTelefono(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    @PatchMapping(path = "/contacto/fecha_nacimiento/{id}")
    public ResponseEntity<Contacto>  actualizarBirthdayDate(Contacto contacto, @PathVariable("id") Long id){
        log.info("Contacto a modificar: {}", contacto);
        contactoService.updateBirthdayDate(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }
}
