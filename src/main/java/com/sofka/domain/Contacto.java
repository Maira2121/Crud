package com.sofka.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;


@Data
@Entity
@Table(name = "contact")
public class Contacto implements Serializable {

    @Serial
    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "cnt_id")
    private Long id;

    @Column(name = "cnt_nombre_completo")
    private String nombreCompleto;

    @Column(name = "cnt_phone_number")
    private String phoneNumber;

    @Column(name = "cnt_email")
    private String email;

    @Column(name = "cnt_fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "cnt_created_at")
    private Timestamp fechaCreacion;

    @Column(name = "cnt_update_at")
    private  Date fechaActualizacion;

    @Column(name = "cnt_deleted_at")
    private Date fechaEliminiacion;
}
