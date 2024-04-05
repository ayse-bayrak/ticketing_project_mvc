package com.cydeo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService <T, ID> {

    /** I just need to some custom database, this is my fake database where i will save
     * whenever i create user whenever I say save, I will describe the same method
     * but where it's gonna save the data. This is my database
     * why we are using Map, I have something called findById, bring me based on the ID certain user
     * Certain role.. it is gonna be so much easy to do with Map
     * because Map have a key and value give me the key and then it will give it object */

    public Map<ID, T> map = new HashMap<>(); //DB --> custom DB fake DB

    T save (ID id, T object){
        map.put(id, object);
        return object; //return map.get(id);
    }
    /**
     * This generic method puts an object (T type) with the given id (ID type) into the Map (Custom DB).
     * At the end, it returns the object which it put into Map.
     *   * @param id ID id (ID is a generic type)
     *   * @param object T object (T is a generic type)
     */

    List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    /**
     * This generic method doesn't take any parameters,
     * It returns all the objects inside the Map created above as List of T objects (T is a generic type).
     *
     * @return List of T objects (T is a generic type)
     */

    T findById(ID id){
        return map.get(id);
    };

    /**
     * This generic method returns the object which has an id equals the id coming from the method parameter, from the Map created above.
     *
     * @param id ID id (ID is a generic type)
     * @return T object (T is a generic type)
     */

    void deleteById(ID id) {
        map.remove(id);
    }
/**
 * This generic method removes the object which has an id equals the id coming from the method parameter, from the Map created above.
 * This generic method doesn't return anything after it removed the corresponding object in the Map.
 *
 * @param id ID id (ID is a generic type)
 */
}
