package spring.excercises.services;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;
import spring.excercises.model.TimeApiResponse;

@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public String getCurrentTime(String timeZone) {
         TimeApiResponse response = Unirest.get("http://worldtimeapi.org/api/timezone/Asia/"+ timeZone)
                .asObject(TimeApiResponse.class).getBody();
        return response.getUtc_datetime();
    }
}
