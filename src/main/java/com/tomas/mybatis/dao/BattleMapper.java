package com.tomas.mybatis.dao;

import com.tomas.mybatis.model.Battle;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface BattleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATTLE
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATTLE
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    int insert(Battle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATTLE
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    Battle selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATTLE
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    List<Battle> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATTLE
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    int updateByPrimaryKey(Battle record);
}