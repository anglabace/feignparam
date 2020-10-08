package feign.provider.pojo;

public class UserInfo {
    //user id
    private Long userId;
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    //username
    private String userName;
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
