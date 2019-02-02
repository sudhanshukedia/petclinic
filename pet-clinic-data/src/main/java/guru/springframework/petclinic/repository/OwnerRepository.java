package guru.springframework.petclinic.repository;

import guru.springframework.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastlName);

    List<Owner> findAllByLastNameLike(String lastName);

    Optional<Owner> findById(Long Id);


}
