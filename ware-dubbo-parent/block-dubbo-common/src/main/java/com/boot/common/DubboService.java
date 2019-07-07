package com.boot.common;

public interface DubboService {
    String getInfo (String param) ;

    UserEntity getUserInfo (UserEntity userEntity) ;

    String timeOut (Integer time) ;
}
