package DAO;

import java.util.List;

abstract class TheBookStoreDAO<Entity, Key> {
        abstract public void insert(Entity entity);
        abstract public void update(Entity entity);
        abstract public void delete(Key id);
        abstract public Entity selectById(Key id);
        abstract public List<Entity> selectAll();
        abstract protected List<Entity> selectBySql(String sql, Object...args);
}
