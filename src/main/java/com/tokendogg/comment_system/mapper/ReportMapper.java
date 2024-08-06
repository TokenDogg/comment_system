package com.tokendogg.comment_system.mapper;

import com.tokendogg.comment_system.entity.Comment;
import com.tokendogg.comment_system.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReportMapper {

    /**
     * 数据库新增举报记录
     * @param report
     * @return 举报是否成功
     */
    public int addNewReport(Report report);


}
