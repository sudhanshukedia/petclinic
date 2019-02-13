package guru.springframework.petclinic.map;

import guru.springframework.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractServiceMap <T extends BaseEntity,ID extends Long>{

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        for(Map.Entry<Long, T > entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return new HashSet<>(map.values());
    }

    T findByID(ID  id) {
       return map.get(id);
    }


    void delete(T object){
      map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id){
      map.remove(id);
    }

     T save(T object){
        if(object  != null ){
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else {
            throw new RuntimeException("object cannot be null");
        }
        return object;
     }

     private Long getNextId() {
         Long nextId = null;
         try {
             nextId = Collections.max(map.keySet()) + 1L;
         } catch (NoSuchElementException e) {
             nextId = 1L;
         }
         return nextId;
     }

}

