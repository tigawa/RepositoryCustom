package com.example.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.query.QueryUtils;

import com.example.controller.dto.ResultCriteria;
import com.example.model.Result;

public class ResultRepositoryImpl implements ResultRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	// 動的条件に一致するEntityを全件検索　するサンプルを元に実装
	// 　http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/ArchitectureInDetail/DataAccessJpa.html#id21
	@Override
	public Page<Result> findByCriteria(ResultCriteria criteria,
			Pageable pageable) {
		
        // collect dynamic conditions.
        final List<String> andConditions = new ArrayList<String>();
        final List<String> joinConditions = new ArrayList<String>();
        final Map<String, Object> bindParameters = new HashMap<String, Object>();

		if (criteria.getStaffId() != null) {
			joinConditions.add("r.resultDetails rd");
			andConditions.add("rd.staff.id = :staffId");
			bindParameters.put("staffId", criteria.getStaffId());
		}

		// TODO result の検索条件はここに書く
//        if (criteria.getStaffId() != null) {
//            andConditions.add("d.staffId = :staffId");
//            bindParameters.put("staffId", criteria.getStaffId());
//        }
        
//        if (!CollectionUtils.isEmpty(criteria.getStatusCodes())) {
//            andConditions.add("o.status.code IN :statusCodes");
//            bindParameters.put("statusCodes", criteria.getStatusCodes());
//        }
//        if (andConditions.isEmpty()) {
//            List<Result> Results = Collections.emptyList();
//            return new PageImpl<Result>(Results, pageable, 0); // (3)
//        }

        // create dynamic query.
        final StringBuilder queryString = new StringBuilder();
        final StringBuilder countQueryString = new StringBuilder(); // (4)
        final StringBuilder conditionsString = new StringBuilder(); // (4)

		queryString.append("select r FROM Result r ");
		countQueryString.append("SELECT COUNT(r) FROM Result r ");

        // (11)
        // add join conditions.
        for (String joinCondition : joinConditions) {
        	conditionsString.append(" JOIN ").append(joinCondition);
        }
        // add conditions.
        Iterator<String> andConditionsIt = andConditions.iterator();
        if (andConditionsIt.hasNext()) {
            conditionsString.append(" WHERE ").append(andConditionsIt.next());
        }
        while (andConditionsIt.hasNext()) {
            conditionsString.append(" AND ").append(andConditionsIt.next());
        }
        queryString.append(conditionsString); // (6)
        countQueryString.append(conditionsString); // (6)

        // add Result by condition.
        // (7)
        String query = QueryUtils.applySorting(queryString.toString(), pageable.getSort(), "r");

        // create typed query.
        final TypedQuery<Long> countQuery = entityManager.createQuery(
                countQueryString.toString(), Long.class); // (8)

        final TypedQuery<Result> findQuery = entityManager.createQuery(
        		query, Result.class);

        // bind parameters.
        for (Map.Entry<String, Object> bindParameter : bindParameters
                .entrySet()) {
            countQuery.setParameter(bindParameter.getKey(), bindParameter
                    .getValue()); // (8)
            findQuery.setParameter(bindParameter.getKey(), bindParameter
                    .getValue());
        }

        long total = countQuery.getSingleResult().longValue(); // (9)
        List<Result> Results = null;
        if (total != 0) { // (10)
            findQuery.setFirstResult(pageable.getOffset());
            findQuery.setMaxResults(pageable.getPageSize());
            // execute query.
            Results = findQuery.getResultList();
        } else { // (11)
            Results = Collections.emptyList();
        }

        return new PageImpl<Result>(Results, pageable, total); // (12)
    }
	
	public Sort sortByIdAsc() {
		return new Sort(Sort.Direction.ASC, "id");
	}
}
