package com.wq.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author wq
 * @since 2022-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserInfo implements Serializable {

    private int id;

    private String userName;

    public UserInfo(String userName) {
        this.userName = userName;
    }
}
