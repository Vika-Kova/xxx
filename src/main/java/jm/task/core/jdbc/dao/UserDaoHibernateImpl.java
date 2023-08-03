package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = new Util().getSessionFactory();

    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().getCurrentSession();
        try (session) {
            String sql = "CREATE TABLE IF NOT EXISTS users(id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL, name VARCHAR(255), lastName VARCHAR(255), age INT)";
            session.beginTransaction();
            session.createSQLQuery(sql);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        //  try (Session session = getSessionFactory().getCurrentSession()) {
        Session session = getSessionFactory().getCurrentSession();
        try (session) {
            String sql = "DROP TABLE IF EXISTS users";
            session.beginTransaction();
            session.createSQLQuery(sql);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.getCurrentSession();
        try (session) {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.getCurrentSession();
        try (session) {
            session.beginTransaction();
            session.createSQLQuery("DELETE User WHERE ID = :id").setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            userList = session.createQuery("from User", User.class).list();
            session.getTransaction().commit();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.getCurrentSession();
        try (session) {
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM users").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}






