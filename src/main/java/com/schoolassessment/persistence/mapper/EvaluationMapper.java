package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.EvaluationResponse;
import com.schoolassessment.persistence.entity.Evaluation;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring", uses = {EvaluationTypeMapper.class})
public interface EvaluationMapper {
    @Mappings ({
            @Mapping(source = "evaluationId",target = "id"),
            @Mapping(source = "evaluationYear",target = "year"),
            @Mapping(source = "evaluationDeadLine",target = "deadLine"),
            @Mapping(source = "evaluationType",target = "type"),
            @Mapping(source = "evaluationDesc",target = "description"),
    })
    EvaluationResponse toEvaluation(Evaluation eval);
    List<EvaluationResponse> toEvaluations(List<Evaluation> evls);
    @InheritInverseConfiguration
            @Mappings({
                    @Mapping(target = "evaluationType",ignore = true),
                    @Mapping(target = "evaluationRegistryList",ignore = true)
            })
    Evaluation evaluationFromResponse(EvaluationResponse eval);


}
