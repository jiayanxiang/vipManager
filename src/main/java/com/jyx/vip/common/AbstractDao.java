package com.jyx.vip.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公共dao接口
 */
public interface AbstractDao<T> {

    void insert(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(@Param("key") String ukfield,@Param("value") Object value) throws Exception;//根据唯一性字段查询

    T select(@Param("key") String ukfield,@Param("value") Object value) throws Exception;

    Boolean exsits(@Param("key") String ukfield,@Param("value") Object value) throws Exception;

    List<T> selectLike(@Param("key") String key) throws Exception;
}
