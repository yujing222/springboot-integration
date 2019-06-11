package com.quart.job.controller;

import com.quart.job.entity.ScheduleJobBean;
import com.quart.job.service.ScheduleJobService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/job")
public class ScheduleJobWeb {

    @Resource
    private ScheduleJobService scheduleJobService ;

    /**
     * 添加定时器
     */
    @RequestMapping("/insertJob")
    public ScheduleJobBean insertJob (){
        ScheduleJobBean scheduleJobBean = new ScheduleJobBean() ;
        scheduleJobBean.setJobId(1L);
        scheduleJobBean.setBeanName("getTimeTask");
        // 每分钟执行一次
        scheduleJobBean.setCronExpression("0 0/1 * * * ?");
        scheduleJobBean.setParams("Hello,Quart-Job");
        scheduleJobBean.setStatus(0);
        scheduleJobBean.setRemark("获取时间定时器");
        scheduleJobBean.setCreateTime(new Date());
        scheduleJobService.insert(scheduleJobBean) ;
        return scheduleJobBean ;
    }

    /**
     * 执行一次定时器
     */
    @RequestMapping("/runJob")
    public String runJob (){
        Long jobId = 1L ;
        scheduleJobService.run(jobId);
        return "success" ;
    }

    /**
     * 更新定时器
     */
    @RequestMapping("/updateJob")
    public String updateJob (){
        Long jobId = 1L ;
        ScheduleJobBean scheduleJobBean = scheduleJobService.selectByPrimaryKey(jobId) ;
        scheduleJobBean.setParams("Hello,Job_Quart");
        scheduleJobService.updateByPrimaryKeySelective(scheduleJobBean) ;
        return "success" ;
    }

    /**
     * 停止定时器
     */
    @RequestMapping("/pauseJob")
    public String pauseJob (){
        Long jobId = 1L ;
        scheduleJobService.pauseJob(jobId);
        return "success" ;
    }

    /**
     * 恢复定时器
     */
    @RequestMapping("/resumeJob")
    public String resumeJob (){
        Long jobId = 1L ;
        scheduleJobService.resumeJob(jobId);
        return "success" ;
    }

    /**
     * 删除定时器
     */
    @RequestMapping("/deleteJob")
    public String deleteJob (){
        Long jobId = 1L ;
        scheduleJobService.delete(jobId);
        return "success" ;
    }

}
