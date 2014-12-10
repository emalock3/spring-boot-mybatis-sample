package com.github.emalock3.mybatis.web;

import com.github.emalock3.mybatis.mapper.domain.Bar;
import com.github.emalock3.mybatis.mapper.domain.Foo;
import com.github.emalock3.mybatis.service.FooBarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foobar")
public class FooBarController {
    
    private final FooBarService fooBarService;
    
    @Autowired
    public FooBarController(FooBarService fooBarService) {
        this.fooBarService = fooBarService;
    }
    
    @RequestMapping("/foos")
    public List<Foo> findFoos() {
        return fooBarService.findAllFoos();
    }
    
    @RequestMapping("/foos/{id}")
    public ResponseEntity<Foo> findFoo(@PathVariable int id) {
        return fooBarService.findFoo(id)
                .map(foo -> new ResponseEntity<>(foo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @RequestMapping("/bars")
    public List<Bar> findBars() {
        return fooBarService.findAllBars();
    }
    
    @RequestMapping("/bars/{id}")
    public ResponseEntity<Bar> findBar(@PathVariable int id) {
        return fooBarService.findBar(id)
                .map(bar -> new ResponseEntity<>(bar, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    
    
}
