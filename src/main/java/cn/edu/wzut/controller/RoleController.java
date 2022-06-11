package cn.edu.wzut.controller;

import cn.edu.wzut.mbp.entity.SysDept;
import cn.edu.wzut.mbp.entity.SysRole;
import cn.edu.wzut.mbp.entity.SysUser;
import cn.edu.wzut.mbp.entity.SysUserExt;
import cn.edu.wzut.mbp.service.ISysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private ISysRoleService roleService;
    @GetMapping
    public JsonResult<List<SysRole>> findbypage(@RequestParam("startindex") Integer startindex,
                                                @RequestParam("pagesize") Integer pagesize,
                                                @RequestParam("name") String name) throws MyException{
        List<SysRole>list=roleService.findbyPage(startindex,pagesize,name);
        return new JsonResult<>(list);
    }
    @GetMapping("/all")
    public JsonResult<List<SysRole>> all() {
        List<SysRole> list = roleService.list();
        return new JsonResult<>(list);
    }
    @GetMapping("/maxsize")
    public Integer maxsiez(@RequestParam("name") String name){
        return roleService.maxsize(name);
    }

    @GetMapping("/{id}")
    public JsonResult<SysRole> get(@PathVariable("id") BigDecimal id) {
        SysRole sysRole = roleService.getById(id);
        return new JsonResult<>(sysRole);
    }

    @PostMapping
    public JsonResult<Object> save(@RequestBody SysRole sysRole) throws MyException {
        boolean b = roleService.saveOrUpdate(sysRole);
        if(b)
            return new JsonResult<>(0, "修改完成");
        else
            throw new MyException("修改失败");
    }

    @DeleteMapping("/{id}")
    public JsonResult<Object> deleteOne(@PathVariable("id") BigDecimal id) throws MyException {
        boolean b = roleService.removeById(id);
        if(b)
            return new JsonResult<>(0, "删除完成");
        else
            throw new MyException("删除失败");
    }

    @DeleteMapping
    public JsonResult<Object> deleteMany(@RequestBody BigDecimal[] ids) throws MyException {
        boolean b = roleService.removeByIds(Arrays.asList(ids));
        if(b)
            return new JsonResult<>(0, "删除完成");
        else
            throw new MyException("删除失败");
    }

}
