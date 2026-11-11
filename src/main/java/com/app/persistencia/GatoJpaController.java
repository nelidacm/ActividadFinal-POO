package com.app.persistencia;

import com.app.logica.Gato;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class GatoJpaController {

    private EntityManagerFactory emf = null;

    public GatoJpaController() {
        emf = Persistence.createEntityManagerFactory("ejemgatitos");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para guardar un Gato en la base de datos.
    public void crear(Gato gato) {

        EntityManager em = null;

        try {
            // Abrimos la conexión.
            em = getEntityManager();

            // Iniciamos la transacción.
            em.getTransaction().begin();

            // Guardamos el Gato.
            em.persist(gato);

            // Confirmamos la transacción.
            em.getTransaction().commit();

        } finally {
            // Cerramos la conexión.
            if (em != null) {
                em.close();
            }
        }
    }
 // BUSCAR UNO: busca un gato por su id.
    public Gato buscarUno(int id) {
        EntityManager em = getEntityManager();

        try {
            return em.find(Gato.class, id);
        } finally {
            em.close();
        }
    }

    // BUSCAR TODOS: devuelve todos los gatos.
    public List<Gato> buscarTodos() {
        EntityManager em = getEntityManager();

        try {
            return em.createQuery("SELECT g FROM Gato g", Gato.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
 // EDITAR UN GATO
    public void editar(Gato gato) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(gato);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    // ELIMINAR UN GATO
    public void eliminar(int id) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            Gato gato = em.find(Gato.class, id);

            if (gato != null) {
                em.remove(gato);
            }

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
    public List<Gato> buscarPorNombre(String nombre) {
        EntityManager em = getEntityManager();

        try {
            return em.createQuery(
                "SELECT g FROM Gato g WHERE LOWER(g.nombre) LIKE LOWER(:nombre)",
                Gato.class
            )
            .setParameter("nombre", "%" + nombre + "%")
            .getResultList();

        } finally {
            em.close();
        }
    }
}