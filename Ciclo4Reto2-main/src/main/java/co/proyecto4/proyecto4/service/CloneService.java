package co.proyecto4.proyecto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.proyecto4.proyecto4.model.Clone;
import co.proyecto4.proyecto4.repository.CloneRepository;

@Service
public class CloneService {
    @Autowired
    private CloneRepository cloneRepository;

    public List<Clone> getAll() {
        return cloneRepository.getAll();
    }

   public Optional<Clone> getClone(Integer clone) {
        return cloneRepository.getClone(clone);
    }

    public Clone create(Clone clone) {
        if (clone.getId()== null) {
            return clone;
        } else {
            return cloneRepository.create(clone);
        }
    }
    
    public Clone update(Clone clone) {

        if (clone.getId() != null) {
            Optional<Clone> cloneDb = cloneRepository.getClone(clone.getId());
            if (!cloneDb.isEmpty()) {
                
                if (clone.getBrand()!= null) {
                    cloneDb.get().setBrand(clone.getBrand());
                }
                
                if (clone.getProcesor()!= null) {
                    cloneDb.get().setProcesor(clone.getProcesor());
                }

                if (clone.getOs()!= null) {
                    cloneDb.get().setOs(clone.getOs());
                }

                if (clone.getDescription() != null) {
                    cloneDb.get().setDescription(clone.getDescription());
                }
                if (clone.getPrice() != 0.0) {
                    cloneDb.get().setPrice(clone.getPrice());
                }
                if (clone.getQuantity() != 0) {
                    cloneDb.get().setQuantity(clone.getQuantity());
                }
                if (clone.getPhotography() != null) {
                    cloneDb.get().setPhotography(clone.getPhotography());
                }
                cloneDb.get().setAvailability(clone.isAvailability());
                cloneRepository.update(cloneDb.get());
                return cloneDb.get();
            } else {
                return clone;
            }
        } else {
            return clone;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getClone(id).map(clone -> {
            cloneRepository.delete(clone);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}

