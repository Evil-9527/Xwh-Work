package com.example.xdemo.mapper;

import com.example.xdemo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询指定ID的数据
     *
     * @param id
     * @return
     */
    @Select("select id, name, mobile, email from user where id = #{id}")
    public User findOne(Long id);

    /**
     * 查询所有数据
     *
     * @return
     */
    @Select("select id, name, mobile, email from user")
    public List<User> findAll();

    /**
     * 插入数据
     *
     * @param data
     * @return
     */
    @Insert("insert into user(id, name, mobile, email) values (#{id}, #{name}, #{mobile}, #{email})")
    public int insert(User data);

    /**
     * 删除指定ID的数据
     *
     * @param id
     * @return
     */
    @Delete("delete from user where id = #{id}")
    public int delete(Long id);

}