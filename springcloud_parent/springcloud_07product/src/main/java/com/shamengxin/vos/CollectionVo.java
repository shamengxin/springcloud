package com.shamengxin.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//定义用来接收集合类型参数的对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionVo {
    private List<String> ids;
}
