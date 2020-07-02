package View;

import java.util.Observable;

public class ObservableView extends Observable {

        public  void notifyObs(Object[] sentObject)
        {
            setChanged();
            notifyObservers();
        }
    }

}
