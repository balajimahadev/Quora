package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.UserAuth;
import com.upgrad.quora.service.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Repository
public class UserDao {
    @Autowired
    private EntityManager entityManager;

    public Users createUsers(Users userEntity){
        entityManager.persist((userEntity));
        return userEntity;
    }

    public Users getUserByEmail(final String email){
        try {
            return entityManager.createNamedQuery("userByEmail", Users.class).setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public Users getUserByUserName(final String userName){
        try {
            return entityManager.createNamedQuery("userByUserName", Users.class).setParameter("username", userName)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public UserAuth createAuthToken(final UserAuth userAuthTokenEntity){
        entityManager.persist(userAuthTokenEntity);
        return userAuthTokenEntity;
    }
}
