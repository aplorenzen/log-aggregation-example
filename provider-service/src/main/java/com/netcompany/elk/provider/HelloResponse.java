package com.netcompany.elk.provider;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class HelloResponse implements Serializable {
    private String message;
    private Date messageTime;
}
