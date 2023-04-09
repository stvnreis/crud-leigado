package com.github.steven.crud;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

import java.util.List;

@MongoEntity(collection = "Pessoa")
public class Pessoa extends PanacheMongoEntity{
    
    private String nome;

    private Integer idade;

    private String email;

    public Pessoa(){}

    public Pessoa(String nome, Integer idade, String email){
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public ObjectId getId(){
        return this.id;
    }


    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public Integer getIdade(){
        return this.idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
