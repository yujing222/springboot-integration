package com.quart.job.service.impl;

import com.quart.job.entity.ScheduleJobLogBean;
import com.quart.job.mapper.ScheduleJobLogMapper;
import com.quart.job.service.ScheduleJobLogService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {

    @Resource
    private ScheduleJobLogMapper scheduleJobLogMapper ;

    @Override
    public int insert(ScheduleJobLogBean record) {
        return scheduleJobLogMapper.insert(record);
    }
}
