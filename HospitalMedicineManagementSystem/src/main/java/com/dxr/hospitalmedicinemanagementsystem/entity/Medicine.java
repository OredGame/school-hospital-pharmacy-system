import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("medicine") // 关联数据库表名
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 药品ID（主键，自增）
     */
    @TableId(type = IdType.AUTO)
    private Integer medicineId;

    /**
     * 药品编码（唯一）
     */
    private String medicineCode;

    /**
     * 药品名称
     */
    private String name;

    /**
     * 药品规格（如500mg/片）
     */
    private String specification;

    /**
     * 单位（盒/瓶/片）
     */
    private String unit;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 乐观锁版本号（用于并发控制）
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除标识（0=未删除，1=已删除）
     */
    @TableLogic
    private Integer deleted;

}