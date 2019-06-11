package com.shard.jdbc.mapper;

import com.shard.jdbc.entity.TableOne;
import com.shard.jdbc.entity.TableOneExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TableOneMapper {

    TableOne selectOneByPhone (@Param("phone") String phone) ;

    int countByExample(TableOneExample example);

    int deleteByExample(TableOneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TableOne record);

    int insertSelective(TableOne record);

    List<TableOne> selectByExample(TableOneExample example);

    TableOne selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TableOne record, @Param("example") TableOneExample example);

    int updateByExample(@Param("record") TableOne record, @Param("example") TableOneExample example);

    int updateByPrimaryKeySelective(TableOne record);

    int updateByPrimaryKey(TableOne record);
}