package  com.lzp.dao.impl;


import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.lzp.dao.UserDao;
import com.lzp.model.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User queryUserByUnameAndUpwd(User user) {
        User userBO= new User();
        System.out.println(user.getUname()+"  " + user.getUpwd());
        Record o = Db.findFirst("select * from user where name=? and pwd=?", user.getUname(), user.getUpwd());
        if(o!=null){
            return userBO.put(o);

        }else {
            return null;
        }
    }
}
