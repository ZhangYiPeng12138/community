package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: community
 * @Author: zhangyipeng
 * @CreateTime: 2022-09-06  09:43
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(String userId, int offset, int limit);

    //@param注解用于给参数取别名
    //如果只有一个参数，并且在<if>里使用，则必须使用别名
    int selectDiscussPostRows(@Param("userId") String userId);

}
