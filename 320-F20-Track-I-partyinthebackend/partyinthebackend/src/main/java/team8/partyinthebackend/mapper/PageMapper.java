package team8.partyinthebackend.mapper;

import java.util.List;

import team8.partyinthebackend.model.Page;

public interface PageMapper{
    //select all Pages
    public List<Page> selectAll();

    //select page by ID
    public Page selectById(int id);

    //update page
    public void update(Page page);

}