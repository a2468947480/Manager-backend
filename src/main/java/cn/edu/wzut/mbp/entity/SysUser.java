package cn.edu.wzut.mbp.entity;

import cn.edu.wzut.mbp.entity.EntityBase;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzut
 * @since 2022-04-27
 */
@Getter
@Setter
@TableName("SYS_USER")
public class SysUser extends EntityBase {

    private static final long serialVersionUID = 1L;

    private BigDecimal id;

    private String username;

    private String password;

    private BigDecimal deptId;

    private BigDecimal roleId;
}
