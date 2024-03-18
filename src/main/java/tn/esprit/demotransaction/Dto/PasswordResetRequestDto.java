package tn.esprit.demotransaction.Dto;

import lombok.Data;

@Data
public class PasswordResetRequestDto {
   private String phoneNumber;//destiantion
   private String userName;
   private String oneTimePassword;
}
