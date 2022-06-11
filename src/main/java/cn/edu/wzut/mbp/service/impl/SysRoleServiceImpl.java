package cn.edu.wzut.mbp.service.impl;

import cn.edu.wzut.mbp.entity.SysRole;
import cn.edu.wzut.mbp.entity.SysUserExt;
import cn.edu.wzut.mbp.mapper.SysRoleMapper;
import cn.edu.wzut.mbp.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzut
 * @since 2022-04-27
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
@Autowired
    SysRoleMapper sysRoleMapper;
@Override
public List<SysRole> findbyPage(Integer startindex,Integer pagesize,String name) {
    return sysRoleMapper.findbyPage(startindex,pagesize,name);
}
@Override
    public Integer maxsize(String name){
    return sysRoleMapper.maxsize(name);
}

}
