package org.breeze.spring.common.domain;

import lombok.Data;
import org.breeze.spring.common.annotation.Super;

/**
 * @author andy
 */
@Super
@Data
public class ChinaUser extends User {

    private String food;

    private String culture;

}
