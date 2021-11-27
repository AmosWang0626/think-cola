package com.amos.think.domain.user.model.types;

import com.amos.think.domain.user.common.util.DesSecretUtil;
import com.amos.think.domain.user.common.util.RandomUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ValidationException;

/**
 * 用户密码
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/27
 */
public class UserPassword {

    /**
     * 密码盐
     */
    private final String salt;
    /**
     * 加密后的密码
     */
    private final String encryptPassword;

    /**
     * 密码盐长度
     */
    private static final int SALT_LENGTH = 8;

    public UserPassword(String password) {
        if (StringUtils.isBlank(password)) {
            throw new ValidationException("密码不能为空");
        }

        // 生成密码盐和加密密码
        String saltCode = generateSalt();
        this.salt = saltCode;
        this.encryptPassword = generateEncryptPassword(password, saltCode);
    }

    public UserPassword(String encryptPassword, String salt) {
        this.salt = salt;
        this.encryptPassword = encryptPassword;
    }

    /**
     * 校验用户输入的密码是否正确
     *
     * @param password 密码
     * @return true-密码正确; false-密码错误
     */
    public boolean isCorrect(String password) {
        return encryptPassword.equals(generateEncryptPassword(password, this.salt));
    }

    /**
     * 生成密码盐
     *
     * @return 密码盐
     */
    private String generateSalt() {
        return RandomUtil.generateLetterString(SALT_LENGTH);
    }

    /**
     * 生成加密密码
     *
     * @return 加密后的密码
     */
    private String generateEncryptPassword(String password, String salt) {
        return DesSecretUtil.encrypt(password, salt);
    }

    public String getSalt() {
        return salt;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }
}
