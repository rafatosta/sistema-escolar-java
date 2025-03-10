package org.rtosta.dao;

import java.util.List;

public interface CRUD<T> {

    public T create(T obj);

    public List<T> find_all();

    public T find_by_id(int id);

    public T edit(T obj);

    public T delete(T obj);
}
