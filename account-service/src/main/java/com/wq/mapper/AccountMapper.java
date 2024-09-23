package com.wq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wq.beans.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountMapper extends BaseMapper<Account> {
    //查询所有数据
    List<Account> findAll();
}
