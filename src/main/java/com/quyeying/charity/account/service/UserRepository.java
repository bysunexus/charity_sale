package com.quyeying.charity.account.service;

import com.quyeying.charity.domain.User;
import com.quyeying.security.UserMongoRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * User: bysun
 * Date: 2014/7/20
 * Time: 22:53
 */
@Repository("userRepository")
public interface UserRepository extends UserMongoRepository,MongoRepository<User,String> {
}
