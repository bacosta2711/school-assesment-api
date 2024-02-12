package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.IndicatorResponse;
import com.schoolassessment.persistence.entity.Indicator;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;
@Mapper(componentModel = "spring",uses = {IndicatorMapping.class, EvaluationMapper.class, EvaluationCritItemMapper.class})
public interface IndicatorMapping {
    @Mappings({
            @Mapping(source = "indicatorId",target = "id"),
            @Mapping(source = "indicatorCode",target = "code"),
            @Mapping(source = "indicatorDesc",target = "description"),
            @Mapping(source = "evaluationCriterians",target = "criteria"),
            @Mapping(source = "indicatorEval",target = "evaluation"),
            @Mapping(source = "indicatorFather",target = "father"),
    })
    IndicatorResponse toIndicator(Indicator indicator);

    List<IndicatorResponse>  toIndicators(List<Indicator> indicator);

    @InheritInverseConfiguration
    Indicator indicatorFromResponse(IndicatorResponse indicator);
}
