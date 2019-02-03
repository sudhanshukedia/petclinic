package guru.springframework.petclinic.model;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="pets")
public class Pet extends BaseEntity {

    @Column(name ="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;

    @Column(name="birth_Date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    public Pet(){}

    @Builder
    public Pet(Long id, String name, PetType petType, LocalDate birthDate, Owner owner, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.birthDate = birthDate;
        this.owner = owner;
        this.visits = visits;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy ="pet" )
    private Set<Visit> visits = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}
