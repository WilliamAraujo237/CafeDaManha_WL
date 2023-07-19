package com.cafe.da.manha.Cafe.Repository;

import com.cafe.da.manha.Cafe.DTO.RegistroComidaColaboradorDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ComidaColaboradorRepository extends CrudRepository<RegistroComidaColaboradorDTO,Long> {
    @PersistenceContext
    EntityManager entityManeger = null;

    //Query para pegar todos os registros da tabela registro_comida_colaboradordto
    @Query(value = "SELECT * FROM registro_comida_colaboradordto",nativeQuery = true)
    List<RegistroComidaColaboradorDTO> SelectGeral();

    //Query para pegar um registro pelo ID
    @Query(value = "SELECT * FROM registro_comida_colaboradordto WHERE id = :id",nativeQuery = true)
    List<RegistroComidaColaboradorDTO> SelecionaPorID(Long id);

    //Query para Atualizar um registro pelo ID
    @Modifying
    @Query(value = "UPDATE registro_comida_colaboradordto SET nome=:nome,cpf=:cpf,comida=:comida WHERE id=:id",nativeQuery = true)
    int UpdateGeral(String nome,Double cpf,String comida, Long id);

    //Query para inserir um novo registro
    @Modifying
    @Query(value = "INSERT INTO registro_comida_colaboradordto (nome,cpf,comida) VALUES (:nome,:cpf,:comida)",nativeQuery = true)
    int InsertRegistro(String nome, Double cpf, String comida);

    //Query para Deletar um registro
    @Modifying
    @Query(value = "DELETE FROM registro_comida_colaboradordto WHERE id=:id",nativeQuery = true)
    Void DeletaRegistro(Long id);

    // Verifica se o nome já existe no banco de dados
    boolean existsByNome(String nome);

    // Verifica se o CPF já existe no banco de dados
    boolean existsByCpf(Double cpf);

    // Verifica se a comida já existe no banco de dados
    boolean existsByComida(String comida);
}
