package co.edu.uptc.presenter;

import co.edu.uptc.view.ParkingView;

public final class Presenter {
    private static Presenter presenter;
    private ParkingView parkingView;

    public Presenter(){
        parkingView = new ParkingView();
        parkingView.setPresenter(this);
    }

    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
        }
        return presenter;
    }


    
    public void init(){
    }


}
