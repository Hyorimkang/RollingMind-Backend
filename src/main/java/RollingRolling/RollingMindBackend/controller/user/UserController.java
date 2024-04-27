package RollingRolling.RollingMindBackend.controller.user;


import RollingRolling.RollingMindBackend.service.user.UserService;
import RollingRolling.RollingMindBackend.validator.CheckNicknameValidator;
import RollingRolling.RollingMindBackend.validator.CheckUserIdValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private final CheckUserIdValidator checkUserIdValidator;
    @Autowired
    private final CheckNicknameValidator checkNicknameValidator;
    @Autowired
    private final UserService userService;


    // 커스텀 유효성 검증을 위해 추가
    @InitBinder
    public void validatorBinder(WebDataBinder binder){
        binder.addValidators(checkUserIdValidator);
        binder.addValidators(checkNicknameValidator);
    }

    // 회원번호 생성
    @GetMapping("/{memberNum}")
    public ResponseEntity<?> createMemberNum(){
        int memberNum = userService.generateMemberNum();
        return ResponseEntity.ok().body(Map.of("memberNum", memberNum));
    }


    // 아이디 중복 처리
    @GetMapping("/exists/{userId}")
    public ResponseEntity<Boolean> checkUserIdDuplicate(@PathVariable String userId){
        return ResponseEntity.ok(userService.checkUserIdDuplication(userId));
    }

    @GetMapping("/exists/{nickname}")
    public ResponseEntity<Boolean> checkNicknameDuplicate(@PathVariable String nickname){
        return ResponseEntity.ok(userService.checkUserIdDuplication(nickname));
    }


}
