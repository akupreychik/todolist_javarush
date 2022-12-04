package com.javarush.hibernate_project.repositories;

import com.javarush.hibernate_project.command.TagCommand;
import com.javarush.hibernate_project.model.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.*;

public class TagRepository {

    private final SessionFactory sessionFactory;

    public TagRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Tag tag) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(tag);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public Optional<Tag> findTagByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Tag where name = :name", Tag.class)
                    .setParameter("name", name)
                    .uniqueResultOptional();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Tag> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Tag", Tag.class)
                    .list();
        } catch (Exception e) {
            return List.of();
        }
    }

    public void deleteByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from Tag where name = :name")
                    .setParameter("name", name)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Long tagId, TagCommand tagCommand) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Tag tag = session.get(Tag.class, tagId);
            tag.setName(tagCommand.getName());
            tag.setColor(tagCommand.getColor());
            session.merge(tag);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Set<Tag> findTagsByIds(Collection<Long> ids) {
        try (Session session = sessionFactory.openSession()) {
            return new HashSet<>(session.createQuery("from Tag where id in :ids", Tag.class)
                    .setParameter("ids", ids)
                    .list());
        } catch (Exception e) {
            return Set.of();
        }
    }
}
