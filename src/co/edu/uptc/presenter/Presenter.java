package co.edu.uptc.presenter;

import co.edu.uptc.model.Parking;

public final class Presenter {
    private static Presenter presenter;
    private Parking parkingView;

    public Presenter(){
        parkingView = new Parking();
    }

    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
        }
        return presenter;
    }


    
    public void init(){
        showParkingView();        
    }


}
