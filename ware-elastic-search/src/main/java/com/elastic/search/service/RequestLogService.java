package com.elastic.search.service;

import com.elastic.search.model.RequestLog;

import java.util.Optional;

public interface RequestLogService {
    String esInsert (Integer num) ;
    Iterable<RequestLog> esFindAll () ;
    String esUpdateById (RequestLog requestLog) ;
    Optional<RequestLog> esSelectById (Long id) ;
    Iterable<RequestLog> esFindOrder () ;
    Iterable<RequestLog> esFindOrders () ;
    Iterable<RequestLog> search () ;
}
