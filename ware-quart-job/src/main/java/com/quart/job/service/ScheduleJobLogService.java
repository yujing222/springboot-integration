package com.quart.job.service;

import com.quart.job.entity.ScheduleJobLogBean;

public interface ScheduleJobLogService {
    // 保存
    int insert(ScheduleJobLogBean record);
}
