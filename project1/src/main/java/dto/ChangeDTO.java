package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
public class ChangeDTO {
	private String userid;
	private String curentPassword;
	private String changePassword;
}