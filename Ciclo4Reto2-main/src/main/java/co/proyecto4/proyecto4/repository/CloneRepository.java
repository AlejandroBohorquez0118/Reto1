package co.proyecto4.proyecto4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.proyecto4.proyecto4.model.Clone;
import co.proyecto4.proyecto4.repository.crud.CloneCrudRepository;

@Repository
public class CloneRepository {
    @Autowired
    private CloneCrudRepository cloneCrudRepository;

    public List<Clone> getAll() {
        return cloneCrudRepository.findAll();
    }

    public Optional<Clone> getClone(Integer clone) {
        return cloneCrudRepository.findById(clone);
    }
    public Clone create(Clone clone) {
        return cloneCrudRepository.save(clone);
    }

    public void update(Clone clone) {
        cloneCrudRepository.save(clone);
    }
    
    public void delete(Clone clone) {
        cloneCrudRepository.delete(clone);
    }
    
}
