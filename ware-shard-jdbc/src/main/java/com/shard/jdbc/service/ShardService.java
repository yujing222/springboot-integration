package com.shard.jdbc.service;

import com.shard.jdbc.entity.TableOne;
import com.shard.jdbc.entity.TableTwo;

public interface ShardService {
    void createTable () ;
    void insertOne () ;
    void insertTwo () ;
    TableOne selectOneByPhone (String phone) ;
    TableTwo selectTwoByPhone (String phone) ;
}
