package br.edu.iftm.extensaoSTS.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Atividade implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Atividade(){
       
    }

	public Atividade(int id, String nome){
	       
        this.id = id;
        this.nome = nome;
       
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}