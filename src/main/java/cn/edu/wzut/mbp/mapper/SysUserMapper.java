package cn.edu.wzut.mbp.mapper;

import cn.edu.wzut.mbp.entity.SysUser;
import cn.edu.wzut.mbp.entity.SysUserExt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzut
 * @since 2022-04-27
 */
//第二步
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select({
            "select a.*, b.role_name, c.dept_name from sys_user a " +
                    "left join sys_role b " +
                    "on b.id = a.role_id " +
                    "left join sys_dept c " +
                    "on c.id = a.dept_id"
    })
    List<SysUserExt> getUserList();
}
