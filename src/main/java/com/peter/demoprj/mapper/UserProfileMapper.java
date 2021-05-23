package com.peter.demoprj.mapper;

import com.peter.demoprj.domain.UserProfile;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserProfileMapper {
    @Select("select * from userprofile where id=#{id}")
    public UserProfile getLoginInfo(@Param("id") String id) throws Exception;
}
