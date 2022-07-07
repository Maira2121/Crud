package com.sofka.service;

import com.sofka.domain.Contacto;

import java.util.List;
import java.util.Optional;

public interface IContactoService {

    public List<Contacto> list();

    public Contacto save(Contacto contacto);

    public Contacto update(Long id, Contacto contacto);

    public void  delete(Contacto contacto);

    public Optional<Contacto> findContacto(Contacto contacto);
}
