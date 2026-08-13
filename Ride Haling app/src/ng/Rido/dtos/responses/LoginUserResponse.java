package ng.Rido.dtos.responses;

public class LoginUserResponse {

    private String successMessage;
    private String failureMessage;


    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage() {
        this.successMessage = "Login successful";
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }


}
