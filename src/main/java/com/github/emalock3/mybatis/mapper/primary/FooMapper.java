package com.github.emalock3.mybatis.mapper.primary;

import com.github.emalock3.mybatis.mapper.domain.Foo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface FooMapper {
    Foo findOne(int id);
    List<Foo> findAll();
    @Insert("insert into foo (id, name) values (#{id}, #{name})")
    public int create(Foo foo);
    @Delete("delete from foo")
    public void deleteAll();
}
