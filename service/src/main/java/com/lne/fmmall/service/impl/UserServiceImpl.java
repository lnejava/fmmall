package com.lne.fmmall.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lne.fmmall.dao.UsersMapper;
import com.lne.fmmall.entity.Users;
import com.lne.fmmall.service.UserService;
import com.lne.fmmall.utils.SecureUtil;
import com.lne.fmmall.vo.ResultVo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * FileName: UserServiceImpl
 * Author:   fengsulin
 * Date:     2022/4/23 19:09
 * Description: 用户管理实现类
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private UsersMapper usersMapper;

    /**
     *用户注册
     * @param: [name, password]
     * @return: com.lne.fmmall.utils.vo.ResultVo
     */
    @Override
    @Transactional
    public ResultVo userRegister(String name, String password) {
        log.info("开始注册！");
        if(name.length()<=0 || name.length() >16 || name.isEmpty() || password.length() < 8||password.length()>16 || password.isEmpty()){
            return new ResultVo()
                    .setSuccess(false)
                    .setCode(10004)
                    .setMsg("用户名或密码长度不合理！")
                    .setData(null);
        }
        synchronized (this){
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username",name);
            List<Users> users = usersMapper.selectByExample(example);
            if(users.size() == 0){
                Users user = new Users();
                // 生成雪花Id，并将生成的id作为用户id和salt
                long snowflakeNextId = IdUtil.getSnowflakeNextId();
                //得到一个加盐的md5的密码
                password = SecureUtil.generateMd5Salt(password,String.valueOf(snowflakeNextId));
                user = new Users();
                user.setUserId(snowflakeNextId);
                user.setUsername(name);
                user.setPassword(password);
                user.setUserRegtime(LocalDateTime.now());
                user.setUserModtime(LocalDateTime.now());
                int insertUser = usersMapper.insert(user);
                if(insertUser > 0){
                    log.info("注册成功！");
                    return new ResultVo()
                            .setSuccess(true)
                            .setCode(10000)
                            .setMsg("注册成功！")
                            .setData(null);
                }else {
                    return new ResultVo()
                            .setSuccess(false)
                            .setCode(10001)
                            .setMsg("注册失败！")
                            .setData(null);
                }
            }else{
                return new ResultVo()
                        .setSuccess(false)
                        .setCode(10001)
                        .setMsg("该用户已被注册")
                        .setData(null);
            }

        }
    }

    /**
     *用户登录
     * @param: [name, password]
     * @return: com.lne.fmmall.utils.vo.ResultVo
     */
    @Override
    public ResultVo userLogin(String name, String password) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",name);
        List<Users> users = usersMapper.selectByExample(example);
        if(users.size() > 0){
            String md5 = users.get(0).getPassword();
            long uuid = users.get(0).getUserId();
            boolean md5Salt = SecureUtil.verifyMd5Salt(password,uuid, md5);
            if(md5Salt){
                JwtBuilder jwtBuilder = Jwts.builder();
                HashMap<String, Object> map = new HashMap<>();
                map.put("username",users.get(0).getUsername());
                map.put("userimg",users.get(0).getUserImg());
                String token = jwtBuilder.setAudience(users.get(0).getUserId().toString())
                        .setIssuedAt(new Date())
                        .setClaims(map)
                        .setExpiration(new Date(System.currentTimeMillis() + 15 * 60 * 1000))
                        .signWith(SignatureAlgorithm.HS256, "fengsulin")
                        .compact();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("token",token);
                hashMap.put("items",users);
                log.info("登录成功！");
                stringRedisTemplate.boundValueOps(token).set(name,2, TimeUnit.MINUTES);
                return new ResultVo()
                        .setSuccess(true)
                        .setCode(10000)
                        .setMsg("登录成功！")
                        .setData(hashMap);
            }
            return new ResultVo()
                    .setSuccess(false)
                    .setCode(10001)
                    .setMsg("用户名或密码不正确！")
                    .setData(null);

        }else {
            return new ResultVo()
                    .setSuccess(false)
                    .setCode(10001)
                    .setMsg("用户名不存在！")
                    .setData(null);
        }
    }
}
