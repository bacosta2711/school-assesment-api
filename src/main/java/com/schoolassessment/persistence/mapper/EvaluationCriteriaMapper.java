package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.EvaluationCriteriaResponse;
import com.schoolassessment.persistence.entity.EvaluationCriteria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EvaluationCritItemMapper.class })
public interface EvaluationCriteriaMapper {
    @Mappings({
            @Mapping(source = "criterionId",target = "id"),
            @Mapping(source = "criterionDesc",target = "description"),
            @Mapping(source = "criterionTotalize",target = "totalize"),
            @Mapping(source = "items",target = "items"),
    })
    EvaluationCriteriaResponse toEvaluationCriteria(EvaluationCriteria evalCrit);

    List<EvaluationCriteriaResponse> toEvaluationCriterias(List<EvaluationCriteria> evalCrit);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "indicators",ignore = true)
    })
    EvaluationCriteria evaluatinoCriteriaFromResponse(EvaluationCriteriaResponse evalCrit);
}
