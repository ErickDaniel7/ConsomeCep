package br.unipar.programacaoweb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDateTime;

public class EnderecoDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CepBD");

    public void salvar(Endereco endereco) {
        // Usando try-with-resources para garantir o fechamento do EntityManager
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(endereco); // Usa merge para inserir ou atualizar
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(); // Loga a exceção
        }
    }

    public Endereco buscarPorCep(String cep) {
        // Usando try-with-resources para garantir o fechamento do EntityManager
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Endereco> query = em.createQuery("SELECT e FROM Endereco e WHERE e.cep = :cep", Endereco.class);
            query.setParameter("cep", cep);
            return query.getSingleResult(); // Retorna o endereço encontrado
        } catch (Exception e) {
            // Loga a exceção e retorna null caso não encontre o CEP
            e.printStackTrace();
            return null;
        }
    }

    public void atualizarDataConsulta(String cep) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Obtém a data e hora atuais
            LocalDateTime dataConsultaAtual = LocalDateTime.now();

            // Atualiza a dataConsulta no banco
            String query = "UPDATE Endereco e SET e.dataConsulta = :dataConsulta WHERE e.cep = :cep";
            em.createQuery(query)
                    .setParameter("dataConsulta", dataConsultaAtual)  // Passa a hora atual
                    .setParameter("cep", cep)
                    .executeUpdate();

            em.getTransaction().commit();  // Commit a transação para garantir que a alteração foi persistida
        } catch (Exception e) {
            em.getTransaction().rollback();  // Rollback em caso de erro
            e.printStackTrace();
        } finally {
            em.close();  // Fecha o EntityManager
        }
    }
}
