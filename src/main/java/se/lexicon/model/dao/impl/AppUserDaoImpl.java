package se.lexicon.model.dao.impl;

import se.lexicon.model.AppUser;
import se.lexicon.model.Roles;
import se.lexicon.model.dao.AppUserDao;
import se.lexicon.model.dao.impl.sequencer.AppUserIdSequencer;

import java.util.ArrayList;
import java.util.List;

public class AppUserDaoImpl implements AppUserDao {
        private List<AppUser> storage;

        private static AppUserDaoImpl instance;

        private AppUserDaoImpl() {
            storage = new ArrayList<>();
        }

        public static AppUserDaoImpl getInstance(){
            if (instance == null) instance = new AppUserDaoImpl();
            return instance;
        }

        @Override
        public AppUser create(AppUser appUser) {
            if (appUser == null) throw new IllegalArgumentException("appUser was null");
            appUser.setId(AppUserIdSequencer.nextId());
            storage.add(appUser);
            return appUser;
        }

        @Override
        public AppUser findById(Integer id) {
            if (id == null) throw new IllegalArgumentException("id was null");
            for (AppUser appUser : storage)
                if (appUser.getId().equals(id)) return appUser;

            return null;
        }

        @Override
        public boolean deleteById(Integer id) {
            AppUser result = findById(id);
            return storage.remove(result);
        }

        @Override
        public void update(AppUser toUpdate) {
            if (toUpdate == null) throw new IllegalArgumentException("toUpdate data was null");
            for (AppUser original : storage) {
                if (original.getId().equals(toUpdate.getId())) {
                    original.setUserName(toUpdate.getUserName());
                    original.setPassWord(toUpdate.getPassWord());
                    original.setRole(toUpdate.getRoles());
                    original.setActive(toUpdate.isActive());
                    break;
                }
            }

        }

        @Override
        public List<AppUser> findAll() {
            return new ArrayList<>(storage);
        }

        @Override
        public AppUser findByUserName(String username) {
            if (username == null) throw new IllegalArgumentException("username was null");
            for (AppUser appUser : storage)
                if (appUser.getUserName().equals(username)) return appUser;
            return null;
        }


    @Override
        public List<AppUser> findByRole(Roles role) {
            if (role == null) throw new IllegalArgumentException("role was null");
            List<AppUser> newList = new ArrayList<>();
            for(AppUser appUser: storage){
                if (appUser.getRoles() == role){
                    newList.add(appUser);
                }
            }

            return newList;
        }
    }

