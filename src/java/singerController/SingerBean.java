package singerController;

import dao.SingerDaoInterface;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Singer;

@Named(value = "singerBean")
@RequestScoped
public class SingerBean {

    private int id;
    private String name;
    private String musicType;

    private List<Singer> singers;

    private List<Integer> ids;

    @Inject
    SingerDaoInterface dao;

    public SingerBean() {
    }

    public String saveSinger() {
        Singer s = new Singer(name, musicType);
        dao.addSinger(s);
        gettAllSingers();
        return "index.xhtml?faces-redirect=true";
    }

    public String removeSinger(int id) {
        dao.deleteSinger(id);
        gettAllSingers();
        return "index.xhtml?faces-redirect=true";
    }

    public String removeSinger2() {
        dao.deleteSinger(id);
        gettAllSingers();
        return "index.xhtml?faces-redirect=true";
    }

    public String updateSinger(int id) {
        Singer s = dao.findSinger(id);

        this.name = s.getName();
        this.musicType = s.getMusicType();
        gettAllSingers();
        return "updatePage.xhtml?faces-redirect=true";
    }

    public String update() {
        Singer s = new Singer(id, name, musicType);

        dao.updateSinger(s);
        gettAllSingers();
        return "index.xhtml?faces-redirect=true";
    }

    public String findSingerById() {
        Singer s = dao.findSinger(id);
        id = s.getId();
        name = s.getName();
        musicType = s.getMusicType();
        return "showOneSinger";
    }

    public String backPage() {
        return "index.xhtml?faces-redirect=true";
    }

    @PostConstruct
    public void gettAllSingers() {
        singers = dao.getAllSingers();
        ids = singers.stream().map(m -> m.getId()).collect(toList());
    }

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }

    public SingerDaoInterface getDao() {
        return dao;
    }

    public void setDao(SingerDaoInterface dao) {
        this.dao = dao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

}
