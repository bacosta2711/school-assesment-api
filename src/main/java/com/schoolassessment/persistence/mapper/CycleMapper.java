package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.CycleResponse;
import com.schoolassessment.persistence.entity.Cycle;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CycleMapper {
    @Mappings({
            @Mapping(source = "cycleId",target = "id"),
            @Mapping(source = "cycleName",target = "name")
    })
    CycleResponse toCycle(Cycle cycle);

    List<CycleResponse> toCycles(List<Cycle> cycles);
    @InheritInverseConfiguration
    Cycle cycleFromResponse(CycleResponse cycle);
}
