/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author lefoly
 */
@NamedQuery(
        name = "Livro.filtrarPorTitulo",
        query = "SELECT l FROM Livro l WHERE l.titulo like CONCAT('%',:titulo,'%')")

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "preco")
    private String preco;

    public Livro() {
    }

    public Livro(String titulo, String autor, String preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void set(String autor) {
        this.autor = autor;
    }

    public String getPreco() {
        return preco;
    }

    public void setTelefone(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "preco{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", preco=" + preco + '}';
    }

}
