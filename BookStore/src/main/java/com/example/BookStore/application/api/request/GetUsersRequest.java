package com.example.BookStore.application.api.request;

import jakarta.validation.Valid;

import org.hibernate.validator.constraints.Range;

import com.example.BookStore.domain.model.user.UserSearchCondition;
import com.example.BookStore.domain.values.DateTimeFilterCondition;
import com.example.BookStore.domain.values.SearchResultLimit;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GetUsersRequest {

	@Valid
	private DateFilterObject dateFilter;

	@Range(min = 1, max = 10000, message = "有効範囲外です（{min} - {max}）")
	private Long limit;
	
	public UserSearchCondition convertToDomain() {
		
		DateTimeFilterCondition filterCondition = null;
		
		if (dateFilter == null) {
			filterCondition = new DateTimeFilterCondition(null, null);
		} else {
			filterCondition = dateFilter.convertToDomain();
		}
		
		SearchResultLimit limit = new SearchResultLimit(this.limit);
		
		UserSearchCondition condition = new UserSearchCondition();
		condition.setFilterCondition(filterCondition);
		condition.setLimit(limit);
		
		return condition;
		
	}

}
