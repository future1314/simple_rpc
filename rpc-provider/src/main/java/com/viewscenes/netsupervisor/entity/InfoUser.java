package com.viewscenes.netsupervisor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: rpc-provider
 * @description: ${description}
 * @author: shiqizhen
 * @create: 2018-11-30 10:11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoUser {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String address;

}

