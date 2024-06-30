package Serializable;

import lombok.Data;

import java.io.Serializable;

@Data
public class InstaAccount implements Serializable {

    private String userName;
    private String accountType;
    private String bio;
    private String emailId;
}
