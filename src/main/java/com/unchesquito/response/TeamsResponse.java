package com.unchesquito.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class TeamsResponse {
	
	private int id;
	private String team_name;
	private String image;

}
