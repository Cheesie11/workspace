package ch.zli.m223.controller;

import ch.zli.m223.model.Tag;
import ch.zli.m223.service.TagService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tags")
public class TagController {

    @Inject
    TagService tagService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tag> index() {
        return tagService.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tag create(Tag tag) {
        return tagService.createTag(tag);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tag update(@PathParam("id") Long id, Tag tag) {
        tag.setId(id);
        return tagService.updateTag(tag);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        tagService.deleteTag(id);
    }
}
