package al.helmo.com.natamobile.model;

import java.util.ArrayList;
import java.util.List;

import al.helmo.com.natamobile.model.entity.Bird;
import al.helmo.com.natamobile.model.entity.Color;
import al.helmo.com.natamobile.model.remote.UserService;
import al.helmo.com.natamobile.model.util.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BirdsHandler {

    private List<Bird> birds;
    private UserService userService;
    private List<Color> primaryColorFilter;
    private List<Color> secondaryColorFilter;
    private List<Filter> weightFilter;
    private List<Bird> filteredBirds;

    public BirdsHandler(){
        birds = new ArrayList<>();
        filteredBirds = new ArrayList<>();
        userService = APIUtils.getUserService();
        getBirdsFromDB();
        buildFilters();
        filteredBirds = birds;
    }

    private void buildFilters() {
        Call<List<Color>> call = userService.getColors(APIUtils.KEYAPI);

        call.enqueue(new Callback<List<Color>>() {
            @Override
            public void onResponse(Call<List<Color>> call, Response<List<Color>> response) {
                if(response.code() == 200){
                    primaryColorFilter = new ArrayList<>();
                    secondaryColorFilter = new ArrayList<>();
                    primaryColorFilter.add(new Color(0,"No Filter"));
                    secondaryColorFilter.add(new Color(0,"No Filter"));
                    primaryColorFilter.addAll(response.body());
                    secondaryColorFilter.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Color>> call, Throwable t) {
                return;
            }
        });

        weightFilter = new ArrayList<>();
        weightFilter.add(new Filter(0,0,"No Filter"));
        weightFilter.add(new Filter(1,99,"- 100 gr"));
        weightFilter.add(new Filter(100,200,"100 - 200 gr"));
        weightFilter.add(new Filter(201,300,"200 - 300 gr"));
        weightFilter.add(new Filter(301,9000,"+ 300 gr"));

    }

    private void getBirdsFromDB() {
        Call<List<Bird>> call = userService.getBirds(APIUtils.KEYAPI);

        call.enqueue(new Callback<List<Bird>>() {
            @Override
            public void onResponse(Call<List<Bird>> call, Response<List<Bird>> response) {
                if(response.code() >=200 && response.code() <=205){
                    birds = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Bird>> call, Throwable t) {
                return;
            }
        });
    }

    public void filterBirds(int primaryColor, int secondaryColor, int weight){

        if(primaryColorFilter.get(primaryColor).getName().equals("No Filter") && secondaryColorFilter.get(secondaryColor).getName().equals("No Filter") && weightFilter.get(weight).getText().equals("No Filter")){
            filteredBirds = this.birds;
        }else{
            filteredBirds = new ArrayList<>();
            for (Bird b:this.birds) {
                if(b.getSecondaryColor() != null){
                    if(((primaryColorFilter.get(primaryColor).getName().equals(b.getPrimaryColor()) || primaryColorFilter.get(primaryColor).getName().equals(b.getSecondaryColor()) || primaryColorFilter.get(primaryColor).getName().equals("No Filter"))
                            ||
                            (secondaryColorFilter.get(secondaryColor).getName().equals(b.getPrimaryColor()) || secondaryColorFilter.get(secondaryColor).getName().equals(b.getSecondaryColor()) || secondaryColorFilter.get(secondaryColor).getName().equals("No Filter"))))
                        if((b.getWeight() >= weightFilter.get(weight).getLimitMin() && b.getWeight() <= weightFilter.get(weight).getLimitMax()) || weightFilter.get(weight).getText().equals("No Filter")) {
                            filteredBirds.add(b);
                    }
                }else{
                    if((primaryColorFilter.get(primaryColor).getName().equals(b.getPrimaryColor()) || primaryColorFilter.get(primaryColor).getName().equals(b.getSecondaryColor()) || primaryColorFilter.get(primaryColor).getName().equals("No Filter"))){
                        if((b.getWeight() >= weightFilter.get(weight).getLimitMin() && b.getWeight() <= weightFilter.get(weight).getLimitMax()) || weightFilter.get(weight).getText().equals("No Filter")) {
                            filteredBirds.add(b);
                        }
                    }
                }
            }
        }
    }

    public List<String> getPrimaryColorFilter() {
        List<String> result = new ArrayList<>();
        for (Color c:primaryColorFilter) {
            result.add(c.getName());
        }
        return result;
    }

    public List<String> getWeightFilter() {
        List<String> result = new ArrayList<>();
        for (Filter f: weightFilter) {
            result.add(f.getText());
        }
        return result;
    }

    public List<String> getBirdsList(){
        List<String> result = new ArrayList<>();
        for(Bird b : filteredBirds){
            result.add(b.getName());
        }
        return result;
    }

    public Bird getSelectedBird(int selectedId){
     return filteredBirds.get(selectedId);
    }
}
