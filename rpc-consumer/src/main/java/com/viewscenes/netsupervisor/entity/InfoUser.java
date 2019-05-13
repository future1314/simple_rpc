package com.viewscenes.netsupervisor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @program: rpc-provider
 * @description: ${description}
 * @author: shiqizhen
 * @create: 2018-11-30 10:11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoUser  {

	private String id;

    private String name;

    private String address;

}

