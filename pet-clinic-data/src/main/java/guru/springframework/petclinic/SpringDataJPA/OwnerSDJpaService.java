package guru.springframework.petclinic.SpringDataJPA;


import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.repository.OwnerRepository;
import guru.springframework.petclinic.repository.PetRepository;
import guru.springframework.petclinic.repository.PetTypeRepository;
import guru.springframework.petclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("SpringDataServiceJPA")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners =new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    public Owner findById(Long aLong) {

        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Owner object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }
}
