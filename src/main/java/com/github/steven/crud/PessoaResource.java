package com.github.steven.crud;

import org.bson.types.ObjectId;
import org.jboss.resteasy.annotations.Body;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.PanacheQuery;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @GET
    public List<Pessoa> getAll() {
        return Pessoa.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa getPessoa(@PathParam("id") ObjectId id) {
        return Pessoa.findById(id);
    }

    @GET
    @Path("/procurar")
    public List<Pessoa> getPessoaByName(@QueryParam("nome") String nome) {
        return Pessoa.list("nome = ?1", nome);
    }

    @POST
    @Path("/add")
    public Response addPessoa(Pessoa nova) {
        Pessoa p = new Pessoa(nova.getNome(), nova.getIdade(), nova.getEmail());
        p.persist();
        return Response.ok().build();
    }

    @PUT
    public Response update(Pessoa pessoa) {
        Pessoa p = Pessoa.findById(pessoa.getId());
        if (p != null) {
            p.update(pessoa);
            return Response.ok().build();
        } else {
            return Response.status(404, "nao encontrado").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") ObjectId id) {
        Pessoa.deleteById(id);
        return Response.ok().build();
    }
}
