package com.quart.job.service.impl;

import com.quart.job.entity.ScheduleJobBean;
import com.quart.job.entity.ScheduleJobExample;
import com.quart.job.mapper.ScheduleJobMapper;
import com.quart.job.service.ScheduleJobService;
import com.quart.job.utils.ScheduleUtil;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Resource
    private Scheduler scheduler ;
    @Resource
    private ScheduleJobMapper scheduleJobMapper ;

    /**
     * 定时器初始化
     */
    @PostConstruct
    public void init (){
        ScheduleJobExample example = new ScheduleJobExample() ;
        List<ScheduleJobBean> scheduleJobBeanList = scheduleJobMapper.selectByExample(example) ;
        for (ScheduleJobBean scheduleJobBean : scheduleJobBeanList) {
            CronTrigger cronTrigger = ScheduleUtil.getCronTrigger(scheduler,scheduleJobBean.getJobId()) ;
            if (cronTrigger == null){
                ScheduleUtil.createJob(scheduler,scheduleJobBean);
            } else {
                ScheduleUtil.updateJob(scheduler,scheduleJobBean);
            }
        }
    }

    @Override
    public ScheduleJobBean selectByPrimaryKey(Long jobId) {
        return scheduleJobMapper.selectByPrimaryKey(jobId);
    }

    @Override
    public List<ScheduleJobBean> selectByExample(ScheduleJobExample example) {
        return scheduleJobMapper.selectByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(ScheduleJobBean record) {
        ScheduleUtil.createJob(scheduler,record);
        return scheduleJobMapper.insert(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(ScheduleJobBean record) {
        ScheduleUtil.updateJob(scheduler,record);
        return scheduleJobMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pauseJob(Long jobId) {
        ScheduleJobBean scheduleJobBean = scheduleJobMapper.selectByPrimaryKey(jobId) ;
        ScheduleUtil.pauseJob(scheduler,jobId);
        scheduleJobBean.setStatus(1);
        scheduleJobMapper.updateByPrimaryKeySelective(scheduleJobBean) ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resumeJob(Long jobId) {
        ScheduleJobBean scheduleJobBean = scheduleJobMapper.selectByPrimaryKey(jobId) ;
        ScheduleUtil.resumeJob(scheduler,jobId);
        scheduleJobBean.setStatus(0);
        scheduleJobMapper.updateByPrimaryKeySelective(scheduleJobBean) ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(Long jobId) {
        ScheduleJobBean scheduleJobBean = scheduleJobMapper.selectByPrimaryKey(jobId) ;
        ScheduleUtil.run(scheduler,scheduleJobBean);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long jobId) {
        ScheduleUtil.deleteJob(scheduler, jobId);
        scheduleJobMapper.deleteByPrimaryKey(jobId) ;
    }
}
