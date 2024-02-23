package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.EvaluationRegistryResponse;
import com.schoolassessment.persistence.entity.EvaluationRegistry;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EvaluationRegistryDetMapper.class})
public interface EvaluationRegistryMapper {
    @Mappings({
            @Mapping(source = "registryId",target = "id"),
            @Mapping(source = "registryEvaluationId",target = "evaluation"),
            @Mapping(source = "registryStatus",target = "status"),
            @Mapping(source = "registryStatusDate",target = "statusDate"),
            @Mapping(source = "registryClassLevel",target = "level"),
            @Mapping(source = "registryClassUser",target = "user"),
            @Mapping(source = "registryClassYear",target = "year"),
            @Mapping(source = "clas",target = "clas"),
            @Mapping(source = "evaluationRegistryDetList",target = "det"),
    })
    EvaluationRegistryResponse toEvaluationReg(EvaluationRegistry evalReg);

    List<EvaluationRegistryResponse> toEvaluationsRegs(List<EvaluationRegistry> evalRegs);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "clas",ignore = true),
            @Mapping(target = "evaluationRegistryDetList",ignore = true)
    })
    EvaluationRegistry EvaluationfromResponse(EvaluationRegistryResponse evalReg);
}
