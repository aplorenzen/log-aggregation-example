package com.netcompany.elk.consumerservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloResponse implements Serializable {
    private String message;
    private Date messageTime;
}
