// package com.pulseup.pulseup_backend.models;


// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.Data;

// @Data
// @Entity
// @Table(name = "usuarios")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String correoElectronico;

//     @Column(nullable = false)
//     private String nombre;

//     @Column(nullable = false)
//     private String apellido;

//     private String apodo;

//     @Column(name = "gusto_musical")
//     private String gustoMusical;

//     @Column(name = "estilo_vestir")
//     private String estiloVestir;

//     @Column(nullable = false)
//     private String contrasena;

//     // @Column(name = "proveedor_autenticacion")
//     // private String proveedorAutenticacion; // Puede ser "correo", "google", "spotify"
// }
