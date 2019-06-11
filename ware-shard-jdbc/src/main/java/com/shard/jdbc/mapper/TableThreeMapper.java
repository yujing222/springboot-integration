package com.shard.jdbc.mapper;

import com.shard.jdbc.entity.TableThree;
import com.shard.jdbc.entity.TableThreeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TableThreeMapper {
    int countByExample(TableThreeExample example);

    int deleteByExample(TableThreeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TableThree record);

    int insertSelective(TableThree record);

    List<TableThree> selectByExample(TableThreeExample example);

    TableThree selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TableThree record, @Param("example") TableThreeExample example);

    int updateByExample(@Param("record") TableThree record, @Param("example") TableThreeExample example);

    int updateByPrimaryKeySelective(TableThree record);

    int updateByPrimaryKey(TableThree record);
}