package com.github.emalock3.mybatis.mapper.secondary;

import com.github.emalock3.mybatis.mapper.domain.Bar;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface BarMapper {
    Bar findOne(int id);
    List<Bar> findAll();
    @Insert("insert into bar (id, name) values (#{id}, #{name})")
    public int create(Bar bar);
    @Delete("delete from bar")
    public void deleteAll();
}
