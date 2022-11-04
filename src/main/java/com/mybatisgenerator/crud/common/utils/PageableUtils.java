package com.mybatisgenerator.crud.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.ap.internal.model.source.selector.SelectionCriteria;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import javax.persistence.criteria.*;

public class PageableUtils<DTO> {
    public static <Entity, Search> void search(CriteriaBuilder builder, CriteriaQuery<Entity> query, Class<Entity> entityClass, Class<Search> searchClass, String keywords)
    {
        List<Predicate> predicates = new ArrayList<>();
        Root<Entity> entity = query.from(entityClass);

        if(StringUtils.isNotEmpty(keywords))
        {
            for(Field field: searchClass.getDeclaredFields())
            {
                predicates.add(builder.like(entity.get(field.getName()), "%" + keywords + "%"));
            }
            Predicate search = builder.or(predicates.toArray(new Predicate[0]));
            query.where(search);
        }

    }
}
