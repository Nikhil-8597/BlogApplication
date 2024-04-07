package com.nikh.dto;

import java.util.List;

import com.nikh.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageResponse {
	
	
	private List<User> content;
	private Long totalElements;
	private Integer totalPages;
	private Boolean isLast;
	

}
