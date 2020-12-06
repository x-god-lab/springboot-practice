package com.example.demo.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  //对应数据库中的主键(uuid,自增id,雪花算法，redis,zookeeper)
  @TableId(type = IdType.AUTO)
  private long id;
  private String name;
  private Integer age;
  private String email;

  @Version //乐观锁Version注解
  private Integer version;
  //字段添加填充内容
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  //逻辑删除
  @TableLogic
  private Integer deleted;
}
