package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.EvaluationTypeResponse;
import com.schoolassessment.persistence.entity.EvaluationType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvaluationTypeMapper {
    @Mappings({
            @Mapping(source = "typeId",target = "id"),
            @Mapping(source = "typeDescription",target = "description")
    })
    EvaluationTypeResponse toEvaluaitonType(EvaluationType ev);

    List<EvaluationTypeResponse> toEvaluationTypes(List<EvaluationType> ev);
    @InheritInverseConfiguration
    @Mapping(target = "evaluationList",ignore = true)
    EvaluationType evaluationTypeFromResponse(EvaluationTypeResponse ev);
}
