package com.dev.chat.vo;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	/*
	 * @NotNull : null일때만 체크
	 * @NotEmpty : null이거나 빈문자열일때 체크
	 * @NotBlack : null이거나 빈문자열 이거나 스페이스 공백일때 체크
	 * @Email : 이메일 형식이 아닐때 체크
	 */
    private int uiNum;
    @NotBlank(message = "아이디는 필수입니다.")
    @Size(min=4, max=30, message="아이디는 4글자 이상 30글자 이하입니다.")
    private String uiId;
    @NotBlank(message = "비밀번호는 필수입니다.") 
    @Size(min=8, max=30, message="비밀번호는 8글자 이상 30글자 이하입니다.")
    private String uiPwd;
    //@NotEmpty(message = "이름은 필수입니다.") 
    @NotBlank(message = "이름은 필수입니다.")
    private String uiName;
    private String uiImgName;
    private MultipartFile uiImg;
    private String uiImgPath;
    @NotBlank(message = "주소는 필수입니다.")
    private String uiAddress1;
    private String uiAddress2;
    @NotBlank(message = "전화번호는 필수입니다.")
    @Pattern(regexp = "^\\d{3}\\d{4}\\d{4}$", message = "올바른 전화번호 형식이 아닙니다.")
    private String uiPhone;
    private String uiDesc;
    private String credat;
    private String cretim;
    private String lmodat;
    private String lmotim;
}
