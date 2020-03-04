package cn.enjoy.vo;

import java.io.Serializable;

/**
 * @author mla
 * @description 多个控制层监控用
 * @prjectName microcloud
 * @className User
 * @date 2020/3/1  14:16
 */
public class User implements Serializable {


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    private Long userId;
    private String userName;
    private String userCode;

}
