package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.EvaluationCriteriaItemResponse;
import com.schoolassessment.persistence.entity.EvaluationCritItem;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface EvaluationCritItemMapper {
    @Mappings({
            @Mapping(source = "id.itemevalId",target = "id"),
            @Mapping(source = "itemDesc",target = "description"),
            @Mapping(source = "itemRep",target = "representation")

    })
    EvaluationCriteriaItemResponse toEvaluationCriteriaItem(EvaluationCritItem evalCrit);
    List<EvaluationCriteriaItemResponse> toEvaluationCriteriansItems(List<EvaluationCritItem> evalCrit);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.criterionId",ignore = "evaluationCriteria."),
            @Mapping(target = "evaluationCriteria",ignore = true)
    })
    EvaluationCritItem evaluaitonCriteriaItemsFromResponse(EvaluationCriteriaItemResponse evalCrit);
}
