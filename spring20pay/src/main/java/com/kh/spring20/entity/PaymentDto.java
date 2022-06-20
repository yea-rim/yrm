package com.kh.spring20.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	private int paymentNo;
	private String paymentTid;
	private int paymentTotal;
	private String paymentName;
	private Date paymentTime;
	private String paymentStatus;
}
