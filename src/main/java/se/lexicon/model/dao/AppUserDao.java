package se.lexicon.model.dao;

import se.lexicon.model.AppUser;
import se.lexicon.model.Roles;

import java.util.List;

public interface AppUserDao extends BaseDao<AppUser> {
    AppUser findByUserName(String userName);
    List<AppUser>findByRole(Roles role);

}
