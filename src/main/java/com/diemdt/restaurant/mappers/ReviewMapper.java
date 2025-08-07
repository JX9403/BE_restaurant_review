
package com.diemdt.restaurant.mappers;

import com.diemdt.restaurant.domain.ReviewCreateUpdateRequest;
import com.diemdt.restaurant.domain.dtos.ReviewCreateUpdateRequestDto;
import com.diemdt.restaurant.domain.dtos.ReviewDto;
import com.diemdt.restaurant.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

    ReviewCreateUpdateRequest toReviewCreateUpdateRequest(ReviewCreateUpdateRequestDto dto);

    ReviewDto toDto(Review review);
    
}
