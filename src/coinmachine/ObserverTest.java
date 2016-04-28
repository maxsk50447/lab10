package coinmachine;

import java.util.Observable;
import java.util.Observer;

public class ObserverTest implements Observer{
	
	@Override
	public void update(Observable subject, Object info) {
		System.out.println("update called by " + subject.getClass().getName());
		System.out.println(info);
	}
	
}
