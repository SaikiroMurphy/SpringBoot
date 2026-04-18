package session11.session11.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import session11.session11.model.dto.response.ApiResponse;
import session11.session11.model.dto.response.PageResponse;
import session11.session11.model.dto.response.UserResponse;
import session11.session11.service.UserService;
import session11.session11.utils.ApiResponseStatusEnum;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAll(Pageable pageable) {
        PageResponse pageRes;
        List<UserResponse> usersList;

        if (pageable != null) {
            Page<UserResponse> users = userService.getAll(pageable);

            pageRes = new PageResponse(
                users.getSize(),
                users.getNumberOfElements(),
                users.getTotalElements(),
                users.getTotalPages()
            );

            usersList = users.getContent();

        } else {
            usersList = userService.getAll();

            pageRes = null;
        }


        ApiResponse<List<UserResponse>> res = new ApiResponse<List<UserResponse>>(
            ApiResponseStatusEnum.SUCCESS,
            200,
            usersList,
            pageRes
        );

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
