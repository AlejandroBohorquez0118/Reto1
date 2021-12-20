package co.proyecto4.proyecto4.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.proyecto4.proyecto4.model.Clone;

public interface CloneCrudRepository extends MongoRepository<Clone, Integer>{
    
}
