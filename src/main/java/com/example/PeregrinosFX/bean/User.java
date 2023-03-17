package com.example.PeregrinosFX.bean;

import jakarta.persistence.*;



@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", updatable = false, nullable = false)
    private long idUser;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contrasenia")
    private String contrasenia;
    @OneToOne
    @JoinColumn
    private Perfil perfil;

    @OneToOne
    @JoinColumn
    private Parada parada;

    @OneToOne
    @JoinColumn
    private Peregrino peregrino;

    public User() {

    }

    public Peregrino getPeregrino() {
        return peregrino;
    }

    public void setPeregrino(Peregrino peregrino) {
        this.peregrino = peregrino;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUsuario() {
        return usuario.toString();
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia.toString();
    }

    public Parada getParada() {
        return parada;
    }

    public void setParada(Parada parada) {
        this.parada = parada;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contrasenia + '\'' +
                ", perfil=" + perfil +
                '}';
    }
}
