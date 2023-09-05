package spring.excercises.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.excercises.model.UserModel;

import java.util.HashMap;
import java.util.Map;

@Service
@Qualifier("primary")
public class UserServiceImpl implements UserService {
    private final TimeService timeService;
    private Map<String, UserModel> userMap = new HashMap<>();

    public UserServiceImpl(TimeService timeService){
        this.timeService = timeService;
        userMap.put("Geetha", new UserModel("Geetha", "Shree C", 3456567));
        userMap.put("Seetha", new UserModel("Seetha", "Shree C", 3454665));
    }

    public UserModel getUser(String userName){
        return userMap.get(userName);
    }

    public void addUser(UserModel user){
         user.setCreationTime(timeService.getCurrentTime("Kolkata"));
         userMap.put(user.getFirstName(), user);
    }

    public void deleteUser(String firstName){
         userMap.remove(firstName);
    }
}
