package br.edu.ifal.listar_compras;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaComprasRepository extends CrudRepository<Item, Long>{
    List<Item> findByDescricaoContaining(String descricao);
}