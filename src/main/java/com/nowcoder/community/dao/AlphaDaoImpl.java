package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: community
 * @Author: zhangyipeng
 * @CreateTime: 2022-08-18  10:00
 * @Description: TODO
 * @Version: 1.0
 */
@Repository("alphaDaoImpl")
public class AlphaDaoImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}