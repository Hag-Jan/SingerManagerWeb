package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Singer;

@Stateless
public class SingerDao implements SingerDaoInterface {

    //Annotation koppling till database
    @PersistenceContext
    EntityManager em;

    @Override
    public void addSinger(Singer s) {
        em.persist(s);
    }

    @Override
    public void deleteSinger(int id) {
        Singer s = em.find(Singer.class, id);
        em.remove(s);
    }

    @Override
    public List<Singer> getAllSingers() {
        return em.createQuery("SELECT s FROM Singer s", Singer.class)
                .getResultList();
    }

    @Override
    public void updateSinger(Singer s) {
        em.merge(s);
    }

    @Override
    public Singer findSinger(int id) {
        return em.find(Singer.class, id);
    }
}
