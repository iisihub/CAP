package com.iisigroup.cap.batch.tasklet;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 用來執行任何的 sql 命令(基本上是 DDL)。
 * 
 * @author Chih-Liang Chang
 * @since 2010/10/12
 */
public class SqlCommandTasklet implements Tasklet {

    private String sql;

    private DataSource dataSource;

    @Override
    public RepeatStatus execute(StepContribution contribution,
            ChunkContext chunkContext) throws Exception {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.execute(sql);
        return RepeatStatus.FINISHED;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
