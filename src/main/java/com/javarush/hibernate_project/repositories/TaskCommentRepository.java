package com.javarush.hibernate_project.repositories;

import com.javarush.hibernate_project.dto.TaskCommentDTO;
import com.javarush.hibernate_project.model.TaskComment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TaskCommentRepository {

    private final SessionFactory sessionFactory;

    public TaskCommentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(TaskComment taskComment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(taskComment);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<TaskCommentDTO> findByTaskId(Long taskId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select new com.javarush.hibernate_project.dto.TaskCommentDTO(tc.id, tc.comment, tc.created, u.username)" +
                            " from TaskComment tc join tc.user u where tc.task.id = :taskId", TaskCommentDTO.class)
                    .setParameter("taskId", taskId)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }


}
