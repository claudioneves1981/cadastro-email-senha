package br.com.cadastroemailsenha.db.contracts;

import br.com.cadastroemailsenha.db.entities.CadastroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCadastroEntity extends JpaRepository<CadastroEntity, Long>{

   @Query(value = "select count(cadastro) from CadastroEntity cadastro" +
           "   WHERE cadastro.email = :email")
   Long findByDuplicates(@Param("email") String email);

   @Query(value = "select cadastro from CadastroEntity cadastro" +
           "   WHERE cadastro.senha = :senha" +
           "   AND cadastro.email = :email")
   CadastroEntity findByEmailESenha(@Param("email") String email, @Param("senha") String senha);

   CadastroEntity findByEmail(String email);

}