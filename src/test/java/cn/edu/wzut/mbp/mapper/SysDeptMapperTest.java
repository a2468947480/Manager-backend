package cn.edu.wzut.mbp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysDeptMapperTest {
@Autowired
    SysDeptMapper sysDeptMapper;
@Test
    void test(){
    Integer a= sysDeptMapper.findchild(1);
    System.out.println(a);
}
}