package org.watermelon.framework.global.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Message implements Domain {
    String msg;
}
