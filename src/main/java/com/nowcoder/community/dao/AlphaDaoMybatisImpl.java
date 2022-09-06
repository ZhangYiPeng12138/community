package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: community
 * @Author: zhangyipeng
 * @CreateTime: 2022-08-18  10:06
 * @Description: TODO
 * @Version: 1.0
 */
@Repository
@Primary//优先级设置
public class AlphaDaoMybatisImpl implements AlphaDao {
    @Override
    public String select() {
        return "Mybatis";
    }
}