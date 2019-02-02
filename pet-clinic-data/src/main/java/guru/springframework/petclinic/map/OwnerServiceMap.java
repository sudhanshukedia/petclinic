package guru.springframework.petclinic.map;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public  class  OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService{


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findByID(aLong);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }
}

