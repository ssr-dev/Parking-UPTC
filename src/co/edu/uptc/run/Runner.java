package co.edu.uptc.run;

import co.edu.uptc.presenter.Presenter;

public class Runner {
    public static void main(String[] args) {
        Presenter presenter = Presenter.getInstance();
        presenter.openLogin();
    }

}
