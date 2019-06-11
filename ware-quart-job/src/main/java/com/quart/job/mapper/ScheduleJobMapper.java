package com.quart.job.mapper;

import com.quart.job.entity.ScheduleJobBean;
import com.quart.job.entity.ScheduleJobExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScheduleJobMapper {
    int countByExample(ScheduleJobExample example);

    int deleteByExample(ScheduleJobExample example);

    int deleteByPrimaryKey(Long jobId);

    int insert(ScheduleJobBean record);

    int insertSelective(ScheduleJobBean record);

    List<ScheduleJobBean> selectByExample(ScheduleJobExample example);

    ScheduleJobBean selectByPrimaryKey(Long jobId);

    int updateByExampleSelective(@Param("record") ScheduleJobBean record, @Param("example") ScheduleJobExample example);

    int updateByExample(@Param("record") ScheduleJobBean record, @Param("example") ScheduleJobExample example);

    int updateByPrimaryKeySelective(ScheduleJobBean record);

    int updateByPrimaryKey(ScheduleJobBean record);
}