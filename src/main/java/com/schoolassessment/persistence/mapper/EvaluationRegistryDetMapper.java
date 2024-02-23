package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.EvaluationRegistryDetResponse;
import com.schoolassessment.persistence.entity.EvaluationRegistryDet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvaluationRegistryDetMapper {

    @Mappings({
            @Mapping(source = "id.registryId", target = "id"),
            @Mapping(source = "registryDetCriterionId", target = "criteria"),
            @Mapping(source = "registryDetItemeValId", target = "itemCritId"),
            @Mapping(source = "registryDetValue", target = "value")
    })
    EvaluationRegistryDetResponse toEvalRegDet(EvaluationRegistryDet evalDet);

    List<EvaluationRegistryDetResponse> toEvaluatonsRegDet(List<EvaluationRegistryDet> evalDet);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.registryDetId", ignore = true),
            @Mapping(target = "registry", ignore = true)
    })
    EvaluationRegistryDet evalDetFromResponse(EvaluationRegistryDetResponse eval);
}