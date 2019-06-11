package com.quart.job.mapper;

import com.quart.job.entity.ScheduleJobLogBean;
import com.quart.job.entity.ScheduleJobLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ScheduleJobLogMapper {
    int countByExample(ScheduleJobLogExample example);

    int deleteByExample(ScheduleJobLogExample example);

    int deleteByPrimaryKey(Long logId);

    int insert(ScheduleJobLogBean record);

    int insertSelective(ScheduleJobLogBean record);

    List<ScheduleJobLogBean> selectByExample(ScheduleJobLogExample example);

    ScheduleJobLogBean selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") ScheduleJobLogBean record, @Param("example") ScheduleJobLogExample example);

    int updateByExample(@Param("record") ScheduleJobLogBean record, @Param("example") ScheduleJobLogExample example);

    int updateByPrimaryKeySelective(ScheduleJobLogBean record);

    int updateByPrimaryKey(ScheduleJobLogBean record);
}