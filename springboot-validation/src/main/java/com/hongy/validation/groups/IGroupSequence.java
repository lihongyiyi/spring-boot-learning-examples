package com.hongy.validation.groups;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * 定义组序列
 * @Author lihongy
 * @Created by on 2019/06/12 12:13.
 * @Description:
 */
@GroupSequence({Default.class, IGroup1.class, IGroup2.class})
public interface IGroupSequence {
}
