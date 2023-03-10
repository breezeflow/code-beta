package org.breezeflow.spring.domain;

import lombok.Data;
import org.breezeflow.spring.annotation.Super;

/**
 * @author andy
 * @create 2023/03/10
 */
@Super
@Data
public class ChinaUser extends User {

    private String food;

    private String culture;

}
