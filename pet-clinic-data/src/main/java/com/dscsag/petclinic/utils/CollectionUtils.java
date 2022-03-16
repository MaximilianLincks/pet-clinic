package com.dscsag.petclinic.utils;

import java.util.Collection;

public class CollectionUtils {

    public static <T, C extends Collection<T>>  C iterableToCollection(Iterable<T> source, C sink){
        source.forEach(sink::add);
        return sink;
    }
}
