package com.elastic.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 点开 Document 可以看到配置内容
 * 加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词。
 * indexName索引名称 理解为数据库名 限定小写
 * type 理解为数据库的表名称
 * shards = 5 默认分区数
 * replicas = 1 每个分区默认的备份数
 * refreshInterval = "1s" 刷新间隔
 * indexStoreType = "fs"  索引文件存储类型
 */
@Document(indexName = "requestlogindex",type = "requestlog")
public class RequestLog {
    //Id注解Elasticsearch里相应于该列就是主键，查询时可以使用主键查询
    @Id
    private Long id;
    private String orderNo;
    private String userId;
    private String userName;
    private String createTime;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
