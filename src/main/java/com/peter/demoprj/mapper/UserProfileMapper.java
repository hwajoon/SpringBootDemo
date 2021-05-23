package com.peter.demoprj.mapper;

import com.peter.demoprj.domain.UserProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserProfileMapper {

    @Select("select name from userprofile where id=#{id}")
    public String getUsername(@Param("id") String id) throws Exception;

    // @Select("select * from userprofile where id=#{id}") ==> UserProfileMapper.xml
    public UserProfile getLoginInfo(@Param("id") String id) throws Exception;
}
