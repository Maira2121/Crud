package com.sofka.service;

import com.sofka.dao.ContactoDao;
import com.sofka.domain.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactoService implements IContactoService{

    @Autowired // Inyectando ContactoDao
    private ContactoDao contactoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> list() {
        return (List<Contacto>) contactoDao.findAll();
    }

    @Override
    @Transactional
    public Contacto save(Contacto contacto) {
        contacto.setFechaCreacion(Timestamp.valueOf(LocalDateTime.now()));
        return contactoDao.save(contacto);
    }

    @Transactional
    public void updateNombreCompleto(Long id, Contacto contacto){
        contactoDao.updateNombreCompleto(id, contacto.getNombreCompleto());
    }

    @Transactional
    public void updateEmail(Long id, Contacto contacto){
        contactoDao.updateEmail(id, contacto.getEmail());
    }

    @Transactional
    public void updateTelefono(Long id, Contacto contacto){
        contactoDao.updateTelefono(id, contacto.getPhoneNumber());
    }
    @Transactional
    public void updateBirthdayDate(Long id, Contacto contacto){
        contactoDao.updateBirthdayDate(id, contacto.getFechaNacimiento());
    }
    @Override
    @Transactional
    public Contacto update(Long id, Contacto contacto) {
       // contacto.setId(id);
        return contactoDao.save(contacto);
    }

    @Override
    @Transactional
    public void delete(Contacto contacto) {
        contactoDao.delete(contacto);
    }

    public Optional<Contacto> getById(Long id){
        return contactoDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contacto> findContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getId());
    }
}
