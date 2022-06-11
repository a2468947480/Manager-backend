package cn.edu.wzut.mbp.mapper;

import cn.edu.wzut.mbp.entity.SysRole;
import cn.edu.wzut.mbp.entity.SysUserExt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzut
 * @since 2022-04-27
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    @Select({
            "SELECT * FROM  \n" +
                    "(  \n" +
                    "SELECT A.*, ROWNUM RN  \n" +
                    "FROM (SELECT * FROM SYS_ROLE WHERE ROLE_NAME LIKE '%${name}%') A  \n" +
                    "WHERE ROWNUM <= #{pagesize}  \n" +
                    ")  \n" +
                    "WHERE RN >= #{startindex}"
    })
    List<SysRole>  findbyPage(Integer startindex,Integer pagesize,String name);
    @Select({
            "SELECT COUNT(*) FROM SYS_ROLE  WHERE ROLE_NAME LIKE '%${name}%'"
    })
    Integer maxsize(String name);


}
