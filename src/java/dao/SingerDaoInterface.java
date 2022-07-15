package dao;

import java.util.List;
import model.Singer;

public interface SingerDaoInterface {

    void addSinger(Singer s);

    void deleteSinger(int id);

    List<Singer> getAllSingers();

    void updateSinger(Singer s);

    Singer findSinger(int id);

}
