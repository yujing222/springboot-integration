package com.quart.job.service;

import com.quart.job.entity.ScheduleJobBean;
import com.quart.job.entity.ScheduleJobExample;
import java.util.List;

public interface ScheduleJobService {
    // 主键查询
    ScheduleJobBean selectByPrimaryKey(Long jobId);
    // 列表查询
    List<ScheduleJobBean> selectByExample(ScheduleJobExample example);
    // 保存
    int insert(ScheduleJobBean record);
    // 更新
    int updateByPrimaryKeySelective(ScheduleJobBean record);
    // 停止
    void pauseJob (Long jobId) ;
    // 恢复
    void resumeJob (Long jobId) ;
    // 执行
    void run (Long jobId) ;
    // 删除
    void delete (Long jobId) ;
}
