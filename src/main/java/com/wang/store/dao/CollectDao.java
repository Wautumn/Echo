package com.wang.store.dao;

import com.wang.store.entity.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 20:02
 */
@Mapper
@Component
public interface CollectDao {

    void AddCollect(Collect collect);

    void DeleteCollect(int id);

    List<Collect> GetCollectsByUser(int userid);

    Collect IfCollected(Collect collect);
}
