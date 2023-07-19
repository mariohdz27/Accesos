package com.unchesquito.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class NotificationModel {

	private boolean ready;
	private boolean finished;
}
