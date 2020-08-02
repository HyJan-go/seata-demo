package com.seata.seatastorageservice.domain;

import lombok.Data;

/**
 * @author: HyJan
 * @create: 2020-08-02 15:50
 **/
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

}
