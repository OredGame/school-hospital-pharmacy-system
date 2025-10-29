package com.dxr.hospitalmedicinemanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("medicine") // 关联数据库表名
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer medicineId;
    private String medicineCode;
    private String name;
    private String specification;
    private String unit;
    private String manufacturer;
    @Version
    private Integer version;
    private Integer deleted;

}