package cn.edu.wzut.mbp.mapper;

import cn.edu.wzut.mbp.entity.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzut
 * @since 2022-04-27
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {
 @Select({
         "SELECT MAX(ID) FROM \"SYS_DEPT\""
 })
    Integer findmaxid();
    @Select({
            "select COUNT(*) from SYS_DEPT where PARENT_ID = #{id}"
    })
    Integer findchild( Integer id);
}
