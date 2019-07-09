package com.elastic.search.repository;

import com.elastic.search.model.RequestLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RequestLogRepository extends ElasticsearchRepository<RequestLog,Long> {
}
