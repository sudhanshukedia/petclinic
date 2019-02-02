package guru.springframework.petclinic.service;

import guru.springframework.petclinic.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

    Owner findById(Long id);

    Set<Owner> findAll();
}
