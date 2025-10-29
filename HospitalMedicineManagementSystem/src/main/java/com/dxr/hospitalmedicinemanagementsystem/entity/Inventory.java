package com.dxr.hospitalmedicinemanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 药品库存表
 * </p>
 *
 * @author dxr
 * @since 2025-10-29
 */
@Getter
@Setter
@ToString
@TableName("inventory")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 库存ID
     */
    @TableId(value = "inventory_id", type = IdType.AUTO)
    private Integer inventoryId;

    /**
     * 关联药品ID
     */
    @TableField("medicine_id")
    private Integer medicineId;

    /**
     * 药品批号
     */
    @TableField("batch_number")
    private String batchNumber;

    /**
     * 有效期至（YYYY-MM-DD）
     */
    @TableField("expiration_date")
    private LocalDate expirationDate;

    /**
     * 当前库存数量（≥0）
     */
    @TableField("quantity")
    private Integer quantity;

    /**
     * 乐观锁版本号
     */
    @Version
    @TableField("version")
    private Integer version;

    /**
     * 逻辑删除（0=未删，1=已删）
     */
    @TableLogic
    @TableField("deleted")
    private Byte deleted;
}
