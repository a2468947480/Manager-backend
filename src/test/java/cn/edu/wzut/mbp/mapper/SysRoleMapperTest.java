package cn.edu.wzut.mbp.mapper;

import cn.edu.wzut.mbp.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysRoleMapperTest {
@Autowired
    SysRoleMapper sysRoleMapper;
@Test
void  test1(){
    List<SysRole> sysRoleList=sysRoleMapper.findbyPage(4,7,"");
    System.out.println(sysRoleList);
}

}