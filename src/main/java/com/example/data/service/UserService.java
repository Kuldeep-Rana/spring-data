package com.example.data.service;

import com.example.data.dto.UserSearchDto;
import com.example.data.entity.User;
import com.example.data.repository.UserRepository;
import com.example.data.repository.specification.UserSearchSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserSearchSpecification specification;

    @Value("${pagination.page.size.default:20}")
    private Integer defaultPageSize;

    public void searchUser(UserSearchDto request){

        var users = userRepository.findAll(specification.getUsers(request));
        System.out.println("result count "+ users.size());
    }

    public void searchUserWithPaging(UserSearchDto request){
        List<User> list;

        Page<User> pages;

        if (request.getPageSize() <= 0) {
            request.setPageSize(defaultPageSize);
        }
        if(request.getPageNumber() < 1){
            request.setPageNumber(1);
        }
        Pageable paging = PageRequest.of(request.getPageNumber() - 1, request.getPageSize());
        pages = userRepository.findAll(specification.getUsers(request), paging);

        if (pages != null && pages.getContent() != null) {
            list = pages.getContent();
            if (list != null && list.size() > 0) {
                System.out.println("total page "+pages.getTotalPages());
                System.out.println("total count "+pages.getTotalElements());
                System.out.println("page no "+pages.getNumber());
            }
        }
    }

}
