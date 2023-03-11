package org.breezeflow.common.domain;

import lombok.Data;
import org.breezeflow.common.annotation.Super;

/**
 * @author andy
 */
@Super
@Data
public class ChinaUser extends User {

    private String food;

    private String culture;

}
