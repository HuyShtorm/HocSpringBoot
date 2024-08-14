package com.example.projectfinal.service;

import com.example.projectfinal.Entity.User;
import com.example.projectfinal.Entity.User_;
import com.example.projectfinal.common.FilterRequest;
import com.example.projectfinal.constant.MessageError;
import com.example.projectfinal.controller.BaseEntity_;
import com.example.projectfinal.enumStatic.UserStatus;
import com.example.projectfinal.exception.NotFoundException;
import com.example.projectfinal.repository.UserRepository;
import com.example.projectfinal.request.SearchRequest;
import com.example.projectfinal.request.user.ActiveRequest;
import com.example.projectfinal.request.user.AdminUpdateStatusRequest;

import com.example.projectfinal.request.user.SignupRequest;
import com.example.projectfinal.response.user.UserResponse;
import com.example.projectfinal.util.DbUtil;
import com.example.projectfinal.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.hibernate.jpamodelgen.util.StringUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@Log4j2

public class UserService {
    //nên xài final thay vì @autowird
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
private static final String TOKEN_ACTIVE = "ysPlvePUPZjYj1gRFaW7";
    // Constructor Injection
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(SignupRequest request) {
        log.info("Yêu cầu đăng ký: {}", request);
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new ServiceException("Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ServiceException("Email alreay exists");
        }
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .status(UserStatus.WAITING_CONFIRM)
                .build();
        user = userRepository.save(user);
        //VETIFI EMAIL
        // Ánh xạ đối tượng user thành đối tượng UserResponse
        UserResponse response = MapperUtil.mapObject(user, UserResponse.class);
        return response; // Trả về đối tượng UserResponse
    }


    public UserResponse getProfile(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(MessageError.USER_NOT_FOUND + userId));
//Optional<User>userOpt =userRepository.findById(userId);
//if (!userOpt.isPresent()){
//    throw new NotFoundException("user not found "+userId);
//        }
        return MapperUtil.mapObject(user, UserResponse.class);
    }

    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        return MapperUtil.mapObjectList(users, UserResponse.class);
    }


    public UserResponse updateUserStatus(String id, UserStatus status) {
        User user = userRepository.findById(id).orElseThrow(() -> new ServiceException("User not found"));
        user.setStatus(status);
        user = userRepository.save(user);
        return MapperUtil.mapObject(user, UserResponse.class);
    }
    public UserResponse active(ActiveRequest request){
        User user=userRepository.findById(request.getUserId()).orElseThrow(()->new NotFoundException("user not found "+ request.getUserId()));
    if(!TOKEN_ACTIVE.equals(request.getToken())){
        throw new ServiceException("Token ko dung hoac da het han ");
    }
    if (UserStatus.WAITING_CONFIRM.equals(user.getStatus())){
        throw  new ServiceException("user ko duoc kich hoat truoc do ");
    }
    //clean token
        user.setStatus((UserStatus.ACTIVE));
    user = userRepository.save(user);
    return MapperUtil.mapObject(user,UserResponse.class);
    }
    public String adminUpdateStatus(AdminUpdateStatusRequest request){
        User user = userRepository.findById(request.getUserId()).orElseThrow(()-> new NotFoundException(MessageError.USER_NOT_FOUND+ request.getUserId()));

        if (UserStatus.WAITING_CONFIRM.equals(request.getStatus())|| UserStatus.WAITING_CONFIRM.equals(user.getStatus())) {
            throw new ServiceException("Trang thai ko hop le !");

        }
        if(user.getStatus().equals(request.getStatus())){
            throw new ServiceException("Trang thai trung voi trang thai cu !");

        }
        user.setStatus(request.getStatus());
        user=userRepository.save(user);
        return user.getStatus().toString();
    }

//        public Page<UserResponse> search(SearchRequest request) {
//       var page = UserRepository.findAll(request.getPage().getPageable());
//       return page.map(user1 -> MapperUtil.mapObject(user1, UserResponse.class));
//    }


    public Page<UserResponse> search(SearchRequest request) {
            Specification<User> filterSpec = (root, query, criteriaBuilder)
                    -> criteriaBuilder.equal(criteriaBuilder.literal(1), criteriaBuilder.literal (1));

            if (Objects.nonNull(request.getFilters()) && !request.getFilters().isEmpty()) {

                for (FilterRequest filterReq : request.getFilters()) {

                    if (User_.STATUS.equalsIgnoreCase(filterReq.getField())) {
                        filterSpec = filterSpec.and(DbUtil.createSpecification(filterReq));
                    }

                }

if(StringUtils.hasText(request.getKeyword())){
Specification<User> searchPec =DbUtil.createSpecification(FilterRequest.builder()
        .field(User_.NAME_SEARCH)

        .value(request.getKeyword())
        .build());
}
                // select * from  // where 1=1 and

                // and status = '"

                // and
                // and (name like or email like )
            }

        Page<User> page = userRepository.findAll(filterSpec,request.getPage().getPageable());
        return MapperUtil.mapPage(page, UserResponse.class);
    }


}