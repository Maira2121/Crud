package com.sofka.dao;

import com.sofka.domain.Contacto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ContactoDao extends CrudRepository<Contacto, Long> {
    @Modifying
    @Query("update Contacto contact set contact.nombreCompleto = :nombreCompleto where contact.id = :id")
    public void updateNombreCompleto(
            @Param(value = "id") Long id,
            @Param(value = "nombreCompleto") String nombreCompleto
    );

    @Modifying
    @Query("update Contacto contact set contact.email = :email where contact.id = :id")
    public void updateEmail(
            @Param(value = "id") Long id,
            @Param(value = "email") String email
    );

    @Modifying
    @Query("update Contacto contact set contact.phoneNumber = :email where contact.id = :id")
    public void updateTelefono(
            @Param(value = "id") Long id,
            @Param(value = "email") String email
    );


    @Modifying
    @Query("update Contacto contact set contact.fechaNacimiento = :fechaNacimiento where contact.id = :id")
    public void updateBirthdayDate(
            @Param(value = "id") Long id,
            @Param(value = "fechaNacimiento") Date fechaNacimiento
    );

}
