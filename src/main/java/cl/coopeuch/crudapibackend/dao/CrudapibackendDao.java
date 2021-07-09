package cl.coopeuch.crudapibackend.dao;

import org.springframework.data.repository.CrudRepository;

import cl.coopeuch.crudapibackend.dto.TareaDto;

public interface CrudapibackendDao extends CrudRepository<TareaDto, Integer> {

}
