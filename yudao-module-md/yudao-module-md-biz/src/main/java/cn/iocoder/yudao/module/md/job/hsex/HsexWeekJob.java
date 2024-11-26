package cn.iocoder.yudao.module.md.job.hsex;


import cn.iocoder.yudao.framework.quartz.core.handler.JobHandler;
import cn.iocoder.yudao.module.md.service.job.HsexJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HsexWeekJob implements JobHandler {

    @Autowired
    private HsexJobService hsexJobService;

    @Override
    public String execute(String param) throws Exception {
        hsexJobService.processWeekTop(20);
        return "[HSexWeekJob] 执行成功";
    }
}
