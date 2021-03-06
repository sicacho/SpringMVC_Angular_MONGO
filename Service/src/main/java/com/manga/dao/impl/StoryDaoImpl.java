package com.manga.dao.impl;

import com.manga.dao.BaseDao;
import com.manga.dao.StoryDao;
import com.manga.domain.Story;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khangtnse60992 on 1/24/2015.
 */
@Repository
public class StoryDaoImpl extends BaseDao<Story,String> implements StoryDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Override
    public List<Story> getNewUpdate(int limit, int offset) {
        List<Story> result = new ArrayList<Story>();
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "update_time"));
        query.limit(limit);
        query.skip(offset);
        result = mongoTemplate.find(query, Story.class);


        return result;
    }
    @Override
    public List<Story> getByName(String name, int limit, int offset) {
        List<Story> result = new ArrayList<Story>();
        Query query = new Query();
        query.addCriteria(Criteria.where("alias").regex(name));
        query.limit(limit);
        query.skip(offset);
        result = mongoTemplate.find(query, Story.class);
        return result;
    }
    @Override
    public List<Story> getByType(String type, int limit, int offset) {
        List<Story> result = new ArrayList<Story>();
        Query query = new Query();
        query.addCriteria(Criteria.where("type").in(type));
        query.with(new Sort(Sort.Direction.DESC, "update_time"));
        query.limit(limit);
        query.skip(offset);
        result = mongoTemplate.find(query, Story.class);
        return result;
    }

    @Override
    public List<Story> getAllStory(int limit, int offset) {
        List<Story> result = new ArrayList<Story>();
        Query query = new Query();
        query.limit(limit);
        query.skip(offset);
        query.with(new Sort(Sort.Direction.DESC, "update_time"));
        result = mongoTemplate.find(query, Story.class);
        return result;
    }

    @Override
    public List<Story> getIzManga(int limit, int offset) {
        List<Story> result = new ArrayList<Story>();
        Query query = new Query();
        query.addCriteria(Criteria.where("source").is("http://www.izmanga.com"));
        query.limit(limit);
        query.skip(offset);
        query.with(new Sort(Sort.Direction.DESC, "update_time"));
        result = mongoTemplate.find(query, Story.class);
        return result;
    }

    @Override
    public List<Story> getKissManga(int limit, int offset) {
        List<Story> result = new ArrayList<Story>();
        Query query = new Query();
        query.addCriteria(Criteria.where("source").is("http://www.kissmanga.com"));
        query.limit(limit);
        query.skip(offset);
        query.with(new Sort(Sort.Direction.DESC, "update_time"));
        result = mongoTemplate.find(query, Story.class);
        return result;
    }

    @Override
    public List<Story> getMangaHead(int limit, int offset) {
        List<Story> result = new ArrayList<Story>();
        Query query = new Query();
        query.addCriteria(Criteria.where("source").is("http://mangahead.com"));
        query.limit(limit);
        query.skip(offset);
        query.with(new Sort(Sort.Direction.DESC, "update_time"));
        result = mongoTemplate.find(query, Story.class);
        return result;
    }

    @Override
    public Story getStory(String name) {
        Story result = new Story();
        Query query = new Query();
        query.addCriteria(Criteria.where("alias").is(name));
        result = mongoTemplate.findOne(query, Story.class);
        return result;
    }
}
