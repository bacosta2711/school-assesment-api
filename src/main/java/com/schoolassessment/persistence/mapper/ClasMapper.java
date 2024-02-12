package com.schoolassessment.persistence.mapper;

import com.schoolassessment.domain.dto.ClasResponse;
import com.schoolassessment.persistence.entity.Clas;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses ={UserMapper.class})
public interface ClasMapper {
    @Mappings({
            @Mapping(source = "classLevel",target = "level"),
            @Mapping(source = "classUser",target = "user"),
            @Mapping(source = "classYear",target = "year"),
            @Mapping(source = "classChildrens",target = "childerns"),
            @Mapping(source = "classGrade",target = "grade"),
            @Mapping(source = "user",target = "usr")
    })
    ClasResponse toClass(Clas clas);
    List<ClasResponse> toClasses(List<Clas> clas);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "evaluationRegistriesList", ignore = true),
            //@Mapping(target = "level", ignore = true)
    })
    Clas clasFromResponse(ClasResponse clas);
}
