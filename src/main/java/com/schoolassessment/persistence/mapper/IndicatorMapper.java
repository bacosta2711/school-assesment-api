package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.IndicatorResponse;
import com.schoolassessment.persistence.entity.Indicator;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;
@Mapper(componentModel = "spring",uses = {EvaluationCriteriaMapper.class})
public interface IndicatorMapper {
    @Mappings({
            @Mapping(source = "indicatorId",target = "id"),
            @Mapping(source = "indicatorCode",target = "code"),
            @Mapping(source = "indicatorDesc",target = "description"),
            @Mapping(source = "evaluationCriterians",target = "criteria"),
            @Mapping(source = "indicatorEvaluation",target = "evaluation"),
           // @Mapping(source = "inicatorFather",target = "father"),
    })
    IndicatorResponse toIndicator(Indicator indicator);

    List<IndicatorResponse>  toIndicators(List<Indicator> indicator);

    @InheritInverseConfiguration
    Indicator indicatorFromResponse(IndicatorResponse indicator);
}
