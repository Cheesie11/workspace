package ch.zli.m223.service;

import ch.zli.m223.model.Tag;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TagService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Tag createTag(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    public List<Tag> findAll() {
        return entityManager.createQuery("FROM Tag", Tag.class).getResultList();
    }

    @Transactional
    public Tag updateTag(Tag tag) {
        return entityManager.merge(tag);
    }

    @Transactional
    public void deleteTag(Long id) {
        Tag tag = entityManager.find(Tag.class, id);
        entityManager.remove(tag);
    }
}
