package com.example.data.repository.specification;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import com.example.data.dto.UserSearchDto;
import com.example.data.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


@Component
public class UserSearchSpecification {

    public Specification<User> getUsers(UserSearchDto request) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (request.getEmail() != null && !request.getEmail().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("email"), request.getEmail()));
            }
            if (request.getFirstName() != null && !request.getFirstName().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")),
                        "%" + request.getFirstName().toLowerCase() + "%"));
            }
            if (request.getGender() != null && !request.getGender().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("gender"), request.getGender()));
            }
            if(request.getExperience() > 0){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("experience"),request.getExperience()));
            }

            query.orderBy(criteriaBuilder.desc(root.get("experience")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}