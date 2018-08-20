package com.mst.db.dao;

import com.mst.db.domain.UserAuth;
import com.mst.db.domain.UserAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAuthMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    long countByExample(UserAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    int deleteByExample(UserAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    int insert(UserAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    int insertSelective(UserAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserAuth selectOneByExample(UserAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserAuth selectOneByExampleSelective(@Param("example") UserAuthExample example, @Param("selective") UserAuth.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<UserAuth> selectByExampleSelective(@Param("example") UserAuthExample example, @Param("selective") UserAuth.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    List<UserAuth> selectByExample(UserAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserAuth selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") UserAuth.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    UserAuth selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserAuth record, @Param("example") UserAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserAuth record, @Param("example") UserAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_auth
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserAuth record);
}