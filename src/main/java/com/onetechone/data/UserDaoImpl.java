package com.onetechone.data;

/**
 * Created by rasoul on 7/19/2017.
 */
import java.util.List;

import com.onetechone.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public User findById(int id) {
        User user = getByKey(id);

        return user;
    }

    public User findBySSO(String sso) {
        System.out.println("SSO : "+sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User)crit.uniqueResult();

        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("Name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return users;
    }

    public void save(User user) {
        persist(user);
    }

    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User)crit.uniqueResult();
        delete(user);
    }

}

