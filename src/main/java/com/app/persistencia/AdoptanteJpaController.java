package com.app.persistencia;

import com.app.logica.Adoptante;
import com.app.logica.Gato;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class AdoptanteJpaController {

    private EntityManagerFactory emf = null;

    public AdoptanteJpaController() {
        emf = Persistence.createEntityManagerFactory("ejemgatitos");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para guardar un Adoptante en la base de datos.
    public void crear(Adoptante adop) {

        EntityManager em = null;

        try {
            // Abrimos la conexión.
            em = getEntityManager();

            // Iniciamos la transacción.
            em.getTransaction().begin();

            // Guardamos el Adoptante.
            em.persist(adop);

            // Confirmamos la transacción.
            em.getTransaction().commit();

        } finally {
            // Cerramos la conexión.
            if (em != null) {
                em.close();
            }
        }
    }
 // BUSCAR UNO: busca un adoptante por su id.
    public Adoptante buscarUno(int id) {
        EntityManager em = getEntityManager();

        try {
            return em.find(Adoptante.class, id);
        } finally {
            em.close();
        }
    }

    // BUSCAR TODOS: devuelve todos los adoptantes.
    public List<Adoptante> buscarTodos() {
        EntityManager em = getEntityManager();

        try {
            return em.createQuery("SELECT a FROM Adoptante a", Adoptante.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
 // EDITAR UN ADOPTANTE
    public void editar(Adoptante adoptante) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(adoptante);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    // ELIMINAR UN ADOPTANTE
    public void eliminar(int id) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            Adoptante adoptante = em.find(Adoptante.class, id);

            if (adoptante != null) {
                // Los gatos que tenían este adoptante quedan sin adoptante.
                List<Gato> gatos = em.createQuery(
                    "SELECT g FROM Gato g WHERE g.adoptante = :adoptante",
                    Gato.class)
                    .setParameter("adoptante", adoptante)
                    .getResultList();

                for (Gato gato : gatos) {
                    gato.setAdoptante(null);
                    em.merge(gato);
                }

                em.remove(adoptante);
            }

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
}