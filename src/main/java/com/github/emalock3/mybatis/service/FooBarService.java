package com.github.emalock3.mybatis.service;

import com.github.emalock3.mybatis.mapper.domain.Bar;
import com.github.emalock3.mybatis.mapper.domain.Foo;
import com.github.emalock3.mybatis.mapper.primary.FooMapper;
import com.github.emalock3.mybatis.mapper.secondary.BarMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooBarService {

    private final FooMapper fooMapper;
    private final BarMapper barMapper;

    @Autowired
    public FooBarService(FooMapper fooMapper, BarMapper barMapper) {
        this.fooMapper = fooMapper;
        this.barMapper = barMapper;
    }

    public void createTestData() {
        for (int i = 0; i < 10; i++) {
            int id = i + 1;
            fooMapper.create(new Foo(id, String.format("foo-%d", id)));
            barMapper.create(new Bar(id, String.format("bar-%d", id)));
        }
    }

    public List<Foo> findAllFoos() {
        return fooMapper.findAll();
    }
    
    public Optional<Foo> findFoo(int id) {
        return Optional.ofNullable(fooMapper.findOne(id));
    }
    
    public Optional<Bar> findBar(int id) {
        return Optional.ofNullable(barMapper.findOne(id));
    }
    
    public List<Bar> findAllBars() {
        return barMapper.findAll();
    }
    
    public void printAllFooAndAllBar() {
        System.out.println("foo:");
        fooMapper.findAll().stream().forEach(System.out::println);
        System.out.println("bar:");
        barMapper.findAll().stream().forEach(System.out::println);
    }
}
